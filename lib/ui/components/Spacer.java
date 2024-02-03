package lib.ui.components;

import lib.Res;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIElementWithContent;

/** Prints a line of characters long as {@link Screen#width}
 * Character printed can be custom, defaults to {@link lib.Res.strings#space} */
public class Spacer implements DisplayableUIElement, UIElementWithContent {

    private static final char DEFAULT_CHARACTER = Res.strings.space.charAt(0);
    private final char character;

    public Spacer() {
        this(DEFAULT_CHARACTER);
    }

    public Spacer(char character) {
        this.character = character;
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }

    @Override
    public String getContent() {
        return String.valueOf(this.character).repeat(Screen.width);
    }
}
