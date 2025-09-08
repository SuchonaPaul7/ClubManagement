import java.util.Scanner;

public class Member {
    private String name;
    private int studentId;
    private String department;
    private String email;
    private String mobileNumber;
    private int semester;
    private int clubId;

    public Member(String input_name, int input_studentid, String input_department, String input_email){
        name = input_name;
        studentId = input_studentid;
        department = input_department;
        email = input_email;
    }

    public static void print(Member member){
        System.out.println("Name: " + member.name + "\n"
                + "Student ID: " + member.studentId + "\n"
                + "Department: " + member.department + "\n"
                + "Email: " + member.email + "\n"
                + "Mobile Number: " + member.mobileNumber + "\n"
                + "Semester: " + member.semester + "\n"
                + "Club ID: " + member.clubId);
    }

    public static Member createFromConsole(){
        //creating an input scanner object
        Scanner sc = new Scanner(System.in);

        //take input from terminal
        System.out.print("Enter Member Name: ");
        String input_name = sc.nextLine();   //read full line including space

        System.out.print("Enter Student ID: ");
        int input_studentid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String input_department = sc.nextLine();

        System.out.print("Enter Email: ");
        String input_email = sc.nextLine();

        sc.close();
        //creating a test member from console input
         return new Member(input_name, input_studentid, input_department, input_email);


    }
}
