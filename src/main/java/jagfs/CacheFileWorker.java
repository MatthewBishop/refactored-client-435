package jagfs;

public class CacheFileWorker implements Runnable {

	@Override
	public void run() {
        try {
            for(; ; ) {
                Class40_Sub6 class40_sub6;
                synchronized(CacheArchive.aLinkedList_53) {
                    class40_sub6 = (Class40_Sub6) CacheArchive.aLinkedList_53.peekFirst((byte) -90);
                }
                if(class40_sub6 == null) {
                	_Duplicate.threadSleep(100L);
                    synchronized(CacheArchive.anObject162) {
                        if(CacheArchive.anInt1987 <= 1) {
                            CacheArchive.anInt1987 = 0;
                            CacheArchive.anObject162.notifyAll();
                            break;
                        }
                        CacheArchive.anInt1987--;
                    }
                } else {
                    if(class40_sub6.anInt2112 == 0) {
                        class40_sub6.cacheIndex.put(class40_sub6.aByteArray2102, class40_sub6.aByteArray2102.length, (int) class40_sub6.key);
                        synchronized(CacheArchive.aLinkedList_53) {
                            class40_sub6.unlink();
                        }
                    } else if(class40_sub6.anInt2112 == 1) {
                        class40_sub6.aByteArray2102 = class40_sub6.cacheIndex.get((int) class40_sub6.key);
                        synchronized(CacheArchive.aLinkedList_53) {
                            CacheArchive.aLinkedList_2604.addLast(class40_sub6, 115);
                        }
                    }
                    synchronized(CacheArchive.anObject162) {
                        if(CacheArchive.anInt1987 <= 1) {
                            CacheArchive.anInt1987 = 0;
                            CacheArchive.anObject162.notifyAll();
                            break;
                        }
                        CacheArchive.anInt1987 = 600;
                    }
                }
            }
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }

}
