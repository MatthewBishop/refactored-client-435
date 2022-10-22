package org.runejs.client.audio;

import org.runejs.client.adapter.ICacheArchive;

public class SoundSystem {

	static final int SAMPLE_RATE = 22050;
	static long timeMs;
	
	private static PcmStreamMixer pcmStreamMixer;

	private static int currentSound = 0;

	private static PcmPlayer pcmPlayer;

	private static Effect[] effects = new Effect[50];
	private static int[] sound = new int[50];
	private static int[] soundDelay = new int[50];
	private static int[] soundLocations = new int[50];
	private static int[] soundVolume = new int[50];

	private static int areaSoundEffectVolume = 127;
	static int getAreaSoundEffectVolume() {
		return areaSoundEffectVolume;
	}

	private static int soundEffectVolume = 127;

	private static ICacheArchive soundEffectCacheArchive;
	
	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void reset() {
		SoundSystem.currentSound = 0;
	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void initialiseSound(ICacheArchive soundEffectCacheArchive) {
		SoundSystem.soundEffectCacheArchive = soundEffectCacheArchive;
		try {
			PcmPlayer player = new PcmPlayer();
			player.method222(2048);
			SoundSystem.pcmPlayer = player;
		} catch (Throwable throwable) {
			/*
			 * Vastly simplified, it used to create new PcmPlayerBase(8000) in addition
			 * to other audio backends which are deprecated on error. However, this is
			 * not needed due to existing nullchecks in the code. After testing, it
			 * appears that the hierarchy of the PCM classes can be removed just fine.
			 */
		}
		
		PcmStreamMixer mixer = new PcmStreamMixer();
		PcmPlayer.setMixer(mixer);
		SoundSystem.pcmStreamMixer = mixer;
	}
	
	private static Class pcmClass;

	public static void handleSounds() {
		if (SoundSystem.pcmPlayer != null) {
			long currentTime = System.currentTimeMillis();
			if (SoundSystem.timeMs < currentTime) {
				SoundSystem.pcmPlayer.method212(currentTime);
				int elapsed = (int) (currentTime - SoundSystem.timeMs);
				SoundSystem.timeMs = currentTime;
				synchronized (pcmClass != null ? pcmClass : (pcmClass = PcmPlayer.class)) {
					PcmPlayer.handle(elapsed);
				}
			}
		}
	}

	public static void play(int soundId, int volume, int delay) {
		if (SoundSystem.soundEffectVolume != 0 && volume != 0 && SoundSystem.currentSound < 50) {
			SoundSystem.sound[SoundSystem.currentSound] = soundId;
			SoundSystem.soundVolume[SoundSystem.currentSound] = volume;
			SoundSystem.soundDelay[SoundSystem.currentSound] = delay;
			SoundSystem.effects[SoundSystem.currentSound] = null;
			SoundSystem.soundLocations[SoundSystem.currentSound] = 0;
			SoundSystem.currentSound++;
		}
	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void play(int soundId, int volume, int delay, int location) {
		if (SoundSystem.areaSoundEffectVolume != 0 && volume > 0 && SoundSystem.currentSound < 50) {
			SoundSystem.sound[SoundSystem.currentSound] = soundId;
			SoundSystem.soundVolume[SoundSystem.currentSound] = volume;
			SoundSystem.soundDelay[SoundSystem.currentSound] = delay;
			SoundSystem.effects[SoundSystem.currentSound] = null;
			SoundSystem.soundLocations[SoundSystem.currentSound] = location;
			SoundSystem.currentSound++;
		}
	}

	/*
	 * In 443, this here also sets the sampleRate to 0. However, checking OSRS,
	 * 435, and 578 this was not the case.
	 * 
	 */
	public static void stop() {
		if (SoundSystem.pcmPlayer != null) {
			SoundSystem.pcmPlayer.stop();
			SoundSystem.pcmPlayer = null;
		}
	}

	public static void processSounds(int pwx, int pwy) {
		for (int index = 0; index < SoundSystem.currentSound; index++) {
			SoundSystem.soundDelay[index]--;
			if (SoundSystem.soundDelay[index] < -10) {
				SoundSystem.currentSound--;
				for (int j = index; SoundSystem.currentSound > j; j++) {
					SoundSystem.sound[j] = SoundSystem.sound[j + 1];
					SoundSystem.effects[j] = SoundSystem.effects[1 + j];
					SoundSystem.soundVolume[j] = SoundSystem.soundVolume[1 + j];
					SoundSystem.soundDelay[j] = SoundSystem.soundDelay[1 + j];
					SoundSystem.soundLocations[j] = SoundSystem.soundLocations[1 + j];
				}
				index--;
			} else {
				Effect effect = SoundSystem.effects[index];
				if (effect == null) {
					effect = Effect.readSoundEffect(SoundSystem.soundEffectCacheArchive, SoundSystem.sound[index], 0);
					if (effect == null)
						continue;
					SoundSystem.soundDelay[index] += effect.delay();
					SoundSystem.effects[index] = effect;
				}
				if (SoundSystem.soundDelay[index] < 0) {
					int volume;
					if (SoundSystem.soundLocations[index] != 0) {
						int radius = 128 * (SoundSystem.soundLocations[index] & 0xff);
						int localX = 0xff & SoundSystem.soundLocations[index] >> 16;
						int localY = (SoundSystem.soundLocations[index] & 0xffb8) >> 8;
						int y = localY * 128 + 64 - pwy;
						int x = localX * 128 + 64 - pwx;
						if (x < 0)
							x = -x;
						if (y < 0)
							y = -y;
						int distance = -128 + x + y;
						if (distance > radius) {
							SoundSystem.soundDelay[index] = -100;
							continue;
						}
						if (distance < 0)
							distance = 0;
						volume = (radius + -distance) * SoundSystem.areaSoundEffectVolume / radius;
					} else
						volume = SoundSystem.soundEffectVolume;
					
					RawSound sound = effect.method428();
					RawPcmStream stream = RawPcmStream.create(sound, 100, volume);
					stream.setNumLoops(-1 + SoundSystem.soundVolume[index]);
					SoundSystem.pcmStreamMixer.addSubStream(stream);
					
			//TODO can replace top 4 lines with
			//		addEffect(effect, volume, -1 + SoundSystem.soundVolume[index]);
					SoundSystem.soundDelay[index] = -100;
				}
			}
		}
	}
	
	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void updateSoundEffectVolume(int varPlayerValue) {
		if (varPlayerValue == 0)
			SoundSystem.soundEffectVolume = 127;
		if (varPlayerValue == 1)
			SoundSystem.soundEffectVolume = 96;
		if (varPlayerValue == 2)
			SoundSystem.soundEffectVolume = 64;
		if (varPlayerValue == 3)
			SoundSystem.soundEffectVolume = 32;
		if (varPlayerValue == 4)
			SoundSystem.soundEffectVolume = 0;
	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void updateAreaSoundEffectVolume(int varPlayerValue) {
		if (varPlayerValue == 0)
			SoundSystem.areaSoundEffectVolume = 127;
		if (varPlayerValue == 1)
			SoundSystem.areaSoundEffectVolume = 96;
		if (varPlayerValue == 2)
			SoundSystem.areaSoundEffectVolume = 64;
		if (varPlayerValue == 3)
			SoundSystem.areaSoundEffectVolume = 32;
		if (varPlayerValue == 4)
			SoundSystem.areaSoundEffectVolume = 0;
	}

	static Effect readSoundEffect(int soundEffectId) {
		return Effect.readSoundEffect(SoundSystem.soundEffectCacheArchive, soundEffectId, 0);
	}

	static void removeSubStream(RawPcmStream stream) {
		SoundSystem.pcmStreamMixer.removeSubStream(stream);		
	}

	static RawPcmStream addEffect(Effect effect, int volume, int numLoops) {
		RawSound sound = effect.method428();
		RawPcmStream stream = RawPcmStream.create(sound, 100, volume);
		stream.setNumLoops(numLoops);
		SoundSystem.pcmStreamMixer.addSubStream(stream);		
		return stream;
	}
	
}
