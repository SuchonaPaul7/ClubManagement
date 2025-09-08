import java.util.Scanner;


public class Sponsor {
    String organization;
    String email;
    String mobileNumber;
    private String address;


    public Sponsor(String input_name, String input_email, String input_number){
        organization = input_name;
        email = input_email;
        mobileNumber = input_number;
    }

    public static Sponsor createFromConsole(){

        //creating an input scanner object
        Scanner sc = new Scanner(System.in);

        //take input from terminal
        System.out.print("Enter Organization Name: ");
        String input_name = sc.nextLine();   //read full line including space

        System.out.print("Enter Email: ");
        String input_email = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String input_number = sc.nextLine();

        sc.close();
        //creating a test sponsor from console input
         return new Sponsor(input_name, input_email, input_number);


    }

    public static void print(Sponsor sponsor){
        System.out.println("Organization Name: " + sponsor.organization + "\n" +"Email: " + sponsor.email + "\n" + "Mobile Number: " + sponsor.mobileNumber + "\n" + "Address: " + sponsor.address);
    }
}
