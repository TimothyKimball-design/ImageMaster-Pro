/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.computer.vision;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BasicComputerVision {

    public static void main(String[] args) {
        try {
            String imagePath = "insertimage.jpg";

           
            BufferedImage image = ImageIO.read(new File(imagePath)); // Provide the path to your input image

           
            BufferedImage grayImage = convertToGrayscale(image);

           
            double gamma = .5;
            BufferedImage gammaCorrectedImage = applyGammaCorrection(grayImage, gamma);

            
            BufferedImage edgesImage = detectEdges(gammaCorrectedImage);

            
            BufferedImage labeledImage = addLabel(edgesImage, "Edge Detection");

           
            saveImage(labeledImage, "output.jpg"); 

            System.out.println("Image processing completed.");
        } catch (IOException e) {
        }
    }

    public static BufferedImage convertToGrayscale(BufferedImage image) {
        BufferedImage grayscaleImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = grayscaleImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return grayscaleImage;
    }

    public static BufferedImage applyGammaCorrection(BufferedImage image, double gamma) {
        BufferedImage correctedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = correctedImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return correctedImage;
    }

    public static BufferedImage detectEdges(BufferedImage image) {
        BufferedImage edgesImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = edgesImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return edgesImage;
    }

    public static BufferedImage addLabel(BufferedImage image, String label) {
        BufferedImage labeledImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = labeledImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(label, 20, 50); // Adjust the position of the label as needed
        g.dispose();
        return labeledImage;
    }

    public static void saveImage(BufferedImage image, String outputPath) {
        try {
            File outputImage = new File(outputPath);
            ImageIO.write(image, "jpg", outputImage);
        } catch (IOException e) {
        }
    }
}
