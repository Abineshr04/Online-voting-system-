import java.io.*;
import java.util.*;

public class ResultGenerator {

    public static void generateResultFile(List<Candidate> candidates, String filePath) {
        // Sort candidates by vote count descending
        candidates.sort((a, b) -> b.getVoteCount() - a.getVoteCount());

        try (FileWriter fw = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("==============================================\n");
            bw.write("        ONLINE VOTING SYSTEM - RESULT\n");
            bw.write("==============================================\n\n");

            int totalVotes = 0;
            for (Candidate c : candidates) totalVotes += c.getVoteCount();

            bw.write(String.format("%-20s %-15s %-10s\n", "Candidate", "Party", "Votes"));
            bw.write("----------------------------------------------\n");

            for (Candidate c : candidates) {
                bw.write(String.format("%-20s %-15s %-10d\n",
                        c.getName(), c.getParty(), c.getVoteCount()));
            }

            bw.write("----------------------------------------------\n");
            bw.write("Total Votes Cast: " + totalVotes + "\n\n");

            if (!candidates.isEmpty()) {
                Candidate winner = candidates.get(0);
                bw.write("WINNER: " + winner.getName() +
                        " (" + winner.getParty() + ") with " +
                        winner.getVoteCount() + " votes.\n");
            }

            bw.write("==============================================\n");

            System.out.println("Result file generated successfully at: " + filePath);

        } catch (IOException e) {
            System.out.println("Error writing result file: " + e.getMessage());
        }
    }
}
