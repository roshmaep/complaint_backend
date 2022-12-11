package com.example.complaintapp1_backend.dao;

import com.example.complaintapp1_backend.model.Complaints;
import com.example.complaintapp1_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository <Complaints,Integer> {
@Query(value = "SELECT u.`address`, u.`email`, u.`name`, u.`phone`,c.complaint FROM `userreg` u JOIN complaints c ON c.userid=u.id",nativeQuery = true)
    List<Map<String,String>>complaints();
@Query(value = "SELECT `id`, `complaint`, `userid` FROM `complaints` WHERE `userid`=:userid",nativeQuery = true)
List<Complaints> getComplaintById(@Param("userid") Integer userid);
}
