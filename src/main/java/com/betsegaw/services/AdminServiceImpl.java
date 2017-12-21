package com.betsegaw.services;

import com.betsegaw.entities.Admin;
import com.betsegaw.exception.NotFoundException;
import com.betsegaw.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Set<Admin> getAdmins() {
        Set<Admin> admins = new HashSet<>();
        adminRepository.findAll().iterator().forEachRemaining(admins::add);
        return admins;
    }

    @Override
    public Admin findById(Long adminId){
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if(!adminOptional.isPresent()){
            throw new NotFoundException("Admin Not Found. For ID value: " + adminId.toString());
        }
        return adminOptional.get();
    }

    @Override
    public Admin findByFirstName(String firstName) {

        Optional<Admin> adminOptional = adminRepository.findByFirstName(firstName);
        if(!adminOptional.isPresent()){
          throw new NotFoundException("Admin Not Found. For First Name value: " + firstName);
        }
        return adminOptional.get();
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteById(Long adminId) {
      adminRepository.deleteById(adminId);
    }
}
