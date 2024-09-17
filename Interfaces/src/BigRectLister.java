import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        Filter bigRectFilter = new BigRectangleFilter();

        // Create 10 rectangles
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(3, 2));
        rectangles.add(new Rectangle(4, 4));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(4, 2));
        rectangles.add(new Rectangle(1, 5));
        rectangles.add(new Rectangle(5, 5));

        System.out.println("Rectangles with perimeter > 10:");
        for (Rectangle rect : rectangles) {
            if (bigRectFilter.accept(rect)) {
                System.out.println("Rectangle: width = " + rect.width +
                        ", height = " + rect.height +
                        ", perimeter = " + (2 * (rect.width + rect.height)));
            }
        }
    }
}