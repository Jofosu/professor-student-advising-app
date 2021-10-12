import java.sql.SQLOutput;
import java.util.Scanner;

public class Gui {
    public static void main(String[] args) {
        System.out.println("Hello Advisor, what will you like to do today ?");
        AdviseeController advisor = new AdviseeController();
        Scanner advisorInput = new Scanner(System.in);

        int work;
        do {
            do{
            System.out.println("Choose a number from the following: \n " +
                    "1. Add new advisee \n " +
                    "2. Print advisee list \n");
            try {
                String s = advisorInput.nextLine();
                work = Integer.parseInt(s);
                break;
            } catch (Exception e) {
            }
            }while(true);
        }while(work > 2);

        int studentId;
        int studentClassYear;
        String studentName;
        String firstName;
        switch(work){
            case 1: System.out.println("Please enter student's first name");
                    firstName = advisorInput.next();
                    System.out.println("Please enter student's last name");
                    studentName = firstName + " " + advisorInput.next();
                    do{
                        do {
                            try {
                                System.out.println("Please enter student's 9 digit id");
                                String s = advisorInput.next();
                                studentId = Integer.parseInt(s);
                                break;
                            } catch (Exception e) {
                            }
                        }while(true);
                    }while(String.valueOf(studentId).length() !=9);

                do{
                    do {
                        try {
                            System.out.println("Please enter student's class year in the pattern 20XX");
                            String s = advisorInput.next();
                            studentClassYear = Integer.parseInt(s);
                            break;
                        } catch (Exception e) {
                        }
                    }while(true);
                    }while(String.valueOf(studentClassYear).length() !=4);

                    if(advisor.addAdvisee(studentName,studentId,studentClassYear))
                        System.out.println(studentName +" has been added to your advisee list");
                    else System.out.println("Incorrect input");
                    break;

        case(2):

        }


    }
}
