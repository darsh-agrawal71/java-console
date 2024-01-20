package app.components;

import app.Res;
import app.views.QuitScreen;
import lib.input.ListInputPrompt;
import lib.input.PromptResult;
import lib.ui.components.ListItem;
import lib.ui.components.ListView;
import lib.ui.components.SideEffect;
import lib.ui.contracts.CustomUIElement;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIScreen;
import lib.ui.navigation.CannotGoBackException;
import lib.ui.navigation.Navigator;
import lib.util.EnumUtils;

public class BackQuitMenu extends CustomUIElement {

    private enum Result {
        BACK, 
        QUIT;
    }

    @Override
    public DisplayableUIElement build() {
        return new SideEffect(new SideEffect.Executable() {

            @Override
            public void execute(SideEffect.Displayer displayer) {
                ListItem back = new ListItem(Res.strings.back);
                ListItem quit = new ListItem(Res.strings.quit);
                ListView options = new ListView(back, quit);
                displayer.display(options);

                ListInputPrompt prompt = new ListInputPrompt();
                PromptResult<Integer> result = prompt.promptUserWithPrompt(Res.strings.enter_choice);
                Result option = EnumUtils.<Result>convertIntToEnum(result.getResult(), Result.class);
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
    
}
