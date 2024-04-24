import java.awt.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Mondrian mond = new Mondrian();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Picture pic = new Picture(random.nextInt(300, 1200), random.nextInt(300, 1200));
            Color[][] pixels = pic.getPixels();
            mond.paintBasicMondrian(pixels);
        }
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the CSE 123 Mondrian Art Generator!");

        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.print("Enter 1 for a basic Mondrian or 2 for a complex Mondrian: ");
            choice = console.nextInt();
        }
        System.out.print("Enter image width (>= 300px): ");
        int width = console.nextInt();
        System.out.print("Enter image height (>= 300px): ");
        int height = console.nextInt();

        mond = new Mondrian();
        Picture pic = new Picture(width, height);
        Color[][] pixels = pic.getPixels();

        if (choice == 1) {
            mond.paintBasicMondrian(pixels);
        } else {    // choice == 2
            mond.paintComplexMondrian(pixels);
        }
        
        pic.setPixels(pixels);
        pic.save(choice == 1 ? "./creative_project_2/basic.png" : "./creative_project_2/extension.png");
        pic.show();
        System.out.println("Enjoy your artwork!");
    }
}

