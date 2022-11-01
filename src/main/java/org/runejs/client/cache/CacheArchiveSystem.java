package org.runejs.client.cache;

import java.io.IOException;
import java.net.Socket;

import org.runejs.client.Class29;
import org.runejs.client.Class51;
import org.runejs.client.GameShell;
import org.runejs.client.GameSocket;
import org.runejs.client.Main;
import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.io.Buffer;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.scene.util.CollisionMap;

public class CacheArchiveSystem {

	public static void connectUpdateServer() {
	    if (UpdateServer.crcMismatches >= 4) {
	    	GameShell.openErrorPage("js5crc");
	        Class51.gameStatusCode = 1000;
	    } else {
	        if (UpdateServer.ioExceptions >= 4) {
	            if (Class51.gameStatusCode > 5) {
	                UpdateServer.ioExceptions = 3;
	                ISAAC.nextAttempt = 3000;
	            } else {
	            	GameShell.openErrorPage("js5io");
	                Class51.gameStatusCode = 1000;
	                return;
	            }
	        }
	        if (ISAAC.nextAttempt-- <= 0) {
	            do {
	                try {
	                    if (MovedStatics.connectionStage == 0) {
	                        ProducingGraphicsBuffer.updateServerSignlinkNode = Main.signlink.createSocketNode(Main.currentPort);
	                        MovedStatics.connectionStage++;
	                    }
	                    if (MovedStatics.connectionStage == 1) {
	                        if (ProducingGraphicsBuffer.updateServerSignlinkNode.status == 2) {
	                            CacheArchiveSystem.js5error(-1);
	                            break;
	                        }
	                        if (ProducingGraphicsBuffer.updateServerSignlinkNode.status == 1)
	                            MovedStatics.connectionStage++;
	                    }
	                    if (MovedStatics.connectionStage == 2) {
	                        Class29.updateServerSocket = new GameSocket((Socket) ProducingGraphicsBuffer.updateServerSignlinkNode.value, Main.signlink);
	                        Buffer buffer = new Buffer(5);
	                        buffer.putByte(15);
	                        buffer.putIntBE(435); // Cache revision
	                        Class29.updateServerSocket.sendDataFromBuffer(5, 0, buffer.buffer);
	                        MovedStatics.connectionStage++;
	                        MovedStatics.handShakeTime = System.currentTimeMillis();
	                    }
	                    if (MovedStatics.connectionStage == 3) {
	                        if (Class51.gameStatusCode > 5 && Class29.updateServerSocket.inputStreamAvailable() <= 0) {
	                            if (System.currentTimeMillis() + -MovedStatics.handShakeTime > 30000L) {
	                                CacheArchiveSystem.js5error(-2);
	                                break;
	                            }
	                        } else {
	                            int i = Class29.updateServerSocket.read();
	                            if (i != 0) {
	                                CacheArchiveSystem.js5error(i);
	                                break;
	                            }
	                            MovedStatics.connectionStage++;
	                        }
	                    }
	                    if (MovedStatics.connectionStage != 4)
	                        break;
	
	                    UpdateServer.handleUpdateServerConnection(Class29.updateServerSocket, Class51.gameStatusCode > 20);
	
	                    ProducingGraphicsBuffer.updateServerSignlinkNode = null;
	                    MovedStatics.connectionStage = 0;
	                    Class29.updateServerSocket = null;
	                    MovedStatics.js5Errors = 0;
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

	public static void js5error(int arg1) {
	    if (Main.currentPort != OverlayDefinition.gameServerPort)
	        Main.currentPort = OverlayDefinition.gameServerPort;
	    else
	        Main.currentPort = CollisionMap.someOtherPort;
	    Class29.updateServerSocket = null;
	    ProducingGraphicsBuffer.updateServerSignlinkNode = null;
	    MovedStatics.js5Errors++;
	    MovedStatics.connectionStage = 0;
	    if (MovedStatics.js5Errors < 2 || arg1 != 7 && arg1 != 9) {
	        if (MovedStatics.js5Errors < 2 || arg1 != 6) {
	            if (MovedStatics.js5Errors >= 4) {
	                if (Class51.gameStatusCode <= 5) {
	                    GameShell.openErrorPage("js5connect");
	                    ISAAC.nextAttempt = 3000;
	                } else
	                    ISAAC.nextAttempt = 3000;
	            }
	        } else {
	        	GameShell.openErrorPage("js5connect_outofdate");
	            Class51.gameStatusCode = 1000;
	        }
	    } else if (Class51.gameStatusCode > 5)
	        ISAAC.nextAttempt = 3000;
	    else {
	    	GameShell.openErrorPage("js5connect_full");
	        Class51.gameStatusCode = 1000;
	    }
	}

}
