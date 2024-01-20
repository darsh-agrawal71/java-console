package lib.ui.components;

import lib.ui.contracts.DisplayableUIElement;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Similar to a {@code div} in {@code HTML}. <br>
 * It wraps many {@link  DisplayableUIElement}s into one. <br>
 * Useful for making complex UIs.
 */
public class Container implements DisplayableUIElement {
    private final List<DisplayableUIElement> children;

    public Container(DisplayableUIElement... children) {
        this.children = new ArrayList<>(List.of(children));
    }

    /**
     * Method to append another child to the list of children. <br>
     * @param child The new child to be appended.
     */
    public void appendChild(DisplayableUIElement child) {
        children.add(child);
    }


    @Override
    public void display() {
        this.children.forEach(new Consumer<DisplayableUIElement>() {
            @Override
            public void accept(DisplayableUIElement child) {
                child.display();
            }
        });
    }
}
