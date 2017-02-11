/*
 * Decompiled with CFR 0_118.
 */
package Utilities;

public class BytesToBinary {
    public static String getBinaryString(byte b) {
        StringBuilder binaryString = new StringBuilder();
        if ((b & 128) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 64) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 32) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 16) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 8) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 4) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 2) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        if ((b & 1) != 0) {
            binaryString.append("1");
        } else {
            binaryString.append("0");
        }
        return binaryString.toString();
    }
}

