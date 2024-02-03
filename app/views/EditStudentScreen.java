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

public class EditStudentScreen implements UIScreen {
    @Override
    public DisplayableUIElement build() {
        return new Container(
                new HeaderComponent(Res.strings.edit_student),
                executeEditFormSideEffect(), 
            new BackQuitMenu()
        );
    }

    private DisplayableUIElement executeEditFormSideEffect() {
        return new SideEffect(new SideEffect.Executable() {
            @Override
            public void execute(SideEffect.Displayer displayer) {
                Text txtEnterOldDetails = new Text(Res.strings.enter_old_details);
                displayer.display(txtEnterOldDetails);

                StudentDetailsForm formOld = new StudentDetailsForm();
                Student oldStudent = formOld.ask();

                Text txtEnterNewDetails = new Text(Res.strings.enter_new_details);
                displayer.display(txtEnterNewDetails);

                StudentDetailsForm formNew = new StudentDetailsForm();
                Student newStudent = formNew.ask();

                Text txtEditingStudent = new Text(Res.strings.editing_student);
                displayer.display(txtEditingStudent);

                StudentService studentService = new StudentService();
                boolean success = editStudentWithService(oldStudent, newStudent, studentService);

                Text txtInfoMessage = new Text(success ? Res.strings.edited_successfully : Res.strings.failed_editing);

                displayer.display(txtInfoMessage);
            }
        });
    }

    private boolean editStudentWithService(Student oldStudent, Student newStudent, StudentService service) {
        ItemBoxer<Boolean> result = new ItemBoxer<>(false);
        service.editStudent(oldStudent, newStudent, new ServiceCallback<Student>() {
            @Override
            public void onSuccess(Student ignored) {
                result.setValue(true);
            }

            @Override
            public void onFailure(Exception e) {
                result.setValue(false);
            }
        });
        return result.getValue();
    }
}
