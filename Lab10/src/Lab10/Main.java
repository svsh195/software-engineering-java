package Lab10;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Box> boxes = new List<Box>();
    }
}

public class Box {
    public int length; // длина
    public int width; // ширина
    public int height; // высота
    public int weight; // вес

    public Box(int length, int width, int height, int weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public int Volume() {
        return length * width * height;
    }
}
