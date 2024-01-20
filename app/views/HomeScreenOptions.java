package app.views;

import app.Res;

public enum HomeScreenOptions {
    ADD_STUDENT(Res.strings.add_student),
    VIEW_ALL_STUDENTS(Res.strings.view_all_students),
    EDIT_STUDENT(Res.strings.edit_student),
    DELETE_STUDENT(Res.strings.delete_student),
    QUIT_APP(Res.strings.quit_application);

    HomeScreenOptions(String content) {
        this.content = content;
    }

    private final String content;

    public String getContent() {
        return content;
    }
}
