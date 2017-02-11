/*
 * Decompiled with CFR 0_118.
 */
package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    public static byte[] getFileBytes(File filePath) {
        int offset= 0;
        FileInputStream is = null;
        try {
            is = new FileInputStream(filePath);
        }
        catch (FileNotFoundException ex) {
            System.out.println("\nFile \"" + filePath + "\" Not Found!");
            return null;
        }
        long length = filePath.length();
        if (length > Integer.MAX_VALUE) {
            System.out.println("Error: File is too large!");
            return null;
        }
        byte[] bytes = new byte[(int)length];
        int numRead = 0;
        try {
            for (offset = 0; offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0; offset += numRead) {
            }
        }
        catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (offset < bytes.length) {
            try {
                throw new IOException("Could not completely read file " + filePath.getName());
            }
            catch (IOException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            is.close();
        }
        catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bytes;
    }
}

