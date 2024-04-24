// Wuihee 
// 11/08/2023
// CSE 123 
// C2: Mondrian Art
// TA: Heon Jwa

import java.util.*;
import java.awt.*;

/**
 * A class that helps to generate Mondrian art.
 */
public class Mondrian {

    // Fields
    Color[] mondrianColors;
    Random random;

    /**
     * Instantiates Mondrian object used to paint Mondrian images.
     */
    public Mondrian() {
        mondrianColors = new Color[]{Color.RED, Color.CYAN, Color.YELLOW, Color.WHITE};
        random = new Random();
    }

    /**
     * Paint a basic Mondrian image.
     * 
     * @param pixels Matrix of Color objects that represent the canvas.
     */
    public void paintBasicMondrian(Color[][] pixels) {
        paintMondrian(pixels, 0, 0, pixels[0].length, pixels.length, true);
    }

    /**
     * Paint a complex Mondrian image.
     * 
     * @param pixels Matrix of Color objects that represent the canvas.
     */
    public void paintComplexMondrian(Color[][] pixels) {
        paintMondrian(pixels, 0, 0, pixels[0].length, pixels.length, false);
    }

    /**
     * Recursive auxilliary method to paint a Mondrian.
     * 
     * @param pixels Matrix of Color objects that represent the canvas.
     * @param w1 The starting column of the current section.
     * @param h1 The starting row of the current section.
     * @param w2 The ending column of the current section.
     * @param h2 The ending row of the current section.
     * @param basic Determines whether to paint a basic or complex Mondrian. 
     */
    private void paintMondrian(Color[][] pixels, int w1, int h1, int w2, int h2, boolean basic) {
        int fullHeight = pixels.length;
        int fullWidth = pixels[0].length;
        int height = h2 - h1;
        int width = w2 - w1;

        if (height < fullHeight / 4 && width < fullWidth / 4) {
            fillRegion(pixels, w1, h1, w2, h2, basic);
        } else if (height > 1 && width > 1) {
            int splitWidth = w1 + random.nextInt(width);
            int splitHeight = h1 + random.nextInt(height);

            if (height >= fullHeight / 4 && width >= fullWidth / 4) {
                paintMondrian(pixels, w1, h1, splitWidth, splitHeight, basic);
                paintMondrian(pixels, splitWidth + 2, h1, w2, splitHeight, basic);
                paintMondrian(pixels, w1, splitHeight + 2, splitWidth, h2, basic);
                paintMondrian(pixels, splitWidth + 2, splitHeight + 2, w2, h2, basic);
            } else if (height >= fullHeight / 4) {
                paintMondrian(pixels, w1, h1, w2, splitHeight, basic);
                paintMondrian(pixels, w1, splitHeight + 2, w2, h2, basic);
            } else if (width >= fullWidth / 4) {
                paintMondrian(pixels, w1, h1, splitWidth, h2, basic);
                paintMondrian(pixels, splitWidth + 2, h1, w2, h2, basic); 
            }
        }
    }

    /**
     * Auxilliary method to fill a specified region with a random Mondrian color.
     * 
     * @param pixels Matrix of Color objects that represent the canvas.
     * @param w1 The starting column of the current section.
     * @param h1 The starting row of the current section.
     * @param w2 The ending column of the current section.
     * @param h2 The ending row of the current section.
     * @param basic Determines whether to paint a basic or complex Mondrian.
     */
    private void fillRegion(Color[][] pixels, int w1, int h1, int w2, int h2, boolean basic) {
        Color color;
        if (basic) {
            color = mondrianColors[random.nextInt(mondrianColors.length)];
        } else {
            color = getRegionalColor(pixels, w1, h1);
        }

        for (int i = h1; i < h2; i++) {
            for (int j = w1; j < w2; j++) {
                pixels[i][j] = color;
            }
        }
    }

    /**
     * Auxilliary method to help paint a complex Mondrian by retrieving a color based on
     * the region.
     * 
     * @param pixels Matrix of Color objects that represent the canvas.
     * @param w1 The starting column of the current section.
     * @param h1 The starting row of the current section.
     * @return The color based on the starting position.
     */
    private Color getRegionalColor(Color[][] pixels, int w1, int h1) {
        int fullHeight = pixels.length;
        int fullWidth = pixels[0].length;
        int blueValue = Math.max(20, (int) (((double) w1 / (double) fullWidth) * 255));
        int redValue = Math.max(20, (int) (((double) h1 / (double) fullHeight) * 255));
        int greenValue = random.nextInt(100) < 40 ? random.nextInt(120) : 0;
        return new Color(redValue, greenValue, blueValue);
    }
}
