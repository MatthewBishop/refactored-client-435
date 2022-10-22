package org.runejs.client.input;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.JagCRC;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.console.Console;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.scene.tile.WallDecoration;
import org.runejs.client.*;
import org.runejs.client.cache.def.FramemapDefinition;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.IdentityKit;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.Configuration;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyFocusListener implements KeyListener, FocusListener {
    public static LinkedList aLinkedList_1278 = new LinkedList();
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1285;

    public static void draw3dScreen() {
        Wall.renderSplitPrivateMessages();
        if (LinkedList.crossType == 1) {
            Class37.cursorCross[OverlayDefinition.crossIndex / 100].drawImage(ClientScriptRunner.crossX - 8 - 4, MovedStatics.crossY - 8 - 4);
        }
        if (LinkedList.crossType == 2) {
            Class37.cursorCross[4 + OverlayDefinition.crossIndex / 100].drawImage(ClientScriptRunner.crossX - 8 - 4, MovedStatics.crossY - 8 - 4);
        }
        if (GameInterface.gameScreenInterfaceId != -1 || GroundItemTile.walkableWidgetId != -1) {
                int var5 = GameInterface.gameScreenInterfaceId != -1 ? 0 : 4;
                int id = GameInterface.gameScreenInterfaceId != -1 ? GameInterface.gameScreenInterfaceId : GroundItemTile.walkableWidgetId;
                Renderable.handleSequences(GameInterface.gameScreenInterfaceId);
                int yOffset = (ScreenController.drawHeight /2) - (334/2) - (184/2);
                int xOffset = (ScreenController.drawWidth /2) - (512/2) - (234/3);
                if(ScreenController.frameMode == ScreenMode.FIXED) {
                    yOffset = 0;
                    xOffset = 0;
                }
                Main.drawParentInterface(var5, xOffset, yOffset, 512+ xOffset, 334 + yOffset, id);
        }
        Class65.method1018();
        Player.setTutorialIslandFlag();
        if (!MovedStatics.menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else  {
            if(ScreenController.frameMode == ScreenMode.FIXED && Projectile.menuScreenArea == 0){
                MovedStatics.drawMenu(4,4);
            }
        }
        if (MovedStatics.anInt2118 == 1) {
            LinkedList.aClass40_Sub5_Sub14_Sub4_1057.drawImage(472, 296);
        }
        if (InteractiveObject.showFps) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }

            int colour = 0xffff00;
            if (GenericTile.fps < 30 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (GenericTile.fps < 20 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            WallDecoration.fontNormal.drawStringRight("Fps: " + GenericTile.fps, x, y, colour);
            colour = 0xffff00;
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int memoryUsed = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            if (memoryUsed > 32768 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (memoryUsed < 65536 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            WallDecoration.fontNormal.drawStringRight("Mem: " + memoryUsed + "k", x, y, colour);
            y += 15;

            WallDecoration.fontNormal.drawStringRight("MouseX: " + Class13.mouseX, x, y ,0xffff00);
            y += 15;

            WallDecoration.fontNormal.drawStringRight("MouseY: " + Landscape.mouseY, x, y ,0xffff00);
            y += 15;
            WallDecoration.fontNormal.drawStringRight("ClickX: " + Class57.clickX, x, y ,0xffff00);
            y += 15;

            WallDecoration.fontNormal.drawStringRight("ClickY: " + RSString.clickY, x, y ,0xffff00);
            y += 15;
            if (MovedStatics.showSidePanelRedrawnText) {
                WallDecoration.fontNormal.drawStringRight(English.sidePanelRedrawn, x, y, 16711680);
                y += 15;
                MovedStatics.showSidePanelRedrawnText = false;
            }
            if (MovedStatics.showChatPanelRedrawnText) {
                WallDecoration.fontNormal.drawStringRight(English.chatPanelRedrawn, x, y, 16711680);
                y += 15;
                MovedStatics.showChatPanelRedrawnText = false;
            }
            if (Class40_Sub3.showIconsRedrawnText) {
                WallDecoration.fontNormal.drawStringRight(English.iconsRedrawn, x, y, 16711680);
                Class40_Sub3.showIconsRedrawnText = false;
                y += 15;
            }
        }
        if (Configuration.DEBUG_WIDGETS) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }
            int widgetParentId = GenericTile.hoveredWidgetId >> 16;
            int widgetChildId = GenericTile.hoveredWidgetId & 0x7fff;
            String typeAsString = "";

            // Gather widget metadata from the cached interfaces
            GameInterface[] parentInterface;
            GameInterface childInterface = null;
            if (widgetParentId >= 0 && widgetChildId < 469) {
                parentInterface = GameInterface.cachedInterfaces[widgetParentId];

                if (parentInterface != null) {
                    childInterface = parentInterface[widgetChildId];
                }

                if (childInterface != null) {
                    switch (childInterface.type) {
                        case TEXT:
                            typeAsString = "TEXT";
                            break;
                        case GRAPHIC:
                            typeAsString = "GRAPHIC";
                            break;
                        case MODEL:
                            typeAsString = "MODEL";
                            break;
                        case RECTANGLE:
                            typeAsString = "RECTANGLE";
                            break;
                        case INVENTORY:
                            typeAsString = "INVENTORY";
                            break;
                        case LINE:
                            typeAsString = "LINE";
                            break;
                        case TEXT_INVENTORY:
                            typeAsString = "TEXT_INVENTORY";
                            break;
                        case LAYER:
                            typeAsString = "LAYER";
                            break;
                        case IF1_TOOLTIP:
                            typeAsString = "IF1_TOOLTIP";
                            break;
                        default:
                            typeAsString = "UNKNOWN";
                    }
                }
            }

            WallDecoration.fontNormal.drawStringRight("Widget " + widgetParentId + ":" + widgetChildId, x, y, 0xffff00);
            y+= 15;
            if (childInterface != null) {
                WallDecoration.fontNormal.drawStringRight("Parent ID: " + childInterface.parentId, x, y, 0xffff00);
                y+= 15;
                WallDecoration.fontNormal.drawStringRight("Type: " + typeAsString, x, y, 0xffff00);
                y+= 15;
            }
            
        }
        if (Class40_Sub5_Sub15.systemUpdateTime != 0) {
            int seconds = Class40_Sub5_Sub15.systemUpdateTime / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if (seconds < 10) {
                WallDecoration.fontNormal.drawString(English.systemUpdateIn + minutes + Native.prefixColonZero + seconds, 4, 329, 16776960);
            } else {
                WallDecoration.fontNormal.drawString(English.systemUpdateIn + minutes + Native.colon + seconds, 4, 329, 16776960);
            }
        }
    }

    public static int method955(CacheArchive arg0) {
        int i = 0;
        if (arg0.method194(Native.aClass1_638, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.chatback, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.mapBack, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1395, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_256, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_338, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.imgBackleft1, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1024, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_281, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.backright2, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1788, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1374, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_2588, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_196, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_304, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_2093, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_3254, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_1517, Native.aClass1_305)) {
            i++;
        }
        if (arg0.method194(Native.aClass1_2787, Native.aClass1_305)) {
            i++;
        }
        return i;

    }

    public static String method956(int arg0, Buffer arg1) {
        if (arg0 < 62) {
            aLinkedList_1278 = null;
        }
        return MovedStatics.method307(arg1, -1, 32767);
    }

    public void keyTyped(KeyEvent arg0) {
        arg0.consume();
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if (Class59.keyFocusListener != null) {
            GameObjectDefinition.anInt2543 = -1;
        }
    }

    public synchronized void keyPressed(KeyEvent keyEvent) {
        if (Class59.keyFocusListener != null) {
            Class49.anInt1147 = 0;
            int obfuscatedKeyCode = keyEvent.getKeyCode();
            int eventKeyCode = keyEvent.getKeyCode();
            if (obfuscatedKeyCode >= 0 && HuffmanEncoding.anIntArray1564.length > obfuscatedKeyCode) {
                obfuscatedKeyCode = HuffmanEncoding.anIntArray1564[obfuscatedKeyCode];
                if ((0x80 & obfuscatedKeyCode) != 0) {
                    obfuscatedKeyCode = -1;
                }
            } else {
                obfuscatedKeyCode = -1;
            }
            int keyChar;
//            for (int i = 0; i < HuffmanEncoding.anIntArray1564.length; i++) {
//                System.out.println("In: " + i + ", out: " + HuffmanEncoding.anIntArray1564[i]);
//            }

            if (eventKeyCode == KeyEvent.VK_BACK_SPACE || eventKeyCode == KeyEvent.VK_TAB || eventKeyCode == 0xA /* Unused key */ || eventKeyCode == KeyEvent.VK_ESCAPE || eventKeyCode == KeyEvent.VK_DELETE) {
                keyChar = -1;
            } else {
                keyChar = Class51.getKeyChar(keyEvent);
            }
            if (eventKeyCode == 192 || eventKeyCode == 129) {
                Console.console.consoleOpen = !Console.console.consoleOpen;
            }
            if (GameObjectDefinition.anInt2543 >= 0 && obfuscatedKeyCode >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = obfuscatedKeyCode;
                GameObjectDefinition.anInt2543 = 0x7f & GameObjectDefinition.anInt2543 + 1;
                if (GameObjectDefinition.anInt2543 == FramemapDefinition.anInt2183) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
            if (obfuscatedKeyCode >= 0 || keyChar >= 0) {
                int i_5_ = 0x7f & 1 + IdentityKit.anInt2598;
                if (Class59.anInt1389 != i_5_) {
                    MovedStatics.anIntArray2113[IdentityKit.anInt2598] = obfuscatedKeyCode;
                    MovedStatics.anIntArray2764[IdentityKit.anInt2598] = keyChar;
                    IdentityKit.anInt2598 = i_5_;
                }
            }
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent arg0) {
        if (Class59.keyFocusListener != null) {
            Class49.anInt1147 = 0;
            int i = arg0.getKeyCode();

            if (i < 0 || HuffmanEncoding.anIntArray1564.length <= i) {
                i = -1;
            } else {
                i = ~0x80 & HuffmanEncoding.anIntArray1564[i];
            }
            if (GameObjectDefinition.anInt2543 >= 0 && i >= 0) {
                RSString.keyCodes[GameObjectDefinition.anInt2543] = i ^ 0xffffffff;
                GameObjectDefinition.anInt2543 = 0x7f & 1 + GameObjectDefinition.anInt2543;
                if (FramemapDefinition.anInt2183 == GameObjectDefinition.anInt2543) {
                    GameObjectDefinition.anInt2543 = -1;
                }
            }
        }
        arg0.consume();
    }
}
