package com.ylz.springsecurityweb.controller;

import com.ylz.springsecurityweb.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    @GetMapping("update")
//    @Secured({"ROLE_sale","ROLE_manager"})
//    @PreAuthorize("hasAnyAuthority('admins,admin')")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String update() {
        System.out.println("update......");
        return "hello update";
    }

    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admins,admin')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAllUser(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(11L,"admin1","6666"));
        list.add(new Users(21L,"admin2","888"));
        System.out.println(list);
        return list;
    }

    @GetMapping("delete")
    @PreFilter(filterTarget="ids", value="filterObject.equals('111')")
    public List<String>  delete(@RequestParam(value = "ids")  List<String>  ids ) {
        return ids;
    }
}
