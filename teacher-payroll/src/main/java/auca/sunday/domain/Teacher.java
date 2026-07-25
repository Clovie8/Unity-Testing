package auca.sunday.domain;

public class Teacher {
    private String teacherId;
    private String fullName;
    private double hourlyRate;
    private double hoursWorked;
    private TeacherCategory category;

    public Teacher(String teacherId, String fullName, double hourlyRate, double hoursWorked, TeacherCategory category) {
        this.teacherId = teacherId;
        this.fullName = fullName;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.category = category;
    }

    // Getters and Setters
    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    public TeacherCategory getCategory() { return category; }
    public void setCategory(TeacherCategory category) { this.category = category; }
}