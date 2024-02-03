package app.views;

import app.Res;
import app.components.BackQuitMenu;
import app.components.HeaderComponent;
import app.models.Student;
import app.services.StudentService;
import lib.ui.components.Container;
import lib.ui.components.ListItem;
import lib.ui.components.ListView;
import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIScreen;
import lib.services.ServiceCallback;
import lib.util.ItemBoxer;

import java.util.List;
import java.util.function.Function;

public class ViewStudentsScreen implements UIScreen {
    @Override
    public DisplayableUIElement build() {
        return new Container(
                new HeaderComponent(Res.strings.view_all_students),
                buildStudentList(), 
            new BackQuitMenu()
        );
    }

    private DisplayableUIElement buildStudentList() {
        StudentService studentService = new StudentService();
        List<Student> students = fetchStudents(studentService);
        List<ListItem> listItems = students.stream().map(new Function<Student, ListItem>() {
            @Override
            public ListItem apply(Student student) {
                return new ListItem(student.toString());
            }
        }).toList();
        return new ListView(ListView.ListType.UNORDERED, listItems);
    }

    private List<Student> fetchStudents(StudentService studentService) {
        ItemBoxer<List<Student>> students = new ItemBoxer<>(List.of());
        studentService.getAllStudents(new ServiceCallback<List<Student>>() {
            @Override
            public void onSuccess(List<Student> result) {
                students.setValue(result);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        return students.getValue();
    }


}
