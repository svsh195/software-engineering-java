import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<Box>(); // создаем список boxes
        boxes.add(new Box(10, 10, 5, 2));
        boxes.add(new Box(5, 5, 20, 7));
        boxes.add(new Box(1, 4, 30, 3));
        boxes.add(new Box(11, 2, 2, 3));
        boxes.add(new Box(4, 10, 5, 2));
        boxes.add(new Box(6, 10, 1, 2));
        boxes.add(new Box(13, 10, 4, 2));
        boxes.add(new Box(3, 7, 5, 2));

        int sumWeight = 0; // общий вес
        int sumVolume = 0; // общий объем
        for (Box box : boxes) {
            sumWeight += box.weight;
            sumVolume += box.volume();
        }
        System.out.printf("Общий объем = %d, общий вес = %d\n", sumVolume, sumWeight);

        Box lightestBox = boxes.get(0); // самая легкая коробка
        Box heaviestBox = boxes.get(0); // самая тяжелая коробка
        for (Box box : boxes) {
            if (box.weight > heaviestBox.weight)
                heaviestBox = box;
            if (box.weight < lightestBox.weight)
                lightestBox = box;
        }
        System.out.printf("Самая тяжелая коробка:\n\tдлина: %d\n\tширина: %d\n\tвысота: %d\n", heaviestBox.length, heaviestBox.width, heaviestBox.height);
        System.out.printf("Самая легкая коробка:\n\tдлина: %d\n\tширина: %d\n\tвысота: %d\n", lightestBox.length, lightestBox.width, lightestBox.height);

        for (int i = boxes.size() - 1; i >= 0; i--) {
            if (boxes.get(i).volume() > 100)
                boxes.remove(boxes.get(i)); // удаляем коробку если объем больше 100
        }

        ArrayList<Box> heavyBoxes = new ArrayList<Box>();
        ArrayList<Box> lightBoxes = new ArrayList<Box>();
        sumWeight = 0;
        for (Box box : boxes) {
            sumWeight += box.weight;
        }
        var mediumWeight = sumWeight / boxes.size(); // находим срений вес оставшихся после удаления коробок
        for (Box box : boxes) {            
            if (box.weight > mediumWeight)
                heavyBoxes.add(box);
            else
                lightBoxes.add(box);
        }
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

    public int volume() {
        return length * width * height;
    }
}
