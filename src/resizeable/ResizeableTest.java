package resizeable;



public class ResizeableTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square();
        Shape[] list = {circle, rectangle, square};
        System.out.println("Mảng các hình trước khi resize");
        for (Shape shape : list) {
            System.out.println(shape);
        }
        for (Shape shape : list) {
            double random = Math.random() * 100;
            if (shape instanceof Circle) {
                Resizeable resizeable = (Circle) shape;
                resizeable.resize(random);
            }
            if (shape instanceof Rectangle) {
                Resizeable resizeable = (Rectangle) shape;
                resizeable.resize(random);
            }
            if (shape instanceof Square){
                Square square1 = (Square) shape;
                square1.resize(random);
                square1.howToColor();
            }
        }
        System.out.println("Mảng các hình sau khi resize");
        for (Shape shape : list) {
            System.out.println(shape);
        }
    }
}
