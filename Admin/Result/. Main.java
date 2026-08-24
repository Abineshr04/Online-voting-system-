import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Candidate> candidates = new ArrayList<>();

        candidates.add(new Candidate("Narendra Modi","Bharatiya Janata Party (BJP)"));
         candidates.add(new Candidate("Anbumani Ramadoss.", "Pattali Makkal Katchi (PMK)"));
        candidates.add(new Candidate("Edappadi K. Palaniswami", "All India Anna Dravida Munnetra Kazhagam (AIADMK)"));
        candidates.add(new Candidate("M. K. Stalin.", "Dravida Munnetra Kazhagam (DMK)"));
        candidates.add(new Candidate(" C. Joseph Vijay (Vijay).", "Tamilaga Vettri Kazhagam (TVK)"));
        candidates.add(new Candidate(" Seeman", "Naam Tamilar Katchi (NTK)"));
        candidates.add(new Canditates("Rahul Gandhi ","Indian National Congress (INC)"));
        


        int choice;
        do {
            System.out.println("\n1. Cast Vote\n2. Generate Result File\n3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Candidates:");
                    for (int i = 0; i < candidates.size(); i++) {
                        System.out.println((i + 1) + ". " + candidates.get(i).getName() +
                                " (" + candidates.get(i).getParty() + ")");
                    }
                    System.out.print("Enter candidate number to vote: ");
                    int vote = sc.nextInt();
                    if (vote >= 1 && vote <= candidates.size()) {
                        candidates.get(vote - 1).incrementVote();
                        System.out.println("Vote recorded successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    ResultGenerator.generateResultFile(candidates, "Results.txt");
                    break;
            }
        } while (choice != 3);

        sc.close();
    }
}
