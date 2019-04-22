package com.group2.stegoproject.stego;

import java.awt.*;
import java.awt.image.*;

public class ImageComposer {

    private Pixel[][] pixels;
    private BufferedImage bufferedImage;
    private int imageType;
    private SampleModel sampleModel;

    public ImageComposer(Pixel[][] pixels, ColorModel colorModel, SampleModel sampleModel, int imageType) {
        this.sampleModel = sampleModel;
        this.pixels = pixels;
        this.imageType = imageType;
        this.bufferedImage = new BufferedImage(pixels[0].length, pixels.length, imageType);

    }

    public BufferedImage compose() {
        DataBuffer dataBuffer = populateBuffer();
        Raster raster = Raster.createWritableRaster(sampleModel, dataBuffer, new Point(0, 0));
        bufferedImage.setData(raster);
        return bufferedImage;
    }


    private DataBuffer populateBuffer() {
        switch (imageType) {
            case BufferedImage.TYPE_4BYTE_ABGR:
                return populateBuffer4ByteABgr();
            case BufferedImage.TYPE_3BYTE_BGR:
                return populateBuffer3ByteBgr();
            default:
                return null;
        }
    }


    private DataBuffer populateBuffer4ByteABgr() {
        int height = pixels.length;
        int width = pixels[0].length;
        DataBuffer db = new DataBufferByte(imageType, height * width * 4);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                db.setElem(i * 4 * width + 4 * j, pixels[i][j].getAlpha());
                db.setElem(i * 4 * width + 4 * j + 1, pixels[i][j].getBlue());
                db.setElem(i * 4 * width + 4 * j + 2, pixels[i][j].getGreen());
                db.setElem(i * 4 * width + 4 * j + 3, pixels[i][j].getRed());

            }
        }

        return db;
    }

    private DataBuffer populateBuffer3ByteBgr() {
        int height = pixels.length;
        int width = pixels[0].length;
        DataBuffer db = new DataBufferByte(height * width * 3);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                db.setElem(i * 3 * width + 3 * j, pixels[i][j].getBlue());
                db.setElem(i * 3 * width + 3 * j + 1, pixels[i][j].getGreen());
                db.setElem(i * 3 * width + 3 * j + 2, pixels[i][j].getRed());

            }
        }

        return db;

    }
}
