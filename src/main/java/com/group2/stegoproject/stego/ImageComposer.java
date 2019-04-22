package com.group2.stegoproject.stego;

import java.awt.image.*;
import java.io.File;

import static java.awt.image.BufferedImage.TYPE_4BYTE_ABGR;

public class ImageComposer {

    private Pixel[][] pixels;
    private BufferedImage bufferedImage;

    public ImageComposer(Pixel[][] pixels, ColorModel colorModel, Raster raster) {
        this.pixels = pixels;
        this.bufferedImage = new BufferedImage(pixels[0].length, pixels.length, TYPE_4BYTE_ABGR);
        populateBuffer();

    }


    private void populateBuffer() {
        int height = pixels.length;
        int width = pixels[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bufferedImage.setRGB(i, j, pixels[i][j].getPixel());
            }
        }
    }
}
