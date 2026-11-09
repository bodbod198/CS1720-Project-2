public class Generate {

    public static String[] generatePlants(int iterations) {
        // adds random plants from list of plants
        String[] plants = {"", "", ""};
        for (int i = 0; i < 3; i++) {
            int randPlant = (int) (Math.random() * 3);
            if (randPlant == 0) {
                plants[i] = generatePlant1(iterations);
            } else if (randPlant == 1) {
                plants[i] = generatePlant2(iterations);
            } else if (randPlant == 2) {
                plants[i] = generatePlant3(iterations);
            }
        }
        return plants;
    }
    private static String generatePlant1(int iterations) {
        // a tall kelp-ish plant
        // a will draw, x is placeholder
        // angle 17
        // color 1, 50, 32 (dark green-ish)
        String initial = "x";
        for (int i = 0; i < iterations; i++) {
            StringBuilder newInstructions = new StringBuilder();
            for (char character : initial.toCharArray()) {
                if (character == 'x') {
                    newInstructions.append("a[+x]a[-x]+x");
                } else if (character == 'a') {
                    newInstructions.append("aa");
                } else {
                    newInstructions.append(character);
                }
            }
            initial = newInstructions.toString();
        }
        return initial;
    }
    private static String generatePlant2(int iterations) {
        // bushy type of plant
        // b is draw
        // angle 22.5
        // color 165, 42, 42 (like a red-brown)
        String initial = "b";
        for (int i = 0; i < iterations; i++) {
            StringBuilder newInstructions = new StringBuilder();
            for (char character : initial.toCharArray()) {
                if (character == 'b') {
                    newInstructions.append("bb+[+b-b-b]-[-b+b+b]");
                } else {
                    newInstructions.append(character);
                }
            }
            initial = newInstructions.toString();
        }
        return initial;
    }

    private static String generatePlant3(int iterations) {
        // one of those underwater ferns
        // c is draw
        // angle 27
        // color 132, 89, 126 (like a dull purple)
        String initial = "c";
        for (int i = 0; i < iterations; i++) {
            StringBuilder newInstructions = new StringBuilder();
            for (char character : initial.toCharArray()) {
                if (character == 'c') {
                    newInstructions.append("c[+c]c[-c][c]");
                } else {
                    newInstructions.append(character);
                }
            }
            initial = newInstructions.toString();
        }
        return initial;
    }
}
