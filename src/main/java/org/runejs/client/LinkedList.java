package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.node.Node;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;

import java.awt.*;

public class LinkedList {
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_1057;
    public static int anInt1061;
    public static LinkedList aLinkedList_1064 = new LinkedList();
    public static int[] anIntArray1071;
    public static volatile int anInt1073 = 0;
    public static int crossType = 0;
    public static int[] minimapHintY = new int[1000];
    public Node aClass40_1056 = new Node();
    public Node aClass40_1068;

    public LinkedList() {

        aClass40_1056.previous = aClass40_1056;
        aClass40_1056.next = aClass40_1056;

    }



    public static String method903(int arg0) {
        String class1 = Integer.toString(arg0);
        for(int i = -3 + class1.length(); i > 0; i -= 3)
            class1 = class1.substring(0, i) + Native.aClass1_795 + class1.substring(i);
        if(class1.length() > 8)
            class1 = Native.green + class1.substring(0, -8 + class1.length()) + English.suffixMillion + Native.aClass1_1213 + class1 + Native.rightParenthasis;
        else if(class1.length() > 4)
            class1 = Native.cyan + class1.substring(0, class1.length() + -4) + Native.aClass1_2593 + Native.aClass1_1213 + class1 + Native.rightParenthasis;
        return Native.aClass1_1123 + class1;
    }

    public static void drawChatBoxGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            RSCanvas.chatBoxImageProducer.drawGraphics(17, 357, graphics);

        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method910() {
        if(VertexNormal.lowMemory && MovedStatics.onBuildTimePlane != Player.worldLevel)
            Actor.method789(Player.localPlayer.pathY[0], -1000, Class17.regionY, Class51.regionX, Player.localPlayer.pathX[0], Player.worldLevel);
        else if(Buffer.anInt1985 != Player.worldLevel) {
            Buffer.anInt1985 = Player.worldLevel;
            MovedStatics.method299((byte) 53, Player.worldLevel);
        }
    }

    public Node method899() {
        Node class40 = aClass40_1056.previous;
        if(class40 == aClass40_1056)
            return null;
        class40.remove();
        return class40;
    }

    public Node last() {
        Node class40 = aClass40_1056.previous;
        if(class40 == aClass40_1056) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.previous;
        return class40;
    }

    public Node method902() {
        Node class40 = aClass40_1056.next;
        if(aClass40_1056 == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void pushBack(Node node) {
        if(node.previous != null)
            node.remove();
        node.previous = aClass40_1056.previous;
        node.next = aClass40_1056;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void method905(Node arg1) {
        if(arg1.previous != null)
            arg1.remove();
        arg1.next = aClass40_1056.next;
        arg1.previous = aClass40_1056;
        arg1.previous.next = arg1;
        arg1.next.previous = arg1;
    }

    public void clear() {
        for(; ; ) {
            Node class40 = aClass40_1056.next;
            if(class40 == aClass40_1056)
                break;
            class40.remove();
        }
    }

    public Node method909() {
        Node class40 = aClass40_1068;
        if(aClass40_1056 == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void method911(Node arg1, Node arg2) {
        if(arg2.previous != null)
            arg2.remove();
        arg2.next = arg1;
        arg2.previous = arg1.previous;
        arg2.previous.next = arg2;
        arg2.next.previous = arg2;
    }

    public Node previous() {
        Node class40 = aClass40_1068;
        if(class40 == aClass40_1056) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.previous;
        return class40;
    }

    public Node method913() {
        Node class40 = aClass40_1056.next;
        if(aClass40_1056 == class40)
            return null;
        class40.remove();
        return class40;
    }
}
