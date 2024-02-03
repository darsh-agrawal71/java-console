package app.views;

import app.Res;
import app.components.BackQuitMenu;
import app.components.HeaderComponent;
import app.components.StudentDetailsForm;
import app.models.Student;
import app.services.StudentService;
import lib.ui.components.Container;
import lib.ui.components.SideEffect;
import lib.ui.components.Text;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIScreen;
import lib.services.ServiceCallback;
import lib.util.ItemBoxer;

public class AddStudentScreen implements UIScreen {

    @Override
    public DisplayableUIElement build() {
        return new Container(
            new HeaderComponent(Res.strings.add_student), 
            executeAddStudentFormSideEffect(), 
            new BackQuitMenu()
            );
    }

    private DisplayableUIElement executeAddStudentFormSideEffect() {
        return new SideEffect(new SideEffect.Executable() {
            @Override
            public void execute(SideEffect.Displayer displayer) {
                StudentDetailsForm form = new StudentDetailsForm();
                Student student = form.ask();

                Text txtAddingStudent = new Text(Res.strings.adding_student);
                displayer.display(txtAddingStudent);

                StudentService studentService = new StudentService();
                ItemBoxer<Boolean> success = new ItemBoxer<Boolean>(false);
                studentService.addStudent(student, ServiceCallback.<Student>successful(success));

                Text txtInfoMessage = new Text(success.getValue() ? Res.strings.added_successfully : Res.strings.failed_adding);

                displayer.display(txtInfoMessage);
            }
        });
    }
}

