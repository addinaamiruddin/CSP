//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Student extends User {
    private int studentId;
    private String mediumStudy;
    private String faculty;
    private String course;
    private String LOS;
    private String specialization;
    private List<Course> courses;
    private int duration;

    public Student(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo, String mediumStudy, String faculty, String LOS, String course, String specialization, int duration) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        Random rand = new Random();
        this.studentId = rand.nextInt(900000001) + 100000000;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
        this.courses = new ArrayList();
        this.course = course;
        this.LOS = LOS;
        this.specialization = specialization;
        this.duration = duration;
    }

    public String getCourse() {
        return this.course;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public String getMediumStudy() {
        return this.mediumStudy;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public Student(String username, String password) {
        super(username, password);
        this.courses = new ArrayList();
    }

    public int getStudentId() {
        return this.studentId;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getLOS() {
        return this.LOS;
    }

    public void setStudentId(int studentId) {
        Random rand = new Random();
        studentId = rand.nextInt(900000001) + 100000000;
        this.studentId = studentId;
    }

    public void setMediumStudy(String mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    public void printRegisteredCourses() {
        if (this.courses.isEmpty()) {
            System.out.println("No registered courses found");
        } else {
            System.out.println("Registered Courses:");
            Iterator var1 = this.courses.iterator();

            while(var1.hasNext()) {
                Course course = (Course)var1.next();
                System.out.println(course.getCourseName());
            }
        }

    }
}
