package com.example.complaintapp1_backend.dao;

import com.example.complaintapp1_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository <UserModel,Integer> {
    @Query(value = "SELECT `id`, `address`, `cpassword`, `email`, `name`, `password`, `phone` FROM `userreg` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<UserModel> UserLogin(@Param("email") String email, @Param("password") String password);
     @Query(value = "SELECT `id`, `address`, `cpassword`, `email`, `name`, `password`, `phone` FROM `userreg` WHERE `id`=:id",nativeQuery = true)
     List<UserModel> FindUser(@Param("id") Integer id);
}
