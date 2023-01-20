package com.example.csp;

import java.util.List;

public class Admin extends User implements ICourseOperation {
    private String adminId;
    private AdminOperation adminOperation;

    public Admin() {
        this.adminOperation = new AdminOperation();
    }
    public void setAdminId(int administratorId) {
        this.adminId = administratorId;
    }
    public Admin(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo,
                 String adminId) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        this.adminId = adminId;
        this.adminOperation = new AdminOperation();
    }

    public Admin(String username, String password) {
        super(username, password);
        this.adminOperation = new AdminOperation();
    }

    public String getAdminId() {
        return adminId;
    }

    private class AdminOperation extends CourseOperation {

        // what about
        @Override
        public void addCourse(Course selectedCourse, User loggedInUser) {
            try (Scanner input = new Scanner(System.in)) {

                String courseName = input.nextLine();

                Course c = new Course(courseName);
                Course.addCourse(c);

                List<Course> allCourses = Course.getAllCourses();

                for (Course course : allCourses) {
                    System.out.println(course.getCourseName());
                }
                System.out.println("\nCourse " + c.getCourseName() + " has been created successfdeully.");

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                    manageCourse(c, loggedInUser);
            } catch (

                    NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void unregisteredFromCourse(Course course, User loggedInUser) {
        System.out.println("unregisteredFromCourse admin is working...");

    }

}


