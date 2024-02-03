package lib.ui.navigation;

/** Thrown when {@link lib.ui.navigation.Navigator} cannot go back further */
public class CannotGoBackException extends Exception {
    public CannotGoBackException(String reason) {
        super("Cannot go back: " + reason);
    }

    public void printMessage() {
        System.err.println(getMessage());
    }
}
