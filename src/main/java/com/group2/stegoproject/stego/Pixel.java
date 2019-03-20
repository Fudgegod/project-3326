package com.group2.stegoproject.stego;

public class Pixel {
    private int alpha;
    private int blue;
    private int green;
    private int red;

    public Pixel(int alpha, int blue, int green, int red) {
        this.alpha = alpha;
        this.blue = blue;
        this.green = green;
        this.red = red;
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
        return red << 24 | green << 16 | blue << 8 | alpha;
    }


    @Override
    public String toString() {
        return String.format("Red: %d\tGreen: %d\tBlue: %d\tAlpha: %d", red, green, blue, alpha);
    }
}
