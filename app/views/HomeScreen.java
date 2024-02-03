package app.views;

import app.Res;
import app.components.HeaderComponent;
import lib.input.ListInputPrompt;
import lib.ui.components.*;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIScreen;
import lib.ui.navigation.Navigator;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class HomeScreen implements UIScreen {

    @Override
    public DisplayableUIElement build() {
        return new Container(
                new HeaderComponent(app.Res.strings.app_title),
                new Spacer(),
                buildOptionList(),
                executeInputSideEffect()
        );
    }

    private DisplayableUIElement buildOptionList() {
        List<ListItem> listItems =
                Stream.<HomeScreenOptions>of(HomeScreenOptions.values())
                        .map(new Function<HomeScreenOptions, ListItem>() {
                            @Override
                            public ListItem apply(HomeScreenOptions homeScreenOptions) {
                                return new ListItem(homeScreenOptions.getContent());
                            }
                        }).toList();
        return new ListView(listItems);
    }

    private DisplayableUIElement executeInputSideEffect() {
        return new SideEffect(new SideEffect.Executable() {
            @Override
            public void execute(SideEffect.Displayer displayer) {
                ListInputPrompt prompt = new ListInputPrompt();
                ListInputPrompt.Result result = prompt.promptUserWithPrompt(Res.strings.enter_choice);
                HomeScreenOptions choice = result.<HomeScreenOptions>convertResultToEnum(HomeScreenOptions.class);
                handleChoice(choice);
            }
        });
    }

    private void handleChoice(HomeScreenOptions choice) {
        UIScreen screen;
        switch (choice) {
            case ADD_STUDENT: {
                screen = new AddStudentScreen();
                break;
            }
            case VIEW_ALL_STUDENTS: {
                screen = new ViewStudentsScreen();
                break;
            }
            case EDIT_STUDENT: {
                screen = new EditStudentScreen();
                break;
            }
            case DELETE_STUDENT: {
                screen = new DeleteStudentScreen();
                break;
            }
            case QUIT_APP: {
                screen = new QuitScreen();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        Navigator.navigateTo(screen);
    }


}
