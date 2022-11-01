package org.runejs.client.cache;

import java.io.IOException;
import java.net.Socket;

import org.runejs.client.Class51;
import org.runejs.client.GameShell;
import org.runejs.client.GameSocket;
import org.runejs.client.Main;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.io.Buffer;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.util.SignlinkNode;

public class CacheArchiveSystem {

	public static void connectUpdateServer() {
	    if (UpdateServer.crcMismatches >= 4) {
	    	GameShell.openErrorPage("js5crc");
	        Class51.gameStatusCode = 1000;
	    } else {
	        if (UpdateServer.ioExceptions >= 4) {
	            if (Class51.gameStatusCode > 5) {
	                UpdateServer.ioExceptions = 3;
	                CacheArchiveSystem.nextAttempt = 3000;
	            } else {
	            	GameShell.openErrorPage("js5io");
	                Class51.gameStatusCode = 1000;
	                return;
	            }
	        }
	        if (CacheArchiveSystem.nextAttempt-- <= 0) {
	            do {
	                try {
	                    if (CacheArchiveSystem.connectionStage == 0) {
	                        CacheArchiveSystem.updateServerSignlinkNode = Main.signlink.createSocketNode(Main.currentPort);
	                        CacheArchiveSystem.connectionStage++;
	                    }
	                    if (CacheArchiveSystem.connectionStage == 1) {
	                        if (CacheArchiveSystem.updateServerSignlinkNode.status == 2) {
	                            CacheArchiveSystem.js5error(-1);
	                            break;
	                        }
	                        if (CacheArchiveSystem.updateServerSignlinkNode.status == 1)
	                            CacheArchiveSystem.connectionStage++;
	                    }
	                    if (CacheArchiveSystem.connectionStage == 2) {
	                        CacheArchiveSystem.updateServerSocket = new GameSocket((Socket) CacheArchiveSystem.updateServerSignlinkNode.value, Main.signlink);
	                        Buffer buffer = new Buffer(5);
	                        buffer.putByte(15);
	                        buffer.putIntBE(435); // Cache revision
	                        CacheArchiveSystem.updateServerSocket.sendDataFromBuffer(5, 0, buffer.buffer);
	                        CacheArchiveSystem.connectionStage++;
	                        CacheArchiveSystem.handShakeTime = System.currentTimeMillis();
	                    }
	                    if (CacheArchiveSystem.connectionStage == 3) {
	                        if (Class51.gameStatusCode > 5 && CacheArchiveSystem.updateServerSocket.inputStreamAvailable() <= 0) {
	                            if (System.currentTimeMillis() + -CacheArchiveSystem.handShakeTime > 30000L) {
	                                CacheArchiveSystem.js5error(-2);
	                                break;
	                            }
	                        } else {
	                            int i = CacheArchiveSystem.updateServerSocket.read();
	                            if (i != 0) {
	                                CacheArchiveSystem.js5error(i);
	                                break;
	                            }
	                            CacheArchiveSystem.connectionStage++;
	                        }
	                    }
	                    if (CacheArchiveSystem.connectionStage != 4)
	                        break;
	
	                    UpdateServer.handleUpdateServerConnection(CacheArchiveSystem.updateServerSocket, Class51.gameStatusCode > 20);
	
	                    CacheArchiveSystem.updateServerSignlinkNode = null;
	                    CacheArchiveSystem.connectionStage = 0;
	                    CacheArchiveSystem.updateServerSocket = null;
	                    CacheArchiveSystem.js5Errors = 0;
	                } catch (java.io.IOException ioexception) {
	                    ioexception.printStackTrace();
	                    CacheArchiveSystem.js5error(-3);
	                    break;
	                }
	                break;
	            } while (false);
	        }
	    }
	}

	private static void js5error(int arg1) {
	    if (Main.currentPort != OverlayDefinition.gameServerPort)
	        Main.currentPort = OverlayDefinition.gameServerPort;
	    else
	        Main.currentPort = CollisionMap.someOtherPort;
	    CacheArchiveSystem.updateServerSocket = null;
	    CacheArchiveSystem.updateServerSignlinkNode = null;
	    CacheArchiveSystem.js5Errors++;
	    CacheArchiveSystem.connectionStage = 0;
	    if (CacheArchiveSystem.js5Errors < 2 || arg1 != 7 && arg1 != 9) {
	        if (CacheArchiveSystem.js5Errors < 2 || arg1 != 6) {
	            if (CacheArchiveSystem.js5Errors >= 4) {
	                if (Class51.gameStatusCode <= 5) {
	                    GameShell.openErrorPage("js5connect");
	                    CacheArchiveSystem.nextAttempt = 3000;
	                } else
	                    CacheArchiveSystem.nextAttempt = 3000;
	            }
	        } else {
	        	GameShell.openErrorPage("js5connect_outofdate");
	            Class51.gameStatusCode = 1000;
	        }
	    } else if (Class51.gameStatusCode > 5)
	        CacheArchiveSystem.nextAttempt = 3000;
	    else {
	    	GameShell.openErrorPage("js5connect_full");
	        Class51.gameStatusCode = 1000;
	    }
	}

	private static int nextAttempt = 0;
	private static int connectionStage = 0;
	private static int js5Errors = 0;
	private static GameSocket updateServerSocket;
	private static SignlinkNode updateServerSignlinkNode;
	private static long handShakeTime;

}
