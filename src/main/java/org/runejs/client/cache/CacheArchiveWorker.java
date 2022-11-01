package org.runejs.client.cache;

import org.runejs.client.Class43;
import org.runejs.client.LinkedList;
import org.runejs.client.Main;
import org.runejs.client.MovedStatics;

public class CacheArchiveWorker implements Runnable {

	private static LinkedList requestQueue = new LinkedList();
	private static int archiveWorkerKeepAlive = 0;
	private static LinkedList responseQueue = new LinkedList();
	private static Object lock = new Object();

	public static void fetchArchive(CacheArchive arg0, int arg1, CacheIndex arg2) {
	    byte[] is = null;
	    synchronized(requestQueue) {
	        for(CacheArchiveWorkerNode class40_sub6 = (CacheArchiveWorkerNode) requestQueue.peekFirst((byte) -90); class40_sub6 != null; class40_sub6 = (CacheArchiveWorkerNode) requestQueue.pollFirst(-4)) {
	            if((long) arg1 == class40_sub6.key && arg2 == class40_sub6.cacheIndex && class40_sub6.type == 0) {
	                is = class40_sub6.data;
	                break;
	            }
	        }
	    }
	    if(is == null) {
	        byte[] is_6_ = arg2.get(arg1);
	        arg0.load(true, is_6_, arg1, arg2);
	    } else {
	        arg0.load(true, is, arg1, arg2);
	    }
	}

	public static void fetchArchive(int arg0, CacheArchive arg1, CacheIndex arg2, byte arg3) {
	    CacheArchiveWorkerNode class40_sub6 = new CacheArchiveWorkerNode();
	    class40_sub6.type = 1;
	    class40_sub6.key = (long) arg0;
	    class40_sub6.cacheIndex = arg2;
	    class40_sub6.cacheArchive = arg1;
	    synchronized(requestQueue) {
	        requestQueue.addLast(class40_sub6, -72);
	    }
	    CacheArchiveWorker.method332(600);
	}

	//TODO	private static Thread thread;
	private static void method332(int arg0) {
	    synchronized (CacheArchiveWorker.lock) {
	        if (CacheArchiveWorker.archiveWorkerKeepAlive == 0) {
	        	//TODO replace this with the thread code below:
	            Main.signlink.createThreadNode(5, new CacheArchiveWorker());
	        	/*
				thread = new Thread(new ArchiveDiskActionHandler());
				thread.setDaemon(true);
				thread.start();
				thread.setPriority(5);
	        	 */
	        }
	        CacheArchiveWorker.archiveWorkerKeepAlive = arg0;
	    }
	}

	public static void method947() {
	    synchronized(lock) {
	        if((CacheArchiveWorker.archiveWorkerKeepAlive ^ 0xffffffff) != -1) {//TODO should be if (CacheArchiveWorker.archiveWorkerKeepAlive != 0) {
	            CacheArchiveWorker.archiveWorkerKeepAlive = 1;
	            try {
	                lock.wait();
	            } catch(InterruptedException interruptedexception) {
	                /* empty */
	            }
	        }
	    }
	}

    public void run() {
        try {
            for(; ; ) {
                CacheArchiveWorkerNode class40_sub6;
                synchronized(CacheArchiveWorker.requestQueue) {
                    class40_sub6 = (CacheArchiveWorkerNode) CacheArchiveWorker.requestQueue.peekFirst((byte) -90);
                }
                if(class40_sub6 == null) {
                    Class43.threadSleep(100L);
                    synchronized(CacheArchiveWorker.lock) {
                        if(CacheArchiveWorker.archiveWorkerKeepAlive <= 1) {
                            CacheArchiveWorker.archiveWorkerKeepAlive = 0;
                            CacheArchiveWorker.lock.notifyAll();
                            break;
                        }
                        CacheArchiveWorker.archiveWorkerKeepAlive--;
                    }
                } else {
                    if(class40_sub6.type == 0) {
                        class40_sub6.cacheIndex.put(class40_sub6.data, class40_sub6.data.length, (int) class40_sub6.key);
                        synchronized(CacheArchiveWorker.requestQueue) {
                            class40_sub6.unlink();
                        }
                    } else if(class40_sub6.type == 1) {
                        class40_sub6.data = class40_sub6.cacheIndex.get((int) class40_sub6.key);
                        synchronized(CacheArchiveWorker.requestQueue) {
                            CacheArchiveWorker.responseQueue.addLast(class40_sub6, 115);
                        }
                    }
                    synchronized(CacheArchiveWorker.lock) {
                        if(CacheArchiveWorker.archiveWorkerKeepAlive <= 1) {
                            CacheArchiveWorker.archiveWorkerKeepAlive = 0;
                            CacheArchiveWorker.lock.notifyAll();
                            break;
                        }
                        CacheArchiveWorker.archiveWorkerKeepAlive = 600;
                    }
                }
            }
        } catch(Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }

	public static void insertArchive(byte[] arg0, CacheIndex cacheIndex, int cacheIndexId) {
	    CacheArchiveWorkerNode class40_sub6 = new CacheArchiveWorkerNode();
	    class40_sub6.key = cacheIndexId;
	    class40_sub6.data = arg0;
	    class40_sub6.type = 0;
	    class40_sub6.cacheIndex = cacheIndex;
	    synchronized(requestQueue) {
	        requestQueue.addLast(class40_sub6, -82);
	    }
	    method332(600);
	}

	public static void handleRequests() {
	    for(; ; ) {
	        CacheArchiveWorkerNode class40_sub6;
	        synchronized(requestQueue) {
	            class40_sub6 = (CacheArchiveWorkerNode) responseQueue.removeFirst(25447);
	        }
	        if(class40_sub6 == null)
	            break;
	        class40_sub6.cacheArchive.load(false, class40_sub6.data, (int) class40_sub6.key, class40_sub6.cacheIndex);
	    }
	}
}
