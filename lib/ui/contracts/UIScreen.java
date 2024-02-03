package lib.ui.contracts;

/** A top-level UI component which represents a screen that can be navigated to and fro with
 * {@link lib.ui.navigation.Navigator}.
 */
public interface UIScreen {
    DisplayableUIElement build();
}
