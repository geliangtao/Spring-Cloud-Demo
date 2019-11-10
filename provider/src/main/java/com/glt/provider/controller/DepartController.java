package com.glt.provider.controller;

import com.glt.provider.bean.Depart;
import com.glt.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {
    @Autowired
    private DepartService service;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        depart.setDbase("test");
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        depart.setDbase("test");
        return service.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
//        return service.listAllDeparts();
        List<Depart> departs = service.listAllDeparts();
        List<Depart> out = new ArrayList<>();
        out.add(departs.get(3));
        return out;
    }
}
