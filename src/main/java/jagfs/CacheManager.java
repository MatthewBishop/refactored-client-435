package jagfs;

import java.io.File;
import java.io.IOException;

import org.runejs.client.net.PacketBuffer;

public class CacheManager {
    public SizedAccessFile[] dataIndexAccessFiles;
    public SizedAccessFile metaIndexAccessFile = null;
    public SizedAccessFile cacheDataAccessFile = null;
    
    public static CacheIndex metaIndex;
    public static CacheFileChannel dataChannel;
    public static CacheFileChannel metaChannel;
    public static CacheFileChannel[] indexChannels = new CacheFileChannel[13];
    
	public CacheManager(String cachePath, int cacheIndexes) throws IOException {
        cacheDataAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.dat2"), "rw", 52428800L);
        dataIndexAccessFiles = new SizedAccessFile[cacheIndexes];
        for(int currentIndex = 0; currentIndex < cacheIndexes; currentIndex++)
            dataIndexAccessFiles[currentIndex] = new SizedAccessFile(new File(cachePath + "main_file_cache.idx" + currentIndex), "rw", 1048576L);
        metaIndexAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.idx255"), "rw", 1048576L);	}


	public CacheManager() {
		// TODO Auto-generated constructor stub
	}


	public void kill() {
        do {
            try {
                if (dataChannel != null)
                	dataChannel.close();
                if (indexChannels != null) {
                    for (int i = 0; i < indexChannels.length; i++) {
                        if (indexChannels[i] != null)
                        	indexChannels[i].close();
                    }
                }
                if (metaChannel == null)
                    break;
                metaChannel.close();
            } catch (java.io.IOException ioexception) {
                break;
            }
            break;
        } while (false);
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


	public void startup() {
        try {
            if (cacheDataAccessFile != null) {
            	dataChannel = new CacheFileChannel(cacheDataAccessFile, 5200);
                for (int i = 0; i < 13; i++)
                	indexChannels[i] = new CacheFileChannel(dataIndexAccessFiles[i], 6000);
                metaChannel = new CacheFileChannel(metaIndexAccessFile, 6000);
                metaIndex = new CacheIndex(255, dataChannel, metaChannel, 500000);
                dataIndexAccessFiles = null;
                metaIndexAccessFile = null;
                cacheDataAccessFile = null;
            }
        } catch (java.io.IOException ioexception) {
        	metaIndex = null;
        	dataChannel = null;
        	metaChannel = null;
        }
	}


	public static void method513(int arg0, CacheArchive arg1, CacheIndex arg2, byte arg3) {
	    Class40_Sub6 class40_sub6 = new Class40_Sub6();
	    class40_sub6.anInt2112 = 1;
	    class40_sub6.key = (long) arg0;
	    class40_sub6.cacheIndex = arg2;
	    class40_sub6.cacheArchive = arg1;
	    synchronized(CacheArchive.aLinkedList_53) {
	        if(arg3 != -28)
	            PacketBuffer.method521(false, -84, -120);
	        CacheArchive.aLinkedList_53.addLast(class40_sub6, -72);
	    }
	    CacheArchive.method332(600);
	}

    
}
