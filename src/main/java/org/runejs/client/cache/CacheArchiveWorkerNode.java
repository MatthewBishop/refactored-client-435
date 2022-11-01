package org.runejs.client.cache;

import org.runejs.client.node.Node;

public class CacheArchiveWorkerNode extends Node {

    public byte[] data;
    public CacheArchive cacheArchive;
    public int type;
    public CacheIndex cacheIndex;
}
