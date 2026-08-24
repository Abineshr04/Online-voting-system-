import java.util.Scanner;

public class Voter {

    String name;
    String epicNo;
    boolean isSirVerified;

    public Voter(String name, String epicNo, boolean isSirVerified) {
        this.name = name;
        this.epicNo = epicNo;
        this.isSirVerified = isSirVerified;
    }

    public static void showWelcome() {
        System.out.println("==============================================");
        System.out.println("     WELCOME TO ONLINE VOTING SYSTEM");
        System.out.println("     Tamil Nadu - SIR 2026 Verified Voters Only");
        System.out.println("==============================================");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        showWelcome();

        System.out.print("\nEnter your EPIC Number: ");
        String epic = scn.nextLine();

        System.out.print("Enter your Name: ");
        String name = scn.nextLine();

        // Simulated SIR check (replace with VoterSirDAO.checkSirStatus() later)
        boolean verified = true;

        Voter voter = new Voter(name, epic, verified);

        if (voter.isSirVerified) {
            System.out.println("\nWelcome, " + voter.name + "! You are SIR verified.");
            System.out.println("Proceeding to voting screen...");
            // TODO: call voting menu here
        } else {
            System.out.println("\nSorry " + voter.name + ", you are NOT SIR verified.");
            System.out.println("Please contact your BLO before voting.");
        }

        scn.close();
    }
}
