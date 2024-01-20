package app.components;

import lib.ui.components.Border;
import lib.ui.components.Container;
import lib.ui.components.Divider;
import lib.ui.components.Text;
import lib.ui.contracts.CustomUIElement;
import lib.ui.contracts.DisplayableUIElement;

public class HeaderComponent extends CustomUIElement {
    private final String headerText;

    public HeaderComponent(String headerText) {
        this.headerText = headerText;
    }

    @Override
    public DisplayableUIElement build() {
        return new Container(
                new Divider(Divider.Thickness.THICK),
                new Border(
                        Border.Thickness.THICK,
                        new Text(headerText, Text.Align.CENTER)
                ),
                new Divider(Divider.Thickness.THICK)
        );
    }

}
