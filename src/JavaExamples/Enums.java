package JavaExamples;

public class Enums {
    // simple enum
    private enum Color {
        RED, GREEN, BLUE;
    }

    // enums can have associated values
    private enum Direction {
        NORTH(0),
        EAST(90),
        SOUTH(180),
        WEST(270);

        private int degrees;

        // enum constructor
        Direction(int degrees) {
            this.degrees = degrees;
        }

        // enum methods
        public int getDegrees() {
            return degrees;
        }
    }

    public static void main(String[] args) {
        // get an enum
        Color c = Color.RED;
        System.out.println(c);

        // use a switch statement on enums
        switch (c) {
            case RED:
                System.out.println("Value is RED");
                break;
            case GREEN:
                System.out.println("Value is GREEN");
                break;
            default:
                System.out.println("Value is BLUE");
                break;
        }

        // use enum methods
        Direction d = Direction.SOUTH;
        System.out.println(d.getDegrees());
    }
}
