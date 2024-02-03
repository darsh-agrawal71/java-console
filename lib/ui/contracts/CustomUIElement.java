package lib.ui.contracts;

/**
 * Used to define custom UI element that can be built upon standard or other custom elements
 */
public abstract class CustomUIElement implements DisplayableUIElement {
    /** Internally display the DisplayableUIElement returned from {@link CustomUIElement#build} */
    @Override
    public final void display() {
        build().display();
    }

    /**
     * Method that returns the content to be displayed.
     * @return A {@link DisplayableUIElement} containing the desired content to be displayed.
     */
    public abstract DisplayableUIElement build();
}
