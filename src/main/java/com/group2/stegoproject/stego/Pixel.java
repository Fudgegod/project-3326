package com.group2.stegoproject.stego;

import java.awt.image.BufferedImage;


public class Pixel {
    private int alpha;
    private int blue;
    private int green;
    private int red;
    private int type;

    public Pixel(int alpha, int blue, int green, int red, int type) {
        this.alpha = alpha;
        this.blue = blue;
        this.green = green;
        this.red = red;
        this.type = type;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getPixel() {
        switch (type) {
            case BufferedImage.TYPE_4BYTE_ABGR:
                return red << 24 | green << 16 | blue << 8 | alpha;
            case BufferedImage.TYPE_3BYTE_BGR:
                return red << 16 | green << 8 | blue;
            default:
                return red << 24 | green << 16 | blue << 8 | alpha;
        }

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        switch (type) {
            case BufferedImage.TYPE_4BYTE_ABGR:
                return String.format("Red: %3d  Green: %3d  Blue: %3d  Alpha: %3d", red, green, blue, alpha);
            case BufferedImage.TYPE_3BYTE_BGR:
                return String.format("Red: %3d  Green: %3d  Blue: %3d", red, green, blue);
            default:
                return String.format("Red: %3d  Green: %3d  Blue: %3d  Alpha: %3d", red, green, blue, alpha);
        }

    }
}
