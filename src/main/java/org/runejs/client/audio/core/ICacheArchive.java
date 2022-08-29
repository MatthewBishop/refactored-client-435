package org.runejs.client.audio.core;

public interface ICacheArchive {

	public byte[] getFile(int fileId, int childId);

	public int getFileId(int hash, String child);

	public int getHash(String string);

}
