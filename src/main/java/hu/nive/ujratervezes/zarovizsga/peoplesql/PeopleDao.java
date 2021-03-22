package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `ip_address` FROM `people` WHERE first_name=? AND last_name=?")) {
            stmt.setString (1, firstName);
            stmt.setString (2, lastName);


            return getStringByPreparedStatement(stmt);


        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by select", se);
        }

    }

    private String getStringByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String ip = rs.getString("ip_address");
                return ip;
            }
            throw new IllegalArgumentException("No results");
        } catch (SQLException se) {
            throw new IllegalStateException("Error by select", se);

        }
    }

}
