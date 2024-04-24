# Creative Project 2: Mondrian Art

## Objective

- Implement a program to generate random artwork in the style of Mondrian. Your random artwork will start with a blank canvas of a given width and height and should repeatedly break the canvas into smaller and smaller regions until the regions are below a certain size.

## Implementation

- Must be done recursively.

### Algorithm

- If the region being considered is at least one-fourth the height of the full canvas and at least one-fourth the width of the full canvas, split it into four smaller regions by choosing one vertical and one horizontal dividing line at random.
- If the region being considered is at least one-fourth the height of the full canvas, split it into two smaller regions by choosing a horizontal dividing line at random.
- If the region being considered is at least one-fourth the width of the full canvas, split it into two smaller regions by choosing a vertical dividing line at random.
- If the region being considered is smaller than one-fourth the height of the full canvas and smaller than one-fourth the width of the full canvas, do not split the region.

### Extension

- Instead of determining the color of a region completely randomly, choose the color based in part on the location of the region in the overall canvas. For example, you might make regions closer to the upper left more likely to be red and regions closer to the lower right more likely to be blue. Or you might make regions closer to the center of the image more likely to be darker and regions closer to the edges more likely to be lighter. (You should still color each full region a single color.)

### Required Methods

- **`public void paintBasicMondrian(Color[][] pixels)`**: Fill pixels with Color objects (using the java.awt.Color class) according to the basic algorithm specified above.
- **`public void paintComplexMondrian(Color[][] pixels)`**: Fill pixels withColor objects (using the java.awt.Color class) based on your chosen extension.
