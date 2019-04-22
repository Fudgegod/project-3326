package com.group2.stegoproject.stego;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.IOException;

public class TestImageManipulation {
    public static void main(String[] args) throws IOException {

        String lena = "test_files/lena.png";
        String outputFile = "test_files/output.png";

        File outputImage = new File(outputFile);


        BufferedImage inputBufferedImage = ImageIO.read(new File(lena));
        PixelDataExtractor extractor = new PixelDataExtractor(inputBufferedImage);



        Pixel[][] pixels = extractor.getPixels();

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                pixels[i][j].setBlue(255);
                pixels[i][j].setRed(255);

            }
        }



        ColorModel colorModel = inputBufferedImage.getColorModel();
        SampleModel sampleModel = inputBufferedImage.getSampleModel();
        int imageType = inputBufferedImage.getType();


        ImageComposer imageComposer = new ImageComposer(pixels, colorModel, sampleModel, imageType);

        ImageIO.write(imageComposer.compose(), "png", outputImage);


    }
}
