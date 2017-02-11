/*
 * Decompiled with CFR 0_118.
 */
package Utilities;

public class BinaryToDecimal {
    public static int getDecimalNumber(String binaryString) {
        int decimalNumber = 0;
        for (int a = 0; a < binaryString.length(); ++a) {
            if (binaryString.charAt(a) != '1') continue;
            decimalNumber = (int)((double)decimalNumber + Math.pow(2.0, binaryString.length() - 1 - a));
        }
        return decimalNumber;
    }
}

