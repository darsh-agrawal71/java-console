package lib.ui.components;

import lib.Res;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIElementWithContent;

/**
 * Displays text to the screen, can be aligned left, center, or right.
 */
public class Text implements DisplayableUIElement, UIElementWithContent {

    /**
     * Specifies the alignment of text
     */
    public enum Align {
        LEFT,
        CENTER,
        RIGHT;
    }


    private final String text;
    private final Text.Align align;

    public Text(String text) {
        this(text, Text.Align.LEFT);
    }

    public Text(String text, Align align) {
        this.text = text;
        this.align = align;
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }

    @Override
    public String getContent() {
        final StringBuilder builder = new StringBuilder();

        // The remaining space that will be filled with
        final int remainingSpace = Screen.width - this.text.length();

        switch (this.align) {
            case LEFT: {
                builder.append(this.text);
                builder.append(Res.strings.space.repeat(remainingSpace));
                break;
            }
            case CENTER: {
                // Calculate the padding on each side by floor dividing the remaining space by 2
                final int padding = Math.floorDiv(remainingSpace, 2);

                // Apply padding to one side
                builder.append(Res.strings.space.repeat(padding));

                builder.append(this.text);

                // Apply rest of the padding
                builder.append(Res.strings.space.repeat(padding));
                break;
            }
            case RIGHT: {
                // Reverse of LEFT
                builder.append(Res.strings.space.repeat(remainingSpace));
                builder.append(this.text);
                break;
            }
        }
        return builder.toString();
    }
}
