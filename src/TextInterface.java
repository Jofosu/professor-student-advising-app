import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextInterface {


    /**
     *
     * Gives the user access to the privileges oa a department chair
     *
     */
    public static void chairUser(){
        Scanner chairInput = new Scanner(System.in);
        System.out.println("Hello department chair, what will you like to do today ?");
        CourseCatalogue courseCatalogue = new CourseCatalogue();
        int counter = 0;
        while (counter != 4) {
            do {
                System.out.println("""
                                Choose a number from the following:\s
                                 1. Add new course\s
                                 2. Print list of available courses\s
                                 3. Remove course\s
                                 4. Main Menu\s
                                """);
                do {
                    try {
                        String s = chairInput.nextLine();
                        counter = Integer.parseInt(s);
                        break;
                    } catch (Exception ignored) {
                    }
                } while (true);
            } while (counter > 4);

            String time;
            String courseID;
            switch (counter) {
                // Adding a new course
                case 1 -> {

                        Pattern coursePrefixOrder = Pattern.compile("^[a-zA-Z]+[0-9]+$");

                        do{
                            System.out.println("Please enter course prefix in the pattern of CMPU103");
                            courseID = chairInput.next().toUpperCase(Locale.ROOT);
                        }
                    while(!coursePrefixOrder.matcher(courseID).find());


                    Pattern timeOrder = Pattern.compile("^[0-9]+$");
                    boolean onlyNum;
                    do{
                        System.out.println("Please enter the time this course takes place in the pattern HH:MM");
                            time = chairInput.next();

                      onlyNum = timeOrder.matcher(time).find();
                    }while( onlyNum && time.length() != 4);

                    if (courseCatalogue.addCourse(courseID, time))
                        System.out.println(courseID + " has been added to your course catalogue");
                    else System.out.println("Course already exists");
                }
                // The list of available courses in the course catalogue
                case (2) -> System.out.println(courseCatalogue.returnCourseList());
                // Removing a course from the course catalogue
                case (3) -> {
                    System.out.println("Please enter course's id");
                    courseID = chairInput.next();
                    if (courseCatalogue.removeCourse(courseID))
                        System.out.println(courseID + " has been removed.");
                    else System.out.println(courseID + " does not exist in the course catalogue");
                }
                // returning to the main menu
                case (4) -> mainMenu();
            }
        }
    }

    public static void advisorUser(){
        Scanner advisorInput = new Scanner(System.in);
        System.out.println("Hello Advisor, what will you like to do today ?");
        Advisor advisor = new Advisor();
        int work = 0;
        while (work != 4) {
            do {
                System.out.println("""
                                Choose a number from the following:\s
                                 1. Add new advisee\s
                                 2. Print advisee list\s
                                 3. Remove advisee\s
                                 4. Main menu\s
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
                case 1 -> {
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
                }
                case (2) -> System.out.println(advisor.returnAdviseeList());
                case (3) -> {
                    System.out.println("Please enter student's first name");
                    firstName = advisorInput.next();
                    System.out.println("Please enter student's last name");
                    studentName = firstName + " " + advisorInput.next();
                    if (advisor.deleteAdvisee(studentName))
                        System.out.println(studentName + " has been removed.");
                    else System.out.println(studentName + " could not be removed");
                }
                case (4) -> mainMenu();
            }
        }

    }
    /**
     * Asks a user for a number that corresponds to one of the 3 options presented on the main menu
     * 
     * @return integer: Either 1 for a department chair user or 2 for an advisor user or 3 to terminate the program
     */

    public static int mainMenu(){
        Scanner userInput = new Scanner(System.in);
        int selectedUser = 0;

        do {
            try {

                System.out.println("Please select one of the options below:");
                System.out.println("""
                                 1. Department Chair\s
                                 2. Advisor\s
                                 3. Quit\s""");

                String selectedUserOption = userInput.nextLine();
                selectedUser = Integer.parseInt(selectedUserOption);

            } catch (Exception ignored) {

            }

        } while (selectedUser > 3 || selectedUser < 1);

        return selectedUser;
    }

    public static void main(String[] args) {
        System.out.println("Welcome");
        // user selects one of the options presented on the main menu
        int userMainMenuOption = mainMenu();

        switch (userMainMenuOption) {
            // User is a department chair
            case 1 ->
                    chairUser();
            // User is an advisor
            case 2 ->
                    advisorUser();
            // User decides to terminate the program
            case 3 ->{  System.out.println("Have a great day");
                        System.exit(0);}
        }
    }
}





