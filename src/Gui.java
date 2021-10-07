import java.util.Scanner;

public class Gui {
    public static void main(String[] args) {
        System.out.println("Hello Advisor, what will you like to do today ?");

        System.out.println();

        System.out.println("Choose a number from the following: \n " +
                "1. Add new advisee \n " +
                "2. Get advisee information \n " +
                "3. Add courses \n ");

        Scanner advisorInput = new Scanner(System.in);
        int work = advisorInput.nextInt();

        int studentId;
        int studentClassYear;
        String studentName;
        switch(work){

            case 1: System.out.println("Please enter student's full name");
                    studentName = advisorInput.next();
                    System.out.println("Please enter student's 9 digit id");
                    studentId = advisorInput.nextInt();
                    System.out.println("Please enter student's class year");
                    studentClassYear = advisorInput.nextInt();
                    Advisee studentAdvisee = new Advisee(studentName,studentId,studentClassYear);
                    break;

            case 2: System.out.println("Please enter student 9 digit id");
                    studentId = advisorInput.nextInt();

        }



    }
}
