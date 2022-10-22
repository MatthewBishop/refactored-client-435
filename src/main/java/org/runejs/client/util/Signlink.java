package org.runejs.client.util;

import org.runejs.client.GameShell;
import org.runejs.client.cache.SizedAccessFile;
import org.runejs.client.cache._Dup;
import org.runejs.Configuration;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable {
    public static Method aMethod724;
    public static String homeDirectory;
    public static Method aMethod729;
    public static String javaVendor;
    public static int anInt737 = 3;
    public static String javaVersion;
    public boolean killed;
    public SignlinkNode current = null;
    public InetAddress netAddress;
    public SignlinkNode next = null;
    public Thread signLinkThread;
    public GameShell gameShell;

    public Signlink(boolean loadCache, GameShell gameShell, InetAddress netAddress, int fileStoreId, String cacheFolder, int cacheIndexes) throws IOException {
        _Dup.metaIndexAccessFile = null;
        _Dup.cacheDataAccessFile = null;
        this.gameShell = gameShell;
        this.netAddress = netAddress;
        javaVersion = "1.1";
        javaVendor = "Unknown";
        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
            homeDirectory = System.getProperty("user.home");
            if(homeDirectory != null)
                homeDirectory += "/";
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(gameShell == null)
                aMethod729 = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            else
                aMethod729 = gameShell.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(gameShell != null)
                aMethod724 = gameShell.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            else
                aMethod724 = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        if(loadCache) {
        	_Dup.loadCache(cacheIndexes);
        }
        killed = false;
        signLinkThread = new Thread(this);
        signLinkThread.setPriority(10);
        signLinkThread.setDaemon(true);
        signLinkThread.start();

    }
    
    public void killSignlinkThread() {
        synchronized(this) {
            killed = true;
            this.notifyAll();
        }
        try {
            signLinkThread.join();
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
        _Dup.kill();
    }

    public SignlinkNode method386(Class[] argumentTypes, String functionName, Class functionType) {
        return putNode(0, 9, new Object[]{functionType, functionName, argumentTypes});

    }

    public SignlinkNode addType4Node(URL url) {
        return putNode(0, 4, url);
    }

    public SignlinkNode putNode(int integerData, int type, Object objectData) {
        SignlinkNode signlinkNode = new SignlinkNode();
        signlinkNode.objectData = objectData;
        signlinkNode.integerData = integerData;
        signlinkNode.type = type;
        synchronized(this) {
            if(next == null)
                next = current = signlinkNode;
            else {
                next.prev = signlinkNode;
                next = signlinkNode;
            }
            this.notify();
        }
        return signlinkNode;
    }

    public void run() {
        for(; ; ) {
            SignlinkNode currentNode;
            synchronized(this) {
                for(; ; ) {
                    if(killed)
                        return;
                    if(current != null) {
                        currentNode = current;
                        current = current.prev;
                        if(current == null)
                            next = null;
                        break;
                    }
                    try {
                        this.wait();
                    } catch(InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
            }
            try {
                int type = currentNode.type;
                if (type == 1) {
                    // Create connection
                    currentNode.value = new Socket(netAddress, currentNode.integerData);
                } else if(type == 2) {
                    // Start thread
                    Thread thread = new Thread((Runnable) currentNode.objectData);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(currentNode.integerData);
                    currentNode.value = thread;
                } else if(type == 4)
                    currentNode.value = new DataInputStream(((URL) currentNode.objectData).openStream());
                else if(type == 9) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredMethod((String) objects[1], (Class[]) objects[2]);
                } else if(type == 10) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredField((String) objects[1]);
                } else {
                    throw new Exception();
                }

                currentNode.status = 1;
            } catch(Exception exception) {
                currentNode.status = 2;
            }
        }

    }

    public SignlinkNode createType10Node(Class variableType, String variableName) {
        return putNode(0, 10, new Object[]{ variableType, variableName });
    }

    // TODO this will just throw an exception, since type 3 isn't handled
    public SignlinkNode createExceptionNode(int arg1) {
        return putNode(arg1, 3, null);
    }

    public SignlinkNode createThreadNode(int nodeId, Runnable runnableClass) {
        return putNode(nodeId, 2, runnableClass);
    }

    public SignlinkNode createSocketNode(int port) {
        return putNode(port, 1, null);
    }

    public SignlinkNode method396(int arg0) {

        if(arg0 < 81)
            return null;
        return null;

    }
}
