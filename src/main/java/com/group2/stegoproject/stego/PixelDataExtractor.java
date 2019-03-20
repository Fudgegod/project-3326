package com.group2.stegoproject.stego;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;

public class PixelDataExtractor {

    private BufferedImage bufferedImage;
    private Pixel[][] pixels;

    public PixelDataExtractor(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        extractPixels();
    }

    private void extractPixels() {
        WritableRaster writableRaster = bufferedImage.getRaster();
        DataBuffer dataBuffer = writableRaster.getDataBuffer();

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        pixels = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = new Pixel(
                        dataBuffer.getElem(i * 4 * width + 4 * j),
                        dataBuffer.getElem(i * 4 * width + 4 * j + 1),
                        dataBuffer.getElem(i * 4 * width + 4 * j + 2),
                        dataBuffer.getElem(i * 4 * width + 4 * j + 3));

            }
        }
    }


    public Pixel[][] getPixels() {
        return pixels;
    }
}
