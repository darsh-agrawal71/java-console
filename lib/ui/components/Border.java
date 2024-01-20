package lib.ui.components;

import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIElementWithContent;

/**
 * Wraps one {@link UIElementWithContent} in a border.
 */
public class Border implements DisplayableUIElement, UIElementWithContent {

    private final Thickness thickness;
    private final UIElementWithContent child;
    private final TruncateMethod truncateMethod;

    /**
     * Defines how the border treats the child content.
     */
    public enum TruncateMethod {
        /**
         * This method sets border characters at the first and last index of the content.<br>
         * Not recommended because in certain use cases it may cause data loss.
         */
        SET,
        /**
         * This method appends the first border character, appends content, and appends the last border character.<br>
         * Recommended method as it has minimal data loss (only truncates when content is greater than {@value Res.dimen#screen_width}).
         */
        APPEND;
    }

    /**
     * Thickness of the border.
     */
    public enum Thickness {
        THIN('|'), THICK('#');
        private final char visualCharacter;

        Thickness(char visualCharacter) {
            this.visualCharacter = visualCharacter;

        }

        public char getVisualCharacter() {
            return visualCharacter;
        }
    }

    public Border(Thickness thickness, UIElementWithContent child, TruncateMethod truncateMethod) {
        this.thickness = thickness;
        this.child = child;
        this.truncateMethod = truncateMethod;
    }

    public Border(Thickness thickness, UIElementWithContent child) {
        this(thickness, child, TruncateMethod.APPEND);
    }

    public void display() {
        System.out.println(getContent());
    }

    public String getContent() {
        switch (this.truncateMethod) {
            case SET:
                return useSetMethod();
            case APPEND:
                return useAppendMethod();
            default:
                throw new IllegalArgumentException();
        }
    }

    private String useSetMethod() {
        final int LAST_CHAR_INDEX = Res.dimen.screen_width - 1;
        final int FIRST_CHAR_INDEX = 0;
        // Leave space for first border
        final StringBuilder builder = new StringBuilder(this.child.getContent().substring(1));
        String content;

        // Fill string with null characters if string is smaller than Res.dimen.SCREEN_WIDTH
        // If string is bigger, no null characters are there, instead string will get cut off.
        builder.setLength(Res.dimen.screen_width);

        // Set the first character to border
        builder.setCharAt(FIRST_CHAR_INDEX, this.thickness.getVisualCharacter());

        // Set the last character to border
        builder.setCharAt(LAST_CHAR_INDEX, this.thickness.getVisualCharacter());

        // Replace null characters with spaces.
        content = builder.toString().replace(Res.strings.null_char, Res.strings.space);

        return content;
    }

    private String useAppendMethod() {
        final int LAST_CHAR_INDEX = Res.dimen.screen_width - 1;
        final StringBuilder builder = new StringBuilder();
        String content;


        // Set the first character to border
        builder.append(thickness.getVisualCharacter());

        // Add content
        builder.append(this.child.getContent());

        // Fill string with null characters if string is smaller than Res.dimen.SCREEN_WIDTH
        // If string is bigger, no null characters are there, instead string will get cut off.
        builder.setLength(Res.dimen.screen_width);

        // Set the last character to border
        builder.setCharAt(LAST_CHAR_INDEX, this.thickness.getVisualCharacter());

        // Replace null characters with spaces.
        content = builder.toString().replace(Res.strings.null_char, Res.strings.space);

        return content;
    }
}
