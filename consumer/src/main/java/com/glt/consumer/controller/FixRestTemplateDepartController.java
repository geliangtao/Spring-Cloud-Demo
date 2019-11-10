package com.glt.consumer.controller;

import com.glt.consumer.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/fixRest/consumer/depart")
@RestController
public class FixRestTemplateDepartController {
    @Autowired
    private RestTemplate getRestTemplate;

    @PostMapping("/save")
    public boolean saveHandle(Depart depart) {
        String url = "http://localhost:9999/provider/depart/save";
        return getRestTemplate.postForObject(url, depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        String url = "http://localhost:9999/provider/depart/del/" + id;
        getRestTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandle(Depart depart) {
        String url = "http://localhost:9999/provider/depart/update";
        getRestTemplate.put(url, depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        String url = "http://localhost:9999/provider/depart/get/" + id;
        return getRestTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        String url = "http://localhost:9999/provider/depart/list";
        return getRestTemplate.getForObject(url, List.class);
    }
}
