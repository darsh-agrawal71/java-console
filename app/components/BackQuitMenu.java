package app.components;

import app.Res;
import app.views.QuitScreen;
import lib.input.ListInputPrompt;
import lib.ui.components.Container;
import lib.ui.components.ListItem;
import lib.ui.components.ListView;
import lib.ui.components.SideEffect;
import lib.ui.contracts.CustomUIElement;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIScreen;
import lib.ui.navigation.CannotGoBackException;
import lib.ui.navigation.Navigator;

public class BackQuitMenu extends CustomUIElement {

    @Override
    public DisplayableUIElement build() {
        return new Container(
                buildOptionsList(),
                executeInputSideEffect()
        );
    }

    private ListView buildOptionsList() {
        ListItem back = new ListItem(Res.strings.back);
        ListItem quit = new ListItem(Res.strings.quit);
        return new ListView(back, quit);
    }

    private SideEffect executeInputSideEffect() {
        return new SideEffect(new SideEffect.Executable() {
            @Override
            public void execute(SideEffect.Displayer displayer) {
                ListInputPrompt prompt = new ListInputPrompt();
                ListInputPrompt.Result result = prompt.promptUserWithPrompt(Res.strings.enter_choice);
                Result option = result.<BackQuitMenu.Result>convertResultToEnum(Result.class);
                try {
                    handleOption(option);
                } catch (CannotGoBackException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    private void handleOption(Result option) throws CannotGoBackException {
        switch (option) {
            case BACK:
                Navigator.navigateBack();
                break;
            case QUIT:
                UIScreen screen = new QuitScreen();
                Navigator.navigateTo(screen);
                break;
            default:
                break;

        }
    }

    private enum Result {
        BACK,
        QUIT;
    }

}
