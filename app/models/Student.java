package app.models;

public class Student {
    private static final char DELIMITER = ';';

    private String name;
    private String grade;
    private String division;
    private String rollNo;
    private String sport;

    public Student(String name, String grade, String division, String rollNo, String sport) {
        this.name = name;
        this.grade = grade;
        this.division = division;
        this.rollNo = rollNo;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public static class Builder {
        private static final int IDX_FIELD_NAME = 0;
        private static final int IDX_FIELD_GRADE = 1;
        private static final int IDX_FIELD_DIVISION = 2;
        private static final int IDX_FIELD_ROLL_NO = 3;
        private static final int IDX_FIELD_SPORT = 4;
        private String name;
        private String grade;
        private String division;
        private String rollNo;
        private String sport;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setGrade(String grade) {
            this.grade = grade;
            return this;
        }

        public Builder setDivision(String division) {
            this.division = division;
            return this;
        }

        public Builder setRollNo(String rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public Builder setSport(String sport) {
            this.sport = sport;
            return this;
        }

        public Student createStudent() {
            return new Student(name, grade, division, rollNo, sport);
        }

        public static Student fromString(String str) {
            String[] fields = str.split(String.valueOf(DELIMITER));
            return new Builder()
                    .setName(fields[IDX_FIELD_NAME])
                    .setGrade(fields[IDX_FIELD_GRADE])
                    .setDivision(fields[IDX_FIELD_DIVISION])
                    .setRollNo(fields[IDX_FIELD_ROLL_NO])
                    .setSport(fields[IDX_FIELD_SPORT])
                    .createStudent();
        }

    }

    @Override
    public String toString() {
        return name + " [" +
                "Grade: " + grade +
                ", Division: " + division +
                ", Roll number: " + rollNo +
                ", Sport: " + sport +
                ']';
    }

    public String dataToString() {
        return name.toUpperCase() + DELIMITER + grade + DELIMITER + division.toUpperCase() + DELIMITER + rollNo + DELIMITER + sport.toUpperCase();
    }
}
