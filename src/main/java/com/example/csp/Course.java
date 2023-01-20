package com.example.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private String[] subjectTaught;
    private int courseDuration;
    private String[] employmentOpportunities;
    private String[] scopeForFutherStudies;
    private boolean scholarshipFacilities;
    private int feeStructure;
    private int maximumStudent;
    private MediumStudy mediumStudy;
    private Programme programme;
    ArrayList<Course> courses = new ArrayList();

    public Course(String var1, String var2, String[] var3, int var4, String[] var5, String[] var6, boolean var7, int var8, int var9, MediumStudy var10) {
        this.courseId = var1;
        this.courseName = var2;
        this.subjectTaught = var3;
        this.courseDuration = var4;
        this.employmentOpportunities = var5;
        this.scopeForFutherStudies = var6;
        this.scholarshipFacilities = var7;
        this.feeStructure = var8;
        this.maximumStudent = var9;
        this.mediumStudy = var10;
    }

    public Course() {
        Course var1 = new Course("ODN3829", "Bachelor of Science (Hons.) Intelligent Robotics", new String[]{"Data Structures", "Algorithms", "Programming Languages"}, 120, new String[]{"Masters in Computer Science", "MBA in IT"}, new String[]{"hello"}, true, 14, 120, MediumStudy.FOUNDATION);
        Course var2 = new Course("ODN3329", "Bachelor of Engineering (Hons.) Electronics", new String[]{"Data Structures", "Algorithms", "Programming Languages"}, 120, new String[]{"Masters in Computer Science", "MBA in IT"}, new String[]{"hello"}, true, 14, 120, MediumStudy.FOUNDATION);
        Course var3 = new Course("ODN3329", "Bachelor of Computer Science (Hons.)", new String[]{"Data Structures", "Algorithms", "Programming Languages"}, 120, new String[]{"Masters in Computer Science", "MBA in IT"}, new String[]{"hello"}, true, 14, 120, MediumStudy.FOUNDATION);
        Course var4 = new Course("ODN3329", "Bachelor of Accounting (Hons.)", new String[]{"Data Structures", "Algorithms", "Programming Languages"}, 120, new String[]{"Masters in Computer Science", "MBA in IT"}, new String[]{"hello"}, true, 14, 120, MediumStudy.FOUNDATION);
        Course var5 = new Course("ODN3329", "Bachelor of Business Management (Hons.)", new String[]{"Data Structures", "Algorithms", "Programming Languages"}, 120, new String[]{"Masters in Computer Science", "MBA in IT"}, new String[]{"hello"}, true, 14, 120, MediumStudy.FOUNDATION);
        this.courses.add(var1);
        this.courses.add(var2);
        this.courses.add(var3);
        this.courses.add(var4);
        this.courses.add(var5);
    }

    public Course(String var1) {
        this.courseName = var1;
    }

    public String toString() {
        String var10000 = this.courseId;
        return "courseId : " + var10000 + "\ncourseName : " + this.courseName + "\nsubjectTaught : " + Arrays.toString(this.subjectTaught) + "\ncourseDuration : " + this.courseDuration + "\nemploymentOpportunities : " + Arrays.toString(this.employmentOpportunities) + "\nscopeForFutherStudies : " + Arrays.toString(this.scopeForFutherStudies) + "\nscholarshipFacilities : " + this.scholarshipFacilities + "\nfeeStructure : " + this.feeStructure + "\nmaximumStudent : " + this.maximumStudent + "\nmediumStudy : " + this.mediumStudy + "\nprogramme : " + this.programme;
    }

    public void addCourse() {
    }

    public void withdrawCourse() {
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getMaximumStudent() {
        return this.maximumStudent;
    }

    public int getCourseDuration() {
        return this.courseDuration;
    }

    public MediumStudy getMediumOfStudy() {
        return this.mediumStudy;
    }

    public Programme getProgramme() {
        return this.programme;
    }

    public String[] getSubjectsTaught() {
        return this.subjectTaught;
    }

    public void displayCourseList() {
    }

    public List<Course> getAllCourses() {
        return this.courses;
    }

    public static void printCourses(List<Course> var0) {
        if (var0.isEmpty()) {
            System.out.println("Student has no courses yet.");
        } else {
            int var1 = 1;

            for(Iterator var2 = var0.iterator(); var2.hasNext(); ++var1) {
                Course var3 = (Course)var2.next();
                System.out.println("(" + var1 + ") " + var3.getCourseName());
            }
        }

    }
}
