package com.group2.stegoproject.stego;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestImageComposer {

    public static void main(String[] args) throws IOException {

        String lena = "test_files/lena.png";
        String outputFile = "test_files/output.png";

        File outputImage = new File(outputFile);
        //hello

        BufferedImage inputBufferedImage = ImageIO.read(new File(lena));
        PixelDataExtractor extractor = new PixelDataExtractor(inputBufferedImage);



        Pixel[][] pixels = extractor.getPixels();
        ColorModel colorModel = inputBufferedImage.getColorModel();
        SampleModel sampleModel = inputBufferedImage.getSampleModel();
        int imageType = inputBufferedImage.getType();


        ImageComposer imageComposer = new ImageComposer(pixels, colorModel, sampleModel, imageType);

        ImageIO.write(imageComposer.compose(), "png", outputImage);


    }

}