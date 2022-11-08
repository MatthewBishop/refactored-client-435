package org.runejs.client.cache;

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

	public static void handleUpdateServer() {
	    if (Class51.gameStatusCode != 1000) {
	        boolean bool = UpdateServer.processUpdateServerResponse();
	        if (!bool)
	            connectUpdateServer();
	    }
	}
	
	private static void connectUpdateServer() {
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
	                    if (CacheArchiveSystem.handShakeStage == 0) {
	                        CacheArchiveSystem.handShakeSocketNode = Main.signlink.createSocketNode(Main.currentPort);
	                        CacheArchiveSystem.handShakeStage++;
	                    }
	                    if (CacheArchiveSystem.handShakeStage == 1) {
	                        if (CacheArchiveSystem.handShakeSocketNode.status == 2) {
	                            CacheArchiveSystem.updateResponse(-1);
	                            break;
	                        }
	                        if (CacheArchiveSystem.handShakeSocketNode.status == 1)
	                            CacheArchiveSystem.handShakeStage++;
	                    }
	                    if (CacheArchiveSystem.handShakeStage == 2) {
	                        CacheArchiveSystem.handShakeSocket = new GameSocket((Socket) CacheArchiveSystem.handShakeSocketNode.value, Main.signlink);
	                        Buffer buffer = new Buffer(5);
	                        buffer.putByte(15);
	                        buffer.putIntBE(435); // Cache revision
	                        CacheArchiveSystem.handShakeSocket.sendDataFromBuffer(5, 0, buffer.buffer);
	                        CacheArchiveSystem.handShakeStage++;
	                        CacheArchiveSystem.handShakeTime = System.currentTimeMillis();
	                    }
	                    if (CacheArchiveSystem.handShakeStage == 3) {
	                        if (Class51.gameStatusCode > 5 && CacheArchiveSystem.handShakeSocket.inputStreamAvailable() <= 0) {
	                            if (System.currentTimeMillis() + -CacheArchiveSystem.handShakeTime > 30000L) {
	                                CacheArchiveSystem.updateResponse(-2);
	                                break;
	                            }
	                        } else {
	                            int i = CacheArchiveSystem.handShakeSocket.read();
	                            if (i != 0) {
	                                CacheArchiveSystem.updateResponse(i);
	                                break;
	                            }
	                            CacheArchiveSystem.handShakeStage++;
	                        }
	                    }
	                    if (CacheArchiveSystem.handShakeStage != 4)
	                        break;
	
	                    UpdateServer.handleUpdateServerConnection(CacheArchiveSystem.handShakeSocket, Class51.gameStatusCode > 20);
	
	                    CacheArchiveSystem.handShakeSocketNode = null;
	                    CacheArchiveSystem.handShakeStage = 0;
	                    CacheArchiveSystem.handShakeSocket = null;
	                    CacheArchiveSystem.handShakeAttempts = 0;
	                } catch (java.io.IOException ioexception) {
	                    ioexception.printStackTrace();
	                    CacheArchiveSystem.updateResponse(-3);
	                    break;
	                }
	                break;
	            } while (false);
	        }
	    }
	}

	private static void updateResponse(int response) {
	    if (Main.currentPort != OverlayDefinition.gameServerPort)
	        Main.currentPort = OverlayDefinition.gameServerPort;
	    else
	        Main.currentPort = CollisionMap.someOtherPort;
	    CacheArchiveSystem.handShakeSocket = null;
	    CacheArchiveSystem.handShakeSocketNode = null;
	    CacheArchiveSystem.handShakeAttempts++;
	    CacheArchiveSystem.handShakeStage = 0;
	    if (CacheArchiveSystem.handShakeAttempts < 2 || response != 7 && response != 9) {
	        if (CacheArchiveSystem.handShakeAttempts < 2 || response != 6) {
	            if (CacheArchiveSystem.handShakeAttempts >= 4) {
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
	private static int handShakeStage = 0;
	private static int handShakeAttempts = 0;
	private static GameSocket handShakeSocket;
	private static SignlinkNode handShakeSocketNode;
	private static long handShakeTime;

}
