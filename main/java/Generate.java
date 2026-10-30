public class Generate {

    // generates plants
    // currently only has a very scuffed example

    /**
     * @param initial starting 'String' which rules are then applied to
     * @param time    sets the amount of iterations (steps) applied to initial
     * @return result of rules applied to {@code initial} after {@code time} iterations
     */
    public static String generatePlant(String initial, int time) {
        for (int i = 0; i < time; i++) {
            // the linter kept telling me to use StringBuilder
            StringBuilder newInstructions = new StringBuilder();
            for (char character : initial.toCharArray()) {
                if (character == 'x') {
                    newInstructions.append("f+[[x]-x]-f[-fx]+x");
                } else if (character == 'f') {
                    newInstructions.append("ff");
                } else {
                    newInstructions.append(character);
                }
            }
            initial = newInstructions.toString();
        }
        return initial;
    }

    /**
     * @param initial starting 'String' which rules are then applied to
     * @param time sets the amount of iterations (steps) appied to {@code initial}
     * @return result of rules applied to {@code initial} after {@code time} iterations
     */
    public static String generateRocks(String initial, int time) {
        // creates rocks using magic
        return "testrocks";
    }

    /**
     * @param initial starting 'String' which rules are then applied to
     * @param time    sets the amount of iterations (steps) applied to initial
     * @return result of rules applied to {@code initial} after {@code time} iterations
     */
    public static String generateFish(String initial, int time) {
        // creates fish using magic
        return "testfish";
    }

    /**
     * @param initial starting 'String' which rules are then applied to
     * @param time    sets the amount of iterations (steps) applied to initial
     * @return result of rules applied to {@code initial} after {@code time} iterations
     */
    public static String generateBubbles(String initial, int time) {
        // creates bubbles using magic

        return "testbubbles";
    }
}
