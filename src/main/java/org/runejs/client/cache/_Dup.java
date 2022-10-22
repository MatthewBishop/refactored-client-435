package org.runejs.client.cache;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.runejs.Configuration;
import org.runejs.client.Main;

public class _Dup {

    public static int stringHash(String str) {
        int i = 0;
        for(int i_12_ = 0; str.length() > i_12_; i_12_++)
            i = (0xff & str.charAt(i_12_)) + -i + (i << 5);
        return i;
    }
    
    public static void threadSleep(long ms) {
        if (ms <= 0L) {
            return;
        }

        try {
            Thread.sleep(ms);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
    }
    
    public static void method278(byte[] arg0, int arg1, byte[] buffer, int arg3, int arg4) {
        if(arg0 == buffer) {
            if(arg1 == arg3)
                return;
            if(arg3 > arg1 && arg3 < arg1 + arg4) {
                arg4--;
                arg1 += arg4;
                arg3 += arg4;
                arg4 = arg1 - arg4;
                arg4 += 7;
                while(arg1 >= arg4) {
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                }
                arg4 -= 7;
                while(arg1 >= arg4)
                    buffer[arg3--] = arg0[arg1--];
                return;
            }
        }
        arg4 += arg1;
        arg4 -= 7;
        while(arg1 < arg4) {
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
        }
        arg4 += 7;
        while(arg1 < arg4)
            buffer[arg3++] = arg0[arg1++];
    }

	public static CacheIndex metaIndex;
	public static CacheFileChannel dataChannel;
	public static CacheFileChannel metaChannel;
	public static CacheFileChannel[] indexChannels = new CacheFileChannel[13];
	
	public static void startup() {
        try {
            if (_Dup.cacheDataAccessFile != null) {
                _Dup.dataChannel = new CacheFileChannel(_Dup.cacheDataAccessFile, 5200);
                for (int i = 0; i < 13; i++)
                    _Dup.indexChannels[i] = new CacheFileChannel(_Dup.dataIndexAccessFiles[i], 6000);
                _Dup.metaChannel = new CacheFileChannel(_Dup.metaIndexAccessFile, 6000);
                _Dup.metaIndex = new CacheIndex(255, _Dup.dataChannel, _Dup.metaChannel, 500000);
                _Dup.dataIndexAccessFiles = null;
                _Dup.metaIndexAccessFile = null;
                _Dup.cacheDataAccessFile = null;
            }
        } catch (java.io.IOException ioexception) {
            _Dup.metaIndex = null;
            _Dup.dataChannel = null;
            _Dup.metaChannel = null;
        }	
	}
	
    public static SizedAccessFile metaIndexAccessFile;
    public static SizedAccessFile cacheDataAccessFile;
    public static SizedAccessFile[] dataIndexAccessFiles;
    public static int uid = 0;
    public static String cachePath = null;
    
	public static void kill() {
        if(cacheDataAccessFile != null) {
            try {
                cacheDataAccessFile.close();
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(metaIndexAccessFile != null) {
            try {
                metaIndexAccessFile.close();
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(dataIndexAccessFiles != null) {
            for(int i = 0; i < dataIndexAccessFiles.length; i++) {
                if(dataIndexAccessFiles[i] != null) {
                    try {
                        dataIndexAccessFiles[i].close();
                    } catch(IOException ioexception) {
                        /* empty */
                    }
                }
            }
        }		
	}
	
    public static void findCachePath() {
        if (Main.signlink.homeDirectory == null) {
        	Main.signlink.homeDirectory = "~/";
        }

        String[] cacheLocations = {
                "c:/rsrcache/",
                "/rsrcache/",
                "c:/windows/",
                "c:/winnt/",
                "d:/windows/",
                "d:/winnt/",
                "e:/windows/",
                "e:/winnt/",
                "f:/windows/",
                "f:/winnt/",
                "c:/",
                Main.signlink.homeDirectory,
                "/tmp/",
                ""
        };

        for (String cacheLocation : cacheLocations) {
            try {
                if (cacheLocation.length() > 0) {
                    File file = new File(cacheLocation);
                    if (!file.exists()) {
                        continue;
                    }
                }
                File file = new File(cacheLocation + Configuration.CACHE_NAME);
                if (file.exists() || file.mkdir()) {
                    cachePath = file.getPath() + "/";
                    return;
                }
            } catch (Exception exception) { }
        }
        throw new RuntimeException();

    }
    
    public static void initializeUniqueIdentifier() {
        try {
            File file = new File(cachePath + "uid.dat");
            if(!file.exists() || file.length() < 4) {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(cachePath + "uid.dat"));
                dataoutputstream.writeInt((int) (9.9999999E7 * Math.random()));
                dataoutputstream.close();
            }
        } catch(Exception exception) {
            /* empty */
        }
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(cachePath + "uid.dat"));
            uid = 1 + datainputstream.readInt();
            datainputstream.close();
        } catch(Exception exception) {
            /* empty */
        }
    }

	public static void loadCache(int cacheIndexes) throws IOException {
        findCachePath();
        cacheDataAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.dat2"), "rw", 52428800L);
        dataIndexAccessFiles = new SizedAccessFile[cacheIndexes];
        for(int currentIndex = 0; currentIndex < cacheIndexes; currentIndex++)
            dataIndexAccessFiles[currentIndex] = new SizedAccessFile(new File(cachePath + "main_file_cache.idx" + currentIndex), "rw", 1048576L);
        metaIndexAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.idx255"), "rw", 1048576L);
        initializeUniqueIdentifier();		
	}
}
