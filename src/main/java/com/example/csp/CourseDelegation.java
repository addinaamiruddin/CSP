package com.example.csp;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;


/* The CourseDelegation class implements the DELEGATION DESIGN PATTERN to separate the responsibilities of handling course add, remove, and update actions for Admin and Student users.
This allows for a cleaner and more organized code structure, as well as the ability to easily add or modify functionality for specific user types in the future.
Other developers should be aware of this structure and should utilize the delegation methods provided in this class when handling course actions for different user types. */
public class CourseDelegation {

    public void handleCourseActions(User loggedInUser) {
        if (loggedInUser instanceof Admin) {
            AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();

            // buttons for manage course

            // btnAddCourse
            adminStrategy.addCourse(loggedInUser);

            // btnUpdateCourse
            adminStrategy.updateCourse(loggedInUser);

            // btnRemoveCourse
            adminStrategy.removeCourse(loggedInUser);

            // btn HOME
            adminStrategy.adminDashboard(loggedInUser);

        } else if (loggedInUser instanceof Student) {
            StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();

            // buttons for manage course

            // btnAddCourse
            studStrategy.addCourse(loggedInUser);

            // btnRemoveCourse
            studStrategy.removeCourse(loggedInUser);

            // btn HOME
            studStrategy.studentDashboard(loggedInUser);
        }
    }

    public void handleAddCourse(User loggedInUser, Course selectedCourse) {
        if (loggedInUser instanceof Admin) {
            // Admin implementation of adding a course
            AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
            AdminManageCourseController AMCC = new AdminManageCourseController();
            try {
                AMCC.switchToAddCourse(new ActionEvent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (loggedInUser instanceof Student) {
            // Student implementation of adding a course
            StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();
            StudentManageCourseController SMCC = new StudentManageCourseController();
            try {
                SMCC.switchToAddCourse(new ActionEvent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void handleUpdateCourse(User user) {
        if (user instanceof Admin) {
            AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
            AdminManageCourseController AMCC = new AdminManageCourseController();
            try {
                AMCC.switchToUpdateCourse(new ActionEvent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            input = new Scanner(System.in); // Re-instantiate the input scanner object here
//
//            // Admin implementation of updating a course
//            System.out.print("\033[H\033[2J");
//            System.out.println("===== UPDATE COURSE =====\n");
//
//            System.out.print("Enter course name : ");
//            String name = input.nextLine();
//
//            System.out.println("Enter course id : ");
//            String id = input.nextLine();
//
//            List<Course> allCourses = Course.getAllCourses();
//
//            for (Course course : allCourses) {
//                if (course.getCourseName().equalsIgnoreCase(name) && course.getCourseId().equalsIgnoreCase(id)) {
//                    System.out.print("Enter new course name : ");
//                    course.setCourseName(input.nextLine());
//
//                    System.out.print("Enter new course id : ");
//                    course.setCourseId(input.nextLine());
//
//                    System.out.print("Enter new subjects taught (separated by commas) : ");
//                    course.setSubjectTaught(input.nextLine().split(","));
//
//                    System.out.print("Enter new course duration : ");
//                    course.setCourseDuration(input.nextInt());
//                    input.nextLine(); // consume the remaining newline character
//
//                    System.out.print("Enter new employment opportunities (separated by commas) : ");
//                    course.setEmploymentOpportunities(input.nextLine().split(","));
//
//                    System.out.print("Enter new scope for further studies (separated by commas) : ");
//                    course.setScopeForFutherStudies(input.nextLine().split(","));
//
//                    System.out.print("Does the course offer scholarship facilities? (true/false) ");
//                    course.setScholarshipFacilities(input.nextBoolean());
//
//                    System.out.print("Enter new fee structure : ");
//                    course.setFeeStructure(input.nextInt());
//
//                    System.out.print("Enter new maximum number of students : ");
//                    course.setMaximumStudent(input.nextInt());
//
//                    System.out.print(
//                            "Enter new medium of study (FOUNDATION, DIPLOMA, UNDERGRADUATE, POSTGRADUATE, PHD) : ");
//                    course.setMediumStudy(MediumOfStudy.valueOf(input.next().toUpperCase()));
//
//                    System.out.print("\nCourse " + course.getCourseName() + " has been updated successfully.");
//
//                    System.out.print("\nPress 0 to return : ");
//
//                    int selection = input.nextInt();
//                    if (selection == 0)
//                        adminStrategy.manageCourse(user);
//                    return;
//                }
//            }
//            System.out.println("Course not found.");
        }

    }

    public void handleRemoveCourse(User loggedInUser) {
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();

        if (loggedInUser instanceof Admin) {
            AdminManageCourseController AMCC = new AdminManageCourseController();
            AMCC.removeCourse(new ActionEvent());
        } else if (loggedInUser instanceof Student) {
            StudentManageCourseController SMCC = new StudentManageCourseController();
//            SMCC.removeCourse(new ActionEvent());
        }
    }

}

