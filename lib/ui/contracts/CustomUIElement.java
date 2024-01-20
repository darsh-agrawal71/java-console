package lib.ui.contracts;

public abstract class CustomUIElement implements DisplayableUIElement {
    @Override
    public final void display() {
        build().display();
    }

    public abstract DisplayableUIElement build();
}
