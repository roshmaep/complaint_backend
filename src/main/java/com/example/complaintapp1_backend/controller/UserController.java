package com.example.complaintapp1_backend.controller;

import com.example.complaintapp1_backend.dao.UserDao;
import com.example.complaintapp1_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/")
    public String HomePage(){
        return "welcome page";
    }
    @Autowired
    private UserDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userreg",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserRegistration(@RequestBody UserModel u){
        dao.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserModel u){

        String email=String.valueOf(u.getEmail());
        String password=String.valueOf(u.getPassword());
        List<UserModel> result=(List<UserModel>) dao.UserLogin(email,password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getUserById", consumes = "application/json", produces = "application/json")
    public List<UserModel> GetUserById(@RequestBody UserModel f){
        return (List<UserModel>) dao.FindUser(f.getId());
    }

}
