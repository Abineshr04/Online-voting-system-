import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/voting_system", "root", "Abinesh@2005");

            VoterSirDAO dao = new VoterSirDAO(con);
            dao.createTable();

            int choice;
            do {
                System.out.println("\n1. Add Voter\n2. Update SIR Date\n3. Check SIR Status\n4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("EPIC No: ");
                        String epic = sc.nextLine();
                        System.out.print("Constituency: ");
                        String constituency = sc.nextLine();
                        System.out.print("Last SIR Date (yyyy-MM-dd): ");
                        String date = sc.nextLine();
                        dao.addVoter(new Voter(0, name, epic, constituency, date));
                        break;

                    case 2:
                        System.out.print("Enter EPIC No: ");
                        String epicUpd = sc.nextLine();
                        System.out.print("New SIR Date (yyyy-MM-dd): ");
                        String newDate = sc.nextLine();
                        dao.updateSirDate(epicUpd, newDate);
                        break;

                    case 3:
                        System.out.print("Enter EPIC No to check: ");
                        String epicCheck = sc.nextLine();
                        dao.checkSirStatus(epicCheck);
                        break;
                }
            } while (choice != 4);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
