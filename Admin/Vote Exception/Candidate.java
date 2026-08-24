public class Candidate {
    private String name;
    private String party;
    private int voteCount;

    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
        this.voteCount = 0;
    }

    public String getName() { return name; }
    public String getParty() { return party; }
    public int getVoteCount() { return voteCount; }
    public void incrementVote() { voteCount++; }
}
