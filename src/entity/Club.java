package entity;

import java.util.Scanner;

public class Club {
    public int clubId;
    public String clubName;
    public float budget;

    public Club(String input_name, float input_budget){
        clubName = input_name;
        budget = input_budget;
    }

    // For loading Club from DB (ID known)
    public Club(int clubId, String clubName, float budget) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.budget = budget;
    }
    public static Club createFromConsole(){

        //creating an input scanner object
        Scanner sc = new Scanner(System.in);

        //take input from terminal
        System.out.print("Enter Club Name: ");
        String input_name = sc.nextLine();

        System.out.print("Enter Budget: ");
        float input_budget = sc.nextFloat();


        //creating a test club from console input
        return new Club(input_name, input_budget);


    }

    public static void print(Club club){
        System.out.println("entity.Club ID: " + club.clubId + "\n" +"entity.Club Name: " + club.clubName + "\n" + "Budget: " + club.budget);
    }
}
