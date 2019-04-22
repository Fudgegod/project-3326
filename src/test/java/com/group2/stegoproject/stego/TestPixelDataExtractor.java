package com.group2.stegoproject.stego;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;

public class TestPixelDataExtractor {
    public static void main(String[] args) throws IOException {
        String filename = "test_files/images/red.png";
        String lena = "test_files/lena.png";
        String outputFile = "test_files/output.txt";

        PrintWriter printWriter = new PrintWriter(new FileWriter(outputFile));



        BufferedImage inputBufferedImage = ImageIO.read(new File(lena));
        PixelDataExtractor extractor = new PixelDataExtractor(inputBufferedImage);



        Pixel[][] pixels = extractor.getPixels();

        int height = pixels.length;
        int width = pixels[0].length;

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        int counter = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                printWriter.println(pixels[i][j]);
                counter++;
            }

        }

        printWriter.close();

    }

}
