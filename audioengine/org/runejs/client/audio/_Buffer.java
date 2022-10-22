package org.runejs.client.audio;

/**
 * This is a duplicate class that was created so the audio engine will be standalone.
 *
 */
class _Buffer {

   int currentPosition;
   byte[] buffer;

   _Buffer(byte[] buffer) {
        currentPosition = 0;
        this.buffer = buffer;

    }

   int getUnsignedByte() {
        return 0xff & buffer[currentPosition++];
    }

   int getUnsignedShortBE() {
        currentPosition += 2;
        return ((0xff & buffer[currentPosition - 2]) << 8) + (buffer[currentPosition - 1] & 0xff);
    }

   int getUnsignedSmart() {
        int peek = buffer[currentPosition] & 0xff;
        if(peek >= 128) {
            return -49152 + getUnsignedShortBE();
        }
        return getUnsignedByte() + -64;
    }

   int getSmart() {
        int i = buffer[currentPosition] & 0xff;
        if(i >= 128) {
            return getUnsignedShortBE() + -32768;
        }
        return getUnsignedByte();
    }

   int getIntBE() {
        currentPosition += 4;
        return (0xff & buffer[currentPosition - 1]) + (buffer[currentPosition - 2] << 8 & 0xff00) + (buffer[currentPosition - 3] << 16 & 0xff0000) + (~0xffffff & buffer[currentPosition - 4] << 24);
    }

}
