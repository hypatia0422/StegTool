/*
 * Decompiled with CFR 0_118.
 */
package Utilities;

import Utilities.BinaryToBytes;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;

public class ByteWriter {
    public static void writeBytesToFile(String bitFilePath, int totalNumBitsInFile, int numBitsToSkip, String portionType) {
        BufferedReader bufferedReader = null;
        BufferedOutputStream bufferedOutputStream = null;
        int numStegazaurusLocationBits = 0;
        int numBitsToPrepend = 0;
        String prependedBitString = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(bitFilePath + "\\Bit.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bitFilePath + "\\Byte.txt"));
            if (portionType == "SI") {
                numStegazaurusLocationBits = (int)(Math.log(totalNumBitsInFile) / Math.log(2.0));
                if (Math.log(totalNumBitsInFile) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                    ++numStegazaurusLocationBits;
                }
                if ((numBitsToPrepend = 8 - numStegazaurusLocationBits % 8) == 8) {
                    numBitsToPrepend = 0;
                }
            } else {
                numStegazaurusLocationBits = (int)(Math.log(totalNumBitsInFile) / Math.log(2.0));
                if (Math.log(totalNumBitsInFile) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                    ++numStegazaurusLocationBits;
                }
                if ((numBitsToPrepend = 8 - (numStegazaurusLocationBits + numBitsToSkip) % 8) == 8) {
                    numBitsToPrepend = 0;
                }
            }
            for (int a = 0; a < numBitsToPrepend; ++a) {
                prependedBitString = prependedBitString + '0';
            }
            if (numBitsToPrepend == 0) {
                String note = "*** Note: No extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly. ***\n\n";
                bufferedOutputStream.write(note.getBytes());
            } else if (numBitsToPrepend == 1) {
                String note = "*** Note: 1 extra '0' bit has been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note.getBytes());
            } else {
                String note = "*** Note: " + numBitsToPrepend + " extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note.getBytes());
            }
            bufferedOutputStream.write(BinaryToBytes.getByteArray(prependedBitString + bufferedReader.readLine()));
            bufferedReader.close();
            bufferedOutputStream.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFrameHeaderBytesToFile(File filePath, int numFramesInFile) {
        BufferedReader bufferedReader = null;
        BufferedOutputStream bufferedOutputStream = null;
        int numStegazaurusLocationBits = 0;
        int numBitsToPrepend = 0;
        String prependedBitString = "";
        try {
            String note;
            String note2;
            String note3;
            String note4;
            bufferedReader = new BufferedReader(new FileReader("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Bit\\Priv.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Byte\\Priv.txt"));
            numStegazaurusLocationBits = (int)(Math.log(numFramesInFile * 1) / Math.log(2.0));
            if (Math.log(numFramesInFile * 1) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                ++numStegazaurusLocationBits;
            }
            if ((numBitsToPrepend = 8 - (numStegazaurusLocationBits + 2) % 8) == 8) {
                numBitsToPrepend = 0;
            }
            for (int a = 0; a < numBitsToPrepend; ++a) {
                prependedBitString = prependedBitString + '0';
            }
            if (numBitsToPrepend == 0) {
                note4 = "*** Note: No extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly. ***\n\n";
                bufferedOutputStream.write(note4.getBytes());
            } else if (numBitsToPrepend == 1) {
                note4 = "*** Note: 1 extra '0' bit has been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note4.getBytes());
            } else {
                note4 = "*** Note: " + numBitsToPrepend + " extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note4.getBytes());
            }
            bufferedOutputStream.write(BinaryToBytes.getByteArray(prependedBitString + bufferedReader.readLine()));
            bufferedReader.close();
            bufferedOutputStream.close();
            prependedBitString = "";
            bufferedReader = new BufferedReader(new FileReader("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Bit\\PrivCopy.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Byte\\PrivCopy.txt"));
            numStegazaurusLocationBits = (int)(Math.log(numFramesInFile * 2) / Math.log(2.0));
            if (Math.log(numFramesInFile * 2) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                ++numStegazaurusLocationBits;
            }
            if ((numBitsToPrepend = 8 - (numStegazaurusLocationBits + 4) % 8) == 8) {
                numBitsToPrepend = 0;
            }
            for (int a2 = 0; a2 < numBitsToPrepend; ++a2) {
                prependedBitString = prependedBitString + '0';
            }
            if (numBitsToPrepend == 0) {
                note3 = "*** Note: No extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly. ***\n\n";
                bufferedOutputStream.write(note3.getBytes());
            } else if (numBitsToPrepend == 1) {
                note3 = "*** Note: 1 extra '0' bit has been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note3.getBytes());
            } else {
                note3 = "*** Note: " + numBitsToPrepend + " extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note3.getBytes());
            }
            bufferedOutputStream.write(BinaryToBytes.getByteArray(prependedBitString + bufferedReader.readLine()));
            bufferedReader.close();
            bufferedOutputStream.close();
            prependedBitString = "";
            bufferedReader = new BufferedReader(new FileReader("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Bit\\PrivCopyOrig.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Byte\\PrivCopyOrig.txt"));
            numStegazaurusLocationBits = (int)(Math.log(numFramesInFile * 3) / Math.log(2.0));
            if (Math.log(numFramesInFile * 3) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                ++numStegazaurusLocationBits;
            }
            if ((numBitsToPrepend = 8 - (numStegazaurusLocationBits + 6) % 8) == 8) {
                numBitsToPrepend = 0;
            }
            for (int a3 = 0; a3 < numBitsToPrepend; ++a3) {
                prependedBitString = prependedBitString + '0';
            }
            if (numBitsToPrepend == 0) {
                note2 = "*** Note: No extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly. ***\n\n";
                bufferedOutputStream.write(note2.getBytes());
            } else if (numBitsToPrepend == 1) {
                note2 = "*** Note: 1 extra '0' bit has been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note2.getBytes());
            } else {
                note2 = "*** Note: " + numBitsToPrepend + " extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note2.getBytes());
            }
            bufferedOutputStream.write(BinaryToBytes.getByteArray(prependedBitString + bufferedReader.readLine()));
            bufferedReader.close();
            bufferedOutputStream.close();
            prependedBitString = "";
            bufferedReader = new BufferedReader(new FileReader("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Bit\\PrivCopyOrigEmph1.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Byte\\PrivCopyOrigEmph1.txt"));
            numStegazaurusLocationBits = (int)(Math.log(numFramesInFile * 4) / Math.log(2.0));
            if (Math.log(numFramesInFile * 4) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                ++numStegazaurusLocationBits;
            }
            if ((numBitsToPrepend = 8 - (numStegazaurusLocationBits + 8) % 8) == 8) {
                numBitsToPrepend = 0;
            }
            for (int a4 = 0; a4 < numBitsToPrepend; ++a4) {
                prependedBitString = prependedBitString + '0';
            }
            if (numBitsToPrepend == 0) {
                note = "*** Note: No extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly. ***\n\n";
                bufferedOutputStream.write(note.getBytes());
            } else if (numBitsToPrepend == 1) {
                note = "*** Note: 1 extra '0' bit has been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note.getBytes());
            } else {
                note = "*** Note: " + numBitsToPrepend + " extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note.getBytes());
            }
            bufferedOutputStream.write(BinaryToBytes.getByteArray(prependedBitString + bufferedReader.readLine()));
            bufferedReader.close();
            bufferedOutputStream.close();
            prependedBitString = "";
            bufferedReader = new BufferedReader(new FileReader("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Bit\\PrivCopyOrigEmph1Emph2.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("Extracted_Information\\" + filePath.getName().toString() + "\\FrameHeaderBits\\Byte\\PrivCopyOrigEmph1Emph2.txt"));
            numStegazaurusLocationBits = (int)(Math.log(numFramesInFile * 5) / Math.log(2.0));
            if (Math.log(numFramesInFile * 5) / Math.log(2.0) - (double)numStegazaurusLocationBits > 0.0) {
                ++numStegazaurusLocationBits;
            }
            if ((numBitsToPrepend = 8 - (numStegazaurusLocationBits + 10) % 8) == 8) {
                numBitsToPrepend = 0;
            }
            for (int a5 = 0; a5 < numBitsToPrepend; ++a5) {
                prependedBitString = prependedBitString + '0';
            }
            if (numBitsToPrepend == 0) {
                String note5 = "*** Note: No extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly. ***\n\n";
                bufferedOutputStream.write(note5.getBytes());
            } else if (numBitsToPrepend == 1) {
                String note6 = "*** Note: 1 extra '0' bit has been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note6.getBytes());
            } else {
                String note7 = "*** Note: " + numBitsToPrepend + " extra '0' bits have been prepended to the following extracted information to make the byte values line up and display correctly! ***\n\n";
                bufferedOutputStream.write(note7.getBytes());
            }
            bufferedOutputStream.write(BinaryToBytes.getByteArray(prependedBitString + bufferedReader.readLine()));
            bufferedReader.close();
            bufferedOutputStream.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeDataBytesToFile(String filePath, String dataToBeWritten) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            bufferedOutputStream.write(BinaryToBytes.getByteArray(dataToBeWritten));
            bufferedOutputStream.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

