package com.glt.consumer.service;

import com.glt.consumer.bean.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartFallbackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {
            @Override
            public boolean saveDepart(Depart depart) {
                System.out.println("执行降级处理");
                return false;
            }

            @Override
            public boolean removeDepartById(int id) {
                return false;
            }

            @Override
            public boolean modifyDepart(Depart depart) {
                return false;
            }

            @Override
            public Depart getDepartById(int id) {
                return null;
            }

            @Override
            public List<Depart> listAllDeparts() {
                return null;
            }
        };
    }
}
