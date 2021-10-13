import java.util.Locale;
import java.util.Scanner;

public class Gui {
    public static void main(String[] args) {
        String selector;
        Scanner neutralInput = new Scanner(System.in);
        do {
            System.out.println("Hello, are you an advisor or head?");
            selector = neutralInput.next();
        } while (!selector.equals("advisor") & !selector.equals("head"));

        switch (selector) {
            case ("head") -> {
                Scanner headInput = new Scanner(System.in);
                System.out.println("Hello Department Head, what will you like to do today ?");
                CourseController courseCatalogue = new CourseController();
                int counter = 0;
                while (counter != 4) {
                    do {
                        System.out.println("""
                                Choose a number from the following:\s
                                 1. Add new course\s
                                 2. Print course list\s
                                 3. Remove course\s
                                 4. Quit\s
                                """);
                        do {
                            try {
                                String s = headInput.nextLine();
                                counter = Integer.parseInt(s);
                                break;
                            } catch (Exception ignored) {
                            }
                        } while (true);
                    } while (counter > 4);

                    String time;
                    String courseID;
                    switch (counter) {
                        case 1:
                            //TODO make it so that you can't enter in a course id wrong
                            System.out.println("Please enter course prefix in the pattern of CMPU103");
                            courseID = headInput.next().toUpperCase(Locale.ROOT);

                            System.out.println("Please enter the time this course takes place");
                            time = headInput.next();

                            if (courseCatalogue.addCourse(courseID, time))
                                System.out.println(courseID + " has been added to your course catalogue");
                            else System.out.println("Incorrect input");
                            break;
                        case (2):
                            System.out.println(courseCatalogue.returnCourseList());
                            break;

                        case (3):
                            System.out.println("Please enter course's id");
                            courseID = headInput.next();
                            if (courseCatalogue.removeCourse(courseID))
                                System.out.println(courseID + " has been removed.");
                            else System.out.println(courseID + " could not be removed");
                            break;

                        case (4):
                            break;
                    }
                }
            }
            case ("advisor") -> {
                Scanner advisorInput = new Scanner(System.in);
                System.out.println("Hello Advisor, what will you like to do today ?");
                AdviseeController advisor = new AdviseeController();
                int work = 0;
                while (work != 4) {
                    do {
                        System.out.println("""
                                Choose a number from the following:\s
                                 1. Add new advisee\s
                                 2. Print advisee list\s
                                 3. Remove advisee\s
                                 4. Quit\s
                                """);
                        do {
                            try {
                                String s = advisorInput.nextLine();
                                work = Integer.parseInt(s);
                                break;
                            } catch (Exception ignored) {
                            }
                        } while (true);
                    } while (work > 4);

                    int studentId;
                    int studentClassYear;
                    String studentName;
                    String firstName;
                    switch (work) {
                        case 1:

                            System.out.println("Please enter student's first name");
                            firstName = advisorInput.next();
                            System.out.println("Please enter student's last name");
                            studentName = firstName + " " + advisorInput.next();
                            do {
                                try {
                                    System.out.println("Please enter student's 9 digit id");
                                    String s = advisorInput.next();
                                    studentId = Integer.parseInt(s);
                                    break;
                                } catch (Exception ignored) {
                                }
                            } while (true);

                            do {
                                try {
                                    System.out.println("Please enter student's class year in the pattern 20XX");
                                    String s = advisorInput.next();
                                    studentClassYear = Integer.parseInt(s);
                                    break;
                                } catch (Exception ignored) {
                                }
                            } while (true);


                            if (advisor.addAdvisee(studentName, studentId, studentClassYear))
                                System.out.println(studentName + " has been added to your advisee list");
                            else System.out.println("Incorrect input");
                            break;

                        case (2):
                            System.out.println(advisor.returnAdviseeList());
                            break;

                        case (3):
                            System.out.println("Please enter student's first name");
                            firstName = advisorInput.next();
                            System.out.println("Please enter student's last name");
                            studentName = firstName + " " + advisorInput.next();
                            if (advisor.deleteAdvisee(studentName))
                                System.out.println(studentName + " has been removed.");
                            else System.out.println(studentName + " could not be removed");
                            break;

                        case (4):

                            break;
                    }
                }
            }
        }
    }
}





