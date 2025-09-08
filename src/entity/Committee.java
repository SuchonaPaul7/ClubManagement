package entity;

import java.util.List;
import java.util.Scanner;

public class Committee {
    public int committeeId;
    public int clubId;
    public int startYear;
    public int endYear;
    private List<Advisor> advisors;

    public Committee(int input_starting, int input_ending, int input_clubid){
        startYear = input_starting;
        endYear = input_ending;
        clubId = input_clubid;
    }

    public static Committee createFromConsole(int clubId){

        //creating an input scanner object
        Scanner sc = new Scanner(System.in);

        //take input from terminal

        System.out.print("Enter Start Year: ");
        int input_starting = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter End Year: ");
        int input_ending = sc.nextInt();


        //creating a test committee from console input
        return new Committee(input_starting, input_ending, clubId);


    }

    public static void print(Committee committee){
        System.out.println("entity.Committee ID: " + committee.committeeId + "\n" +"Start Year: " + committee.startYear + "\n" + "End Year: " + committee.endYear);
    }
}
