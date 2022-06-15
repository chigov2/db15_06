package com.database.db.jdbc;

import com.database.db.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        //map
       return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person finById(int id){
        //map
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person finByName(String name){
        //map
        return jdbcTemplate.queryForObject("select * from person where name=?", new Object[]{name},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id){
        //map
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public int insert(Person person){
        return jdbcTemplate.update("insert into person(id, name, location, birth_date) "
                + "values(?,?,?,?)",
                person.getId(),
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person){
        return jdbcTemplate.update("update person "
                + " set name = ?, location = ?, birth_date = ? "
                + " where id = ?",
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()),
                person.getId());
    }

}
