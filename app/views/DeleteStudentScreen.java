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
import lib.ui.services.ServiceCallback;
import lib.util.ItemBoxer;

public class DeleteStudentScreen implements UIScreen {
    @Override
    public DisplayableUIElement build() {
        return new Container(
                new HeaderComponent(Res.strings.delete_student),
                executeDeleteStudentFormSideEffect(), 
            new BackQuitMenu()
        );
    }

    private DisplayableUIElement executeDeleteStudentFormSideEffect() {
        return new SideEffect(new SideEffect.Executable() {
            @Override
            public void execute(SideEffect.Displayer displayer) {
                StudentDetailsForm form = new StudentDetailsForm();
                Student student = form.ask();

                Text txtDeletingStudent = new Text(Res.strings.deleting_student);
                displayer.display(txtDeletingStudent);

                StudentService studentService = new StudentService();
                ItemBoxer<Boolean> success = new ItemBoxer<Boolean>(false);
                studentService.deleteStudent(student, ServiceCallback.successful(success));
                Text txtInfoMessage = new Text(success.getValue() ? Res.strings.deleted_successfully : Res.strings.failed_deleting);

                displayer.display(txtInfoMessage);
            }
        });
    }


}
