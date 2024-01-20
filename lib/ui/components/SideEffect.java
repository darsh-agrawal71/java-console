package lib.ui.components;

import lib.ui.contracts.DisplayableUIElement;

public class SideEffect implements DisplayableUIElement {
    private final Executable executable;

    public SideEffect(Executable executable) {
        this.executable = executable;
    }

    /**
     * Does not render elements, only serves as a way to call code in UI.
     * Gives a {@code displayer}, a way to display UI elements like messages.
     * e.g.
     * <pre>
     *
     * new SideEffect(new SideEffectExecutable() {
     *     &#064;Override
     *     public void execute(SideEffectDisplayer displayer) {
     *         // code here...
     *     }
     * })
     * .display(); // execute code
     *
     * //or using lambda:
     *
     * new SideEffect(displayer -> {
     *     // code here...
     * }).display();
     *  </pre>
     *}
     */
    @Override
    public void display() {
        SideEffect.Displayer displayer = new SideEffect.Displayer();
        executable.execute(displayer);
    }

    public static final class Displayer {
        public void display(DisplayableUIElement element) {
            element.display();
        }
    }

    @FunctionalInterface
    public interface Executable {
        void execute(Displayer displayer);
    }
}
