package com.example.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum courseLevel {
    FOUNDATION,
    DIPLOMA,
    UNDERGRADUATE,
    POSTGRADUATE,
    PHD;
}

enum Faculty {
    EEE("Electrical and Electronics Engineering"),
    ECE("Electronics and Communication Engineering"),
    CSE("Computer Science Engineering"),
    MECHANICAL("Mechanical Engineering"),
    CIVIL("Civil Engineering");

    private String fullFacultyName;

    Faculty(String fullFacultyName) {
        this.fullFacultyName = fullFacultyName;
    }

    public String getFullFacultyName() {
        return fullFacultyName;
    }
}

// The Course class represents a course offered by the university.
// It contains details information regarding on the course.
// This class is used in conjunction with the courseDelegation class to manage
// and display course information for students and faculties.
// The logic to handle action course, add course, update course & delete course
// is inside courseDelegation class.
public class Course extends CourseDelegation {
    private static List<Course> sampleCourses = new ArrayList<>();
    private String courseId;
    private String courseName;
    private String[] subjectTaught;
    private int courseDuration;
    private String[] employmentOpportunities;
    private String[] scopeForFutherStudies;
    private boolean scholarshipFacilities;
    private int feeStructure;
    private int maximumStudent;
    private courseLevel mediumStudy;
    private Faculty faculty;

    private static List<Course> courses = new ArrayList<>();
    private CourseDelegation delegation = new CourseDelegation();

    // for admin
    public Course(String courseId, String courseName, String[] subjectTaught, int courseDuration, String[] employmentOpportunities, String[] scopeForFutherStudies, boolean scholarshipFacilities, int feeStructure, int maximumStudent, courseLevel mediumStudy, Faculty faculty) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.subjectTaught = subjectTaught;
        this.courseDuration = courseDuration;
        this.employmentOpportunities = employmentOpportunities;
        this.scopeForFutherStudies = scopeForFutherStudies;
        this.scholarshipFacilities = scholarshipFacilities;
        this.feeStructure = feeStructure;
        this.maximumStudent = maximumStudent;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
    }

    // for student
    public Course(String courseName, courseLevel mediumStudy, int price) {
        this.courseName = courseName;
        this.mediumStudy = mediumStudy;
        this.feeStructure = price;
    }

    public Course() {
    }

    // toString()

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean getScholarship() {
        return scholarshipFacilities;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String[] getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String[] subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String[] getEmploymentOpportunities() {
        return employmentOpportunities;
    }

    public void setEmploymentOpportunities(String[] employmentOpportunities) {
        this.employmentOpportunities = employmentOpportunities;
    }

    public String[] getScopeForFutherStudies() {
        return scopeForFutherStudies;
    }

    public void setScopeForFutherStudies(String[] scopeForFutherStudies) {
        this.scopeForFutherStudies = scopeForFutherStudies;
    }

    public boolean isScholarshipFacilities() {
        return scholarshipFacilities;
    }

    public void setScholarshipFacilities(boolean scholarshipFacilities) {
        this.scholarshipFacilities = scholarshipFacilities;
    }

    public int getFeeStructure() {
        return feeStructure;
    }

    public void setFeeStructure(int feeStructure) {
        this.feeStructure = feeStructure;
    }

    public int getMaximumStudent() {
        return maximumStudent;
    }

    public void setMaximumStudent(int maximumStudent) {
        this.maximumStudent = maximumStudent;
    }

    public courseLevel getMediumStudy() {
        return mediumStudy;
    }

    public void setMediumStudy(courseLevel mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public static List<Course> getCourses() {
        sampleCourses.add(new Course("CS101", "Computer Science", new String[]{"Data Structure", "Object Oriented Programming", "Algorithm Design"}, 3, new String[]{"Developer", "Cloud Architect"}, new String[]{"PHD", "DIPLOMA"}, true, 36000, 120, com.example.csp.courseLevel.FOUNDATION, Faculty.CSE));
        sampleCourses.add(new Course("EE32", "Electrical Engineering", new String[]{"Engineering Mathematics", "Circuits Theory", "Analogue Electronics"}, 3, new String[]{"Engineer", "Technician Specialist"}, new String[]{"PHD", "DIPLOMA"}, true, 45000, 120, com.example.csp.courseLevel.FOUNDATION, Faculty.EEE));
        sampleCourses.add(new Course("CE12", "Civil Engineering", new String[]{"Material Science and Engineering", "Coastal Engineering", "Construction Engineering"}, 3, new String[]{"Engineer", "Civil Engineer"}, new String[]{"PHD", "DIPLOMA"}, true, 54000, 120, com.example.csp.courseLevel.FOUNDATION, Faculty.CIVIL));
        sampleCourses.add(new Course("ME45", "Mechanical Engineering", new String[]{"Engineering Mathematics", "Thermodynamics", "Fluid Mechanics."}, 3, new String[]{"Engineer", "Manufacturing Engineer"}, new String[]{"POSTGRADUATE", "PHD"}, true, 23000, 120, courseLevel.UNDERGRADUATE, Faculty.MECHANICAL));

        return sampleCourses;
    }

    @Override
    public String toString() {
        return courseName;
    }

    public static void setCourses(List<Course> courses) {
        Course.courses = courses;
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public void withdrawCourse() {
    }

    public static List<Course> getAllCourses() {
        return courses;
    }

    public static void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("Student has no courses yet.");
        } else {

            int i = 1;
            for (Course course : courses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }
        }
    }

    public void displayAllCourse() {
        // display all available course
        List<Course> courses = Course.getAllCourses();

        int i = 1;
        for (Course course : courses) {
            System.out.println("(" + i + ") " + course.getCourseName());
            i++;
        }
    }

    // This method handleCourseActions uses delegation design pattern by delegating
    // the responsibility of handling course actions to the object referenced by the
    // delegation variable.
    public void handleCourseActions(User loggedInUser) {
        delegation.handleCourseActions(loggedInUser);
    }

    // This method addOfferedCourse uses delegation design pattern by delegating
    // the responsibility of add course actions to the object referenced by the
    // delegation variable.
    public void handleAddCourse(User loggedInUser) {
        delegation.handleAddCourse(loggedInUser, this);
    }

    // This method updateOfferedCourse uses delegation design pattern by delegating
    // the responsibility of update course actions to the object referenced by the
    // delegation variable.
    public void handleUpdateCourse(User loggedInUser) {
        delegation.handleUpdateCourse(loggedInUser);
    }

    // This method removeOfferedCourse uses delegation design pattern by delegating
    // the responsibility of delete course actions to the object referenced by the
    // delegation variable.
    public void handleRemoveCourse(User loggedInUser) {
        delegation.handleRemoveCourse(loggedInUser);
    }
}
