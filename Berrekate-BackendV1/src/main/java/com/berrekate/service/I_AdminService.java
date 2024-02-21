package com.berrekate.service;

import com.berrekate.dto.AdminDTO;

import java.util.List;

public interface I_AdminService {

    AdminDTO  createAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAllAdmins();

    AdminDTO getAdminById(Long id);

    void deleteAdmin(Long id);

    AdminDTO updateAdmin(AdminDTO adminDTO);

    AdminDTO getAdminByEmail(String email);
}
