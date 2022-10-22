package org.runejs.client.audio;

abstract class PcmStream extends _Node {
    boolean active;
    AbstractSound sound;

    abstract void skip(int i);

    abstract int fill(int[] is, int i, int i_0_);

    int method845() {
        return 255;
    }
}
