package org.runejs.client.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import org.runejs.client.Class43;
import org.runejs.client.util.Signlink;

public class PcmPlayer implements Runnable {
	
    private static final int BYTES_PER_SAMPLE = 2;       // 16-bit audio
    private static final int BITS_PER_SAMPLE = 16;       // 16-bit audio
    
    private static final int MONO   = 1;
    private static final int STEREO = 2;
    private static final boolean LITTLE_ENDIAN = false;
    private static final boolean BIG_ENDIAN    = true;
    private static final boolean SIGNED        = true;
    private static final boolean UNSIGNED      = false;

	private static int[] samples = new int[256];
	private boolean aBoolean1820;
	private long aLong1821;
	private int anInt1822;
	private int anInt1823;
	private int anInt1824;
	private int anInt1825 = 0;
	private long aLong1826;
	private int anInt1827;
	private int anInt1828;
	private int anInt1830;
	private int capacity;
	private long aLong1832;
	private int[] anIntArray1833;
	private SourceDataLine line;

	private AudioFormat audioFormat;
	private byte[] byteSamples = new byte[512];

	public PcmPlayer() throws Exception {
		SoundSystem.timeMs = System.currentTimeMillis();
		this.aLong1821 = 0L;
		this.anInt1827 = 256;
		this.aBoolean1820 = false;
		this.anInt1828 = 0;
		this.anInt1822 = 0;
		this.anInt1824 = 0;
		this.anIntArray1833 = new int[512];
		this.audioFormat = new AudioFormat(22050.0F, BITS_PER_SAMPLE, MONO, SIGNED, LITTLE_ENDIAN);

	}

	private void method219(long arg0) throws Exception {
		this.open(this.capacity);
		for (;;) {
			int i = this.avail();
			if (i < this.anInt1827)
				break;
			this.write();
		}
		this.anInt1823 = 0;
		this.anInt1830 = 0;
		this.aLong1832 = arg0;
		this.aLong1826 = arg0;
	}

	private void method221(long arg0) {
		if (this.aLong1821 != 0L) {
			for (/**/; this.aLong1832 < arg0; this.aLong1832 += 256000 / SoundSystem.SAMPLE_RATE)
				skip(256);
			if (arg0 < this.aLong1821)
				return;
			try {
				this.method219(arg0);
			} catch (Exception exception) {
				this.close();
				this.aLong1821 += 5000L;
				return;
			}
			this.aLong1821 = 0L;
		}
		while (this.aLong1832 < arg0) {
			this.aLong1832 += 250880 / SoundSystem.SAMPLE_RATE;
			int i;
			try {
				i = this.avail();
			} catch (Exception exception) {
				this.close();
				this.aLong1821 = arg0;
				return;
			}
			this.method227(i);
			int i_0_ = this.anInt1828 * 3 / 512 - this.anInt1822 * 2;
			if (i_0_ < 0)
				i_0_ = 0;
			else if (i_0_ > this.anInt1824)
				i_0_ = this.anInt1824;
			this.anInt1827 = this.capacity - 256 - i_0_;
			if (this.anInt1827 < 256)
				this.anInt1827 = 256;
			if (this.capacity < 16384) {
				if (i >= this.capacity) {
					this.anInt1823 += 5;
					if (this.anInt1823 >= 100) {
						this.close();
						this.capacity += 2048;
						this.aLong1821 = arg0;
						return;
					}
				} else if (i != this.anInt1830 && this.anInt1823 > 0)
					this.anInt1823--;
			}
			this.anInt1830 = i;
			if (i < this.anInt1827)
				break;
			fill(PcmPlayer.samples, 256);
			try {
				this.write();
			} catch (Exception exception) {
				this.close();
				this.aLong1821 = arg0;
				return;
			}
			this.aLong1826 = arg0;
			this.anInt1830 -= 256;
		}
		if (arg0 >= this.aLong1826 + 5000L) {
			this.close();
			this.aLong1821 = arg0;
			for (int i = 0; i < 512; i++)
				this.anIntArray1833[i] = 0;
			this.anInt1822 = this.anInt1824 = this.anInt1828 = 0;
		}
	}

	public void method222(Signlink arg0, int arg1) throws Exception {
		this.capacity = arg1;
		this.method219(System.currentTimeMillis());
		arg0.createThreadNode(10, this);
	}

	public void stop() {
		synchronized (this) {
			this.aBoolean1820 = true;
		}
		for (;;) {
			synchronized (this) {
				if (!this.aBoolean1820)
					break;
			}
			Class43.threadSleep(50L);
		}
	}

	private void write() {
		for (int i = 0; i < 256; i++) {
			int ampl = PcmPlayer.samples[i];
			if ((ampl + 8388608 & ~0xffffff) != 0)
				ampl = 0x7fffff ^ ampl >> 31;
			this.byteSamples[i * 2] = (byte) (ampl >> 8);
			this.byteSamples[i * 2 + 1] = (byte) (ampl >> 16);
		}
		this.line.write(this.byteSamples, 0, 512);
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (this) {
				if (this.aBoolean1820) {
					if (this.aLong1821 == 0L)
						this.close();
					this.aBoolean1820 = false;
					break;
				}
				this.method212(System.currentTimeMillis());
			}
			Class43.threadSleep(5L);
		}
	}

	private int avail() {
		int i;
		try {
			i = this.line.available() >> 1;
		} catch (RuntimeException runtimeexception) {
			throw runtimeexception;
		}
		return i;
	}

	private void close() {
		if (this.line != null) {
			this.line.close();
			this.line = null;
		}
	}

	private void open(int capacity) throws LineUnavailableException {
		try {
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, this.audioFormat, capacity * BYTES_PER_SAMPLE);
			this.line = (SourceDataLine) AudioSystem.getLine(info);
			this.line.open();
			this.line.start();
		} catch (LineUnavailableException lineunavailableexception) {
			this.line = null;
			throw lineunavailableexception;
		}
	}

	public synchronized void method212(long arg0) {
		this.method221(arg0);
		if (this.aLong1832 < arg0)
			this.aLong1832 = arg0;
	}

	private void method227(int arg0) {
		int i = arg0 - this.anInt1827;
		int i_1_ = this.anIntArray1833[this.anInt1825];
		this.anIntArray1833[this.anInt1825] = i;
		this.anInt1828 += i - i_1_;
		int i_2_ = this.anInt1825 + 1 & 0x1ff;
		if (i > this.anInt1824)
			this.anInt1824 = i;
		if (i < this.anInt1822)
			this.anInt1822 = i;
		if (i_1_ == this.anInt1824) {
			int i_3_ = i;
			for (int i_4_ = i_2_; i_4_ != this.anInt1825 && i_3_ < this.anInt1824; i_4_ = i_4_ + 1 & 0x1ff) {
				int i_5_ = this.anIntArray1833[i_4_];
				if (i_5_ > i_3_)
					i_3_ = i_5_;
			}
			this.anInt1824 = i_3_;
		}
		if (i_1_ == this.anInt1822) {
			int i_6_ = i;
			for (int i_7_ = i_2_; i_7_ != this.anInt1825 && i_6_ > this.anInt1822; i_7_ = i_7_ + 1 & 0x1ff) {
				int i_8_ = this.anIntArray1833[i_7_];
				if (i_8_ < i_6_)
					i_6_ = i_8_;
			}
			this.anInt1822 = i_6_;
		}
		this.anInt1825 = i_2_;
	}

	private static synchronized void fill(int[] arg0, int arg1) {
		int i = 0;
		arg1 -= 7;
		while (i < arg1) {
			arg0[i++] = 0;
			arg0[i++] = 0;
			arg0[i++] = 0;
			arg0[i++] = 0;
			arg0[i++] = 0;
			arg0[i++] = 0;
			arg0[i++] = 0;
			arg0[i++] = 0;
		}
		arg1 += 7;
		while (i < arg1)
			arg0[i++] = 0;
		if (PcmPlayer.mixer != null)
			PcmPlayer.mixer.fill(arg0, 0, arg1);
		skip0(arg1);
	}

	private static synchronized void skip(int arg0) {
		if (PcmPlayer.mixer != null)
			PcmPlayer.mixer.skip(arg0);
		skip0(arg0);
	}

	private static void skip0(int arg1) {
		for (PcmPlayer.anInt2866 += arg1; PcmPlayer.anInt2866 >= SoundSystem.SAMPLE_RATE; PcmPlayer.anInt2866 -= SoundSystem.SAMPLE_RATE) {
			PcmPlayer.anInt2081 -= PcmPlayer.anInt2081 >> 2;
		}
		PcmPlayer.anInt2081 -= 1000 * arg1;
		if (PcmPlayer.anInt2081 < 0) {
			PcmPlayer.anInt2081 = 0;
		}
	}

	private static int anInt2866;
	private static int anInt2081;

	public static void handle(int elapsed) {
		PcmPlayer.anInt2081 += SoundSystem.SAMPLE_RATE * elapsed;
		int i_0_ = (-(2000 * SoundSystem.SAMPLE_RATE) + PcmPlayer.anInt2081) / 1000;
		if (i_0_ > 0) {
			if (PcmPlayer.mixer != null)
				PcmPlayer.mixer.skip(i_0_);
			PcmPlayer.anInt2081 -= i_0_ * 1000;
		}
	}

	static synchronized void setMixer(PcmStream arg0) {
		PcmPlayer.mixer = arg0;
	}

	private static PcmStream mixer;

}
