/*
 * Decompiled with CFR 0_118.
 */
package FrameViewer;

import Utilities.BytesToBinary;
import domain.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameViewer {
    public static void frameViewerMenu(ArrayList<Frame> frameArrayList, File filePath) {
        String welcomeString = "";
        int menuChoice = 0;
        welcomeString = welcomeString + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nMP3StegDetector - MP3 Frame Viewer\n\n\n";
        welcomeString = welcomeString + "Selected File: " + filePath + "\n\n";
        welcomeString = welcomeString + "Number of MP3 frames in file: " + frameArrayList.size() + "\n\n";
        welcomeString = welcomeString + "1 - View an MP3 frame based on its index number (0 to " + (frameArrayList.size() - 1) + ")\n";
        welcomeString = welcomeString + "2 - View an MP3 frame based on its beginning decimal address\n";
        welcomeString = welcomeString + "3 - View an MP3 frame based on its beginning hexadecimal address\n";
        welcomeString = welcomeString + "0 - Exit MP3 Frame Viewer\n\n";
        welcomeString = welcomeString + "Please enter your choice: ";
        do {
            System.out.print(welcomeString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                menuChoice = Integer.parseInt(reader.readLine().trim());
            }
            catch (IOException ex) {
                Logger.getLogger(FrameViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (menuChoice < 0 || menuChoice > 3) {
                System.out.print("\nInvalid choice! Please enter a valid menu choice: ");
                reader = null;
                reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    menuChoice = Integer.parseInt(reader.readLine().trim());
                }
                catch (IOException ex) {
                    Logger.getLogger(FrameViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            switch (menuChoice) {
                case 1: {
                    FrameViewer.viewFrameOption1(frameArrayList, filePath);
                    break;
                }
                case 2: {
                    FrameViewer.viewFrameOption2(frameArrayList, filePath);
                }
            }
        } while (menuChoice != 0);
    }

    private static void viewFrameOption1(ArrayList<Frame> frameArrayList, File filePath) {
        int frameChoice = 0;
        System.out.print("\nPlease enter the frame's index number: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            frameChoice = Integer.parseInt(reader.readLine().trim());
        }
        catch (IOException ex) {
            Logger.getLogger(FrameViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (frameChoice < 0 || frameChoice > frameArrayList.size() - 1) {
            System.out.print("\nInvalid frame number! Please enter a valid frame number: ");
            reader = null;
            reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                frameChoice = Integer.parseInt(reader.readLine().trim());
            }
            catch (IOException ex) {
                Logger.getLogger(FrameViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FrameViewer.displayFrame(frameArrayList.get(frameChoice), frameArrayList, filePath);
    }

    private static void viewFrameOption2(ArrayList<Frame> frameArrayList, File filePath) {
        int frameAddressChoice = 0;
        HashMap<Integer, Frame> frameAddressMap = new HashMap<Integer, Frame>();
        for (Frame frame : frameArrayList) {
            frameAddressMap.put(frame.getFrameIndex(), frame);
        }
        System.out.print("\nPlease enter the frame's beginning decimal address: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            frameAddressChoice = Integer.parseInt(reader.readLine().trim());
        }
        catch (IOException ex) {
            Logger.getLogger(FrameViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (!frameAddressMap.containsKey(frameAddressChoice)) {
            System.out.print("\nInvalid beginning frame address! Please enter a valid beginning decimal frame address: ");
            reader = null;
            reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                frameAddressChoice = Integer.parseInt(reader.readLine().trim());
            }
            catch (IOException ex) {
                Logger.getLogger(FrameViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FrameViewer.displayFrame((Frame)frameAddressMap.get(frameAddressChoice), frameArrayList, filePath);
    }

    private static void displayFrame(Frame frame, ArrayList<Frame> frameArrayList, File filePath) {
        StringBuilder frameString = new StringBuilder();
        frameString.append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n----------------------------------------------------------------\n\n");
        frameString.append("Currently viewing frame " + frame.getId() + " / " + (frameArrayList.size() - 1) + " of file \"" + filePath + "\"\n");
        frameString.append("Frame's beginning decimal address: " + frame.getFrameIndex() + "\n");
        frameString.append("Frame's reported length: " + frame.getFrameLength() + " bytes");
        if (frame.isSpecialFrameFlag()) {
            frameString.append(" *\n");
            frameString.append("* Frame's actual length: " + frame.getFrameBytes().size() + " bytes\n\n");
        } else {
            frameString.append("\n\n");
        }
        frameString.append("----------------------------------------------------------------\n\n");
        frameString.append("Header Portion:\n\n");
        frameString.append("Byte 1: " + BytesToBinary.getBinaryString(frame.getHeaderBytes().get(0).byteValue()) + "\n");
        frameString.append("Byte 2: " + BytesToBinary.getBinaryString(frame.getHeaderBytes().get(1).byteValue()) + "\n");
        frameString.append("Byte 3: " + BytesToBinary.getBinaryString(frame.getHeaderBytes().get(2).byteValue()) + "\n");
        frameString.append("Byte 4: " + BytesToBinary.getBinaryString(frame.getHeaderBytes().get(3).byteValue()) + "\n\n");
        frameString.append("MPEG Audio Version: " + frame.getMpegAudioVersion() + "\n");
        frameString.append("Layer: " + frame.getLayer() + "\n");
        frameString.append("Protection Bit set? ");
        if (frame.isProtectionBitSet()) {
            frameString.append("Yes. 2-byte CRC Field NOT present.\n");
        } else {
            frameString.append("No. 2-byte CRC Field present after Header Portion. (See below)\n");
        }
        frameString.append("BitRate: " + frame.getBitRate() / 1000.0 + " kbps\n");
        frameString.append("Sampling Frequency: " + frame.getSamplingFrequency() / 1000.0 + " kHz\n");
        frameString.append("Padding Bit set? ");
        if (frame.isPaddingBitSet()) {
            frameString.append("Yes. Frame extended by 1 byte.\n");
        } else {
            frameString.append("No. Frame not extended by 1 byte.\n");
        }
        frameString.append("Channel Mode: " + frame.getChannelMode() + "\n");
        frameString.append("Mode Extenstion: " + frame.getModeExtension() + "\n");
        frameString.append("Emphasis Type: " + frame.getEmphasisType() + "\n");
        frameString.append("Private Bit set? ");
        if (frame.isPaddingBitSet()) {
            frameString.append("Yes.\n");
        } else {
            frameString.append("No.\n");
        }
        frameString.append("Copyright Bit set? ");
        if (frame.isCopyrightBitSet()) {
            frameString.append("Yes.\n");
        } else {
            frameString.append("No.\n");
        }
        frameString.append("Original Bit set? ");
        if (frame.isOriginalBitSet()) {
            frameString.append("Yes.\n\n");
        } else {
            frameString.append("No.\n\n");
        }
        frameString.append("----------------------------------------------------------------\n\n");
        if (!frame.isProtectionBitSet()) {
            frameString.append("CRC Field:\n\n");
            frameString.append("Byte 1: " + BytesToBinary.getBinaryString(frame.getCrcBytes().get(0).byteValue()) + "\n");
            frameString.append("Byte 2: " + BytesToBinary.getBinaryString(frame.getCrcBytes().get(1).byteValue()) + "\n\n");
            frameString.append("----------------------------------------------------------------\n\n");
        }
        if (frame.getChannelMode().equals("Single Channel")) {
            frameString.append("Side Information Portion:\n\n");
            frameString.append("Byte 1:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(0).byteValue()) + "\n");
            frameString.append("Byte 2:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(1).byteValue()) + "\n");
            frameString.append("Byte 3:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(2).byteValue()) + "\n");
            frameString.append("Byte 4:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(3).byteValue()) + "\n");
            frameString.append("Byte 5:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(4).byteValue()) + "\n");
            frameString.append("Byte 6:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(5).byteValue()) + "\n");
            frameString.append("Byte 7:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(6).byteValue()) + "\n");
            frameString.append("Byte 8:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(7).byteValue()) + "\n");
            frameString.append("Byte 9:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(8).byteValue()) + "\n");
            frameString.append("Byte 10: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(9).byteValue()) + "\n");
            frameString.append("Byte 11: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(10).byteValue()) + "\n");
            frameString.append("Byte 12: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(11).byteValue()) + "\n");
            frameString.append("Byte 13: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(12).byteValue()) + "\n");
            frameString.append("Byte 14: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(13).byteValue()) + "\n");
            frameString.append("Byte 15: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(14).byteValue()) + "\n");
            frameString.append("Byte 16: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(15).byteValue()) + "\n");
            frameString.append("Byte 17: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(16).byteValue()) + "\n\n");
            frameString.append("Main_Data_Begin Field value: " + frame.getMain_data_beginBytes() + " bytes\n");
            frameString.append("Padding Bit contents: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(1).byteValue()).substring(1, 6) + "\n\n\n");
            frameString.append("Granule 1 Information:\n\n");
            frameString.append("Part2_3_Length Field value: " + frame.getPart2_3_lengthBits1() + " bits\n");
            frameString.append("Big_Values Field value: " + frame.getBig_valuesLengthBits1() + " bits\n");
            frameString.append("Table_Select Field value: " + frame.getTable_selectBits1() + " bits\n\n\n");
            frameString.append("Granule 2 Information:\n\n");
            frameString.append("Part2_3_Length Field value: " + frame.getPart2_3_lengthBits2() + " bits\n");
            frameString.append("Big_Values Field value: " + frame.getBig_valuesLengthBits2() + " bits\n");
            frameString.append("Table_Select Field value: " + frame.getTable_selectBits2() + " bits\n\n");
            frameString.append("Empty Frame? ");
            if (frame.getBig_valuesLengthBits1() + frame.getBig_valuesLengthBits2() + frame.getTable_selectBits1() + frame.getTable_selectBits2() == 0) {
                frameString.append("Yes\n\n");
            } else {
                frameString.append("No\n\n");
            }
        } else {
            frameString.append("Side Information Portion:\n\n");
            frameString.append("Byte 1:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(0).byteValue()) + "\n");
            frameString.append("Byte 2:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(1).byteValue()) + "\n");
            frameString.append("Byte 3:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(2).byteValue()) + "\n");
            frameString.append("Byte 4:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(3).byteValue()) + "\n");
            frameString.append("Byte 5:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(4).byteValue()) + "\n");
            frameString.append("Byte 6:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(5).byteValue()) + "\n");
            frameString.append("Byte 7:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(6).byteValue()) + "\n");
            frameString.append("Byte 8:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(7).byteValue()) + "\n");
            frameString.append("Byte 9:  " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(8).byteValue()) + "\n");
            frameString.append("Byte 10: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(9).byteValue()) + "\n");
            frameString.append("Byte 11: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(10).byteValue()) + "\n");
            frameString.append("Byte 12: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(11).byteValue()) + "\n");
            frameString.append("Byte 13: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(12).byteValue()) + "\n");
            frameString.append("Byte 14: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(13).byteValue()) + "\n");
            frameString.append("Byte 15: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(14).byteValue()) + "\n");
            frameString.append("Byte 16: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(15).byteValue()) + "\n");
            frameString.append("Byte 17: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(16).byteValue()) + "\n");
            frameString.append("Byte 18: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(17).byteValue()) + "\n");
            frameString.append("Byte 19: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(18).byteValue()) + "\n");
            frameString.append("Byte 20: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(19).byteValue()) + "\n");
            frameString.append("Byte 21: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(20).byteValue()) + "\n");
            frameString.append("Byte 22: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(21).byteValue()) + "\n");
            frameString.append("Byte 23: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(22).byteValue()) + "\n");
            frameString.append("Byte 24: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(23).byteValue()) + "\n");
            frameString.append("Byte 25: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(24).byteValue()) + "\n");
            frameString.append("Byte 26: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(25).byteValue()) + "\n");
            frameString.append("Byte 27: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(26).byteValue()) + "\n");
            frameString.append("Byte 28: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(27).byteValue()) + "\n");
            frameString.append("Byte 29: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(28).byteValue()) + "\n");
            frameString.append("Byte 30: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(29).byteValue()) + "\n");
            frameString.append("Byte 31: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(30).byteValue()) + "\n");
            frameString.append("Byte 32: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(31).byteValue()) + "\n\n");
            frameString.append("Main_Data_Begin Field value: " + frame.getMain_data_beginBytes() + " bytes\n");
            frameString.append("Padding Bit contents: " + BytesToBinary.getBinaryString(frame.getSideInformationBytes().get(1).byteValue()).substring(1, 4) + "\n\n\n");
            frameString.append("Granule 1, Channel 1 Information:\n\n");
            frameString.append("Part2_3_Length Field value: " + frame.getPart2_3_lengthBits1() + " bits\n");
            frameString.append("Big_Values Field value: " + frame.getBig_valuesLengthBits1() + " bits\n");
            frameString.append("Table_Select Field value: " + frame.getTable_selectBits1() + " bits\n\n\n");
            frameString.append("Granule 1, Channel 2 Information:\n\n");
            frameString.append("Part2_3_Length Field value: " + frame.getPart2_3_lengthBits2() + " bits\n");
            frameString.append("Big_Values Field value: " + frame.getBig_valuesLengthBits2() + " bits\n");
            frameString.append("Table_Select Field value: " + frame.getTable_selectBits2() + " bits\n\n\n");
            frameString.append("Granule 2, Channel 1 Information:\n\n");
            frameString.append("Part2_3_Length Field value: " + frame.getPart2_3_lengthBits3() + " bits\n");
            frameString.append("Big_Values Field value: " + frame.getBig_valuesLengthBits3() + " bits\n");
            frameString.append("Table_Select Field value: " + frame.getTable_selectBits3() + " bits\n\n\n");
            frameString.append("Granule 2, Channel 2 Information:\n\n");
            frameString.append("Part2_3_Length Field value: " + frame.getPart2_3_lengthBits4() + " bits\n");
            frameString.append("Big_Values Field value: " + frame.getBig_valuesLengthBits4() + " bits\n");
            frameString.append("Table_Select Field value: " + frame.getTable_selectBits4() + " bits\n\n");
            frameString.append("Empty Frame? ");
            if (frame.isEmptyFrameFlag()) {
                frameString.append("Yes\n\n");
            } else {
                frameString.append("No\n\n");
            }
        }
        frameString.append("----------------------------------------------------------------\n\n");
        frameString.append("Main Data Portion:\n\n");
        frameString.append("Main Data Portion length: " + frame.getMainDataBytes().size() + " bytes\n\n");
        for (int a = 0; a < frame.getMainDataBytes().size(); ++a) {
            frameString.append(BytesToBinary.getBinaryString(frame.getMainDataBytes().get(a).byteValue()));
        }
        frameString.append("\n\n");
        frameString.append("----------------------------------------------------------------\n\n");
        frameString.append("Frame information shown above.\n");
        frameString.append("Please press ENTER when finished viewing...");
        System.out.print(frameString.toString());
        Scanner pause = new Scanner(System.in);
        pause.nextLine();
    }
}

