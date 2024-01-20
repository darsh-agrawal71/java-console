package lib.ui.components;

/**
 * Prints a line to separate content. Extends {@link Spacer}
 */
public class Divider extends Spacer {

    /**
     * The thickness for the divider
     */
    public enum Thickness {
        THIN('-'), THICK('=');
        private final char visualCharacter;

        Thickness(char visualCharacter) {
            this.visualCharacter = visualCharacter;
        }

        public char getVisualCharacter() {
            return visualCharacter;
        }
    }

    public Divider(Thickness thickness) {
        super(thickness.getVisualCharacter());
    }
}
