import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Edappadi K. Palaniswami.", "All India Anna Dravida Munnetra Kazhagam (AIADMK)"));
        candidates.add(new Candidate("Anbumani Ramadoss", "Pattali Makkal Katchi (PMK)"));
        candidates.add(new Candidate("C. Joseph Vijay", "Tamilaga Vettri Kazhagam (TVK)"));
        candidates.add(new Candidate("Naam Tamilar Katchi (NTK)", " Seeman"));
        candidates.add(new Candidate("M. K. Stalin.", "Dravida Munnetra Kazhagam (DMK)"));
        candidates.add(new Candidate("Narendra Modi", "Bharatiya Janata Party (BJP)"));
        candidates.add(new Candidate("Rahul Gandhi", "Indian National Congress (INC)"));

        VotingSystem vs = new VotingSystem(candidates);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter EPIC No: ");
        String epic = sc.nextLine();

        System.out.println("Candidates:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).getName());
        }
        System.out.print("Enter candidate number: ");
        int choice = sc.nextInt();

        try {
            vs.castVote(epic, choice, true); // pass isSirVerified = true/false based on your DB check
        } catch (DuplicateVoteException | InvalidCandidateException | VoterNotVerifiedException e) {
            System.out.println("Vote Failed: " + e.getMessage());
        }

        sc.close();
    }
}
