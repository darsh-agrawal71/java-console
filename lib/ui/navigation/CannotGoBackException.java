package lib.ui.navigation;

public class CannotGoBackException extends Exception {
    public CannotGoBackException(String reason) {
        super("Cannot go back: " + reason);
    }

    public void printMessage() {
        System.err.println(getMessage());
    }
}
