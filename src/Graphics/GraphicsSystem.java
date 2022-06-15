package Graphics;

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

public class GraphicsSystem {
}
