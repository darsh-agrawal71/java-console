package app;

import app.views.HomeScreen;
import lib.ui.contracts.Application;
import lib.ui.contracts.UIScreen;

public class App implements Application {

    @Override
    public UIScreen initializeApp() {
        return new HomeScreen();
    }
}

