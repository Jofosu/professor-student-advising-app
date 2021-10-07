import java.util.Scanner;

public class Gui {
    public static void main(String[] args) {
        System.out.println("Hello Advisor, what will you like to do today ?");
        AdviseeController advisor = new AdviseeController();
        System.out.println("Choose a number from the following: \n " +
                "1. Add new advisee \n ");

        Scanner advisorInput = new Scanner(System.in);
        int work = advisorInput.nextInt();

        int studentId;
        int studentClassYear;
        String studentName;

        switch(work){

            case 1: System.out.println("Please enter student's full name");
                    studentName = advisorInput.next();
                    do{
                        System.out.println("Please enter student's 9 digit id");
                        studentId = advisorInput.nextInt();
                    }while(String.valueOf(studentId).length() !=9);
                    System.out.println("Please enter student's class year");
                    studentClassYear = advisorInput.nextInt();
                    if(advisor.addAdvisee(studentName,studentId,studentClassYear))
                        System.out.println(studentName +" has been added to your advisee list");
                    else System.out.println("Incorrect input");
                    break;



        }



    }
}
