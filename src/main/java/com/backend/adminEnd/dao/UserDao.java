package com.backend.adminEnd.dao;
import java.util.List;
import com.backend.model.UserEntity;

/**
 * Created by kevin on 2017/4/11.
 */
public interface UserDao {
    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public List<UserEntity> listUser();
    public UserEntity getUserById(String userId);
    public void removeUser(String userId);
}
