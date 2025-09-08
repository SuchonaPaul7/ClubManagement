package entity;

import java.util.Scanner;

public class Advisor {
    public String name;
    public int advisorId;
    public String department;
    private String email;
    private String mobileNumber;
    public int clubId;

    public Advisor(String input_name, int input_advisorid, String input_department,int input_clubid){
        name = input_name;
        advisorId = input_advisorid;
        department = input_department;
        clubId = input_clubid;
    }

        public static Advisor createFromConsole(int clubId){

            //creating an input scanner object
            Scanner sc = new Scanner(System.in);

            //take input from terminal
            System.out.print("Enter entity.Advisor Name: ");
            String input_name = sc.nextLine();   //read full line including space

            System.out.print("Enter entity.Advisor ID: ");
            int input_advisorid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Department: ");
            String input_department = sc.nextLine();


            //creating a test advisor from console input
            return new Advisor(input_name, input_advisorid, input_department, clubId);


        }

        public static void print(Advisor advisor){
            System.out.println("entity.Advisor Name: " + advisor.name + "\n" +"entity.Advisor ID: " + advisor.advisorId + "\n" + "Department: " + advisor.department);
        }
    }


