package com.example.Hotel.Guest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class GuestDataAccessService implements GuestDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertGuest(Guest guest) {
        return 0;
    }

    @Override
    public List<Guest> selectAllGuests() {
        final String sql = "SELECT IdCardNr,first_name,surname,room  FROM guest"; // as well i could use *
        List<Guest> guests =jdbcTemplate.query(sql,(resultSet,i)->{
            return new Guest(resultSet.getString("IdCardNr"),
                             resultSet.getString("first_name"),
                             resultSet.getString("surname"),
                             resultSet.getInt("room"));
        });
        return guests;
    }

    @Override
    public Optional<Guest> selectGuestById(String idCardNr) {
        final String sql = "SELECT IdCardNr,first_name,surname,room  FROM guest WHERE IdCardNr = ?";

        Guest guest = jdbcTemplate.queryForObject(
            sql,
            new Object[]{idCardNr},
                (resultSet, i) -> {
                String GuestIdCardNr = resultSet.getString(("IdCardNr"));
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("surname");
                Integer room = resultSet.getInt("room");
                return new Guest(GuestIdCardNr,name,surname,room);
         });
        return Optional.ofNullable(guest);


    }

    @Override
    public int deleteGuestById(String idCardNr) {
        return 0;
    }

    @Override
    public int updateGuestById(String idCardNr, Guest newGuest) {
        return 0;
    }

    @Override
    public int updateRoomGuest(String idCardNr, GuestRoomChange room) {
        return 0;
    }
}
