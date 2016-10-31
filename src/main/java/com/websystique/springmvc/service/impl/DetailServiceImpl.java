package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Employees2;
import com.websystique.springmvc.domain.Passports;
import com.websystique.springmvc.domain.Permissions;
import com.websystique.springmvc.repository.PermissionsRepository;
import com.websystique.springmvc.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yaroslav on 31.10.2016.
 */
@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private PermissionsRepository permissionsRepository;

    @Override
    public Passports getPassportsByName(String name) {

  return permissionsRepository.getPassportsByName(name);
    }

//    @Override
//    public Employees2 getEmployeeByName(String username) {
//        return permissionsRepository.getEmployeeByName(username);
//    }
}
