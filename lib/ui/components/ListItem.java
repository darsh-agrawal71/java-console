package lib.ui.components;

import lib.Res;
import lib.ui.contracts.UIElementWithContent;

/**
 * Represents a list item. <br>
 * Used in {@link ListView}.
 */
public class ListItem implements UIElementWithContent {
    private final String content;
    private char itemMarker;

    public ListItem(String content) {
        this.content = content;
    }

    public void setItemMarker(char itemMarker) {
        this.itemMarker = itemMarker;
    }

    @Override
    public String getContent() {
        StringBuilder builder = new StringBuilder();
        builder.append(Res.strings.bracket_open);
        builder.append(itemMarker);
        builder.append(Res.strings.bracket_close);
        builder.append(Res.strings.space);
        builder.append(content);
        builder.append(Res.strings.newline);
        return builder.toString();
    }
}
