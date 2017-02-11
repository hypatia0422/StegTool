/*
 * Decompiled with CFR 0_118.
 */
package Utilities;

import java.util.ArrayList;

public class FrameCharacteristics {
    public static String getMPEGAudioVersion(byte[] fileByteArray, int frameIndex) {
        String mpegAudioVersion = "";
        if ((fileByteArray[frameIndex + 1] & 16) == 0 && (fileByteArray[frameIndex + 1] & 8) == 0) {
            mpegAudioVersion = "MPEG-2.5";
        } else if ((fileByteArray[frameIndex + 1] & 16) == 0 && (fileByteArray[frameIndex + 1] & 8) != 0) {
            mpegAudioVersion = "Reserved";
        } else if ((fileByteArray[frameIndex + 1] & 16) != 0 && (fileByteArray[frameIndex + 1] & 8) == 0) {
            mpegAudioVersion = "MPEG-2";
        } else if ((fileByteArray[frameIndex + 1] & 16) != 0 && (fileByteArray[frameIndex + 1] & 8) != 0) {
            mpegAudioVersion = "MPEG-1";
        }
        return mpegAudioVersion;
    }

    public static String getLayer(byte[] fileByteArray, int frameIndex) {
        String layer = "";
        if ((fileByteArray[frameIndex + 1] & 4) == 0 && (fileByteArray[frameIndex + 1] & 2) == 0) {
            layer = "Reserved";
        } else if ((fileByteArray[frameIndex + 1] & 4) == 0 && (fileByteArray[frameIndex + 1] & 2) != 0) {
            layer = "Layer 3";
        } else if ((fileByteArray[frameIndex + 1] & 4) != 0 && (fileByteArray[frameIndex + 1] & 2) == 0) {
            layer = "Layer 2";
        } else if ((fileByteArray[frameIndex + 1] & 4) != 0 && (fileByteArray[frameIndex + 1] & 2) != 0) {
            layer = "Layer 1";
        }
        return layer;
    }

    public static double getBitRate(byte[] fileByteArray, int frameIndex) {
        double bitRate = 0.0;
        bitRate = (fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 32000.0 : ((fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 40000.0 : ((fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 48000.0 : ((fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 56000.0 : ((fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 64000.0 : ((fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 80000.0 : ((fileByteArray[frameIndex + 2] & 128) == 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 96000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 112000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 128000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 160000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) == 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 192000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 224000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) == 0 && (fileByteArray[frameIndex + 2] & 16) != 0 ? 256000.0 : ((fileByteArray[frameIndex + 2] & 128) != 0 && (fileByteArray[frameIndex + 2] & 64) != 0 && (fileByteArray[frameIndex + 2] & 32) != 0 && (fileByteArray[frameIndex + 2] & 16) == 0 ? 320000.0 : 0.0)))))))))))));
        return bitRate;
    }

    public static double getSamplingFrequency(byte[] fileByteArray, int frameIndex) {
        double samplingFrequency = 0.0;
        samplingFrequency = (fileByteArray[frameIndex + 2] & 8) == 0 && (fileByteArray[frameIndex + 2] & 4) == 0 ? 44100.0 : ((fileByteArray[frameIndex + 2] & 8) == 0 && (fileByteArray[frameIndex + 2] & 4) != 0 ? 48000.0 : ((fileByteArray[frameIndex + 2] & 8) != 0 && (fileByteArray[frameIndex + 2] & 4) == 0 ? 32000.0 : 0.0));
        return samplingFrequency;
    }

    public static String getChannelMode(byte[] fileByteArray, int frameIndex) {
        String channelMode = "";
        if ((fileByteArray[frameIndex + 3] & 128) == 0 && (fileByteArray[frameIndex + 3] & 64) == 0) {
            channelMode = "Stereo";
        } else if ((fileByteArray[frameIndex + 3] & 128) == 0 && (fileByteArray[frameIndex + 3] & 64) != 0) {
            channelMode = "Joint Stereo";
        } else if ((fileByteArray[frameIndex + 3] & 128) != 0 && (fileByteArray[frameIndex + 3] & 64) == 0) {
            channelMode = "Dual Channel";
        } else if ((fileByteArray[frameIndex + 3] & 128) != 0 && (fileByteArray[frameIndex + 3] & 64) != 0) {
            channelMode = "Single Channel";
        }
        return channelMode;
    }

    public static String getModeExtension(byte[] fileByteArray, int frameIndex) {
        String modeExtension = "";
        if ((fileByteArray[frameIndex + 3] & 32) == 0 && (fileByteArray[frameIndex + 3] & 16) == 0) {
            modeExtension = "IS off, MSS off";
        } else if ((fileByteArray[frameIndex + 3] & 32) == 0 && (fileByteArray[frameIndex + 3] & 16) != 0) {
            modeExtension = "IS on, MSS off";
        } else if ((fileByteArray[frameIndex + 3] & 32) != 0 && (fileByteArray[frameIndex + 3] & 16) == 0) {
            modeExtension = "IS off, MSS on";
        } else if ((fileByteArray[frameIndex + 3] & 32) != 0 && (fileByteArray[frameIndex + 3] & 16) != 0) {
            modeExtension = "IS on, MSS on";
        }
        return modeExtension;
    }

    public static String getEmphasisType(byte[] fileByteArray, int frameIndex) {
        String emphasisType = "";
        if ((fileByteArray[frameIndex + 3] & 2) == 0 && (fileByteArray[frameIndex + 3] & 1) == 0) {
            emphasisType = "None";
        } else if ((fileByteArray[frameIndex + 3] & 2) == 0 && (fileByteArray[frameIndex + 3] & 1) != 0) {
            emphasisType = "50/15 ms";
        } else if ((fileByteArray[frameIndex + 3] & 2) != 0 && (fileByteArray[frameIndex + 3] & 1) == 0) {
            emphasisType = "Reserved";
        } else if ((fileByteArray[frameIndex + 3] & 2) != 0 && (fileByteArray[frameIndex + 3] & 1) != 0) {
            emphasisType = "CCITT J.17";
        }
        return emphasisType;
    }

    public static int getPart2_3_LengthBitsSingle1(ArrayList<Byte> sideInformationBytes) {
        int part2_3_lengthBits = 0;
        if ((sideInformationBytes.get(3).byteValue() & 4) != 0) {
            ++part2_3_lengthBits;
        }
        if ((sideInformationBytes.get(3).byteValue() & 8) != 0) {
            part2_3_lengthBits += 2;
        }
        if ((sideInformationBytes.get(3).byteValue() & 16) != 0) {
            part2_3_lengthBits += 4;
        }
        if ((sideInformationBytes.get(3).byteValue() & 32) != 0) {
            part2_3_lengthBits += 8;
        }
        if ((sideInformationBytes.get(3).byteValue() & 64) != 0) {
            part2_3_lengthBits += 16;
        }
        if ((sideInformationBytes.get(3).byteValue() & 128) != 0) {
            part2_3_lengthBits += 32;
        }
        if ((sideInformationBytes.get(2).byteValue() & 1) != 0) {
            part2_3_lengthBits += 64;
        }
        if ((sideInformationBytes.get(2).byteValue() & 2) != 0) {
            part2_3_lengthBits += 128;
        }
        if ((sideInformationBytes.get(2).byteValue() & 4) != 0) {
            part2_3_lengthBits += 256;
        }
        if ((sideInformationBytes.get(2).byteValue() & 8) != 0) {
            part2_3_lengthBits += 512;
        }
        if ((sideInformationBytes.get(2).byteValue() & 16) != 0) {
            part2_3_lengthBits += 1024;
        }
        if ((sideInformationBytes.get(2).byteValue() & 32) != 0) {
            part2_3_lengthBits += 2048;
        }
        return part2_3_lengthBits;
    }

    public static int getPart2_3_LengthBitsSingle2(ArrayList<Byte> sideInformationBytes) {
        int part2_3_lengthBits = 0;
        if ((sideInformationBytes.get(11).byteValue() & 128) != 0) {
            ++part2_3_lengthBits;
        }
        if ((sideInformationBytes.get(10).byteValue() & 1) != 0) {
            part2_3_lengthBits += 2;
        }
        if ((sideInformationBytes.get(10).byteValue() & 2) != 0) {
            part2_3_lengthBits += 4;
        }
        if ((sideInformationBytes.get(10).byteValue() & 4) != 0) {
            part2_3_lengthBits += 8;
        }
        if ((sideInformationBytes.get(10).byteValue() & 8) != 0) {
            part2_3_lengthBits += 16;
        }
        if ((sideInformationBytes.get(10).byteValue() & 16) != 0) {
            part2_3_lengthBits += 32;
        }
        if ((sideInformationBytes.get(10).byteValue() & 32) != 0) {
            part2_3_lengthBits += 64;
        }
        if ((sideInformationBytes.get(10).byteValue() & 64) != 0) {
            part2_3_lengthBits += 128;
        }
        if ((sideInformationBytes.get(10).byteValue() & 128) != 0) {
            part2_3_lengthBits += 256;
        }
        if ((sideInformationBytes.get(9).byteValue() & 1) != 0) {
            part2_3_lengthBits += 512;
        }
        if ((sideInformationBytes.get(9).byteValue() & 2) != 0) {
            part2_3_lengthBits += 1024;
        }
        if ((sideInformationBytes.get(9).byteValue() & 4) != 0) {
            part2_3_lengthBits += 2048;
        }
        return part2_3_lengthBits;
    }

    public static int getPart2_3_LengthBitsDual1(ArrayList<Byte> sideInformationBytes) {
        int part2_3_lengthBits = 0;
        if ((sideInformationBytes.get(3).byteValue() & 1) != 0) {
            ++part2_3_lengthBits;
        }
        if ((sideInformationBytes.get(3).byteValue() & 2) != 0) {
            part2_3_lengthBits += 2;
        }
        if ((sideInformationBytes.get(3).byteValue() & 4) != 0) {
            part2_3_lengthBits += 4;
        }
        if ((sideInformationBytes.get(3).byteValue() & 8) != 0) {
            part2_3_lengthBits += 8;
        }
        if ((sideInformationBytes.get(3).byteValue() & 16) != 0) {
            part2_3_lengthBits += 16;
        }
        if ((sideInformationBytes.get(3).byteValue() & 32) != 0) {
            part2_3_lengthBits += 32;
        }
        if ((sideInformationBytes.get(3).byteValue() & 64) != 0) {
            part2_3_lengthBits += 64;
        }
        if ((sideInformationBytes.get(3).byteValue() & 128) != 0) {
            part2_3_lengthBits += 128;
        }
        if ((sideInformationBytes.get(2).byteValue() & 1) != 0) {
            part2_3_lengthBits += 256;
        }
        if ((sideInformationBytes.get(2).byteValue() & 2) != 0) {
            part2_3_lengthBits += 512;
        }
        if ((sideInformationBytes.get(2).byteValue() & 4) != 0) {
            part2_3_lengthBits += 1024;
        }
        if ((sideInformationBytes.get(2).byteValue() & 8) != 0) {
            part2_3_lengthBits += 2048;
        }
        return part2_3_lengthBits;
    }

    public static int getPart2_3_LengthBitsDual2(ArrayList<Byte> sideInformationBytes) {
        int part2_3_lengthBits = 0;
        if ((sideInformationBytes.get(11).byteValue() & 32) != 0) {
            ++part2_3_lengthBits;
        }
        if ((sideInformationBytes.get(11).byteValue() & 64) != 0) {
            part2_3_lengthBits += 2;
        }
        if ((sideInformationBytes.get(11).byteValue() & 128) != 0) {
            part2_3_lengthBits += 4;
        }
        if ((sideInformationBytes.get(10).byteValue() & 1) != 0) {
            part2_3_lengthBits += 8;
        }
        if ((sideInformationBytes.get(10).byteValue() & 2) != 0) {
            part2_3_lengthBits += 16;
        }
        if ((sideInformationBytes.get(10).byteValue() & 4) != 0) {
            part2_3_lengthBits += 32;
        }
        if ((sideInformationBytes.get(10).byteValue() & 8) != 0) {
            part2_3_lengthBits += 64;
        }
        if ((sideInformationBytes.get(10).byteValue() & 16) != 0) {
            part2_3_lengthBits += 128;
        }
        if ((sideInformationBytes.get(10).byteValue() & 32) != 0) {
            part2_3_lengthBits += 256;
        }
        if ((sideInformationBytes.get(10).byteValue() & 64) != 0) {
            part2_3_lengthBits += 512;
        }
        if ((sideInformationBytes.get(10).byteValue() & 128) != 0) {
            part2_3_lengthBits += 1024;
        }
        if ((sideInformationBytes.get(9).byteValue() & 1) != 0) {
            part2_3_lengthBits += 2048;
        }
        return part2_3_lengthBits;
    }

    public static int getPart2_3_LengthBitsDual3(ArrayList<Byte> sideInformationBytes) {
        int part2_3_lengthBits = 0;
        if ((sideInformationBytes.get(18).byteValue() & 4) != 0) {
            ++part2_3_lengthBits;
        }
        if ((sideInformationBytes.get(18).byteValue() & 8) != 0) {
            part2_3_lengthBits += 2;
        }
        if ((sideInformationBytes.get(18).byteValue() & 16) != 0) {
            part2_3_lengthBits += 4;
        }
        if ((sideInformationBytes.get(18).byteValue() & 32) != 0) {
            part2_3_lengthBits += 8;
        }
        if ((sideInformationBytes.get(18).byteValue() & 64) != 0) {
            part2_3_lengthBits += 16;
        }
        if ((sideInformationBytes.get(18).byteValue() & 128) != 0) {
            part2_3_lengthBits += 32;
        }
        if ((sideInformationBytes.get(17).byteValue() & 1) != 0) {
            part2_3_lengthBits += 64;
        }
        if ((sideInformationBytes.get(17).byteValue() & 2) != 0) {
            part2_3_lengthBits += 128;
        }
        if ((sideInformationBytes.get(17).byteValue() & 4) != 0) {
            part2_3_lengthBits += 256;
        }
        if ((sideInformationBytes.get(17).byteValue() & 8) != 0) {
            part2_3_lengthBits += 512;
        }
        if ((sideInformationBytes.get(17).byteValue() & 16) != 0) {
            part2_3_lengthBits += 1024;
        }
        if ((sideInformationBytes.get(17).byteValue() & 32) != 0) {
            part2_3_lengthBits += 2048;
        }
        return part2_3_lengthBits;
    }

    public static int getPart2_3_LengthBitsDual4(ArrayList<Byte> sideInformationBytes) {
        int part2_3_lengthBits = 0;
        if ((sideInformationBytes.get(26).byteValue() & 128) != 0) {
            ++part2_3_lengthBits;
        }
        if ((sideInformationBytes.get(25).byteValue() & 1) != 0) {
            part2_3_lengthBits += 2;
        }
        if ((sideInformationBytes.get(25).byteValue() & 2) != 0) {
            part2_3_lengthBits += 4;
        }
        if ((sideInformationBytes.get(25).byteValue() & 4) != 0) {
            part2_3_lengthBits += 8;
        }
        if ((sideInformationBytes.get(25).byteValue() & 8) != 0) {
            part2_3_lengthBits += 16;
        }
        if ((sideInformationBytes.get(25).byteValue() & 16) != 0) {
            part2_3_lengthBits += 32;
        }
        if ((sideInformationBytes.get(25).byteValue() & 32) != 0) {
            part2_3_lengthBits += 64;
        }
        if ((sideInformationBytes.get(25).byteValue() & 64) != 0) {
            part2_3_lengthBits += 128;
        }
        if ((sideInformationBytes.get(25).byteValue() & 128) != 0) {
            part2_3_lengthBits += 256;
        }
        if ((sideInformationBytes.get(24).byteValue() & 1) != 0) {
            part2_3_lengthBits += 512;
        }
        if ((sideInformationBytes.get(24).byteValue() & 2) != 0) {
            part2_3_lengthBits += 1024;
        }
        if ((sideInformationBytes.get(24).byteValue() & 4) != 0) {
            part2_3_lengthBits += 2048;
        }
        return part2_3_lengthBits;
    }

    public static int getBig_ValuesLengthBitsSingle1(ArrayList<Byte> sideInformationBytes) {
        int big_valuesLengthBits = 0;
        if ((sideInformationBytes.get(4).byteValue() & 2) != 0) {
            ++big_valuesLengthBits;
        }
        if ((sideInformationBytes.get(4).byteValue() & 4) != 0) {
            big_valuesLengthBits += 2;
        }
        if ((sideInformationBytes.get(4).byteValue() & 8) != 0) {
            big_valuesLengthBits += 4;
        }
        if ((sideInformationBytes.get(4).byteValue() & 16) != 0) {
            big_valuesLengthBits += 8;
        }
        if ((sideInformationBytes.get(4).byteValue() & 32) != 0) {
            big_valuesLengthBits += 16;
        }
        if ((sideInformationBytes.get(4).byteValue() & 64) != 0) {
            big_valuesLengthBits += 32;
        }
        if ((sideInformationBytes.get(4).byteValue() & 128) != 0) {
            big_valuesLengthBits += 64;
        }
        if ((sideInformationBytes.get(3).byteValue() & 1) != 0) {
            big_valuesLengthBits += 128;
        }
        if ((sideInformationBytes.get(3).byteValue() & 2) != 0) {
            big_valuesLengthBits += 256;
        }
        return big_valuesLengthBits;
    }

    public static int getBig_ValuesLengthBitsSingle2(ArrayList<Byte> sideInformationBytes) {
        int big_valuesLengthBits = 0;
        if ((sideInformationBytes.get(12).byteValue() & 64) != 0) {
            ++big_valuesLengthBits;
        }
        if ((sideInformationBytes.get(12).byteValue() & 128) != 0) {
            big_valuesLengthBits += 2;
        }
        if ((sideInformationBytes.get(11).byteValue() & 1) != 0) {
            big_valuesLengthBits += 4;
        }
        if ((sideInformationBytes.get(11).byteValue() & 2) != 0) {
            big_valuesLengthBits += 8;
        }
        if ((sideInformationBytes.get(11).byteValue() & 4) != 0) {
            big_valuesLengthBits += 16;
        }
        if ((sideInformationBytes.get(11).byteValue() & 8) != 0) {
            big_valuesLengthBits += 32;
        }
        if ((sideInformationBytes.get(11).byteValue() & 16) != 0) {
            big_valuesLengthBits += 64;
        }
        if ((sideInformationBytes.get(11).byteValue() & 32) != 0) {
            big_valuesLengthBits += 128;
        }
        if ((sideInformationBytes.get(11).byteValue() & 64) != 0) {
            big_valuesLengthBits += 256;
        }
        return big_valuesLengthBits;
    }

    public static int getBig_ValuesLengthBitsDual1(ArrayList<Byte> sideInformationBytes) {
        int big_valuesLengthBits = 0;
        if ((sideInformationBytes.get(5).byteValue() & 128) != 0) {
            ++big_valuesLengthBits;
        }
        if ((sideInformationBytes.get(4).byteValue() & 1) != 0) {
            big_valuesLengthBits += 2;
        }
        if ((sideInformationBytes.get(4).byteValue() & 2) != 0) {
            big_valuesLengthBits += 4;
        }
        if ((sideInformationBytes.get(4).byteValue() & 4) != 0) {
            big_valuesLengthBits += 8;
        }
        if ((sideInformationBytes.get(4).byteValue() & 8) != 0) {
            big_valuesLengthBits += 16;
        }
        if ((sideInformationBytes.get(4).byteValue() & 16) != 0) {
            big_valuesLengthBits += 32;
        }
        if ((sideInformationBytes.get(4).byteValue() & 32) != 0) {
            big_valuesLengthBits += 64;
        }
        if ((sideInformationBytes.get(4).byteValue() & 64) != 0) {
            big_valuesLengthBits += 128;
        }
        if ((sideInformationBytes.get(4).byteValue() & 128) != 0) {
            big_valuesLengthBits += 256;
        }
        return big_valuesLengthBits;
    }

    public static int getBig_ValuesLengthBitsDual2(ArrayList<Byte> sideInformationBytes) {
        int big_valuesLengthBits = 0;
        if ((sideInformationBytes.get(12).byteValue() & 16) != 0) {
            ++big_valuesLengthBits;
        }
        if ((sideInformationBytes.get(12).byteValue() & 32) != 0) {
            big_valuesLengthBits += 2;
        }
        if ((sideInformationBytes.get(12).byteValue() & 64) != 0) {
            big_valuesLengthBits += 4;
        }
        if ((sideInformationBytes.get(12).byteValue() & 128) != 0) {
            big_valuesLengthBits += 8;
        }
        if ((sideInformationBytes.get(11).byteValue() & 1) != 0) {
            big_valuesLengthBits += 16;
        }
        if ((sideInformationBytes.get(11).byteValue() & 2) != 0) {
            big_valuesLengthBits += 32;
        }
        if ((sideInformationBytes.get(11).byteValue() & 4) != 0) {
            big_valuesLengthBits += 64;
        }
        if ((sideInformationBytes.get(11).byteValue() & 8) != 0) {
            big_valuesLengthBits += 128;
        }
        if ((sideInformationBytes.get(11).byteValue() & 16) != 0) {
            big_valuesLengthBits += 256;
        }
        return big_valuesLengthBits;
    }

    public static int getBig_ValuesLengthBitsDual3(ArrayList<Byte> sideInformationBytes) {
        int big_valuesLengthBits = 0;
        if ((sideInformationBytes.get(19).byteValue() & 2) != 0) {
            ++big_valuesLengthBits;
        }
        if ((sideInformationBytes.get(19).byteValue() & 4) != 0) {
            big_valuesLengthBits += 2;
        }
        if ((sideInformationBytes.get(19).byteValue() & 8) != 0) {
            big_valuesLengthBits += 4;
        }
        if ((sideInformationBytes.get(19).byteValue() & 16) != 0) {
            big_valuesLengthBits += 8;
        }
        if ((sideInformationBytes.get(19).byteValue() & 32) != 0) {
            big_valuesLengthBits += 16;
        }
        if ((sideInformationBytes.get(19).byteValue() & 64) != 0) {
            big_valuesLengthBits += 32;
        }
        if ((sideInformationBytes.get(19).byteValue() & 128) != 0) {
            big_valuesLengthBits += 64;
        }
        if ((sideInformationBytes.get(18).byteValue() & 1) != 0) {
            big_valuesLengthBits += 128;
        }
        if ((sideInformationBytes.get(18).byteValue() & 2) != 0) {
            big_valuesLengthBits += 256;
        }
        return big_valuesLengthBits;
    }

    public static int getBig_ValuesLengthBitsDual4(ArrayList<Byte> sideInformationBytes) {
        int big_valuesLengthBits = 0;
        if ((sideInformationBytes.get(27).byteValue() & 64) != 0) {
            ++big_valuesLengthBits;
        }
        if ((sideInformationBytes.get(27).byteValue() & 128) != 0) {
            big_valuesLengthBits += 2;
        }
        if ((sideInformationBytes.get(26).byteValue() & 1) != 0) {
            big_valuesLengthBits += 4;
        }
        if ((sideInformationBytes.get(26).byteValue() & 2) != 0) {
            big_valuesLengthBits += 8;
        }
        if ((sideInformationBytes.get(26).byteValue() & 4) != 0) {
            big_valuesLengthBits += 16;
        }
        if ((sideInformationBytes.get(26).byteValue() & 8) != 0) {
            big_valuesLengthBits += 32;
        }
        if ((sideInformationBytes.get(26).byteValue() & 16) != 0) {
            big_valuesLengthBits += 64;
        }
        if ((sideInformationBytes.get(26).byteValue() & 32) != 0) {
            big_valuesLengthBits += 128;
        }
        if ((sideInformationBytes.get(26).byteValue() & 64) != 0) {
            big_valuesLengthBits += 256;
        }
        return big_valuesLengthBits;
    }

    public static int getTable_SelectBitsSingle1(ArrayList<Byte> sideInformationBytes, boolean WinSwitchFlagBitSet) {
        int table_selectBits = 0;
        if (WinSwitchFlagBitSet) {
            if ((sideInformationBytes.get(8).byteValue() & 128) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(7).byteValue() & 1) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(7).byteValue() & 2) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(7).byteValue() & 4) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(7).byteValue() & 8) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(7).byteValue() & 16) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(7).byteValue() & 32) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(7).byteValue() & 64) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(7).byteValue() & 128) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(6).byteValue() & 1) != 0) {
                table_selectBits += 512;
            }
        } else {
            if ((sideInformationBytes.get(8).byteValue() & 2) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(8).byteValue() & 4) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(8).byteValue() & 8) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(7).byteValue() & 1) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(7).byteValue() & 2) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(7).byteValue() & 4) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(7).byteValue() & 8) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(7).byteValue() & 16) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(7).byteValue() & 32) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(7).byteValue() & 64) != 0) {
                table_selectBits += 512;
            }
            if ((sideInformationBytes.get(7).byteValue() & 128) != 0) {
                table_selectBits += 1024;
            }
            if ((sideInformationBytes.get(6).byteValue() & 1) != 0) {
                table_selectBits += 2048;
            }
            if ((sideInformationBytes.get(6).byteValue() & 2) != 0) {
                table_selectBits += 4096;
            }
            if ((sideInformationBytes.get(6).byteValue() & 4) != 0) {
                table_selectBits += 8192;
            }
            if ((sideInformationBytes.get(6).byteValue() & 8) != 0) {
                table_selectBits += 16384;
            }
        }
        return table_selectBits;
    }

    public static int getTable_SelectBitsSingle2(ArrayList<Byte> sideInformationBytes, boolean WinSwitchFlagBitSet) {
        int table_selectBits = 0;
        if (WinSwitchFlagBitSet) {
            if ((sideInformationBytes.get(15).byteValue() & 16) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(15).byteValue() & 32) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(15).byteValue() & 64) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(15).byteValue() & 128) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(14).byteValue() & 1) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(14).byteValue() & 2) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(14).byteValue() & 4) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(14).byteValue() & 8) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(14).byteValue() & 16) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(14).byteValue() & 32) != 0) {
                table_selectBits += 512;
            }
        } else {
            if ((sideInformationBytes.get(15).byteValue() & 4) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(15).byteValue() & 8) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(15).byteValue() & 16) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(15).byteValue() & 32) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(15).byteValue() & 64) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(15).byteValue() & 128) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(14).byteValue() & 1) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(14).byteValue() & 2) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(14).byteValue() & 4) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(14).byteValue() & 8) != 0) {
                table_selectBits += 512;
            }
            if ((sideInformationBytes.get(14).byteValue() & 16) != 0) {
                table_selectBits += 1024;
            }
            if ((sideInformationBytes.get(14).byteValue() & 32) != 0) {
                table_selectBits += 2048;
            }
            if ((sideInformationBytes.get(14).byteValue() & 64) != 0) {
                table_selectBits += 4096;
            }
            if ((sideInformationBytes.get(14).byteValue() & 128) != 0) {
                table_selectBits += 8192;
            }
            if ((sideInformationBytes.get(13).byteValue() & 1) != 0) {
                table_selectBits += 16384;
            }
        }
        return table_selectBits;
    }

    public static int getTable_SelectBitsDual1(ArrayList<Byte> sideInformationBytes, boolean WinSwitchFlagBitSet) {
        int table_selectBits = 0;
        if (WinSwitchFlagBitSet) {
            if ((sideInformationBytes.get(8).byteValue() & 32) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(8).byteValue() & 64) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(8).byteValue() & 128) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(7).byteValue() & 1) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(7).byteValue() & 2) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(7).byteValue() & 4) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(7).byteValue() & 8) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(7).byteValue() & 16) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(7).byteValue() & 32) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(7).byteValue() & 64) != 0) {
                table_selectBits += 512;
            }
        } else {
            if ((sideInformationBytes.get(8).byteValue() & 8) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(8).byteValue() & 16) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(8).byteValue() & 32) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(8).byteValue() & 64) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(8).byteValue() & 128) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(7).byteValue() & 1) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(7).byteValue() & 2) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(7).byteValue() & 4) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(7).byteValue() & 8) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(7).byteValue() & 16) != 0) {
                table_selectBits += 512;
            }
            if ((sideInformationBytes.get(7).byteValue() & 32) != 0) {
                table_selectBits += 1024;
            }
            if ((sideInformationBytes.get(7).byteValue() & 64) != 0) {
                table_selectBits += 2048;
            }
            if ((sideInformationBytes.get(7).byteValue() & 128) != 0) {
                table_selectBits += 4096;
            }
            if ((sideInformationBytes.get(6).byteValue() & 1) != 0) {
                table_selectBits += 8192;
            }
            if ((sideInformationBytes.get(6).byteValue() & 2) != 0) {
                table_selectBits += 16384;
            }
        }
        return table_selectBits;
    }

    public static int getTable_SelectBitsDual2(ArrayList<Byte> sideInformationBytes, boolean WinSwitchFlagBitSet) {
        int table_selectBits = 0;
        if (WinSwitchFlagBitSet) {
            if ((sideInformationBytes.get(15).byteValue() & 4) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(15).byteValue() & 8) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(15).byteValue() & 16) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(15).byteValue() & 32) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(15).byteValue() & 64) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(15).byteValue() & 128) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(14).byteValue() & 1) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(14).byteValue() & 2) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(14).byteValue() & 4) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(14).byteValue() & 8) != 0) {
                table_selectBits += 512;
            }
        } else {
            if ((sideInformationBytes.get(15).byteValue() & 1) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(15).byteValue() & 2) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(15).byteValue() & 4) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(15).byteValue() & 8) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(15).byteValue() & 16) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(15).byteValue() & 32) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(15).byteValue() & 64) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(15).byteValue() & 128) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(14).byteValue() & 1) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(14).byteValue() & 2) != 0) {
                table_selectBits += 512;
            }
            if ((sideInformationBytes.get(14).byteValue() & 4) != 0) {
                table_selectBits += 1024;
            }
            if ((sideInformationBytes.get(14).byteValue() & 8) != 0) {
                table_selectBits += 2048;
            }
            if ((sideInformationBytes.get(14).byteValue() & 16) != 0) {
                table_selectBits += 4096;
            }
            if ((sideInformationBytes.get(14).byteValue() & 32) != 0) {
                table_selectBits += 8192;
            }
            if ((sideInformationBytes.get(14).byteValue() & 64) != 0) {
                table_selectBits += 16384;
            }
        }
        return table_selectBits;
    }

    public static int getTable_SelectBitsDual3(ArrayList<Byte> sideInformationBytes, boolean WinSwitchFlagBitSet) {
        int table_selectBits = 0;
        if (WinSwitchFlagBitSet) {
            if ((sideInformationBytes.get(23).byteValue() & 128) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(22).byteValue() & 1) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(22).byteValue() & 2) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(22).byteValue() & 4) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(22).byteValue() & 8) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(22).byteValue() & 16) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(22).byteValue() & 32) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(22).byteValue() & 64) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(22).byteValue() & 128) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(21).byteValue() & 1) != 0) {
                table_selectBits += 512;
            }
        } else {
            if ((sideInformationBytes.get(23).byteValue() & 32) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(23).byteValue() & 64) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(23).byteValue() & 128) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(22).byteValue() & 1) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(22).byteValue() & 2) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(22).byteValue() & 4) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(22).byteValue() & 8) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(22).byteValue() & 16) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(22).byteValue() & 32) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(22).byteValue() & 64) != 0) {
                table_selectBits += 512;
            }
            if ((sideInformationBytes.get(22).byteValue() & 128) != 0) {
                table_selectBits += 1024;
            }
            if ((sideInformationBytes.get(21).byteValue() & 1) != 0) {
                table_selectBits += 2048;
            }
            if ((sideInformationBytes.get(21).byteValue() & 2) != 0) {
                table_selectBits += 4096;
            }
            if ((sideInformationBytes.get(21).byteValue() & 4) != 0) {
                table_selectBits += 8192;
            }
            if ((sideInformationBytes.get(21).byteValue() & 8) != 0) {
                table_selectBits += 16384;
            }
        }
        return table_selectBits;
    }

    public static int getTable_SelectBitsDual4(ArrayList<Byte> sideInformationBytes, boolean WinSwitchFlagBitSet) {
        int table_selectBits = 0;
        if (WinSwitchFlagBitSet) {
            if ((sideInformationBytes.get(30).byteValue() & 16) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(30).byteValue() & 32) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(30).byteValue() & 64) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(30).byteValue() & 128) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(29).byteValue() & 1) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(29).byteValue() & 2) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(29).byteValue() & 4) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(29).byteValue() & 8) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(29).byteValue() & 16) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(29).byteValue() & 32) != 0) {
                table_selectBits += 512;
            }
        } else {
            if ((sideInformationBytes.get(30).byteValue() & 4) != 0) {
                ++table_selectBits;
            }
            if ((sideInformationBytes.get(30).byteValue() & 8) != 0) {
                table_selectBits += 2;
            }
            if ((sideInformationBytes.get(30).byteValue() & 16) != 0) {
                table_selectBits += 4;
            }
            if ((sideInformationBytes.get(30).byteValue() & 32) != 0) {
                table_selectBits += 8;
            }
            if ((sideInformationBytes.get(30).byteValue() & 64) != 0) {
                table_selectBits += 16;
            }
            if ((sideInformationBytes.get(30).byteValue() & 128) != 0) {
                table_selectBits += 32;
            }
            if ((sideInformationBytes.get(29).byteValue() & 1) != 0) {
                table_selectBits += 64;
            }
            if ((sideInformationBytes.get(29).byteValue() & 2) != 0) {
                table_selectBits += 128;
            }
            if ((sideInformationBytes.get(29).byteValue() & 4) != 0) {
                table_selectBits += 256;
            }
            if ((sideInformationBytes.get(29).byteValue() & 8) != 0) {
                table_selectBits += 512;
            }
            if ((sideInformationBytes.get(29).byteValue() & 16) != 0) {
                table_selectBits += 1024;
            }
            if ((sideInformationBytes.get(29).byteValue() & 32) != 0) {
                table_selectBits += 2048;
            }
            if ((sideInformationBytes.get(29).byteValue() & 64) != 0) {
                table_selectBits += 4096;
            }
            if ((sideInformationBytes.get(29).byteValue() & 128) != 0) {
                table_selectBits += 8192;
            }
            if ((sideInformationBytes.get(28).byteValue() & 1) != 0) {
                table_selectBits += 16384;
            }
        }
        return table_selectBits;
    }

    public static int getMain_Data_BeginBytes(ArrayList<Byte> sideInformationBytes) {
        int main_data_beginBytes = 0;
        if ((sideInformationBytes.get(1).byteValue() & 128) != 0) {
            ++main_data_beginBytes;
        }
        if ((sideInformationBytes.get(0).byteValue() & 1) != 0) {
            main_data_beginBytes += 2;
        }
        if ((sideInformationBytes.get(0).byteValue() & 2) != 0) {
            main_data_beginBytes += 4;
        }
        if ((sideInformationBytes.get(0).byteValue() & 4) != 0) {
            main_data_beginBytes += 8;
        }
        if ((sideInformationBytes.get(0).byteValue() & 8) != 0) {
            main_data_beginBytes += 16;
        }
        if ((sideInformationBytes.get(0).byteValue() & 16) != 0) {
            main_data_beginBytes += 32;
        }
        if ((sideInformationBytes.get(0).byteValue() & 32) != 0) {
            main_data_beginBytes += 64;
        }
        if ((sideInformationBytes.get(0).byteValue() & 64) != 0) {
            main_data_beginBytes += 128;
        }
        if ((sideInformationBytes.get(0).byteValue() & 128) != 0) {
            main_data_beginBytes += 256;
        }
        return main_data_beginBytes;
    }

    public static int getFrameLength(double bitRate, double samplingFrequency, boolean paddingBitSet) {
        int frameLength = 0;
        double d = bitRate / samplingFrequency * 144.0;
        frameLength = (int)d;
        if (paddingBitSet) {
            ++frameLength;
        }
        return frameLength;
    }
}

