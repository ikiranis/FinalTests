package Graphics;

import java.util.ArrayList;
import java.util.List;

abstract class GraphicObject {
    private String name;
    private double[] position = new double[2];

    public GraphicObject(String name, int x, int y) {
        this.name = name;
        position[0] = x;
        position[1] = y;
    }

    abstract public double emvadon();
}

class Square extends GraphicObject {
    private double width;

    public Square(String name, int x, int y, double width) {
        super(name, x, y);
        this.width = width;
    }

    @Override
    public double emvadon() {
        return Math.pow(width, 2);
    }
}

class Circle extends GraphicObject {
    private double radius;

    public Circle(String name, int x, int y, double radius) {
        super(name, x, y);
        this.radius = radius;
    }

    @Override
    public double emvadon() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Group extends GraphicObject {
    private List<GraphicObject> elements;

    public Group(String name, int x, int y, List<GraphicObject> elements) throws Exception {
        super(name, x, y);

        if (elements.size() < 2) {
            throw new Exception("H ομάδα θα πρέπει να περιλαμβάνει 2 ή περισσότερα αντικείμενα");
        } else {
            this.elements = elements;
        }
    }

    public void addElement(GraphicObject element) {
        elements.add(element);
    }

    public void removeElement(GraphicObject element) {
        elements.remove(element);
    }

    @Override
    public double emvadon() {
        double emvadon = 0;

        for (GraphicObject g : elements) {
            emvadon += g.emvadon();
        }

        return emvadon;
    }
}

public class GraphicsSystem {
    public static void main(String[] args) {
        List<GraphicObject> elements = new ArrayList<>();

        Circle c1 = new Circle("Circle 1", 3, 4, 5);
        Circle c2 = new Circle("Circle 2", 3, 4, 7);
        Square s1 = new Square("Square 1", 10, 12, 10);
        Square s2 = new Square("Square 2", 10, 12, 20);

        elements.add(c1);
        elements.add(s1);

        try {
            Group group = new Group("Group 1", 7, 8, elements);

            System.out.println("Συνολικό εμβαδόν: " + group.emvadon());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
