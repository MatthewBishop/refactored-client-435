package org.runejs.client.cache;

public class JCRC32 {
    public static int[] crc8LookupTable = new int[256];

    static {
        for (int divident = 0; divident < 256; divident++) {
            int currentByte = divident;
            for (int bit = 0; bit < 8; bit++) {
                if ((currentByte & 0x1) != 1) {
                    currentByte >>>= 1;
                } else {
                    currentByte = -306674912 ^ currentByte >>> 1;
                }
            }
            crc8LookupTable[divident] = currentByte;
        }
    }

    public static int calculateCrc8(int offset, int size, byte[] data) {
        int crc = -1;
        for (int currentByte = offset; currentByte < size; currentByte++) {
            int tableIndex = 0xff & (crc ^ data[currentByte]);
            crc = JCRC32.crc8LookupTable[tableIndex] ^ crc >>> 8;
        }
        crc ^= 0xffffffff;
        return crc;
    }
    
    public static int calculateFullCrc8(byte[] data, int size) {
        return JCRC32.calculateCrc8(0, size, data);
    }
}
