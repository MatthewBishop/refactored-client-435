package org.runejs.client;

import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.SceneTile;

public class Class65 {
    public static int cameraVertical;

    static {
        cameraVertical = 128;
    }


    public static void method1018() {
        MovedStatics.gameScreenImageProducer.prepareRasterizer();
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(Class24.fullScreenTextureArray);
    }

    public static void method1020() {
        Class59.anIntArray1398 = new int[104];
        OverlayDefinition.tile_underlay_path = new byte[4][104][104];
        MovedStatics.anIntArrayArrayArray262 = new int[4][105][105];
        MovedStatics.lowestPlane = 99;
        InteractiveObject.aByteArrayArrayArray492 = new byte[4][105][105];
        FloorDecoration.anIntArray612 = new int[104];
        MovedStatics.anIntArray1579 = new int[104];
        SceneTile.anIntArray2048 = new int[104];
        AnimationSequence.anIntArrayArray2490 = new int[105][105];
        MouseHandler.tile_overlayids = new byte[4][104][104];
        Class40_Sub5_Sub17_Sub6.anIntArray3250 = new int[104];
        Class35.tile_overlay_rotation = new byte[4][104][104];
        MovedStatics.tile_underlayids = new byte[4][104][104];
    }
}
