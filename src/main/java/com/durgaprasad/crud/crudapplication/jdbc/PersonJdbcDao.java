package com.durgaprasad.crud.crudapplication.jdbc;

import com.durgaprasad.crud.crudapplication.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static class PersonRowMapper implements RowMapper<List<Person>> {

        @Override
        public List<Person> mapRow(ResultSet rs, int rowNum) throws SQLException {
            List<Person> users = new ArrayList<>();

            while (rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setLocation(rs.getString("location"));
                person.setBirthDate(rs.getTimestamp("birth_date"));
                users.add(person);
            }

            return users;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM Person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    // Still a bug, returning one result -> need to fix
    public List<Person> findByName(String name){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE name=?",
                new Object[]{name}, new PersonRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM PERSON WHERE id=?", id);
    }

    public void insert(Person person) {
        jdbcTemplate.update("INSERT INTO person (id, name, location, birth_date) VALUES (?,?,?,?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }
}
