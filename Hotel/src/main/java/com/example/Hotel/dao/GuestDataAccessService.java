package com.example.Hotel.dao;


import com.example.Hotel.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class GuestDataAccessService implements GuestDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertGuest(Guest guest) {
        final String sql = "INSERT INTO guest (id_card_nr,name,surname,room) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,guest.getIdCardNr(),guest.getName(),guest.getSurname(),guest.getRoom());

    }

    @Override
    public List<Guest> selectAllGuests() {
        final String sql = "SELECT id_card_nr,name,surname,room  FROM guest"; // as well i could use *
        List<Guest> guests =jdbcTemplate.query(sql,(resultSet,i)->{
            return new Guest(resultSet.getString("id_card_nr"),
                             resultSet.getString("name"),
                             resultSet.getString("surname"),
                             resultSet.getInt("room"));
        });
        return guests;
    }

    @Override
    public Optional<Guest> selectGuestById(String idCardNr) {
        final String sql = "SELECT id_card_nr,name,surname,room  FROM guest WHERE id_card_nr = ?";

        Guest guest = jdbcTemplate.queryForObject(
            sql,
            new Object[]{idCardNr},
                (resultSet, i) -> {
                String GuestIdCardNr = resultSet.getString(("id_card_nr"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int room = resultSet.getInt("room");
                return new Guest(GuestIdCardNr,name,surname,room);
         });
        return Optional.ofNullable(guest);


    }

    @Override
    public int deleteGuestById(String idCardNr) {
        final String sql = "DELETE FROM guest WHERE id_card_nr=?";
        return jdbcTemplate.update(sql,idCardNr);
    }

    @Override
    public int updateGuestById(String idCardNr, Guest newGuest) {
        final String sql = "UPDATE guest SET id_card_nr = ?, name = ?,surname = ?,room = ? WHERE id_card_nr = ?";
        return jdbcTemplate.update(sql, newGuest.getIdCardNr(),newGuest.getName(),newGuest.getSurname(),newGuest.getRoom(),idCardNr);
    }

}
