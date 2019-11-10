package com.glt.consumer.controller;

import com.glt.consumer.bean.Depart;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/loadBalancedRest/consumer/depart")
@RestController
public class LoadBalancedRestTemplateController {

    @Resource
    private RestTemplate getLoadBalancedRestTemplate;

    private final String URL = "http://provider-depart/provider/depart";

    @Resource
    private DiscoveryClient client;

    @GetMapping("/allserver")
    public Object discoveryAllServer(){
        List<String> services = client.getServices();
        String s = services.get(1);
        List<ServiceInstance> instances = client.getInstances(s);
        return instances;
    }

    @PostMapping("/save")
    public boolean saveHandle(Depart depart) {
        return getLoadBalancedRestTemplate.postForObject(URL+"/save", depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        getLoadBalancedRestTemplate.delete(URL+"/del/" + id);
    }

    @PutMapping("/update")
    public void updateHandle(Depart depart) {
        getLoadBalancedRestTemplate.put(URL+"/update", depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return getLoadBalancedRestTemplate.getForObject(URL+"/get/" + id, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return getLoadBalancedRestTemplate.getForObject(URL+"/list", List.class);
    }
}
