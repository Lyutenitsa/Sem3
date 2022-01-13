//package com.indv_project.rest_api.services;
//
//import com.indv_project.rest_api.models.ERole;
//import com.indv_project.rest_api.models.Role;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader{
//
//    private RoleService roleService;
//
//    public DataLoader() {
//        this.roleService = new RoleService();
//        LoadUsers();
//    }
//
//    private void LoadUsers() {
//        roleService.save(new Role(ERole.ROLE_ADMIN));
//        roleService.save(new Role(ERole.ROLE_USER));
//        roleService.save(new Role(ERole.ROLE_MODERATOR));
//    }
//
//
//}
