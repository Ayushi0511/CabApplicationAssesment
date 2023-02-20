package com.assesment.cabBooking.Repository;

import com.assesment.cabBooking.Entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Primary
public class UserRepository implements IUserRepository {
    List<User> userList;

    public UserRepository() {
        this.userList=new ArrayList<>();
    }


    @Override
    public boolean onBoardUser(User user) {
        userList.add(user);
        return true;
    }

    @Override
    public List<User> getUsers() {
        return userList;
    }
}
