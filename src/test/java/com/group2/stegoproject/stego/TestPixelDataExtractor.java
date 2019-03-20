package com.group2.stegoproject.stego;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TestPixelDataExtractor {
    public static void main(String[] args) throws IOException {
        String filename = "test_files/whitegray.png";
        PixelDataExtractor extractor = new PixelDataExtractor(ImageIO.read(new File(filename)));


        Pixel[][] pixels = extractor.getPixels();

        int height = pixels.length;
        int width = pixels[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(pixels[i][j]);
            }

        }

    }

}
