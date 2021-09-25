package java_coursera.JavaProgramming_SolvingProblemswithSoftware.Week4.BatchGrayScale;

import java.io.*;
public class Assignment {
        public edu.duke.ImageResource makeGray(edu.duke.ImageResource inImage) {
            edu.duke.ImageResource outImage = new edu.duke.ImageResource(inImage);

            for (edu.duke.Pixel pixel : outImage.pixels()) {
                edu.duke.Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                int r = inPixel.getRed();
                int g = inPixel.getGreen();
                int b = inPixel.getBlue();
                int average = (r + g + b) / 3;

                pixel.setRed(average);
                pixel.setGreen(average);
                pixel.setBlue(average);
            }

            return outImage;
        }

        public void selectAndConvert() {
            edu.duke.DirectoryResource dr = new edu.duke.DirectoryResource();

            for (File f : dr.selectedFiles()) {
                edu.duke.ImageResource inImage = new edu.duke.ImageResource(f);
                edu.duke.ImageResource outImage = makeGray(inImage);

                String fileName = inImage.getFileName();
                String newFileName = "gray-" + fileName;

                outImage.setFileName(newFileName);
                outImage.save();
            }
        }

        public static void main(String[] args) {
            Assignment assignment=new Assignment();
            assignment.selectAndConvert();
        }

    }
