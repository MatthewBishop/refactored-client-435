package org.runejs.client.audio;

class RawSound extends AbstractSound {
    byte[] samples;
    int start;
    int end;
    int sampleRate;

    RawSound(int sampleRate, byte[] samples, int start, int end) {
        this.sampleRate = sampleRate;
        this.samples = samples;
        this.start = start;
        this.end = end;
    }

}
