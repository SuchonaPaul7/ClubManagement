import java.util.Scanner;

public class Club {
    private int clubId;
    private String clubName;
    private float budget;

    public Club(int input_clubid, String input_name, float input_budget){
        clubId = input_clubid;
        clubName = input_name;
        budget = input_budget;
    }
    public static Club createFromConsole(){

        //creating an input scanner object
        Scanner sc = new Scanner(System.in);

        //take input from terminal
        System.out.print("Enter Club ID: ");
        int input_clubid = sc.nextInt(); //read full line including space
        sc.nextLine();

        System.out.print("Enter Club Name: ");
        String input_name = sc.nextLine();

        System.out.print("Enter Budget: ");
        float input_budget = sc.nextFloat();

        sc.close();
        //creating a test club from console input
        return new Club(input_clubid, input_name, input_budget);


    }

    public static void print(Club club){
        System.out.println("Club ID: " + club.clubId + "\n" +"Club Name: " + club.clubName + "\n" + "Budget: " + club.budget);
    }
}
