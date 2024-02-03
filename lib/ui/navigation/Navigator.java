package lib.ui.navigation;

import lib.ui.contracts.UIScreen;
import lib.ui.components.Screen;

import java.util.Stack;

public final class Navigator {
    private static final Stack<UIScreen> navigationStack = new Stack<>();

    public static void navigateTo(UIScreen otherScreen) {
        navigationStack.push(otherScreen);
        internalNavigate(otherScreen);
    }

    public static void navigateBack() throws CannotGoBackException {
        if (navigationStack.isEmpty()) {
            throw new CannotGoBackException("Empty navigation stack. There is no previous destination to go back to.");
        }
        UIScreen previousScreen = navigationStack.pop();
        if (!navigationStack.isEmpty()) {
            internalNavigate(navigationStack.peek());
        }
    }

    private static void internalNavigate(UIScreen otherScreen) {
        Screen.clear();
        otherScreen.build().display();
    }
}
