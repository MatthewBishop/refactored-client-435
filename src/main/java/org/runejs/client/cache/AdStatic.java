package org.runejs.client.cache;

import org.runejs.client.LinkedList;
import org.runejs.client.Main;

public class AdStatic implements Runnable {

    public void run() {
        try {
            for(; ; ) {
                Class40_Sub6 class40_sub6;
                synchronized(AdStatic.aLinkedList_53) {
                    class40_sub6 = (Class40_Sub6) AdStatic.aLinkedList_53.method902((byte) -90);
                }
                if(class40_sub6 == null) {
                    _Dup.threadSleep(100L);
                    synchronized(AdStatic.anObject162) {
                        if(AdStatic.anInt1987 <= 1) {
                            AdStatic.anInt1987 = 0;
                            AdStatic.anObject162.notifyAll();
                            break;
                        }
                        AdStatic.anInt1987--;
                    }
                } else {
                    if(class40_sub6.anInt2112 == 0) {
                        class40_sub6.cacheIndex.put(class40_sub6.aByteArray2102, class40_sub6.aByteArray2102.length, (int) class40_sub6.key);
                        synchronized(AdStatic.aLinkedList_53) {
                            class40_sub6.remove();
                        }
                    } else if(class40_sub6.anInt2112 == 1) {
                        class40_sub6.aByteArray2102 = class40_sub6.cacheIndex.get((int) class40_sub6.key);
                        synchronized(AdStatic.aLinkedList_53) {
                            AdStatic.aLinkedList_2604.pushBack(class40_sub6, 115);
                        }
                    }
                    synchronized(AdStatic.anObject162) {
                        if(AdStatic.anInt1987 <= 1) {
                            AdStatic.anInt1987 = 0;
                            AdStatic.anObject162.notifyAll();
                            break;
                        }
                        AdStatic.anInt1987 = 600;
                    }
                }
            }
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }
    
	public static void handleRequests(byte arg0) {
	    for(; ; ) {
	        Class40_Sub6 class40_sub6;
	        synchronized(AdStatic.aLinkedList_53) {
	            class40_sub6 = (Class40_Sub6) AdStatic.aLinkedList_2604.method913(25447);
	        }
	        if(class40_sub6 == null)
	            break;
	        class40_sub6.cacheArchive.method198(false, class40_sub6.aByteArray2102, (int) class40_sub6.key, class40_sub6.cacheIndex);
	    }
	}

	public static void method1055(byte[] arg0, CacheIndex cacheIndex, int cacheIndexId) {
	    Class40_Sub6 class40_sub6 = new Class40_Sub6();
	    class40_sub6.key = cacheIndexId;
	    class40_sub6.aByteArray2102 = arg0;
	    class40_sub6.anInt2112 = 0;
	    class40_sub6.cacheIndex = cacheIndex;
	    synchronized(AdStatic.aLinkedList_53) {
	        AdStatic.aLinkedList_53.pushBack(class40_sub6, -82);
	    }
	    AdStatic.method332(600);
	}

	public static LinkedList aLinkedList_53 = new LinkedList();

	public static void method602(CacheArchive arg0, int arg1, CacheIndex arg2) {
	    byte[] is = null;
	    synchronized(aLinkedList_53) {
	        for(Class40_Sub6 class40_sub6 = (Class40_Sub6) aLinkedList_53.method902((byte) -90); class40_sub6 != null; class40_sub6 = (Class40_Sub6) aLinkedList_53.method909(-4)) {
	            if((long) arg1 == class40_sub6.key && arg2 == class40_sub6.cacheIndex && class40_sub6.anInt2112 == 0) {
	                is = class40_sub6.aByteArray2102;
	                break;
	            }
	        }
	    }
	    if(is == null) {
	        byte[] is_6_ = arg2.get(arg1);
	        arg0.method198(true, is_6_, arg1, arg2);
	    } else {
	        arg0.method198(true, is, arg1, arg2);
	    }
	}

	public static void method513(int arg0, CacheArchive arg1, CacheIndex arg2, byte arg3) {
	    Class40_Sub6 class40_sub6 = new Class40_Sub6();
	    class40_sub6.anInt2112 = 1;
	    class40_sub6.key = (long) arg0;
	    class40_sub6.cacheIndex = arg2;
	    class40_sub6.cacheArchive = arg1;
	    synchronized(aLinkedList_53) {
	        aLinkedList_53.pushBack(class40_sub6, -72);
	    }
	    AdStatic.method332(600);
	}

	public static void method332(int arg0) {
	    synchronized (AdStatic.anObject162) {
	        if (AdStatic.anInt1987 == 0)
	            Main.signlink.createThreadNode(5, new AdStatic());
	        AdStatic.anInt1987 = arg0;
	    }
	}

	public static void method947(int arg0) {
	    synchronized(AdStatic.anObject162) {
	        if((AdStatic.anInt1987 ^ 0xffffffff) != arg0) {
	            AdStatic.anInt1987 = 1;
	            try {
	                AdStatic.anObject162.wait();
	            } catch(InterruptedException interruptedexception) {
	                /* empty */
	            }
	        }
	    }
	}

	public static int anInt1987 = 0;
	public static Object anObject162 = new Object();
	public static LinkedList aLinkedList_2604 = new LinkedList();

}
