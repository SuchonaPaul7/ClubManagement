import java.util.Scanner;

public class Advisor {
    private String name;
    private int advisorId;
    private String department;
    private String email;
    private String mobileNumber;
    private int clubId;

    public Advisor(String input_name, int input_advisorid, String input_department){
        name = input_name;
        advisorId = input_advisorid;
        department = input_department;
    }

        public static Advisor createFromConsole(){

            //creating an input scanner object
            Scanner sc = new Scanner(System.in);

            //take input from terminal
            System.out.print("Enter Advisor Name: ");
            String input_name = sc.nextLine();   //read full line including space

            System.out.print("Enter Advisor ID: ");
            int input_advisorid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Department: ");
            String input_department = sc.nextLine();

            sc.close();
            //creating a test advisor from console input
            return new Advisor(input_name, input_advisorid, input_department);


        }

        public static void print(Advisor advisor){
            System.out.println("Advisor Name: " + advisor.name + "\n" +"Advisor ID: " + advisor.advisorId + "\n" + "Department: " + advisor.department);
        }
    }


