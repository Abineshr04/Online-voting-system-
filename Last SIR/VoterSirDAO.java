import java.sql.*;

public class VoterSirDAO {
    Connection con;

    public VoterSirDAO(Connection con) {
        this.con = con;
    }

    // Create table
    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS voters (" +
                     "voter_id INT PRIMARY KEY AUTO_INCREMENT, " +
                     "name VARCHAR(100), " +
                     "epic_no VARCHAR(20) UNIQUE, " +
                     "constituency VARCHAR(100), " +
                     "last_sir_date DATE)";
        Statement st = con.createStatement();
        st.execute(sql);
    }

    // Add voter with SIR date
    public void addVoter(Voter v) throws SQLException {
        String sql = "INSERT INTO voters (name, epic_no, constituency, last_sir_date) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, v.getName());
        ps.setString(2, v.getEpicNo());
        ps.setString(3, v.getConstituency());
        ps.setString(4, v.getLastSirDate());
        ps.executeUpdate();
        System.out.println("Voter added successfully.");
    }

    // Update SIR verification date
    public void updateSirDate(String epicNo, String newDate) throws SQLException {
        String sql = "UPDATE voters SET last_sir_date = ? WHERE epic_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newDate);
        ps.setString(2, epicNo);
        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "SIR date updated." : "Voter not found.");
    }

    // Check if voter's SIR is verified for TN 2026 cycle (published 07-Feb-2026)
    public void checkSirStatus(String epicNo) throws SQLException {
        String sql = "SELECT * FROM voters WHERE epic_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, epicNo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Date sirDate = rs.getDate("last_sir_date");
            Date tnSirPublishDate = Date.valueOf("2026-02-07");

            System.out.println("Voter: " + rs.getString("name"));
            System.out.println("Constituency: " + rs.getString("constituency"));
            if (sirDate != null && !sirDate.before(tnSirPublishDate)) {
                System.out.println("Status: SIR Verified (Eligible to vote)");
            } else {
                System.out.println("Status: NOT verified under 2026 SIR - Please contact BLO");
            }
        } else {
            System.out.println("Voter not found.");
        }
    }
}
