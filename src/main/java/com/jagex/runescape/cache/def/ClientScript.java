package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.MemoryCache;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

public class ClientScript extends SubNode {
    public static LinkedList aLinkedList_2268 = new LinkedList();
    public static ProducingGraphicsBuffer chatboxRight;
    public static int crossY = 0;
    public static int anInt2278 = 0;
    public static int anInt2280 = 0;
    public static MemoryCache clientScriptCache = new MemoryCache(128);

    public int[] intOperands;
    public int intStackCount;
    public int stringStackCount;
    public int localStringCount;
    public String[] stringOperands;
    public int localIntCount;
    public int[] opcodes;


    public static void method543(CollisionMap arg0, int arg1, int arg2, int arg3, int arg4, Scene arg5, int arg6, int arg7, int arg8, int arg9) {
        int i = Class40_Sub6.tile_height[arg2][arg9][arg8];
        int i_0_ = Class40_Sub6.tile_height[arg2][1 + arg9][arg8];
        int i_1_ = Class40_Sub6.tile_height[arg2][arg9][1 + arg8];
        int i_2_ = Class40_Sub6.tile_height[arg2][arg9 + 1][arg8 + 1];
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(arg1);
        int i_3_ = i_2_ + i_0_ + i + i_1_ >> 2;
        int i_4_ = (arg7 << 6) + arg4;
        int i_5_ = arg9 - (-(arg8 << 7) - (arg1 << 14) - 1073741824);
        if (gameObjectDefinition.hasActions == 0)
            i_5_ += -2147483648;
        if (gameObjectDefinition.supportsItems == 1)
            i_4_ += 256;
        if (arg4 == 22) {
            Renderable renderable;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 22, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 22, i_0_);
            arg5.addGroundDecoration(arg9, arg8, arg3, i_3_, i_5_, renderable, i_4_);
            if (gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1)
                arg0.markBlocked(arg8, arg9);
        } else if (arg4 == 10 || arg4 == 11) {
            Renderable renderable;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 10, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 10, i_0_);
            if (renderable != null) {
                int i_6_;
                int i_7_;
                if (arg7 == 1 || arg7 == 3) {
                    i_6_ = gameObjectDefinition.sizeX;
                    i_7_ = gameObjectDefinition.sizeY;
                } else {
                    i_7_ = gameObjectDefinition.sizeX;
                    i_6_ = gameObjectDefinition.sizeY;
                }
                int i_8_ = 0;
                if (arg4 == 11)
                    i_8_ += 256;
                arg5.addEntityB(arg9, arg8, arg3, i_3_, i_8_, i_6_, i_7_, i_5_, renderable, i_4_);
            }
            if (gameObjectDefinition.solid)
                arg0.unmarkSolidOccupant(arg9, arg8, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, arg7, gameObjectDefinition.walkable);
        } else if (arg4 >= 12) {
            Renderable renderable;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, arg4, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, arg4, i_0_);
            arg5.addEntityB(arg9, arg8, arg3, i_3_, 0, 1, 1, i_5_, renderable, i_4_);
            if (gameObjectDefinition.solid)
                arg0.unmarkSolidOccupant(arg9, arg8, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, arg7, gameObjectDefinition.walkable);
        } else if (arg4 == 0) {
            Renderable renderable;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 0, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 0, i_0_);
            arg5.addWall(arg9, arg8, arg3, i_3_, SceneCluster.anIntArray761[arg7], 0, i_5_, renderable, null, i_4_);
            if (gameObjectDefinition.solid)
                arg0.unmarkWall(arg9, arg8, arg4, arg7, gameObjectDefinition.walkable);
        } else if (arg4 == 1) {
            Renderable renderable;
            if (gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 1, i_0_);
            else
                renderable = new GameObject(arg1, 1, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            arg5.addWall(arg9, arg8, arg3, i_3_, Class40_Sub5_Sub15.anIntArray2788[arg7], 0, i_5_, renderable, null, i_4_);
            if (gameObjectDefinition.solid)
                arg0.unmarkWall(arg9, arg8, arg4, arg7, gameObjectDefinition.walkable);
        } else if (arg4 == 2) {
            int i_9_ = arg7 + 1 & 0x3;
            Renderable renderable;
            Renderable renderable_10_;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null) {
                renderable = new GameObject(arg1, 2, 4 + arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
                renderable_10_ = new GameObject(arg1, 2, i_9_, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            } else {
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7 + 4, i, 2, i_0_);
                renderable_10_ = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, i_9_, i, 2, i_0_);
            }
            arg5.addWall(arg9, arg8, arg3, i_3_, SceneCluster.anIntArray761[arg7], SceneCluster.anIntArray761[i_9_], i_5_, renderable, renderable_10_, i_4_);
            if (gameObjectDefinition.solid)
                arg0.unmarkWall(arg9, arg8, arg4, arg7, gameObjectDefinition.walkable);
        } else if (arg4 == 3) {
            Renderable renderable;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 3, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 3, i_0_);
            arg5.addWall(arg9, arg8, arg3, i_3_, Class40_Sub5_Sub15.anIntArray2788[arg7], 0, i_5_, renderable, null, i_4_);
            if (gameObjectDefinition.solid)
                arg0.unmarkWall(arg9, arg8, arg4, arg7, gameObjectDefinition.walkable);
        } else if (arg4 == 9) {
            Renderable renderable;
            if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, arg4, arg7, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, arg4, i_0_);
            arg5.addEntityB(arg9, arg8, arg3, i_3_, 0, 1, 1, i_5_, renderable, i_4_);
            if (gameObjectDefinition.solid)
                arg0.unmarkSolidOccupant(arg9, arg8, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, arg7, gameObjectDefinition.walkable);
        } else {
            if (gameObjectDefinition.adjustToTerrain) {
                if (arg7 == 1) {
                    int i_13_ = i_1_;
                    i_1_ = i_2_;
                    i_2_ = i_0_;
                    i_0_ = i;
                    i = i_13_;
                } else if (arg7 == 2) {
                    int i_12_ = i_1_;
                    i_1_ = i_0_;
                    i_0_ = i_12_;
                    i_12_ = i_2_;
                    i_2_ = i;
                    i = i_12_;
                } else if (arg7 == 3) {
                    int i_11_ = i_1_;
                    i_1_ = i;
                    i = i_0_;
                    i_0_ = i_2_;
                    i_2_ = i_11_;
                }
            }
            if (arg4 == 4) {
                Renderable renderable;
                if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                    renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
                else
                    renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, i_0_);
                arg5.addWallDecoration(arg9, arg8, arg3, i_3_, 0, 0, 512 * arg7, i_5_, renderable, i_4_, SceneCluster.anIntArray761[arg7]);
            } else if (arg4 == 5) {
                int i_14_ = 16;
                int i_15_ = arg5.method122(arg3, arg9, arg8);
                if (i_15_ > 0)
                    i_14_ = GameObjectDefinition.getDefinition(i_15_ >> 14 & 0x7fff).setDecorDisplacement;
                Renderable renderable;
                if (gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, i_0_);
                else
                    renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
                arg5.addWallDecoration(arg9, arg8, arg3, i_3_, Class27.anIntArray666[arg7] * i_14_, ProducingGraphicsBuffer_Sub1.anIntArray2207[arg7] * i_14_, 512 * arg7, i_5_, renderable, i_4_, SceneCluster.anIntArray761[arg7]);
            } else if (arg6 == -22078) {
                if (arg4 == 6) {
                    Renderable renderable;
                    if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                        renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
                    else
                        renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, i_0_);
                    arg5.addWallDecoration(arg9, arg8, arg3, i_3_, 0, 0, arg7, i_5_, renderable, i_4_, 256);
                } else if (arg4 == 7) {
                    Renderable renderable;
                    if (gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, i_0_);
                    else
                        renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
                    arg5.addWallDecoration(arg9, arg8, arg3, i_3_, 0, 0, arg7, i_5_, renderable, i_4_, 512);
                } else if (arg4 == 8) {
                    Renderable renderable;
                    if (gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                        renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true);
                    else
                        renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, i_0_);
                    arg5.addWallDecoration(arg9, arg8, arg3, i_3_, 0, 0, arg7, i_5_, renderable, i_4_, 768);
                }
            }
        }

    }

    public static void processPlayerMenuOptions(Player player, int x, int y, int index) {
        if (Player.localPlayer != player && ActorDefinition.menuActionRow < 400) {
            String rsString;
            if (player.skillLevel == 0)
                rsString = player.playerName + SceneTile.getCombatLevelColour(Player.localPlayer.combatLevel, player.combatLevel) + Native.aClass1_569 + English.prefixLevel + player.combatLevel + Native.aClass1_1199;
            else
                rsString = player.playerName + Native.aClass1_569 + English.prefixSkill + player.skillLevel + Native.aClass1_1199;
            if (Class8.itemSelected == 1) {
                OverlayDefinition.addActionRow(English.use, index, x, y, 22, Native.aClass1_3295 + Native.aClass1_3068 + rsString);
            } else if (Main.widgetSelected == 1) {
                if ((ItemDefinition.selectedMask & 0x8) == 8) {
                    OverlayDefinition.addActionRow(Native.aClass1_1918, index, x, y, 1, Native.aClass1_611 + Native.aClass1_3068 + rsString);
                }
            } else {
                for (int i = 4; i >= 0; i--) {
                    if (Main.playerActions[i] != null) {
                        int i_16_ = 0;
                        int i_17_ = 0;
                        if (Main.playerActions[i].equalsIgnoreCase(English.attack)) {
                            if (Player.localPlayer.combatLevel < player.combatLevel)
                                i_17_ = 2000;
                            if (Player.localPlayer.teamId != 0 && player.teamId != 0) {
                                if (Player.localPlayer.teamId != player.teamId)
                                    i_17_ = 0;
                                else
                                    i_17_ = 2000;
                            }
                        } else if (Class13.playerArray[i])
                            i_17_ = 2000;
                        if (i == 0)
                            i_16_ = 10 + i_17_;
                        if (i == 1)
                            i_16_ = 39 + i_17_;
                        if (i == 2)
                            i_16_ = i_17_ + 44;
                        if (i == 3)
                            i_16_ = i_17_ + 14;
                        if (i == 4)
                            i_16_ = 41 + i_17_;
                        OverlayDefinition.addActionRow(Main.playerActions[i], index, x, y, i_16_, Native.aClass1_620 + rsString);
                    }
                }
            }
            for (int i = 0; i < ActorDefinition.menuActionRow; i++) {
                if (MovedStatics.menuActionTypes[i] == 7) {
                    Landscape.menuActionTexts[i] = English.walkHere + Native.aClass1_1117 + Native.aClass1_620 + rsString;
                    break;
                }
            }
        }

    }

    public static int method546(int arg0) {
        if(!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
        if (arg0 != 256)
            anInt2280 = 44;
        int i = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, Class40_Sub5_Sub6.cameraY);
        if (i + -SceneCluster.cameraZ < 800 && (OverlayDefinition.tile_flags[Player.worldLevel][Class12.cameraX >> 7][Class40_Sub5_Sub6.cameraY >> 7] & 0x4) != 0)
            return Player.worldLevel;
        return 3;
    }

    public static ClientScript decodeClientScript(int arg0, int arg1) {
        long l = arg0 + (arg1 << 16);
        ClientScript clientScript = (ClientScript) clientScriptCache.get(l);
        if(clientScript != null) {
            return clientScript;
        }

        Buffer buffer = new Buffer(MemoryCache.clientScriptCacheIndex.method170(Native.emptyString, arg1 + Native.comma + arg0));
        clientScript = new ClientScript();
        buffer.currentPosition = buffer.buffer.length - 12;
        int opcodeCount = buffer.getIntBE();
        int operandIndex = 0;
        clientScript.localIntCount = buffer.getUnsignedShortBE();
        clientScript.localStringCount = buffer.getUnsignedShortBE();
        clientScript.intStackCount = buffer.getUnsignedShortBE();
        clientScript.stringStackCount = buffer.getUnsignedShortBE();
        clientScript.stringOperands = new String[opcodeCount];
        clientScript.intOperands = new int[opcodeCount];
        buffer.currentPosition = 0;
        clientScript.opcodes = new int[opcodeCount];
        while(buffer.currentPosition < -12 + buffer.buffer.length) {
            int opcode = buffer.getUnsignedShortBE();
            if(opcode == 3) {
                clientScript.stringOperands[operandIndex] = buffer.getString();
            } else if(opcode >= 100 || opcode == 21 || opcode == 38 || opcode == 39) {
                clientScript.intOperands[operandIndex] = buffer.getUnsignedByte();
            } else {
                clientScript.intOperands[operandIndex] = buffer.getIntBE();
            }
            clientScript.opcodes[operandIndex++] = opcode;
        }
        clientScriptCache.put(l, clientScript);
        return clientScript;
    }
}