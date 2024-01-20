import app.App;
import lib.ui.contracts.Application;
import lib.ui.contracts.UIScreen;
import lib.ui.navigation.Navigator;

public class Program {
    public static void main(String[] args) {
        Application app = new App();
        UIScreen initialScreen = app.initializeApp();
        Navigator.navigateTo(initialScreen);
    }
}