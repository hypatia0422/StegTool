/*
 * Decompiled with CFR 0_118.
 */
package domain;

import java.util.ArrayList;

public class Frame {
    private int id = 0;
    private int frameIndex = 0;
    private String mpegAudioVersion = "";
    private String layer = "";
    private boolean protectionBitSet = false;
    private double bitRate = 0.0;
    private double samplingFrequency = 0.0;
    private boolean paddingBitSet = false;
    private boolean privateBitSet = false;
    private String channelMode = "";
    private String modeExtension = "";
    private boolean copyrightBitSet = false;
    private boolean originalBitSet = false;
    private boolean emphasisBit1Set = false;
    private boolean emphasisBit2Set = false;
    private String emphasisType = "";
    private int frameLength = 0;
    private ArrayList<Byte> frameBytes = new ArrayList();
    private ArrayList<Byte> headerBytes = new ArrayList();
    private ArrayList<Byte> crcBytes = new ArrayList();
    private ArrayList<Byte> sideInformationBytes = new ArrayList();
    private ArrayList<Byte> mainDataBytes = new ArrayList();
    private int main_data_beginBytes = 0;
    private int part2_3_lengthBits1 = 0;
    private int part2_3_lengthBits2 = 0;
    private int part2_3_lengthBits3 = 0;
    private int part2_3_lengthBits4 = 0;
    private int big_valuesLengthBits1 = 0;
    private int big_valuesLengthBits2 = 0;
    private int big_valuesLengthBits3 = 0;
    private int big_valuesLengthBits4 = 0;
    private boolean winSwitchFlagBitSet1 = false;
    private boolean winSwitchFlagBitSet2 = false;
    private boolean winSwitchFlagBitSet3 = false;
    private boolean winSwitchFlagBitSet4 = false;
    private int table_selectBits1 = 0;
    private int table_selectBits2 = 0;
    private int table_selectBits3 = 0;
    private int table_selectBits4 = 0;
    boolean specialFrameFlag = false;
    boolean emptyFrameFlag = false;

    public Frame(int id, int frameIndex, String mpegAudioVersion, String layer, boolean protectionBitSet, double bitRate, double samplingFrequency, boolean paddingBitSet, boolean privateBitSet, String channelMode, String modeExtension, boolean copyrightBitSet, boolean originalBitSet, boolean emphasisBit1Set, boolean emphasisBit2Set, String emphasisType, int frameLength, ArrayList<Byte> frameBytes, ArrayList<Byte> headerBytes, ArrayList<Byte> crcBytes, ArrayList<Byte> sideInformationBytes, ArrayList<Byte> mainDataBytes, int main_data_beginBytes, int part2_3_lengthBits1, int part2_3_lengthBits2, int part2_3_lengthBits3, int part2_3_lengthBits4, int big_valuesLengthBits1, int big_valuesLengthBits2, int big_valuesLengthBits3, int big_valuesLengthBits4, boolean winSwitchFlagBitSet1, boolean winSwitchFlagBitSet2, boolean winSwitchFlagBitSet3, boolean winSwitchFlagBitSet4, int table_selectBits1, int table_selectBits2, int table_selectBits3, int table_selectBits4, boolean specialFrameFlag, boolean emptyFrameFlag) {
        this.id = id;
        this.frameIndex = frameIndex;
        this.mpegAudioVersion = mpegAudioVersion;
        this.layer = layer;
        this.protectionBitSet = protectionBitSet;
        this.bitRate = bitRate;
        this.samplingFrequency = samplingFrequency;
        this.paddingBitSet = paddingBitSet;
        this.privateBitSet = privateBitSet;
        this.channelMode = channelMode;
        this.modeExtension = modeExtension;
        this.copyrightBitSet = copyrightBitSet;
        this.originalBitSet = originalBitSet;
        this.emphasisBit1Set = emphasisBit1Set;
        this.emphasisBit2Set = emphasisBit2Set;
        this.emphasisType = emphasisType;
        this.frameLength = frameLength;
        this.frameBytes = frameBytes;
        this.headerBytes = headerBytes;
        this.crcBytes = crcBytes;
        this.sideInformationBytes = sideInformationBytes;
        this.mainDataBytes = mainDataBytes;
        this.main_data_beginBytes = main_data_beginBytes;
        this.part2_3_lengthBits1 = part2_3_lengthBits1;
        this.part2_3_lengthBits2 = part2_3_lengthBits2;
        this.part2_3_lengthBits3 = part2_3_lengthBits3;
        this.part2_3_lengthBits4 = part2_3_lengthBits4;
        this.big_valuesLengthBits1 = big_valuesLengthBits1;
        this.big_valuesLengthBits2 = big_valuesLengthBits2;
        this.big_valuesLengthBits3 = big_valuesLengthBits3;
        this.big_valuesLengthBits4 = big_valuesLengthBits4;
        this.winSwitchFlagBitSet1 = winSwitchFlagBitSet1;
        this.winSwitchFlagBitSet2 = winSwitchFlagBitSet2;
        this.winSwitchFlagBitSet3 = winSwitchFlagBitSet3;
        this.winSwitchFlagBitSet4 = winSwitchFlagBitSet4;
        this.table_selectBits1 = table_selectBits1;
        this.table_selectBits2 = table_selectBits2;
        this.table_selectBits3 = table_selectBits3;
        this.table_selectBits4 = table_selectBits4;
        this.specialFrameFlag = specialFrameFlag;
        this.emptyFrameFlag = emptyFrameFlag;
    }

    public int getBig_valuesLengthBits1() {
        return this.big_valuesLengthBits1;
    }

    public void setBig_valuesLengthBits1(int big_valuesLengthBits1) {
        this.big_valuesLengthBits1 = big_valuesLengthBits1;
    }

    public int getBig_valuesLengthBits2() {
        return this.big_valuesLengthBits2;
    }

    public void setBig_valuesLengthBits2(int big_valuesLengthBits2) {
        this.big_valuesLengthBits2 = big_valuesLengthBits2;
    }

    public int getBig_valuesLengthBits3() {
        return this.big_valuesLengthBits3;
    }

    public void setBig_valuesLengthBits3(int big_valuesLengthBits3) {
        this.big_valuesLengthBits3 = big_valuesLengthBits3;
    }

    public int getBig_valuesLengthBits4() {
        return this.big_valuesLengthBits4;
    }

    public void setBig_valuesLengthBits4(int big_valuesLengthBits4) {
        this.big_valuesLengthBits4 = big_valuesLengthBits4;
    }

    public double getBitRate() {
        return this.bitRate;
    }

    public void setBitRate(double bitRate) {
        this.bitRate = bitRate;
    }

    public String getChannelMode() {
        return this.channelMode;
    }

    public void setChannelMode(String channelMode) {
        this.channelMode = channelMode;
    }

    public boolean isCopyrightBitSet() {
        return this.copyrightBitSet;
    }

    public void setCopyrightBitSet(boolean copyrightBitSet) {
        this.copyrightBitSet = copyrightBitSet;
    }

    public ArrayList<Byte> getCrcBytes() {
        return this.crcBytes;
    }

    public void setCrcBytes(ArrayList<Byte> crcBytes) {
        this.crcBytes = crcBytes;
    }

    public boolean isEmphasisBit1Set() {
        return this.emphasisBit1Set;
    }

    public void setEmphasisBit1Set(boolean emphasisBit1Set) {
        this.emphasisBit1Set = emphasisBit1Set;
    }

    public boolean isEmphasisBit2Set() {
        return this.emphasisBit2Set;
    }

    public void setEmphasisBit2Set(boolean emphasisBit2Set) {
        this.emphasisBit2Set = emphasisBit2Set;
    }

    public String getEmphasisType() {
        return this.emphasisType;
    }

    public void setEmphasisType(String emphasisType) {
        this.emphasisType = emphasisType;
    }

    public ArrayList<Byte> getFrameBytes() {
        return this.frameBytes;
    }

    public void setFrameBytes(ArrayList<Byte> frameBytes) {
        this.frameBytes = frameBytes;
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }

    public int getFrameLength() {
        return this.frameLength;
    }

    public void setFrameLength(int frameLength) {
        this.frameLength = frameLength;
    }

    public ArrayList<Byte> getHeaderBytes() {
        return this.headerBytes;
    }

    public void setHeaderBytes(ArrayList<Byte> headerBytes) {
        this.headerBytes = headerBytes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLayer() {
        return this.layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public ArrayList<Byte> getMainDataBytes() {
        return this.mainDataBytes;
    }

    public void setMainDataBytes(ArrayList<Byte> mainDataBytes) {
        this.mainDataBytes = mainDataBytes;
    }

    public int getMain_data_beginBytes() {
        return this.main_data_beginBytes;
    }

    public void setMain_data_beginBytes(int main_data_beginBytes) {
        this.main_data_beginBytes = main_data_beginBytes;
    }

    public String getModeExtension() {
        return this.modeExtension;
    }

    public void setModeExtension(String modeExtension) {
        this.modeExtension = modeExtension;
    }

    public String getMpegAudioVersion() {
        return this.mpegAudioVersion;
    }

    public void setMpegAudioVersion(String mpegAudioVersion) {
        this.mpegAudioVersion = mpegAudioVersion;
    }

    public boolean isOriginalBitSet() {
        return this.originalBitSet;
    }

    public void setOriginalBitSet(boolean originalBitSet) {
        this.originalBitSet = originalBitSet;
    }

    public boolean isPaddingBitSet() {
        return this.paddingBitSet;
    }

    public void setPaddingBitSet(boolean paddingBitSet) {
        this.paddingBitSet = paddingBitSet;
    }

    public int getPart2_3_lengthBits1() {
        return this.part2_3_lengthBits1;
    }

    public void setPart2_3_lengthBits1(int part2_3_lengthBits1) {
        this.part2_3_lengthBits1 = part2_3_lengthBits1;
    }

    public int getPart2_3_lengthBits2() {
        return this.part2_3_lengthBits2;
    }

    public void setPart2_3_lengthBits2(int part2_3_lengthBits2) {
        this.part2_3_lengthBits2 = part2_3_lengthBits2;
    }

    public int getPart2_3_lengthBits3() {
        return this.part2_3_lengthBits3;
    }

    public void setPart2_3_lengthBits3(int part2_3_lengthBits3) {
        this.part2_3_lengthBits3 = part2_3_lengthBits3;
    }

    public int getPart2_3_lengthBits4() {
        return this.part2_3_lengthBits4;
    }

    public void setPart2_3_lengthBits4(int part2_3_lengthBits4) {
        this.part2_3_lengthBits4 = part2_3_lengthBits4;
    }

    public boolean isPrivateBitSet() {
        return this.privateBitSet;
    }

    public void setPrivateBitSet(boolean privateBitSet) {
        this.privateBitSet = privateBitSet;
    }

    public boolean isProtectionBitSet() {
        return this.protectionBitSet;
    }

    public void setProtectionBitSet(boolean protectionBitSet) {
        this.protectionBitSet = protectionBitSet;
    }

    public double getSamplingFrequency() {
        return this.samplingFrequency;
    }

    public void setSamplingFrequency(double samplingFrequency) {
        this.samplingFrequency = samplingFrequency;
    }

    public ArrayList<Byte> getSideInformationBytes() {
        return this.sideInformationBytes;
    }

    public void setSideInformationBytes(ArrayList<Byte> sideInformationBytes) {
        this.sideInformationBytes = sideInformationBytes;
    }

    public int getTable_selectBits1() {
        return this.table_selectBits1;
    }

    public void setTable_selectBits1(int table_selectBits1) {
        this.table_selectBits1 = table_selectBits1;
    }

    public int getTable_selectBits2() {
        return this.table_selectBits2;
    }

    public void setTable_selectBits2(int table_selectBits2) {
        this.table_selectBits2 = table_selectBits2;
    }

    public int getTable_selectBits3() {
        return this.table_selectBits3;
    }

    public void setTable_selectBits3(int table_selectBits3) {
        this.table_selectBits3 = table_selectBits3;
    }

    public int getTable_selectBits4() {
        return this.table_selectBits4;
    }

    public void setTable_selectBits4(int table_selectBits4) {
        this.table_selectBits4 = table_selectBits4;
    }

    public boolean isWinSwitchFlagBitSet1() {
        return this.winSwitchFlagBitSet1;
    }

    public void setWinSwitchFlagBitSet1(boolean winSwitchFlagBitSet1) {
        this.winSwitchFlagBitSet1 = winSwitchFlagBitSet1;
    }

    public boolean isWinSwitchFlagBitSet2() {
        return this.winSwitchFlagBitSet2;
    }

    public void setWinSwitchFlagBitSet2(boolean winSwitchFlagBitSet2) {
        this.winSwitchFlagBitSet2 = winSwitchFlagBitSet2;
    }

    public boolean isWinSwitchFlagBitSet3() {
        return this.winSwitchFlagBitSet3;
    }

    public void setWinSwitchFlagBitSet3(boolean winSwitchFlagBitSet3) {
        this.winSwitchFlagBitSet3 = winSwitchFlagBitSet3;
    }

    public boolean isWinSwitchFlagBitSet4() {
        return this.winSwitchFlagBitSet4;
    }

    public void setWinSwitchFlagBitSet4(boolean winSwitchFlagBitSet4) {
        this.winSwitchFlagBitSet4 = winSwitchFlagBitSet4;
    }

    public boolean isSpecialFrameFlag() {
        return this.specialFrameFlag;
    }

    public void setSpecialFrameFlag(boolean specialFrameFlag) {
        this.specialFrameFlag = specialFrameFlag;
    }

    public boolean isEmptyFrameFlag() {
        return this.emptyFrameFlag;
    }

    public void setEmptyFrameFlag(boolean emptyFrameFlag) {
        this.emptyFrameFlag = emptyFrameFlag;
    }
}

