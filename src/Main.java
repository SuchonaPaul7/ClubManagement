import dao.*;
import entity.*;

import java.util.Objects;
import java.util.Scanner;
import java.sql.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }


    private static void mainMenu() {
        while (true) {
            System.out.println("\n Welcome To Club Management System \n");

            System.out.println(" 1.Create New Club");
            System.out.println(" 2.List All Clubs");
            System.out.println(" 3.EXIT");

            System.out.print("\nEnter an option(1-3): ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    createClub();
                    break;
                case 2:
                    clubMenu();
                    break;
                case 3:
                    System.out.println("\n Exiting Club Management System..");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        }
    }


    private static void createClub() {
        ClubDAO cdao = new ClubDAO();

        Club cl = Club.createFromConsole();
        cdao.insert(cl);  //add Member to Database\
        System.out.println("\n--- New Club added to Database ---");
    }


    private static void clubMenu() {
        System.out.println("\nSelect Club to Manage \n");


        // Table Header
        System.out.println("+------------+----------------------+");
        System.out.printf("| %-10s | %-20s |\n", "Club ID", "Club Name");
        System.out.println("+------------+----------------------+");


        ClubDAO cdao = new ClubDAO();

        // Table Body
        for (var club : cdao.getAll()) {
            System.out.printf("| %-10d | %-20s |\n", club.clubId, club.clubName);
        }

        System.out.println("+------------+----------------------+\n");

        System.out.println("0 - Back to Main Menu");

        System.out.print("\nEnter an option: ");
        int clubOption = sc.nextInt();
        sc.nextLine();

        ClubDAO dao = new ClubDAO();
        int clubID = clubOption;
        if(clubOption == 0){
            return;
        }
        else{
            entityMenu(clubID);
        }
    }


    private static void entityMenu(int clubID) {
        System.out.println("\n Select a table to perform CRUD operations \n");
        System.out.println("1. Members");
        System.out.println("2. Advisors");
        System.out.println("3. Committee");
        System.out.println("4. Sponsors");
        System.out.println("5. Back to Main Menu");


        System.out.print("\nEnter an option(1-5): ");
        int entityOption = sc.nextInt();
        sc.nextLine();


        switch (entityOption) {
            case 1:
                crudMenu("Member", clubID);
                break;
            case 2:
                crudMenu("Advisor", clubID);
                break;
            case 3:
                crudMenu("Committee", clubID);
                break;
            case 4:
                crudMenu("Sponsor", clubID);
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice!");

        }

    }


    private static void crudMenu(String entity, int clubID) {

        while (true) {
            System.out.println("\n" + entity + " Menu:");
            System.out.println("1. List all " + entity.toLowerCase() + "s");
            System.out.println("2. Add " + entity.toLowerCase());
            System.out.println("3. Update " + entity.toLowerCase());
            System.out.println("4. Delete " + entity.toLowerCase());
            System.out.println("5. Back to Main Menu");

            System.out.print("\n Enter an option(1-5): ");
            int crudMenuOption = sc.nextInt();
            sc.nextLine();

            switch (crudMenuOption) {
                case 1 -> listEntities(entity, clubID);
                case 2 -> addEntity(entity, clubID);
                case 3 -> updateEntity(entity, clubID);
                case 4 -> deleteEntity(entity, clubID);
                case 5 -> {return;}
                default -> System.out.println("Invalid Choice!");
            }
        }

    }

    private static void addEntity(String entity, int clubID) {
        switch (entity) {

            case "Member":
                MemberDAO mdao = new MemberDAO();

                Member m = Member.createFromConsole(clubID);
                mdao.insert(m);  //add Member to Database\
                System.out.println("\n--- Member added to Database ---");
                break;

            case "Advisor":
                AdvisorDAO adao = new AdvisorDAO();

                Advisor a = Advisor.createFromConsole(clubID);
                adao.insert(a);
                System.out.println("\n--- Advisor added to Database ---");
                break;

            case "Sponsor":
                SponsorDAO sdao = new SponsorDAO();

                Sponsor s = Sponsor.createFromConsole();
                sdao.insert(s);
                System.out.println("\n--- Sponsor added to Database ---");
                break;

            case "Committee":
                CommitteeDAO cdao = new CommitteeDAO();

                Committee c = Committee.createFromConsole(clubID);
                cdao.insert(c);
                System.out.println("\n--- Committee added to Database ---");
                break;

        }
    }

    private static void listEntities(String entity, int clubID){
        switch (entity) {

            case "Member":
                // Table Header
                System.out.println("+------------+----------------------+");
                System.out.printf("| %-10s | %-20s |\n", "Member ID", "Member Name");
                System.out.println("+------------+----------------------+");


                MemberDAO mdao = new MemberDAO();

                for (var member : mdao.getAll()) {
                    System.out.printf("| %-10d | %-20s |\n", member.studentId, member.name); // class attrs names
                }

                System.out.println("+------------+----------------------+\n");
                break;

            case "Advisor":
                // Table Header
                System.out.println("+------------+----------------------+");
                System.out.printf("| %-10s | %-20s |\n", "Advisor ID", "Advisor Name");
                System.out.println("+---------------+------------------+\n");


                AdvisorDAO adao = new AdvisorDAO();

                for (var advisor : adao.getAll()) {
                    System.out.printf("| %-10s | %-20s |\n", advisor.advisorId, advisor.name); // class attrs names
                }

                System.out.println("+------------+----------------------+\n");
                break;

            case "Sponsor":
                // Table Header
                System.out.println("+---------------+------------------+");
                System.out.printf("| %-13s | %-17s |\n", "Organization", "Email");
                System.out.println("+---------------+------------------+\n");


                SponsorDAO sdao = new SponsorDAO();

                for (var sponsor : sdao.getAll()) {
                    System.out.printf("| %-13s | %-17s |\n", sponsor.organization, sponsor.email); // class attrs names
                }

                System.out.println("+---------------+------------------+\n");
                break;

            case "Committee":
                // Table Header
                System.out.println("+------------+----------------------+");
                System.out.printf("| %-10s | %-20s |\n", "Start Year", "End Year");
                System.out.println("+------------+----------------------+");


                CommitteeDAO cdao = new CommitteeDAO();

                for (var committee : cdao.getAll()) {
                    System.out.printf("| %-10s | %-20s |\n", committee.startYear, committee.endYear); // class attrs names
                }

                System.out.println("+------------+----------------------+\n");
                break;

        }
    }

    private  static  void updateEntity(String entity, int clubID){
        switch (entity) {

            case "Member":
                MemberDAO mdao = new MemberDAO();

                System.out.print("Enter ID to update: ");
                int mid = sc.nextInt(); sc.nextLine();
                System.out.print("New Number: ");
                int memberNumber = sc.nextInt();sc.nextLine();
                mdao.update(memberNumber, mid);
                System.out.println("\n--- Memeber updated successfully ---");
                break;

            case "Advisor":
                AdvisorDAO adao = new AdvisorDAO();

                System.out.print("Enter ID to update: ");
                int aid = sc.nextInt(); sc.nextLine();
                System.out.print("New Number: ");
                int advisorNumber = sc.nextInt();sc.nextLine();
                adao.update(advisorNumber,aid);
                System.out.println("\n--- Advisor updated successfully ---");
                break;

            case "Sponsor":
                SponsorDAO sdao = new SponsorDAO();

                System.out.print("Enter ID to update: ");
                int sid = sc.nextInt(); sc.nextLine();

                System.out.print("New Number: ");
                int sponsorNumber = sc.nextInt();sc.nextLine();
                sdao.update(sponsorNumber, sid);
                System.out.println("\n--- Sponsor updated successfully ---");
                break;



        }
    }

    private  static  void deleteEntity(String entity, int clubID){
        switch (entity) {

            case "Member":
                MemberDAO mdao = new MemberDAO();

                System.out.print("Enter ID to delete: ");
                int mid = sc.nextInt(); sc.nextLine();
                mdao.delete(mid);
                System.out.println("\n--- Memeber deleted successfully ---");
                break;

            case "Advisor":
                AdvisorDAO adao = new AdvisorDAO();

                System.out.print("Enter ID to delete: ");
                int aid = sc.nextInt(); sc.nextLine();
                adao.delete(aid);
                System.out.println("\n--- Advisor deleted successfully ---");
                break;

            case "Sponsor":
                SponsorDAO sdao = new SponsorDAO();

                System.out.print("Enter ID to delete: ");
                int sid = sc.nextInt(); sc.nextLine();
                sdao.delete(sid);
                System.out.println("\n--- Sponsor deleted successfully ---");
                break;

            case "Committee":
                CommitteeDAO cdao = new CommitteeDAO();

                System.out.print("Enter ID to delete: ");
                int cid = sc.nextInt(); sc.nextLine();
                cdao.delete(cid);
                System.out.println("\n--- Committee deleted successfully ---");
                break;

        }
    }
}