/* Class32 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class32 {
    public static int anInt744;
    public static PacketBuffer packetBuffer;
    public static int anInt753;
    public static int anInt754;
    public static int[] anIntArray761 = {1, 2, 4, 8};
    public static int anInt765;
    public static RSString aClass1_766;
    public static int anInt767;
    public static Class38 aClass38_768;
    public static int anInt769;
    public static int anInt770;
    public static int anInt771;
    public static RSString aClass1_772;
    public static Class6_Sub1 aClass6_Sub1_773;
    public static int[] anIntArray774;

    static {
        packetBuffer = new PacketBuffer(5000);
        anInt770 = 0;
        aClass1_772 = Class58.method978(-11538, "title)3jpg");
        aClass1_766 = Class58.method978(-11538, "Ignorieren");
        anIntArray774 = new int[]{12800, 12800, 12800, 12800, 12800, 12800,
                12800, 12800, 12800, 12800, 12800, 12800,
                12800, 12800, 12800, 12800};
        anInt771 = 0;
    }

    public int anInt742;
    public int anInt743;
    public int anInt745;
    public int anInt746;
    public int anInt748;
    public int anInt749;
    public int anInt750;
    public int anInt751;
    public int anInt752;
    public int anInt755;
    public int anInt756;
    public int anInt757;
    public int anInt758;
    public int anInt759;
    public int anInt760;
    public int anInt762;
    public int anInt763;
    public int anInt764;

    public static void method398(int arg0) {
        try {
            RSString class1 = null;
            for (int i = 0; NpcDefinition.anInt2394 > i; i++) {
                if ((Landscape.aClass1Array1184[i].method60(Class46.aClass1_1114,
                        32)
                        ^ 0xffffffff)
                        != 0) {
                    class1 = (Landscape.aClass1Array1184[i].method50
                            ((byte) 95,
                                    Landscape.aClass1Array1184[i]
                                            .method60(Class46.aClass1_1114, 32)));
                    break;
                }
            }
            anInt765++;
            if (class1 == null)
                Class40_Sub5_Sub6.method588(-1);
            else {
                int i = Class46.anInt1086;
                int i_0_ = Class19.anInt475;
                if ((i ^ 0xffffffff) < -191)
                    i = 190;
                int i_1_ = Class3.anInt168;
                int i_2_ = Main.anInt1758;
                if ((i_0_ ^ 0xffffffff) > -1)
                    i_0_ = 0;
                int i_3_ = 6116423;
                Rasterizer.method656(i_0_, i_2_, i, i_1_, i_3_);
                Rasterizer.method656(i_0_ - -1, i_2_ - -1, arg0 + i,
                        16, 0);
                Rasterizer.method665(i_0_ + 1, 18 + i_2_, -2 + i,
                        i_1_ + -19, 0);
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246
                        .method683(class1, 3 + i_0_, 14 + i_2_, i_3_, false);
                int i_4_ = Class13.anInt420;
                int i_5_ = Landscape.anInt1166;
                if ((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -1) {
                    i_4_ -= 4;
                    i_5_ -= 4;
                }
                if ((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -2) {
                    i_4_ -= 553;
                    i_5_ -= 205;
                }
                if (Class40_Sub5_Sub17_Sub1.anInt2983 == 2) {
                    i_5_ -= 357;
                    i_4_ -= 17;
                }
                for (int i_6_ = 0;
                     ((i_6_ ^ 0xffffffff)
                             > (NpcDefinition.anInt2394 ^ 0xffffffff));
                     i_6_++) {
                    int i_7_ = 31 + i_2_ + (NpcDefinition.anInt2394
                            + (-1 + -i_6_)) * 15;
                    RSString class1_8_ = Landscape.aClass1Array1184[i_6_];
                    int i_9_ = 16777215;
                    if (class1_8_.method87(arg0 + 112, class1)) {
                        class1_8_
                                = class1_8_.method68(0, 0,
                                (class1_8_.method59(-3136)
                                        - class1.method59(arg0
                                        + -3134)));
                        if (class1_8_.method87(arg0 ^ ~0x6f,
                                Class46.aClass1_1117))
                            class1_8_ = (class1_8_.method68
                                    (0, 0, (class1_8_.method59(-3136)
                                            + -Class46.aClass1_1117
                                            .method59(-3136))));
                    }
                    if ((i_0_ ^ 0xffffffff) > (i_4_ ^ 0xffffffff)
                            && (i_4_ ^ 0xffffffff) > (i_0_ + i ^ 0xffffffff)
                            && -13 + i_7_ < i_5_ && 3 + i_7_ > i_5_)
                        i_9_ = 16776960;
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246
                            .method683(class1_8_, 3 + i_0_, i_7_, i_9_, true);
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ld.C(" + arg0 + ')');
        }
    }

    public static void method399(int arg0, int arg1, int arg2) {
        anInt744++;
        long l = (long) ((arg0 << -713372176) - -arg2);
        Class40_Sub5_Sub13 class40_sub5_sub13
                = ((Class40_Sub5_Sub13)
                Class40_Sub5_Sub8.aClass23_2545.method331(l, 6120));
        if (class40_sub5_sub13 != null) {
            Class19.aClass27_485.method367(true, class40_sub5_sub13);
            if (arg1 <= 11)
                aClass1_766 = null;
        }
    }

    public static int method400(int arg0) {
        try {
            if (arg0 != -1)
                packetBuffer = null;
            anInt753++;
            return Class45.anInt1073++;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ld.B(" + arg0 + ')');
        }
    }

    public static void method401(int arg0) {
        try {
            anIntArray774 = null;
            aClass38_768 = null;
            aClass1_766 = null;
            aClass1_772 = null;
            anIntArray761 = null;
            packetBuffer = null;
            if (arg0 >= 29)
                aClass6_Sub1_773 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ld.D(" + arg0 + ')');
        }
    }
}
