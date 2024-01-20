package app.components;

import app.Res;
import app.models.Student;
import lib.input.StringInputPrompt;
import lib.ui.contracts.Form;

public class StudentDetailsForm implements Form<Student> {
    @Override
    public Student ask() {
        StringInputPrompt prompt = new StringInputPrompt();
        String name = prompt.promptUserWithPrompt(Res.strings.enter_name).getResult();
        String grade = prompt.promptUserWithPrompt(Res.strings.enter_grade).getResult();
        String division = prompt.promptUserWithPrompt(Res.strings.enter_division).getResult();
        String rollNumber = prompt.promptUserWithPrompt(Res.strings.enter_roll_no).getResult();
        String sport = prompt.promptUserWithPrompt(Res.strings.enter_sport).getResult();



        Student.Builder studentBuilder = new Student.Builder()
                .setName(name)
                .setGrade(grade)
                .setDivision(division)
                .setRollNo(rollNumber)
                .setSport(sport);

        Student student = studentBuilder.createStudent();
        return student;
    }
}
