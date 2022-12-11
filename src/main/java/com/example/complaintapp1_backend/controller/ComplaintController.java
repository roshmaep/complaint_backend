package com.example.complaintapp1_backend.controller;

import com.example.complaintapp1_backend.dao.ComplaintDao;
import com.example.complaintapp1_backend.model.Complaints;
import com.example.complaintapp1_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintController {
    @Autowired
    private ComplaintDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addcomplaint",consumes = "application/json",produces = "application/json")
    public Map<String,String> Addcomplaint(@RequestBody Complaints c) {
        System.out.println(c.getUserid());
        System.out.println(c.getComplaint().toString());
        HashMap<String, String> result = new HashMap<>();
        dao.save(c);
        result.put("status", "success");
        return result;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path="/viewallcomp")
    public List<Map<String,String>> viewAll(){
    return(List<Map<String,String>>) dao.complaints();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getMyComplaintId", consumes = "application/json", produces = "application/json")
    public List<Complaints> getComplaintById(@RequestBody Complaints c){
        System.out.println(c.getUserid());
        return (List<Complaints>) dao.getComplaintById((c.getUserid()));
    }
}
