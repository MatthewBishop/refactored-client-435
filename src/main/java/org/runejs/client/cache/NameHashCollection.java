package org.runejs.client.cache;

public class NameHashCollection {
    public int[] hashes;

    public NameHashCollection(int[] nameHashes) {
        int i;
        for(i = 1; (nameHashes.length >> 1) + nameHashes.length >= i; i <<= 1) {
            /* empty */
        }
        hashes = new int[i + i];
        for(int i_8_ = 0; i + i > i_8_; i_8_++)
            hashes[i_8_] = -1;
        for(int i_9_ = 0; nameHashes.length > i_9_; i_9_++) {
            int i_10_;
            for(i_10_ = nameHashes[i_9_] & i - 1; hashes[i_10_ + i_10_ + 1] != -1; i_10_ = i_10_ + 1 & -1 + i) {
                /* empty */
            }
            hashes[i_10_ + i_10_] = nameHashes[i_9_];
            hashes[1 + i_10_ + i_10_] = i_9_;
        }

    }


    public int method882(int hash) {
        int i = -2 + hashes.length;
        int i_0_ = hash << 1 & i;
        for(; ; ) {
            int _hash = hashes[i_0_];
            if(_hash == hash)
                return hashes[i_0_ + 1];
            if(_hash == -1)
                return -1;
            i_0_ = i_0_ + 2 & i;
        }
    }
}
