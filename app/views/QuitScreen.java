package app.views;

import app.Res;
import lib.ui.components.Container;
import lib.ui.components.SideEffect;
import lib.ui.components.Text;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIScreen;

public class QuitScreen implements UIScreen {
    @Override
    public DisplayableUIElement build() {
        return new Container(
                buildMessageText(),
                executeExitSideEffect()
        );
    }

    private DisplayableUIElement buildMessageText() {
        return new Text(Res.strings.quitting);
    }

    private DisplayableUIElement executeExitSideEffect() {
        return new SideEffect(new SideEffect.Executable() {
            @Override
            public void execute(SideEffect.Displayer displayer) {
                System.exit(Res.values.EXIT_SUCCESS);
            }
        });
    }
}
