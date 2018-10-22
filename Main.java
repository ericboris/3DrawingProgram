import java.io.File;

public class Main {
    public static void main(String[] args)  {
        ShapeLibrary shapeLib  = new ShapeLibrary();
        Drawing drawing1 = new Drawing(shapeLib, new File("Instruct-Simple.txt"));
        Drawing drawing2 = new Drawing(shapeLib, new File("Instruct-Rand.txt"));
        Drawing drawing3 = new Drawing(shapeLib, new File("Instruct-RepeatOffset.txt"));
        Drawing drawing4 = new Drawing(shapeLib, new File("Instruct-Gradient.txt"));
        Drawing drawing5 = new Drawing(shapeLib, new File("Instruct-Rotate.txt"));
        Drawing drawing6 = new Drawing(shapeLib, new File("Instruct-Gradient-Horiz.txt"));
        Drawing drawing7 = new Drawing(shapeLib, new File("Instruct-Gradient-Vert.txt"));
        Drawing drawing8 = new Drawing(shapeLib, new File("Instruct-Gradient-DiagTL.txt"));
        Drawing drawing9 = new Drawing(shapeLib, new File("Instruct-Gradient-DiagTR.txt"));
        Drawing drawing10 = new Drawing(shapeLib, new File("drawGems.txt"));
        Drawing drawing11 = new Drawing(shapeLib, new File("drawSpirals.txt")); 
        Drawing drawing12 = new Drawing(shapeLib, new File("sunriseOverGem.txt"));
        
        drawing12.draw();
        drawing11.draw();
        drawing10.draw();
        drawing9.draw();
        drawing8.draw();
        drawing7.draw();
        drawing6.draw();
        drawing5.draw();
        drawing4.draw();
        drawing3.draw();
        drawing2.draw();
        drawing1.draw();
        
        System.out.println(drawing1.toString());
        System.out.println(drawing2.toString());
        System.out.println(drawing3.toString());
        System.out.println(drawing4.toString());
        System.out.println(drawing5.toString());
        System.out.println(drawing6.toString());
        System.out.println(drawing7.toString());
        System.out.println(drawing8.toString());
        System.out.println(drawing9.toString());
        System.out.println(drawing10.toString());
        System.out.println(drawing11.toString());
        System.out.println(drawing12.toString());
    }    
}
