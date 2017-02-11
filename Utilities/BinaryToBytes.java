/*
 * Decompiled with CFR 0_118.
 */
package Utilities;

public class BinaryToBytes {
    public static byte[] getByteArray(String bitString) {
        int numBitsLeftOver = bitString.length() % 8;
        StringBuilder temp1 = new StringBuilder(bitString.substring(bitString.length() - numBitsLeftOver, bitString.length()));
        bitString = bitString.substring(0, bitString.length() - numBitsLeftOver) + temp1.toString();
        int numBytes = bitString.length() / 8;
        byte[] byteArray = new byte[numBytes];
        int byteValue = 0;
        for (int i = 0; i < numBytes; ++i) {
            byteValue = 0;
            if (bitString.substring(i * 8, i * 8 + 8).charAt(0) == '1') {
                byteValue -= 128;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(1) == '1') {
                byteValue += 64;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(2) == '1') {
                byteValue += 32;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(3) == '1') {
                byteValue += 16;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(4) == '1') {
                byteValue += 8;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(5) == '1') {
                byteValue += 4;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(6) == '1') {
                byteValue += 2;
            }
            if (bitString.substring(i * 8, i * 8 + 8).charAt(7) == '1') {
                ++byteValue;
            }
            byteArray[i] = (byte)byteValue;
        }
        return byteArray;
    }
}

