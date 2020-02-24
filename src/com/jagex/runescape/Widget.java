package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.util.Signlink;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Date;

public class Widget extends SubNode {
    public static RSString aClass1_2637 = RSString.CreateString("glow2:");
    public static RSString aClass1_2671 = aClass1_2637;
    public static RSString aClass1_2674 = RSString.CreateString("Starting game engine)3)3)3");
    public static RSString aClass1_2684 = RSString.CreateString("Choose Option");
    public static RSString cmd_errortest = RSString.CreateString("::errortest");
    public static RSString aClass1_2716 = RSString.CreateString("Fehler beim Laden Ihres Charakter)2Profils");
    public static RSString goldCrown = RSString.CreateString("@cr2@");
    public static RSString aClass1_2740 = RSString.CreateString("Enter name of friend to add to list");
    public static int packetsize = 0;
    public static Widget[][] interfaces;

    public boolean isIf3 = false;
    public int contentType;
    public RSString alternateText;
    public boolean aBoolean2641;
    public int fontId;
    public int originalHeight;
    public Object[] anObjectArray2644;
    public boolean filled;
    public int textColor;
    public int parentId;
    public int originalX;
    public Object[] anObjectArray2650;
    public int anInt2651 = 1;
    public int alternateAnimation;
    public int anInt2654;
    public boolean itemUsable;
    public int currentX;
    public int rotationZ;
    public Object[] anObjectArray2658;
    public int animation;
    public int anInt2660;
    public RSString[] aClass1Array2661;
    public int alternateHoveredTextColor;
    public RSString targetVerb;
    public boolean textShadowed;
    public int itemSpritePadsY;
    public RSString text;
    public Object[] anObjectArray2669;
    public int alternateSpriteId;
    public Object[] anObjectArray2672;
    public int modelId;
    public RSString tooltip;
    public Object[] anObjectArray2677;
    public int offsetY2d;
    public Object[] anObjectArray2680;
    public Object[] anObjectArray2681;
    public boolean aBoolean2682;
    public int type;
    public int[] items;
    public int modelType;
    public boolean aBoolean2688;
    public int id;
    public int rotationX;
    public int originalWidth;
    public int[] alternateRhs;
    public boolean aBoolean2694;
    public Object[] anObjectArray2695;
    public int currentY;
    public RSString[] configActions;
    public int[] images;
    public boolean orthogonal;
    public int clickMask;
    public boolean itemSwapable;
    public int[] imageY;
    public Object[] anObjectArray2707;
    public int[] imageX;
    public RSString spellName;
    public int[] itemAmounts;
    public int alternateModelId;
    public Object[] anObjectArray2712;
    public Widget[] aWidgetArray2713;
    public int menuType;
    public int yTextAlignment;
    public int anInt2718;
    public int hoveredTextColor;
    public int scrollHeight;
    public int hoveredSiblingId;
    public int anInt2722;
    public boolean itemDeletesDraged;
    public int rotationY;
    public int alternateTextColor;
    public boolean isInventory;
    public int modelZoom;
    public boolean aBoolean2730;
    public int scrollPosition;
    public int lineHeight;
    public int xTextAlignment;
    public int anInt2734;
    public int anInt2736;
    public int offsetX2d;
    public int anInt2738;
    public int[] alternateOperators;
    public int originalY;
    public int spriteId;
    public int opacity;
    public int anInt2746;
    public Object[] anObjectArray2747;
    public int[][] clientScripts;
    public int itemSpritePadsX;
    public boolean isHidden;
    public int anInt2751;

    public Widget() {
        contentType = 0;
        rotationZ = 0;
        textShadowed = false;
        aBoolean2641 = false;
        targetVerb = Class22_Sub2.aClass1_1877;
        anInt2654 = 0;
        tooltip = Class39.str_ok;
        itemSpritePadsY = 0;
        anInt2660 = 0;
        modelType = 1;
        alternateAnimation = -1;
        textColor = 0;
        aBoolean2682 = false;
        modelId = -1;
        rotationX = 0;
        clickMask = 0;
        aBoolean2694 = false;
        parentId = -1;
        alternateHoveredTextColor = 0;
        aBoolean2688 = false;
        alternateSpriteId = -1;
        currentY = 0;
        alternateModelId = -1;
        originalX = 0;
        isInventory = false;
        alternateText = Class22_Sub2.aClass1_1877;
        itemSwapable = false;
        hoveredTextColor = 0;
        originalWidth = 0;
        animation = -1;
        xTextAlignment = 0;
        hoveredSiblingId = -1;
        spellName = Class22_Sub2.aClass1_1877;
        offsetY2d = 0;
        anInt2734 = 0;
        text = Class22_Sub2.aClass1_1877;
        id = -1;
        lineHeight = 0;
        itemUsable = false;
        filled = false;
        anInt2738 = -1;
        modelZoom = 100;
        itemDeletesDraged = false;
        anInt2722 = 0;
        yTextAlignment = 0;
        currentX = 0;
        orthogonal = false;
        spriteId = -1;
        aBoolean2730 = false;
        originalHeight = 0;
        opacity = 0;
        originalY = 0;
        rotationY = 0;
        anInt2746 = 0;
        offsetX2d = 0;
        isHidden = false;
        alternateTextColor = 0;
        scrollHeight = 0;
        scrollPosition = 0;
        anInt2736 = 0;
        anInt2718 = -1;
        itemSpritePadsX = 0;
        menuType = 0;
        anInt2751 = 0;
    }

    public static void method639(int arg0) {
        synchronized(Class59.aClass54_1392) {
            Class59.anInt1389 = Class52.anInt1214;
            if(GameObjectDefinition.anInt2543 < 0) {
                for(int i = 0; (i ^ 0xffffffff) > -113; i++) {
                    Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i] = false;
                }
                GameObjectDefinition.anInt2543 = Class40_Sub13.anInt2183;
            } else {
                while((Class40_Sub13.anInt2183 ^ 0xffffffff) != (GameObjectDefinition.anInt2543 ^ 0xffffffff)) {
                    int i = RSString.anIntArray1706[Class40_Sub13.anInt2183];
                    Class40_Sub13.anInt2183 = 0x7f & Class40_Sub13.anInt2183 + 1;
                    if((i ^ 0xffffffff) > -1) {
                        Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i ^ 0xffffffff] = false;
                    } else {
                        Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i] = true;
                    }
                }
            }
            Class52.anInt1214 = IdentityKit.anInt2598;
        }
        if(arg0 <= 121) {
            aClass1_2674 = null;
        }
    }

    public static void method640(byte arg0) {
        Class68.aClass9_1615.method235((byte) 49);
    }

    public static void method641(int arg0) {
        aClass1_2716 = null;
        aClass1_2671 = null;
        if(arg0 > -88) {
            method648(85, (byte) 24);
        }
        cmd_errortest = null;
        goldCrown = null;
        aClass1_2637 = null;
        aClass1_2674 = null;
        aClass1_2740 = null;
        aClass1_2684 = null;
    }

    public static void method642(Component arg0, int arg1) {
        if(arg1 != -10) {
            method639(-106);
        }
        Method method = Signlink.aMethod729;
        if(method != null) {
            try {
                method.invoke(arg0, Boolean.FALSE);
            } catch(Throwable throwable) {
                /* empty */
            }
        }
        arg0.addKeyListener(Class59.aClass54_1392);
        arg0.addFocusListener(Class59.aClass54_1392);
    }

    public static void method645(byte arg0) {
        Class58.aClass9_1364.method235((byte) 118);
        VertexNormal.aClass9_1102.method235((byte) -42);
        if(arg0 != -37) {
            aClass1_2637 = null;
        }
        Class19.aClass9_470.method235((byte) 103);
        Class49.aClass9_1145.method235((byte) 97);
    }

    public static RSString method648(int arg0, byte arg1) {
        if(arg1 != -100) {
            return null;
        }
        if(arg0 < 100000) {
            return HashTable.method334(arg0, -1);
        }
        if((arg0 ^ 0xffffffff) > -10000001) {
            return (Class40_Sub5_Sub17_Sub6.method832(110, new RSString[]{HashTable.method334(arg0 / 1000, -1), IdentityKit.aClass1_2587}));
        }
        return (Class40_Sub5_Sub17_Sub6.method832(-84, new RSString[]{HashTable.method334(arg0 / 1000000, arg1 ^ 0x63), Class22.aClass1_542}));
    }

    public static void method891(Object[] arg0, int arg1, int arg2, Widget arg3, int arg4, boolean arg5) {

        Class43.anInt1015++;
        int i = 0;
        Class40_Sub5_Sub1 class40_sub5_sub1 = IdentityKit.method626(((Integer) arg0[0]).intValue(), 76, 27);
        int[] is = class40_sub5_sub1.anIntArray2262;
        int[] is_0_ = class40_sub5_sub1.anIntArray2272;
        int i_1_ = 0;
        int i_2_ = -1;
        int i_3_ = -1;
        try {
            anIntArray2086 = new int[class40_sub5_sub1.anInt2271];
            Class51.aClass1Array1204 = new RSString[class40_sub5_sub1.anInt2267];
            int i_4_ = 0;
            int i_5_ = 0;
            if(arg5 != false) {
                Class43.cameraYawOffset = -119;
            }
            for(int i_6_ = 1; i_6_ < arg0.length; i_6_++) {
                if(!(arg0[i_6_] instanceof Integer)) {
                    if(arg0[i_6_] instanceof RSString) {
                        Class51.aClass1Array1204[i_5_++] = (RSString) arg0[i_6_];
                    }
                } else {
                    int i_7_ = ((Integer) arg0[i_6_]).intValue();
                    if((i_7_ ^ 0xffffffff) == 2147483646) {
                        i_7_ = arg4;
                    }
                    if(i_7_ == -2147483646) {
                        i_7_ = arg2;
                    }
                    if(i_7_ == -2147483645) {
                        i_7_ = arg3.id;
                    }
                    if(i_7_ == -2147483644) {
                        i_7_ = arg1;
                    }
                    anIntArray2086[i_4_++] = i_7_;
                }
            }
            for(; ; ) {
                i_3_ = is_0_[++i_2_];
                if((i_3_ ^ 0xffffffff) > -101) {
                    if((i_3_ ^ 0xffffffff) == -1) {
                        Class67.anIntArray1588[i++] = is[i_2_];
                        continue;
                    }
                    if(i_3_ == 1) {
                        int i_8_ = is[i_2_];
                        Class67.anIntArray1588[i++] = Class58.varbitmasks[i_8_];
                        continue;
                    }
                    if(i_3_ == 2) {
                        int i_9_ = is[i_2_];
                        Class58.varbitmasks[i_9_] = Class67.anIntArray1588[--i];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -4) {
                        Class40_Sub11.aClass1Array2153[i_1_++] = class40_sub5_sub1.aClass1Array2270[i_2_];
                        continue;
                    }
                    if(i_3_ == 6) {
                        i_2_ += is[i_2_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -8) {
                        i -= 2;
                        if(Class67.anIntArray1588[i] != Class67.anIntArray1588[1 + i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(i_3_ == 8) {
                        i -= 2;
                        if((Class67.anIntArray1588[1 + i] ^ 0xffffffff) == (Class67.anIntArray1588[i] ^ 0xffffffff)) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -10) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] > Class67.anIntArray1588[i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -11) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] < Class67.anIntArray1588[i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -22) {
                        if((Class29.anInt678 ^ 0xffffffff) != -1) {
                            Class61 class61 = (Class56.aClass61Array1320[--Class29.anInt678]);
                            Class51.aClass1Array1204 = class61.aClass1Array1430;
                            anIntArray2086 = class61.anIntArray1420;
                            i_2_ = class61.anInt1433;
                            class40_sub5_sub1 = class61.aClass40_Sub5_Sub1_1419;
                            is = class40_sub5_sub1.anIntArray2262;
                            is_0_ = class40_sub5_sub1.anIntArray2272;
                            continue;
                        }
                        break;
                    }
                    if(i_3_ == 25) {
                        int i_10_ = is[i_2_];
                        Class67.anIntArray1588[i++] = Class40_Sub5_Sub6.method585(i_10_, 1369);
                        continue;
                    }
                    if(i_3_ == 27) {
                        int i_11_ = is[i_2_];
                        Class40_Sub2.method522(Class67.anIntArray1588[--i], i_11_, (byte) 118);
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -32) {
                        i -= 2;
                        if((Class67.anIntArray1588[i] <= Class67.anIntArray1588[i + 1])) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -33) {
                        i -= 2;
                        if((Class67.anIntArray1588[1 + i] <= Class67.anIntArray1588[i])) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(i_3_ == 33) {
                        Class67.anIntArray1588[i++] = anIntArray2086[is[i_2_]];
                        continue;
                    }
                    if(i_3_ == 34) {
                        anIntArray2086[is[i_2_]] = Class67.anIntArray1588[--i];
                        continue;
                    }
                    if(i_3_ == 35) {
                        Class40_Sub11.aClass1Array2153[i_1_++] = Class51.aClass1Array1204[is[i_2_]];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -37) {
                        Class51.aClass1Array1204[is[i_2_]] = Class40_Sub11.aClass1Array2153[--i_1_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -38) {
                        int i_12_ = is[i_2_];
                        i_1_ -= i_12_;
                        RSString class1 = (IdentityKit.method627(63, i_12_, i_1_, Class40_Sub11.aClass1Array2153));
                        Class40_Sub11.aClass1Array2153[i_1_++] = class1;
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -39) {
                        i--;
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -40) {
                        i_1_--;
                        continue;
                    }
                    if(i_3_ == 40) {
                        int i_13_ = is[i_2_];
                        Class40_Sub5_Sub1 class40_sub5_sub1_14_ = IdentityKit.method626(i_13_, 73, 65);
                        int[] is_15_ = new int[class40_sub5_sub1_14_.anInt2271];
                        RSString[] class1s = new RSString[class40_sub5_sub1_14_.anInt2267];
                        for(int i_16_ = 0; ((class40_sub5_sub1_14_.anInt2263 > i_16_)); i_16_++) {
                            is_15_[i_16_] = (Class67.anIntArray1588[i - (class40_sub5_sub1_14_.anInt2263 + -i_16_)]);
                        }
                        for(int i_17_ = 0; class40_sub5_sub1_14_.anInt2266 > i_17_; i_17_++) {
                            class1s[i_17_] = (Class40_Sub11.aClass1Array2153[(i_1_ - class40_sub5_sub1_14_.anInt2266 + i_17_)]);
                        }
                        i_1_ -= class40_sub5_sub1_14_.anInt2266;
                        i -= class40_sub5_sub1_14_.anInt2263;
                        Class61 class61 = new Class61();
                        class61.aClass1Array1430 = Class51.aClass1Array1204;
                        class61.aClass40_Sub5_Sub1_1419 = class40_sub5_sub1;
                        class61.anIntArray1420 = anIntArray2086;
                        class40_sub5_sub1 = class40_sub5_sub1_14_;
                        class61.anInt1433 = i_2_;
                        Class56.aClass61Array1320[Class29.anInt678++] = class61;
                        is = class40_sub5_sub1.anIntArray2262;
                        Class51.aClass1Array1204 = class1s;
                        i_2_ = -1;
                        anIntArray2086 = is_15_;
                        is_0_ = class40_sub5_sub1.anIntArray2272;
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -43) {
                        Class67.anIntArray1588[i++] = Class22_Sub1.anIntArray1847[is[i_2_]];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -44) {
                        Class22_Sub1.anIntArray1847[is[i_2_]] = Class67.anIntArray1588[--i];
                        continue;
                    }
                }
                boolean bool;
                bool = (is[i_2_] ^ 0xffffffff) == -2;
                if((i_3_ ^ 0xffffffff) > -1001) {
                    if((i_3_ ^ 0xffffffff) == -101) {
                        i -= 3;
                        int i_18_ = Class67.anIntArray1588[i];
                        int i_19_ = Class67.anIntArray1588[i + 1];
                        int i_20_ = Class67.anIntArray1588[i + 2];
                        Widget widget = forId(i_18_);
                        if(widget.aWidgetArray2713 == null) {
                            widget.aWidgetArray2713 = new Widget[1 + i_20_];
                        }
                        if((i_20_ ^ 0xffffffff) <= ((widget.aWidgetArray2713).length ^ 0xffffffff)) {
                            Widget[] widgets = new Widget[1 + i_20_];
                            for(int i_21_ = 0; (((widget.aWidgetArray2713).length > i_21_)); i_21_++) {
                                widgets[i_21_] = (widget.aWidgetArray2713[i_21_]);
                            }
                            widget.aWidgetArray2713 = widgets;
                        }
                        Widget widget_22_ = new Widget();
                        widget_22_.parentId = widget.id;
                        widget_22_.type = i_19_;
                        widget_22_.id = ((0xffff & widget.id) << -1708169617) + (-2147483648 + i_20_);
                        widget.aWidgetArray2713[i_20_] = widget_22_;
                        if(!bool) {
                            Class22_Sub2.aWidget_1887 = widget_22_;
                        } else {
                            Class40_Sub6.aWidget_2116 = widget_22_;
                        }
                    } else if(i_3_ == 101) {
                        Widget widget = (!bool ? Class22_Sub2.aWidget_1887 : Class40_Sub6.aWidget_2116);
                        Widget widget_23_ = forId((widget.parentId));
                        widget_23_.aWidgetArray2713[Class66.method1021((widget.id), 32767)] = null;
                    } else {
                        if(i_3_ != 102) {
                            break;
                        }
                        Widget widget = forId((Class67.anIntArray1588[--i]));
                        widget.aWidgetArray2713 = null;
                    }
                } else if(((i_3_ ^ 0xffffffff) <= -1001 && (i_3_ ^ 0xffffffff) > -1101) || ((i_3_ ^ 0xffffffff) <= -2001 && i_3_ < 2100)) {
                    Widget widget;
                    if(i_3_ >= 2000) {
                        widget = forId((Class67.anIntArray1588[--i]));
                        i_3_ -= 1000;
                    } else {
                        widget = (bool ? Class40_Sub6.aWidget_2116 : Class22_Sub2.aWidget_1887);
                    }
                    if((i_3_ ^ 0xffffffff) == -1001) {
                        i -= 2;
                        widget.currentX = Class67.anIntArray1588[i];
                        widget.currentY = Class67.anIntArray1588[i + 1];
                    } else if((i_3_ ^ 0xffffffff) == -1002) {
                        i -= 2;
                        widget.originalWidth = Class67.anIntArray1588[i];
                        widget.originalHeight = Class67.anIntArray1588[1 + i];
                    } else if(i_3_ == 1003) {
                        widget.isHidden = Class67.anIntArray1588[--i] == 1;
                    } else {
                        if(i_3_ != 1004) {
                            break;
                        }
                        widget.aBoolean2688 = Class67.anIntArray1588[--i] == 1;
                    }
                } else if((i_3_ ^ 0xffffffff) <= -1101 && i_3_ < 1200 || ((i_3_ ^ 0xffffffff) <= -2101 && (i_3_ ^ 0xffffffff) > -2201)) {
                    Widget widget;
                    if((i_3_ ^ 0xffffffff) > -2001) {
                        widget = (!bool ? Class22_Sub2.aWidget_1887 : Class40_Sub6.aWidget_2116);
                    } else {
                        widget = forId((Class67.anIntArray1588[--i]));
                        i_3_ -= 1000;
                    }
                    if(i_3_ == 1100) {
                        i -= 2;
                        widget.anInt2746 = Class67.anIntArray1588[i];
                        widget.scrollPosition = Class67.anIntArray1588[1 + i];
                    } else if(i_3_ == 1101) {
                        int i_24_ = Class67.anIntArray1588[--i];
                        int i_25_ = (0x7e0b & i_24_) >> 1185286442;
                        int i_26_ = i_24_ & 0x1f;
                        int i_27_ = i_24_ >> 2043942949 & 0x1f;
                        widget.textColor = ((i_27_ << 1110799051) + (i_25_ << -2109315117) + (i_26_ << -170628573));
                    } else if(i_3_ == 1102) {
                        widget.filled = Class67.anIntArray1588[--i] == 1;
                    } else if((i_3_ ^ 0xffffffff) == -1104) {
                        widget.opacity = Class67.anIntArray1588[--i];
                    } else if((i_3_ ^ 0xffffffff) == -1105) {
                        i--;
                    } else if(i_3_ == 1105) {
                        widget.spriteId = Class67.anIntArray1588[--i];
                    } else if((i_3_ ^ 0xffffffff) == -1107) {
                        widget.anInt2751 = Class67.anIntArray1588[--i];
                    } else if((i_3_ ^ 0xffffffff) == -1108) {
                        widget.aBoolean2641 = ((Class67.anIntArray1588[--i] ^ 0xffffffff) == -2);
                    } else if(i_3_ == 1108) {
                        widget.modelType = 1;
                        widget.modelId = Class67.anIntArray1588[--i];
                    } else if((i_3_ ^ 0xffffffff) == -1110) {
                        i -= 6;
                        widget.offsetX2d = Class67.anIntArray1588[i];
                        widget.offsetY2d = Class67.anIntArray1588[1 + i];
                        widget.rotationX = Class67.anIntArray1588[i + 2];
                        widget.rotationZ = Class67.anIntArray1588[3 + i];
                        widget.rotationY = Class67.anIntArray1588[4 + i];
                        widget.modelZoom = Class67.anIntArray1588[5 + i];
                    } else if((i_3_ ^ 0xffffffff) == -1111) {
                        widget.animation = Class67.anIntArray1588[--i];
                    } else if(i_3_ == 1111) {
                        widget.orthogonal = ((Class67.anIntArray1588[--i] ^ 0xffffffff) == -2);
                    } else if(i_3_ == 1112) {
                        widget.text = Class40_Sub11.aClass1Array2153[--i_1_];
                    } else if(i_3_ == 1113) {
                        widget.fontId = Class67.anIntArray1588[--i];
                    } else if((i_3_ ^ 0xffffffff) == -1115) {
                        i -= 3;
                        widget.xTextAlignment = Class67.anIntArray1588[i];
                        widget.yTextAlignment = Class67.anIntArray1588[i + 1];
                        widget.lineHeight = Class67.anIntArray1588[i + 2];
                    } else {
                        if((i_3_ ^ 0xffffffff) != -1116) {
                            break;
                        }
                        widget.textShadowed = Class67.anIntArray1588[--i] == 1;
                    }
                } else if((i_3_ < 1200 || (i_3_ ^ 0xffffffff) <= -1301) && ((i_3_ ^ 0xffffffff) > -2201 || i_3_ >= 2300)) {
                    if((i_3_ < 1300 || (i_3_ ^ 0xffffffff) <= -1401) && ((i_3_ ^ 0xffffffff) > -2301 || (i_3_ ^ 0xffffffff) <= -2401)) {
                        if(i_3_ < 1500) {
                            if(i_3_ == 1400) {
                                i -= 2;
                                int i_28_ = Class67.anIntArray1588[i + 1];
                                int i_29_ = Class67.anIntArray1588[i];
                                Widget widget = forId(i_29_);
                                if((widget.aWidgetArray2713) == null || ((widget.aWidgetArray2713).length <= i_28_) || (widget.aWidgetArray2713[i_28_]) == null) {
                                    Class67.anIntArray1588[i++] = 0;
                                } else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(!bool) {
                                        Class22_Sub2.aWidget_1887 = (widget.aWidgetArray2713[i_28_]);
                                    } else {
                                        Class40_Sub6.aWidget_2116 = (widget.aWidgetArray2713[i_28_]);
                                    }
                                }
                            } else if((i_3_ ^ 0xffffffff) == -1402) {
                                i -= 3;
                                int i_30_ = Class67.anIntArray1588[i];
                                int i_31_ = Class67.anIntArray1588[2 + i];
                                int i_32_ = Class67.anIntArray1588[i + 1];
                                Widget widget = (Class27.method361((interfaces[i_30_]), i_31_, true, 0, -1, 0, i_32_, 398));
                                if(widget != null) {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(!bool) {
                                        Class22_Sub2.aWidget_1887 = widget;
                                    } else {
                                        Class40_Sub6.aWidget_2116 = widget;
                                    }
                                } else {
                                    Class67.anIntArray1588[i++] = 0;
                                }
                            } else {
                                if((i_3_ ^ 0xffffffff) != -1403) {
                                    break;
                                }
                                i -= 3;
                                Widget widget = forId((Class67.anIntArray1588[i]));
                                int i_33_ = Class67.anIntArray1588[2 + i];
                                int i_34_ = Class67.anIntArray1588[i + 1];
                                Widget widget_35_ = (Class27.method361((widget.aWidgetArray2713), i_33_, true, widget.scrollPosition, widget.id, widget.anInt2746, i_34_, 398));
                                if(widget_35_ == null) {
                                    Class67.anIntArray1588[i++] = 0;
                                } else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(!bool) {
                                        Class22_Sub2.aWidget_1887 = widget_35_;
                                    } else {
                                        Class40_Sub6.aWidget_2116 = widget_35_;
                                    }
                                }
                            }
                        } else if(i_3_ < 1600) {
                            Widget widget = (bool ? Class40_Sub6.aWidget_2116 : (Class22_Sub2.aWidget_1887));
                            if(i_3_ == 1500) {
                                Class67.anIntArray1588[i++] = widget.currentX;
                            } else if((i_3_ ^ 0xffffffff) == -1502) {
                                Class67.anIntArray1588[i++] = widget.currentY;
                            } else if((i_3_ ^ 0xffffffff) == -1503) {
                                Class67.anIntArray1588[i++] = widget.originalWidth;
                            } else if(i_3_ == 1503) {
                                Class67.anIntArray1588[i++] = widget.originalHeight;
                            } else if((i_3_ ^ 0xffffffff) == -1505) {
                                Class67.anIntArray1588[i++] = (!widget.isHidden ? 0 : 1);
                            } else {
                                if((i_3_ ^ 0xffffffff) != -1506) {
                                    break;
                                }
                                Class67.anIntArray1588[i++] = widget.parentId;
                            }
                        } else if((i_3_ ^ 0xffffffff) <= -1701) {
                            if((i_3_ ^ 0xffffffff) > -2501) {
                                if((i_3_ ^ 0xffffffff) == -2402) {
                                    i -= 3;
                                    int i_36_ = Class67.anIntArray1588[1 + i];
                                    int i_37_ = Class67.anIntArray1588[i];
                                    int i_38_ = Class67.anIntArray1588[i + 2];
                                    Widget widget = (Class27.method361((interfaces[i_37_]), i_38_, false, 0, -1, 0, i_36_, 398));
                                    if(widget != null) {
                                        Class67.anIntArray1588[i++] = widget.id;
                                    } else {
                                        Class67.anIntArray1588[i++] = -1;
                                    }
                                } else {
                                    if((i_3_ ^ 0xffffffff) != -2403) {
                                        break;
                                    }
                                    i -= 3;
                                    Widget widget = (forId(Class67.anIntArray1588[i]));
                                    int i_39_ = Class67.anIntArray1588[1 + i];
                                    int i_40_ = Class67.anIntArray1588[i + 2];
                                    Widget widget_41_ = (Class27.method361((interfaces[(widget.id >> -291405296)]), i_40_, false, widget.scrollPosition, 0xffff & (widget.id), widget.anInt2746, i_39_, 398));
                                    if(widget_41_ != null) {
                                        Class67.anIntArray1588[i++] = (widget_41_.id);
                                    } else {
                                        Class67.anIntArray1588[i++] = -1;
                                    }
                                }
                            } else if((i_3_ ^ 0xffffffff) <= -2601) {
                                if((i_3_ ^ 0xffffffff) > -2701) {
                                    Widget widget = (forId(Class67.anIntArray1588[--i]));
                                    if((i_3_ ^ 0xffffffff) == -2601) {
                                        Class67.anIntArray1588[i++] = widget.anInt2746;
                                    } else {
                                        if(i_3_ != 2601) {
                                            break;
                                        }
                                        Class67.anIntArray1588[i++] = widget.scrollPosition;
                                    }
                                } else {
                                    if(i_3_ < 2800) {
                                        break;
                                    }
                                    if(i_3_ < 3100) {
                                        if(i_3_ == 3000) {
                                            int i_42_ = (Class67.anIntArray1588[--i]);
                                            if((CacheIndex_Sub1.anInt1819 ^ 0xffffffff) == 0) {
                                                PacketBuffer.method517(0, i_42_, -9225);
                                                CacheIndex_Sub1.anInt1819 = i_42_;
                                            }
                                        } else if(((i_3_ ^ 0xffffffff) == -3002) || ((i_3_ ^ 0xffffffff) == -3004)) {
                                            i -= 2;
                                            int i_43_ = (Class67.anIntArray1588[i]);
                                            int i_44_ = (Class67.anIntArray1588[i + 1]);
                                            Class33.method406(0, i_44_, i_43_, -128);
                                        } else if(i_3_ == 3002) {
                                            Widget widget = (!bool ? (Class22_Sub2.aWidget_1887) : (Class40_Sub6.aWidget_2116));
                                            if((CacheIndex_Sub1.anInt1819 ^ 0xffffffff) == 0) {
                                                PacketBuffer.method517((widget.id) & 0x7fff, (widget.parentId), -9225);
                                                CacheIndex_Sub1.anInt1819 = (widget.id);
                                            }
                                        } else {
                                            if((i_3_ ^ 0xffffffff) != -3004) {
                                                break;
                                            }
                                            Widget widget = (bool ? (Class40_Sub6.aWidget_2116) : (Class22_Sub2.aWidget_1887));
                                            int i_45_ = (Class67.anIntArray1588[--i]);
                                            Class33.method406((0x7fff & (widget.id)), i_45_, (widget.parentId), -121);
                                        }
                                    } else if(i_3_ >= 3200) {
                                        if((i_3_ ^ 0xffffffff) > -3301) {
                                            if((i_3_ ^ 0xffffffff) == -3201) {
                                                i -= 3;
                                                Class53.method950((Class67.anIntArray1588[i]), (byte) 55, (Class67.anIntArray1588[i + 1]), (Class67.anIntArray1588[2 + i]));
                                            } else if(i_3_ == 3201) {
                                                Class51.method942(257, (Class67.anIntArray1588[--i]));
                                            } else {
                                                if((i_3_ ^ 0xffffffff) != -3203) {
                                                    break;
                                                }
                                                i -= 2;
                                                Class57.method975((Class67.anIntArray1588[i + 1]), (byte) 110, (Class67.anIntArray1588[i]));
                                            }
                                        } else if(i_3_ < 3400) {
                                            if(i_3_ != 3300) {
                                                break;
                                            }
                                            Class67.anIntArray1588[i++] = pulseCycle;
                                        } else if(i_3_ < 4100) {
                                            if((i_3_ ^ 0xffffffff) == -4001) {
                                                i -= 2;
                                                int i_46_ = (Class67.anIntArray1588[i]);
                                                int i_47_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = i_46_ + i_47_;
                                            } else if((i_3_ ^ 0xffffffff) == -4002) {
                                                i -= 2;
                                                int i_48_ = (Class67.anIntArray1588[1 + i]);
                                                int i_49_ = (Class67.anIntArray1588[i]);
                                                Class67.anIntArray1588[i++] = i_49_ + -i_48_;
                                            } else if((i_3_ ^ 0xffffffff) == -4003) {
                                                i -= 2;
                                                int i_50_ = (Class67.anIntArray1588[i + 1]);
                                                int i_51_ = (Class67.anIntArray1588[i]);
                                                Class67.anIntArray1588[i++] = i_51_ * i_50_;
                                            } else if((i_3_ ^ 0xffffffff) == -4004) {
                                                i -= 2;
                                                int i_52_ = (Class67.anIntArray1588[i]);
                                                int i_53_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = i_52_ / i_53_;
                                            } else if(i_3_ == 4004) {
                                                int i_54_ = (Class67.anIntArray1588[--i]);
                                                Class67.anIntArray1588[i++] = (int) (Math.random() * (double) i_54_);
                                            } else if((i_3_ ^ 0xffffffff) == -4006) {
                                                int i_55_ = (Class67.anIntArray1588[--i]);
                                                Class67.anIntArray1588[i++] = (int) ((double) (1 + i_55_) * (Math.random()));
                                            } else if((i_3_ ^ 0xffffffff) == -4007) {
                                                i -= 5;
                                                int i_56_ = (Class67.anIntArray1588[1 + i]);
                                                int i_57_ = (Class67.anIntArray1588[i]);
                                                int i_58_ = (Class67.anIntArray1588[i + 3]);
                                                int i_59_ = (Class67.anIntArray1588[i + 4]);
                                                int i_60_ = (Class67.anIntArray1588[2 + i]);
                                                Class67.anIntArray1588[i++] = (i_57_ + ((i_59_ + -i_60_) * (-i_57_ + i_56_) / (i_58_ - i_60_)));
                                            } else if((i_3_ ^ 0xffffffff) == -4008) {
                                                i -= 2;
                                                int i_61_ = (Class67.anIntArray1588[i]);
                                                int i_62_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = i_61_ + (i_62_ * i_61_ / 100);
                                            } else if((i_3_ ^ 0xffffffff) == -4009) {
                                                i -= 2;
                                                int i_63_ = (Class67.anIntArray1588[i]);
                                                int i_64_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = (UnderlayDefinition.method619(1 << i_64_, i_63_));
                                            } else if((i_3_ ^ 0xffffffff) == -4010) {
                                                i -= 2;
                                                int i_65_ = (Class67.anIntArray1588[i]);
                                                int i_66_ = (Class67.anIntArray1588[1 + i]);
                                                Class67.anIntArray1588[i++] = (Class66.method1021(i_65_, -1 + -(1 << i_66_)));
                                            } else if(i_3_ == 4010) {
                                                i -= 2;
                                                int i_67_ = (Class67.anIntArray1588[i]);
                                                int i_68_ = (Class67.anIntArray1588[1 + i]);
                                                Class67.anIntArray1588[i++] = (((Class66.method1021(1 << i_68_, i_67_)) ^ 0xffffffff) != -1 ? 1 : 0);
                                            } else if(i_3_ == 4011) {
                                                i -= 2;
                                                int i_69_ = (Class67.anIntArray1588[i + 1]);
                                                int i_70_ = (Class67.anIntArray1588[i]);
                                                Class67.anIntArray1588[i++] = i_70_ % i_69_;
                                            } else if((i_3_ ^ 0xffffffff) == -4013) {
                                                i -= 2;
                                                int i_71_ = (Class67.anIntArray1588[i]);
                                                int i_72_ = (Class67.anIntArray1588[i + 1]);
                                                if(i_71_ != 0) {
                                                    Class67.anIntArray1588[i++] = (int) (Math.pow((double) i_71_, (double) i_72_));
                                                } else {
                                                    Class67.anIntArray1588[i++] = 0;
                                                }
                                            } else {
                                                if(i_3_ != 4013) {
                                                    break;
                                                }
                                                i -= 2;
                                                int i_73_ = (Class67.anIntArray1588[i]);
                                                int i_74_ = (Class67.anIntArray1588[1 + i]);
                                                if(i_73_ != 0) {
                                                    if((i_74_ ^ 0xffffffff) != -1) {
                                                        Class67.anIntArray1588[i++] = (int) (Math.pow((double) i_73_, (1.0 / (double) i_74_)));
                                                    } else {
                                                        Class67.anIntArray1588[i++] = 2147483647;
                                                    }
                                                } else {
                                                    Class67.anIntArray1588[i++] = 0;
                                                }
                                            }
                                        } else {
                                            if(i_3_ >= 4200) {
                                                break;
                                            }
                                            if(i_3_ == 4100) {
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                                int i_75_ = (Class67.anIntArray1588[--i]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(118, (new RSString[]{class1, (HashTable.method334(i_75_, -1))})));
                                            } else if(i_3_ == 4101) {
                                                i_1_ -= 2;
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[i_1_ + 1]);
                                                RSString class1_76_ = (Class40_Sub11.aClass1Array2153[i_1_]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(53, (new RSString[]{class1_76_, class1})));
                                            } else if(i_3_ == 4102) {
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                                int i_77_ = (Class67.anIntArray1588[--i]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(-115, (new RSString[]{class1, (Class66.method1024(true, (byte) -85, i_77_))})));
                                            } else if((i_3_ ^ 0xffffffff) == -4104) {
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = class1.toLowerCase();
                                            } else if((i_3_ ^ 0xffffffff) == -4105) {
                                                int i_78_ = (Class67.anIntArray1588[--i]);
                                                long l = (86400000L * ((long) i_78_ + 11745L));
                                                Class8.aCalendar279.setTime(new Date(l));
                                                int i_79_ = Class8.aCalendar279.get(5);
                                                int i_80_ = Class8.aCalendar279.get(2);
                                                int i_81_ = Class8.aCalendar279.get(1);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(-55, (new RSString[]{(HashTable.method334(i_79_, -1)), (Class27.aClass1_643), (Class40_Sub5_Sub17_Sub1.aClass1Array2964[i_80_]), (Class27.aClass1_643), (HashTable.method334(i_81_, -1))})));
                                            } else if((i_3_ ^ 0xffffffff) == -4106) {
                                                i_1_ -= 2;
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[i_1_]);
                                                RSString class1_82_ = (Class40_Sub11.aClass1Array2153[i_1_ + 1]);
                                                if((Player.localPlayer.aClass30_3282) == null || !(Player.localPlayer.aClass30_3282.aBoolean683)) {
                                                    Class40_Sub11.aClass1Array2153[i_1_++] = class1;
                                                } else {
                                                    Class40_Sub11.aClass1Array2153[i_1_++] = class1_82_;
                                                }
                                            } else if(i_3_ == 4106) {
                                                int i_83_ = (Class67.anIntArray1588[--i]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (HashTable.method334(i_83_, -1));
                                            } else {
                                                if(i_3_ != 4107) {
                                                    break;
                                                }
                                                i_1_ -= 2;
                                                Class67.anIntArray1588[i++] = (Class40_Sub11.aClass1Array2153[i_1_].method84((Class40_Sub11.aClass1Array2153[i_1_ + 1]), (byte) 109));
                                            }
                                        }
                                    } else if((i_3_ ^ 0xffffffff) == -3101) {
                                        RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                        Class44.method895(84, 0, class1, (Landscape.aClass1_1183));
                                    } else {
                                        if(i_3_ != 3101) {
                                            break;
                                        }
                                        i -= 2;
                                        ActorDefinition.method570(Class67.anIntArray1588[i], (Class67.anIntArray1588[i + 1]), (Player.localPlayer), -1);
                                    }
                                }
                            } else {
                                Widget widget = forId((Class67.anIntArray1588[--i]));
                                if((i_3_ ^ 0xffffffff) == -2501) {
                                    Class67.anIntArray1588[i++] = widget.currentX;
                                } else if((i_3_ ^ 0xffffffff) == -2502) {
                                    Class67.anIntArray1588[i++] = widget.currentY;
                                } else if((i_3_ ^ 0xffffffff) == -2503) {
                                    Class67.anIntArray1588[i++] = widget.originalWidth;
                                } else if(i_3_ == 2503) {
                                    Class67.anIntArray1588[i++] = widget.originalHeight;
                                } else if(i_3_ == 2504) {
                                    Class67.anIntArray1588[i++] = (widget.isHidden ? 1 : 0);
                                } else {
                                    if(i_3_ != 2505) {
                                        break;
                                    }
                                    Class67.anIntArray1588[i++] = widget.parentId;
                                }
                            }
                        } else {
                            Widget widget = (bool ? Class40_Sub6.aWidget_2116 : (Class22_Sub2.aWidget_1887));
                            if((i_3_ ^ 0xffffffff) == -1601) {
                                Class67.anIntArray1588[i++] = widget.anInt2746;
                            } else {
                                if(i_3_ != 1601) {
                                    break;
                                }
                                Class67.anIntArray1588[i++] = widget.scrollPosition;
                            }
                        }
                    } else {
                        Widget widget;
                        if((i_3_ ^ 0xffffffff) <= -2001) {
                            widget = forId((Class67.anIntArray1588[--i]));
                            i_3_ -= 1000;
                        } else {
                            widget = (!bool ? Class22_Sub2.aWidget_1887 : (Class40_Sub6.aWidget_2116));
                        }
                        if((i_3_ ^ 0xffffffff) <= -1301 && i_3_ <= 1309 || i_3_ >= 1314 && i_3_ <= 1317) {
                            RSString class1 = Class40_Sub11.aClass1Array2153[--i_1_];
                            Object[] objects = new Object[class1.length() + 1];
                            for(int i_84_ = objects.length - 1; (i_84_ ^ 0xffffffff) <= -2; i_84_--) {
                                if(class1.method55(-1 + i_84_, arg5) != 115) {
                                    objects[i_84_] = new Integer(Class67.anIntArray1588[--i]);
                                } else {
                                    objects[i_84_] = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                }
                            }
                            objects[0] = new Integer(Class67.anIntArray1588[--i]);
                            if(i_3_ == 1303) {
                                widget.anObjectArray2707 = objects;
                            }
                            if(i_3_ == 1317) {
                                widget.anObjectArray2680 = objects;
                            }
                            if((i_3_ ^ 0xffffffff) == -1305) {
                                widget.anObjectArray2658 = objects;
                            }
                            if((i_3_ ^ 0xffffffff) == -1303) {
                                widget.anObjectArray2644 = objects;
                            }
                            if((i_3_ ^ 0xffffffff) == -1317) {
                                widget.anObjectArray2747 = objects;
                            }
                            if(i_3_ == 1301) {
                                widget.anObjectArray2681 = objects;
                            }
                            if(i_3_ == 1300) {
                                widget.anObjectArray2677 = objects;
                            }
                            if((i_3_ ^ 0xffffffff) == -1316) {
                                widget.anObjectArray2695 = objects;
                            }
                            if((i_3_ ^ 0xffffffff) == -1307) {
                                widget.anObjectArray2669 = objects;
                            }
                            if((i_3_ ^ 0xffffffff) == -1306) {
                                widget.anObjectArray2672 = objects;
                            }
                            if(i_3_ == 1309) {
                                widget.anObjectArray2712 = objects;
                            }
                            if(i_3_ == 1308) {
                                widget.anObjectArray2650 = objects;
                            }
                        } else if((i_3_ ^ 0xffffffff) == -1311) {
                            int i_85_ = -1 + Class67.anIntArray1588[--i];
                            if((i_85_ ^ 0xffffffff) > -1 || (i_85_ ^ 0xffffffff) < -10) {
                                i_1_--;
                            } else {
                                if((widget.aClass1Array2661 == null) || (((widget.aClass1Array2661).length <= i_85_))) {
                                    RSString[] class1s = new RSString[1 + i_85_];
                                    if(widget.aClass1Array2661 != null) {
                                        for(int i_86_ = 0; (((widget.aClass1Array2661).length > i_86_)); i_86_++) {
                                            class1s[i_86_] = (widget.aClass1Array2661[i_86_]);
                                        }
                                    }
                                    widget.aClass1Array2661 = class1s;
                                }
                                widget.aClass1Array2661[i_85_] = (Class40_Sub11.aClass1Array2153[--i_1_]);
                            }
                        } else if((i_3_ ^ 0xffffffff) == -1312) {
                            widget.anInt2738 = Class67.anIntArray1588[--i];
                        } else if(i_3_ == 1312) {
                            widget.aBoolean2694 = (Class67.anIntArray1588[--i] ^ 0xffffffff) == -2;
                        } else {
                            if((i_3_ ^ 0xffffffff) != -1314) {
                                break;
                            }
                            i--;
                        }
                    }
                } else {
                    Widget widget;
                    if((i_3_ ^ 0xffffffff) > -2001) {
                        widget = (!bool ? Class22_Sub2.aWidget_1887 : Class40_Sub6.aWidget_2116);
                    } else {
                        widget = forId((Class67.anIntArray1588[--i]));
                        i_3_ -= 1000;
                    }
                    if(i_3_ == 1200) {
                        i -= 3;
                        int i_87_ = Class67.anIntArray1588[i];
                        int i_88_ = Class67.anIntArray1588[i + 2];
                        if((i_87_ ^ 0xffffffff) != 0) {
                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_87_, 10);
                            widget.modelType = 4;
                            widget.rotationX = class40_sub5_sub16.xan2d;
                            widget.rotationY = class40_sub5_sub16.zan2d;
                            widget.modelZoom = (100 * class40_sub5_sub16.zoom2d / i_88_);
                            widget.rotationZ = class40_sub5_sub16.yan2d;
                            widget.offsetY2d = class40_sub5_sub16.yOffset2d;
                            widget.offsetX2d = class40_sub5_sub16.xOffset2d;
                            widget.modelId = i_87_;
                        } else {
                            widget.modelType = 0;
                        }
                    } else if((i_3_ ^ 0xffffffff) == -1202) {
                        widget.modelType = 2;
                        widget.modelId = Class67.anIntArray1588[--i];
                    } else if(i_3_ == 1202) {
                        widget.modelType = 3;
                        widget.modelId = Player.localPlayer.aClass30_3282.method374(-20874);
                    } else {
                        if(i_3_ != 1203) {
                            break;
                        }
                        Widget widget_89_ = (!bool ? Class40_Sub6.aWidget_2116 : Class22_Sub2.aWidget_1887);
                        widget.anInt2738 = widget_89_.id;
                    }
                }
            }
        } catch(Exception exception) {
            /* empty */
        }

    }

    public static Widget forId(int arg0) {

        Class68.anInt1626++;
        int i = arg0 >> 16;
        int i_8_ = 0xffff & arg0;
        if(interfaces[i] == null || (interfaces[i][i_8_] == null)) {
            boolean bool = Class68.method1043(i);
            if(!bool)
                return null;
        }
        return interfaces[i][i_8_];

    }

    public void swapItems(int arg0, boolean arg1, int arg2) {
        int i = items[arg2];
        items[arg2] = items[arg0];
        items[arg0] = i;
        i = itemAmounts[arg2];
        itemAmounts[arg2] = itemAmounts[arg0];
        if(arg1 != false) {
            clientScripts = null;
        }
        itemAmounts[arg0] = i;
    }

    public void decodeIf1(Buffer buffer) {
        isIf3 = false;
        type = buffer.getUnsignedByte();
        menuType = buffer.getUnsignedByte();
        contentType = buffer.getUnsignedShortBE();
        originalX = currentX = buffer.getShortBE(); // originalX
        originalY = currentY = buffer.getShortBE(); // originalY
        originalWidth = buffer.getUnsignedShortBE();
        originalHeight = buffer.getUnsignedShortBE();
        opacity = buffer.getUnsignedByte();
        parentId = buffer.getUnsignedShortBE();
        if(parentId == 0xFFFF) {
            parentId = -1;
        }
        hoveredSiblingId = buffer.getUnsignedShortBE();
        if(hoveredSiblingId == 0xFFFF) {
            hoveredSiblingId = -1;
        }
        int var2 = buffer.getUnsignedByte();
        int var3;
        if(var2 > 0) {
            alternateOperators = new int[var2];
            alternateRhs = new int[var2];
            for(var3 = 0; var2 > var3; var3++) {
                alternateOperators[var3] = buffer.getUnsignedByte();
                alternateRhs[var3] = buffer.getUnsignedShortBE();
            }
        }
        var3 = buffer.getUnsignedByte();
        if(var3 > 0) {
            clientScripts = new int[var3][];
            for(int i_2_ = 0; (i_2_ < var3); i_2_++) {
                int i_3_ = buffer.getUnsignedShortBE();
                clientScripts[i_2_] = new int[i_3_];
                for(int i_4_ = 0; (i_3_ > i_4_); i_4_++) {
                    clientScripts[i_2_][i_4_] = buffer.getUnsignedShortBE();
                    if((clientScripts[i_2_][i_4_] ^ 0xffffffff) == -65536) {
                        clientScripts[i_2_][i_4_] = -1;
                    }
                }
            }
        }
        if(type == 0) {
            scrollHeight = buffer.getUnsignedShortBE();
            isHidden = buffer.getUnsignedByte() == 1;
        }
        if(type == 1) {
            buffer.getUnsignedShortBE();
            buffer.getUnsignedByte();
        }
        if(type == 2) {
            items = new int[originalHeight * originalWidth];
            itemAmounts = new int[originalHeight * originalWidth];
            itemSwapable = buffer.getUnsignedByte()== 1;
            isInventory = buffer.getUnsignedByte() == 1;
            itemUsable = buffer.getUnsignedByte() == 1;
            itemDeletesDraged = buffer.getUnsignedByte() == 1;
            itemSpritePadsX = buffer.getUnsignedByte();
            itemSpritePadsY = buffer.getUnsignedByte();
            imageX = new int[20];
            imageY = new int[20];
            images = new int[20];
            for(int sprite = 0; sprite < 20; sprite++) {
                int hasSprite = buffer.getUnsignedByte();
                if(hasSprite == 1) {
                    images[sprite] = buffer.getShortBE();
                    imageX[sprite] = buffer.getShortBE();
                    imageY[sprite] = buffer.getIntBE();
                } else {
                    imageY[sprite] = -1;
                }
            }
            configActions = new RSString[5];
            for(int i_7_ = 0; i_7_ < 5; i_7_++) {
                configActions[i_7_] = buffer.getRSString();
                if(configActions[i_7_].length() == 0) {
                    configActions[i_7_] = null;
                }
            }
        }
        if(type == 3) {
            filled = buffer.getUnsignedByte() == 1;
        }
        if(type == 4 || type == 1) {
            xTextAlignment = buffer.getUnsignedByte();
            yTextAlignment = buffer.getUnsignedByte();
            lineHeight = buffer.getUnsignedByte();
            fontId = buffer.getUnsignedShortBE();
            textShadowed = buffer.getUnsignedByte() == 1;
        }
        if(type == 4) {
            text = buffer.getRSString();
            alternateText = buffer.getRSString();
        }
        if(type == 1 || type == 3 || type == 4) {
            textColor = buffer.getIntBE();
        }
        if(type == 3 || type == 4) {
            alternateTextColor = buffer.getIntBE();
            hoveredTextColor = buffer.getIntBE();
            alternateHoveredTextColor = buffer.getIntBE();
        }
        if(type == 5) {
            spriteId = buffer.getIntBE();
            alternateSpriteId = buffer.getIntBE();
        }
        if(type == 6) {
            modelType = 1;
            modelId = buffer.getUnsignedShortBE();
            if(modelId == 0xFFFF) {
                modelId = -1;
            }
            anInt2651 = 1;
            alternateModelId = buffer.getUnsignedShortBE();
            if(alternateModelId == 0xFFFF) {
                alternateModelId = -1;
            }
            animation = buffer.getUnsignedShortBE();
            if(animation == 0xFFFF) {
                animation = -1;
            }
            alternateAnimation = buffer.getUnsignedShortBE();
            if(alternateAnimation == 0xFFFF) {
                alternateAnimation = -1;
            }
            modelZoom = buffer.getUnsignedShortBE();
            rotationX = buffer.getUnsignedShortBE();
            rotationZ = buffer.getUnsignedShortBE();
        }
        if(type == 7) {
            items = new int[originalWidth * originalHeight];
            itemAmounts = new int[originalWidth * originalHeight];
            xTextAlignment = buffer.getUnsignedByte();
            fontId = buffer.getUnsignedShortBE();
            textShadowed = buffer.getUnsignedByte() == 1;
            textColor = buffer.getIntBE();
            itemSpritePadsX = buffer.getShortBE();
            itemSpritePadsY = buffer.getShortBE();
            isInventory = buffer.getUnsignedByte() == 1;
            configActions = new RSString[5];
            for(int i_8_ = 0; i_8_ < 5; i_8_++) {
                configActions[i_8_] = buffer.getRSString();
                if(configActions[i_8_].length() == 0) {
                    configActions[i_8_] = null;
                }
            }
        }
        if(type == 8) {
            text = buffer.getRSString();
        }
        if(menuType == 2 || type == 2) {
            targetVerb = buffer.getRSString();
            spellName = buffer.getRSString();
            clickMask = buffer.getUnsignedShortBE();
        }
        if(menuType == 1 || menuType == 4 || menuType == 5 || menuType == 6) {
            tooltip = buffer.getRSString();
            if(tooltip.length() == 0) {
                if(menuType == 1) {
                    tooltip = Class39.str_ok;
                }
                if(menuType == 4) {
                    tooltip = RSRuntimeException.str_select;
                }
                if(menuType == 5) {
                    tooltip = RSRuntimeException.str_select;
                }
                if(menuType == 6) {
                    tooltip = CollisionMap.str_continue;
                }
            }
        }
    }

    public ImageRGB method638(byte arg0, int arg1) {
        Class40_Sub13.aBoolean2177 = false;
        if((arg1 ^ 0xffffffff) > -1 || imageY.length <= arg1) {
            return null;
        }
        int i = imageY[arg1];
        if((i ^ 0xffffffff) == 0) {
            return null;
        }
        int i_9_ = 124 % ((-15 - arg0) / 34);
        ImageRGB class40_sub5_sub14_sub4 = ((ImageRGB) Cache.aClass9_326.method231((long) i, (byte) 121));
        if(class40_sub5_sub14_sub4 != null) {
            return class40_sub5_sub14_sub4;
        }
        class40_sub5_sub14_sub4 = Class48.method927(0, Class40_Sub5_Sub15.aCacheIndex_2779, true, i);
        if(class40_sub5_sub14_sub4 != null) {
            Cache.aClass9_326.method230(-7208, (long) i, class40_sub5_sub14_sub4);
        } else {
            Class40_Sub13.aBoolean2177 = true;
        }
        return class40_sub5_sub14_sub4;
    }

    public ImageRGB method643(int arg0, boolean arg1) {
        Class40_Sub13.aBoolean2177 = false;
        int i;
        if(arg1) {
            i = alternateSpriteId;
        } else {
            i = spriteId;
        }
        if((i ^ 0xffffffff) == 0) {
            return null;
        }
        ImageRGB class40_sub5_sub14_sub4 = ((ImageRGB) Cache.aClass9_326.method231((long) i, (byte) 103));
        if(arg0 != 127) {
            isIf3 = false;
        }
        if(class40_sub5_sub14_sub4 != null) {
            return class40_sub5_sub14_sub4;
        }
        class40_sub5_sub14_sub4 = Class48.method927(0, Class40_Sub5_Sub15.aCacheIndex_2779, true, i);
        if(class40_sub5_sub14_sub4 == null) {
            Class40_Sub13.aBoolean2177 = true;
        } else {
            Cache.aClass9_326.method230(-7208, (long) i, class40_sub5_sub14_sub4);
        }
        return class40_sub5_sub14_sub4;
    }

    public void decodeIf3(Buffer buffer) {
        buffer.getUnsignedByte();
        isIf3 = true;
        type = buffer.getUnsignedByte();
        contentType = buffer.getUnsignedShortBE();
        originalX = currentX = buffer.getShortBE();
        originalY = currentY = buffer.getShortBE();
        originalWidth = buffer.getUnsignedShortBE();
        if(type == 9) {
            originalHeight = buffer.getShortBE();
        } else {
            originalHeight = buffer.getUnsignedShortBE();
        }
        parentId = buffer.getUnsignedShortBE();
        if(parentId == 0xFFFF) {
            parentId = -1;
        }
        isHidden = (buffer.getUnsignedByte() ^ 0xffffffff) == -2;
        aBoolean2688 = (buffer.getUnsignedByte() ^ 0xffffffff) == -2;
        if(type == 0) {
            anInt2746 = buffer.getUnsignedShortBE();
            scrollPosition = buffer.getUnsignedShortBE();
        }
        if((type ^ 0xffffffff) == -6) {
            spriteId = buffer.getIntBE();
            anInt2751 = buffer.getUnsignedShortBE();
            aBoolean2641 = (buffer.getUnsignedByte() ^ 0xffffffff) == -2;
            opacity = buffer.getUnsignedByte();
        }
        if(type == 6) {
            modelType = 1;
            modelId = buffer.getUnsignedShortBE();
            if((modelId ^ 0xffffffff) == -65536) {
                modelId = -1;
            }
            offsetX2d = buffer.getShortBE();
            offsetY2d = buffer.getShortBE();
            rotationX = buffer.getUnsignedShortBE();
            rotationZ = buffer.getUnsignedShortBE();
            rotationY = buffer.getUnsignedShortBE();
            modelZoom = buffer.getUnsignedShortBE();
            animation = buffer.getUnsignedShortBE();
            if((animation ^ 0xffffffff) == -65536) {
                animation = -1;
            }
            orthogonal = buffer.getUnsignedByte() == 1;
        }
        if(type == 4) {
            fontId = buffer.getUnsignedShortBE();
            text = buffer.getRSString();
            lineHeight = buffer.getUnsignedByte();
            xTextAlignment = buffer.getUnsignedByte();
            yTextAlignment = buffer.getUnsignedByte();
            textShadowed = buffer.getUnsignedByte() == 1;
            textColor = buffer.getIntBE();
        }
        if((type ^ 0xffffffff) == -4) {
            textColor = buffer.getIntBE();
            filled = (buffer.getUnsignedByte() ^ 0xffffffff) == -2;
            opacity = buffer.getUnsignedByte();
        }
        if(type == 9) {
            buffer.getUnsignedByte();
            textColor = buffer.getIntBE();
        }
        if(aBoolean2688) {
            anObjectArray2677 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2681 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2644 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2707 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2658 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2672 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2669 = FloorDecoration.method345((byte) 89, buffer);
            FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2650 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2712 = FloorDecoration.method345((byte) 89, buffer);
            FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2695 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2747 = FloorDecoration.method345((byte) 89, buffer);
            anObjectArray2680 = FloorDecoration.method345((byte) 89, buffer);
            isInventory = buffer.getUnsignedByte() == 1;
            anInt2736 = buffer.getUnsignedShortBE();
            aBoolean2694 = buffer.getUnsignedByte() == 1;
            buffer.getUnsignedByte();
            int i = buffer.getUnsignedByte();
            if(i > 0) {
                aClass1Array2661 = new RSString[i];
                for(int i_10_ = 0; (i_10_ < i); i_10_++) {
                    aClass1Array2661[i_10_] = buffer.getRSString();
                }
            }
            anInt2738 = buffer.getUnsignedShortBE();
            if((anInt2738 ^ 0xffffffff) == -65536) {
                anInt2738 = -1;
            }
        }
    }

    public Model method646(byte arg0, AnimationSequence arg1, int arg2, boolean arg3, Class30 arg4) {
        Class40_Sub13.aBoolean2177 = false;
        int i;
        int i_11_;
        if(arg3) {
            i_11_ = alternateModelId;
            i = anInt2651;
        } else {
            i = modelType;
            i_11_ = modelId;
        }
        if((i ^ 0xffffffff) == -1) {
            return null;
        }
        if((i ^ 0xffffffff) == -2 && (i_11_ ^ 0xffffffff) == 0) {
            return null;
        }
        if(arg0 <= 25) {
            aBoolean2688 = true;
        }
        Model class40_sub5_sub17_sub5 = ((Model) Class53.aClass9_1264.method231((long) ((i << -983578160) + i_11_), (byte) 59));
        if(class40_sub5_sub17_sub5 == null) {
            if((i ^ 0xffffffff) == -2) {
                class40_sub5_sub17_sub5 = Model.getModel(Cache.aCacheIndex_329, i_11_, 0);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64, 768, -50, -10, -50, true);
            }
            if((i ^ 0xffffffff) == -3) {
                class40_sub5_sub17_sub5 = ActorDefinition.getDefinition((byte) -101, i_11_).getHeadModel((byte) 122);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64, 768, -50, -10, -50, true);
            }
            if((i ^ 0xffffffff) == -4) {
                if(arg4 == null) {
                    return null;
                }
                class40_sub5_sub17_sub5 = arg4.method379(30);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64, 768, -50, -10, -50, true);
            }
            if((i ^ 0xffffffff) == -5) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_11_, 10);
                class40_sub5_sub17_sub5 = class40_sub5_sub16.method753(false, 10, 26910);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64 + (class40_sub5_sub16.ambient), 768 + (class40_sub5_sub16.contrast), -50, -10, -50, true);
            }
            Class53.aClass9_1264.method230(-7208, (long) ((i << -557905040) + i_11_), class40_sub5_sub17_sub5);
        }
        if(arg1 != null) {
            class40_sub5_sub17_sub5 = arg1.method598(arg2, class40_sub5_sub17_sub5, true);
        }
        return class40_sub5_sub17_sub5;
    }

    public TypeFace method647(byte arg0) {
        Class40_Sub13.aBoolean2177 = false;
        if((fontId ^ 0xffffffff) == -65536) {
            return null;
        }
        TypeFace class40_sub5_sub14_sub1 = ((TypeFace) Class67.aClass9_1582.method231((long) fontId, (byte) 67));
        if(arg0 != 34) {
            return null;
        }
        if(class40_sub5_sub14_sub1 != null) {
            return class40_sub5_sub14_sub1;
        }
        class40_sub5_sub14_sub1 = Class40_Sub5_Sub17_Sub1.method760(0, (byte) 36, (Class40_Sub5_Sub15.aCacheIndex_2779), fontId);
        if(class40_sub5_sub14_sub1 == null) {
            Class40_Sub13.aBoolean2177 = true;
        } else {
            Class67.aClass9_1582.method230(-7208, (long) fontId, class40_sub5_sub14_sub1);
        }
        return class40_sub5_sub14_sub1;
    }
}
