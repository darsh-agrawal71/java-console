package app.services;

import app.models.Student;
import lib.Res;
import lib.services.ServiceCallback;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentService {
    private final String STUDENT_FILE_PATH = "student.txt";
    private final Path filePath = Path.of(STUDENT_FILE_PATH);

    public void addStudent(Student student, ServiceCallback<Student> callback) {
        try {
            Files.writeString(filePath, student.dataToString() + Res.strings.newline, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            callback.onSuccess(student);
        } catch (IOException e) {
            callback.onFailure(e);
        }
    }

    public void getAllStudents(ServiceCallback<List<Student>> callback) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            List<Student> students = new ArrayList<>();
            lines.forEach(new Consumer<String>() {
                @Override
                public void accept(String line) {
                    Student student = Student.Builder.fromString(line);
                    students.add(student);
                }
            });
            callback.onSuccess(students);
        } catch (IOException e) {
            callback.onFailure(e);
        }
    }

    public void editStudent(Student old, Student new_, ServiceCallback<Student> callback) {
        try {
            if (!studentExists(old)) {
                callback.onFailure(new Exception("Student with name " + old.getName() + " not found."));
            }
            List<String> lines = Files.readAllLines(filePath).stream().map(new Function<String, String>() {
                // Find and update line.
                @Override
                public String apply(String line) {
                    if (old.dataToString().equalsIgnoreCase(line)) {
                        return new_.dataToString();
                    }
                    return line;
                }
            }).toList();
            overwriteLines(lines);
            callback.onSuccess(new_);
        } catch (IOException e) {
            callback.onFailure(e);
        }
    }

    public void deleteStudent(Student student, ServiceCallback<Student> callback) {
        try {
            if (!studentExists(student)) {
                callback.onFailure(new Exception("Student with name " + student.getName() + " not found."));
            }
            List<String> lines = Files.readAllLines(filePath).stream().filter(new Predicate<String>() {
                // Find and update line.
                @Override
                public boolean test(String line) {
                    return !line.equalsIgnoreCase(student.dataToString());
                }
            }).toList();
            overwriteLines(lines);
            callback.onSuccess(student);
        } catch (IOException e) {
            callback.onFailure(e);
        }
    }

    private boolean studentExists(Student student) throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        return lines.stream().anyMatch(new Predicate<String>() {
            @Override
            public boolean test(String line) {
                return line.equalsIgnoreCase(student.dataToString());
            }
        });
    }

    private void clearFile() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(filePath);
        writer.write("");
        writer.flush();
        writer.close();
    }

    private void overwriteLines(List<String> lines) throws IOException {
        clearFile();
        lines.forEach(new Consumer<String>() {
            // Re-write every line
            @Override
            public void accept(String line) {
                try {
                    Files.writeString(filePath, line + Res.strings.newline, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException ignored) {}
            }
        });
    }
}