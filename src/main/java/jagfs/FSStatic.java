package jagfs;

import java.io.IOException;

import org.runejs.client.io.Buffer;

public class FSStatic {

	public static CacheArchive[] aClass6_Sub1Array580 = new CacheArchive[256];
	public static int anInt1157 = 0;
	public static void method19(boolean loggedIn) {
	    if (UpdateServer.updateServerSocket != null) {
	        try {
	            Buffer buffer = new Buffer(4);
	            buffer.putByte(loggedIn ? 2 : 3);
	            buffer.putMediumBE(0);
	            UpdateServer.updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
	        } catch (java.io.IOException ioexception) {
	            ioexception.printStackTrace();
	            try {
	                UpdateServer.updateServerSocket.kill();
	            } catch (Exception exception) {
	                exception.printStackTrace();
	                /* empty */
	            }
	            UpdateServer.updateServerSocket = null;
	            UpdateServer.anInt2278++;
	        }
	    }
	
	}
	public static int msSinceLastUpdate = 0;
	public static long lastUpdateInMillis;
	public static int anInt813 = 0;

}
