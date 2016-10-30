package com.lemur.repository;

import com.lemur.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Виталий on 30.10.2016.
 */
@Repository("contactRepository")
public class ContactRepositoryImpl implements ContactRepository<Contact> {

	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public void persist(Contact object) {
		Object[] params = new Object[] { object.getId(), object.getFirstName(),
				object.getLastName(), object.getPhone(), object.getAddress()};
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};

		jdbcOperations.update("INSERT INTO contacts(\n" +
				"            id, first_name, last_name, phone, address)\n" +
				"    VALUES (cast(? as UUID), ?, ?, ?, ?);", params, types);
	}

	@Override
	public void delete(Contact object) {
		jdbcOperations.update("DELETE FROM contacts\n" +
				" WHERE id = '" + object.getId().toString() + "';");
	}

	@Override
	public Set<String> getRandomData() {
		Set<String> result = new HashSet<>();
		SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT first_name"
				+ " FROM contacts ORDER BY RANDOM() LIMIT 50;");
		while (rowSet.next()) {
			result.add(rowSet.getString("first_name"));
		}
		return result;
	}
}
