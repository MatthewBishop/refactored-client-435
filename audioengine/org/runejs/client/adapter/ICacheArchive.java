package org.runejs.client.adapter;

public interface ICacheArchive {

	public byte[] getFile(int fileId, int childId);

	public int getFileId(int hash, String child);

	public int getHash(String string);

}
