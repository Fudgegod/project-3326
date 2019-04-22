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
        int imageType = bufferedImage.getType();
        switch (imageType) {
            case BufferedImage.TYPE_4BYTE_ABGR:
                extractPixels4ByteABgr();
                break;
            case BufferedImage.TYPE_3BYTE_BGR:
                extractPixels3ByteBgr();
                break;
            default:
                System.out.println("Wrong image type");
                throw new RuntimeException("Wrong image type");
        }
    }

    private void extractPixels3ByteBgr() {
        WritableRaster writableRaster = bufferedImage.getRaster();
        DataBuffer dataBuffer = writableRaster.getDataBuffer();

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        pixels = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = new Pixel(
                        255,
                        dataBuffer.getElem(i * 3 * width + 3 * j),
                        dataBuffer.getElem(i * 3 * width + 3 * j + 1),
                        dataBuffer.getElem(i * 3 * width + 3 * j + 2),
                        BufferedImage.TYPE_3BYTE_BGR
                );

            }
        }

    }

    private void extractPixels4ByteABgr() {
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
                        dataBuffer.getElem(i * 4 * width + 4 * j + 3),
                        BufferedImage.TYPE_4BYTE_ABGR
                );

            }
        }
    }


    public Pixel[][] getPixels() {
        return pixels;
    }
}
