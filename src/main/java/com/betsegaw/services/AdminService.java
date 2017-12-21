package com.betsegaw.services;


import com.betsegaw.entities.Admin;

import java.util.Set;

public interface AdminService {
    public Set<Admin> getAdmins();
    public Admin findById(Long adminId);
    public Admin findByFirstName(String firstName);
    public Admin saveAdmin(Admin admin);
    public void deleteById(Long adminId);

}
