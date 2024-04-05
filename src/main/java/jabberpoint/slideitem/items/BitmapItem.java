package jabberpoint.slideitem.items;

import jabberpoint.Style;
import jabberpoint.slide.iterator.Iterator;
import jabberpoint.slideitem.SlideItem;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;


/**
 * <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items have the responsibility to draw themselves.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class BitmapItem implements SlideItem {
    private BufferedImage bufferedImage;
    private String imageName; //path to file
    private int level;


    // "Constructor" without parameters
    @Override
    public SlideItem createSlideItem() {
        this.level = 0;
        this.imageName = "Default.png";

        try {
            this.bufferedImage = ImageIO.read(new File("./bitmapimage/" + this.imageName));
        } catch (IOException e) {
            System.err.println("File " + this.imageName + " not found");
        }

        return this;
    }

    //"Constructor" with parameters
    @Override
    public SlideItem createSlideItem(int level, String imageName) {
        if (level < 0 || level > 5) {
            throw new IllegalArgumentException("Level must be between 0-5");
        }

        if (imageName.length() < 4){
            throw new IllegalArgumentException("Image needs to be at least 4 character long")
        }
        this.level = level;
        this.imageName = imageName;

        try {
            this.bufferedImage = ImageIO.read(new File("./bitmapimage/" + this.imageName));
        } catch (IOException e) {
            System.err.println("File " + this.imageName + " not found");
        }

        return this;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public int getLevel() {
        return level;
    }

    // give the  bounding box of the image
    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        return new Rectangle((int) (myStyle.indent * scale), 0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (myStyle.leading * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale));
    }

    // draw the image
    @Override
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
        int width = x + (int) (myStyle.indent * scale);
        int height = y + (int) (myStyle.leading * scale);
        g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale), observer);
    }

    @Override
    public Iterator createIterator() {

        return
    }
}
