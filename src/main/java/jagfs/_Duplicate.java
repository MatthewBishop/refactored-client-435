package jagfs;

public class _Duplicate {

    public static int stringHash(String str) {
        int i = 0;
        for(int i_12_ = 0; str.length() > i_12_; i_12_++)
            i = (0xff & str.charAt(i_12_)) + -i + (i << 5);
        return i;
    }
    
    public static void threadSleep(long ms) {
        if (ms <= 0L) {
            return;
        }

        try {
            Thread.sleep(ms);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
    }
    
    public static void method278(byte[] arg0, int arg1, byte[] buffer, int arg3, int arg4) {
        if(arg0 == buffer) {
            if(arg1 == arg3)
                return;
            if(arg3 > arg1 && arg3 < arg1 + arg4) {
                arg4--;
                arg1 += arg4;
                arg3 += arg4;
                arg4 = arg1 - arg4;
                arg4 += 7;
                while(arg1 >= arg4) {
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                }
                arg4 -= 7;
                while(arg1 >= arg4)
                    buffer[arg3--] = arg0[arg1--];
                return;
            }
        }
        arg4 += arg1;
        arg4 -= 7;
        while(arg1 < arg4) {
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
        }
        arg4 += 7;
        while(arg1 < arg4)
            buffer[arg3++] = arg0[arg1++];
    }
}
