package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    private String fileName;
    String path = System.getProperty("user.dir");
    private String newFileName;
    private String transformationType;
    public  Bitmap(String fileName, String newFileName, String transformationType) throws IOException {

        if (path.endsWith("bitmap-transformer")) {
            this.fileName = "app/src/main/resources/" + fileName;
            this.newFileName = "app/src/main/resources/" + newFileName + ".bmp";
        } else {
            this.fileName = "src/main/resources/" + fileName;
            this.newFileName = "src/main/resources/" + newFileName + ".bmp";
        }

        if(transformationType.equals("grayScale")) {
                grayScale();
        } else if (transformationType.equals("convertBW")) {
            convertBW();
        } else if (transformationType.equals("invertColors")){
            invertColors();
        } else {
            System.out.println("Please select grayScale, convertBW, or invertColors");
        }
    }

    public void invertColors() throws IOException {
        try {
            File input = new File(fileName);
            BufferedImage img = ImageIO.read(input);
            int height = img.getHeight();
            int width = img.getWidth();

            BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < height; i++ ) {
                for (int j = 0; j < width; j++) {
                    Color currentColor = new Color(img.getRGB(j, i));
                    int redValue = 255 - currentColor.getRed();
                    int greenValue = 255 - currentColor.getGreen();
                    int blueValue = 255 - currentColor.getBlue();
                    Color newColors = new Color(redValue, greenValue, blueValue);
                    newImg.setRGB(j, i, newColors.getRGB());
                }
            }
            ImageIO.write(newImg, "bmp", new File(newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertBW() throws IOException {
        try {
            File input = new File(fileName);
            BufferedImage img = ImageIO.read(input);
            int height = img.getHeight();
            int width = img.getWidth();
            BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color currentColor = new Color(img.getRGB(j, i));
                    int redValue = 0;
                    int blueValue = 0;
                    int greenValue = 0;
                    if (currentColor.getRed() >= 128) {
                        greenValue = 255;
                        redValue = 255;
                        blueValue = 255;
                    } else {
                         redValue = 0;
                         blueValue = 0;
                         greenValue = 0;
                    }  if (currentColor.getBlue() >= 128) {
                        greenValue = 255;
                        redValue = 255;
                        blueValue = 255;
                    } else {
                         blueValue = 0;
                        redValue = 0;
                        greenValue = 0;
                    }  if (currentColor.getGreen() >= 128) {
                         greenValue = 255;
                         redValue = 255;
                         blueValue = 255;
                    } else {
                        greenValue = 0;
                        blueValue = 0;
                        redValue = 0;

                    }
                    Color newColors = new Color(redValue, greenValue, blueValue);
                    newImg.setRGB(j, i, newColors.getRGB());
                }
                ImageIO.write(newImg, "bmp", new File(newFileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void grayScale() throws IOException {
        try {
            File input = new File(fileName);
            BufferedImage img = ImageIO.read(input);
            int height = img.getHeight();
            int width = img.getWidth();
            BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color currentColor = new Color(img.getRGB(j, i));
                    int redValue = currentColor.getRed();
                    int greenValue = currentColor.getGreen();
                    int blueValue = currentColor.getBlue();
                    int greyColor = (redValue + greenValue + blueValue)/3;
                    Color newColors = new Color(greyColor, greyColor, greyColor);
                    newImg.setRGB(j, i, newColors.getRGB());
                }
                ImageIO.write(newImg, "bmp", new File(newFileName));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
