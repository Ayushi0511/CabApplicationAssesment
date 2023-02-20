package com.assesment.cabBooking.Repository;


import com.assesment.cabBooking.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepository {

    public boolean onBoardUser(User user);
    public List<User> getUsers();


}
