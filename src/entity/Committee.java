import java.util.List;
import java.util.Scanner;

public class Committee {
    private int committeeId;
    private int clubId;
    private int startYear;
    private int endYear;
    private List<Advisor> advisors;

    public Committee(int input_committeeeid, int input_starting, int input_ending){
        committeeId = input_committeeeid;
        startYear = input_starting;
        endYear = input_ending;
    }

    public static Committee createFromConsole(){

        //creating an input scanner object
        Scanner sc = new Scanner(System.in);

        //take input from terminal
        System.out.print("Enter Committee ID: ");
        int input_committeeid = sc.nextInt(); //read full line including space
        sc.nextLine();

        System.out.print("Enter Start Year: ");
        int input_starting = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter End Year: ");
        int input_ending = sc.nextInt();

        sc.close();
        //creating a test committee from console input
        return new Committee(input_committeeid, input_starting, input_ending);


    }

    public static void print(Committee committee){
        System.out.println("Committee ID: " + committee.committeeId + "\n" +"Start Year: " + committee.startYear + "\n" + "End Year: " + committee.endYear);
    }
}
