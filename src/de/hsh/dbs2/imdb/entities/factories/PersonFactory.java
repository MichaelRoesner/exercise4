package de.hsh.dbs2.imdb.logic.factories;

import java.sql.*;
import java.util.ArrayList;
import de.hsh.dbs2.imdb.util.DBConnection;

public class PersonFactory {
	ArrayList<String> list;

	public ArrayList<String> getPersonList(String text) throws SQLException {
		String SQL = "Select name From Person where name like upper(?) ";
		try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(SQL)) {
			stmt.setString(1, "%" + text + "%");
			list = new ArrayList<>();
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {

					list.add(rs.getString("name"));
				}
			}
		}
		return list;
	}

}
