package com.cg.bmd.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.cg.bmd.entities.Admin;
import com.cg.bmd.repository.AdminRepository;

@SpringBootTest
public class AdminServiceTest {

	public static Admin admin, admin1, admin2;
	
	@BeforeAll // it is used to signal that the annotated method should executed before all tests in 
	         // the current test class.
	public static void setUp() {
        admin = new Admin();
        admin1 = new Admin();
        admin2 = new Admin();
        
        admin.setId(1);
                admin.setPassword("Shravs@1");
        admin.setAdminName("shravs");
        admin.setEmail("shravs@gmail.com");
        admin.setContactNumber(705522698);
        
        admin1.setPassword("Sindhu@3");
        admin1.setAdminName("sindhu");
        admin1.setEmail("sin@gmail.com");
        admin1.setContactNumber(1217025211);


        admin2.setPassword("Rama@123");
        admin2.setAdminName("rama");
        admin2.setEmail("rama@gmail.com");
        admin2.setContactNumber(1224436587);
        
	}
	
	@Autowired
    IAdminService adminService;


    @MockBean //
    AdminRepository adminRepository;


    @Test
    @DisplayName("positive test case of add admin")
    void testAddAdminValidTest() throws Exception{
        when(adminRepository.save(admin)).thenReturn(admin);
        assertEquals(admin, adminService.addAdmin(admin));

    }
    
    @Test
    @DisplayName("negative test case of add admin")
    void testAddAdminNotValidTest() throws Exception{
        when(adminRepository.save(admin)).thenReturn(admin);
        assertNotEquals(admin1, adminService.addAdmin(admin));

    }

    @Test
    @DisplayName("positive test case for get admin")
    void testGetAdminPositive() throws Exception{
        when(adminRepository.findById(1)).thenReturn(Optional.of(admin1));
        admin = adminService.viewAdmin(1);
        assertEquals(admin1.toString(), admin.toString());	
    }

    @Test
    @DisplayName("negative test case for get admin")
    void testGetAdminNegative() throws Exception{
        when(adminRepository.findById(2)).thenReturn(Optional.of(admin1));
        admin = adminService.viewAdmin(2);
        assertNotEquals(admin2.toString(), admin.toString());

    }

    @Test
    @DisplayName("positive test case of get all admin")
    void testGetAllAdminive() throws Exception{
        List<Admin> list = new ArrayList<>();
        list.add(admin1);
        list.add(admin2);
        adminService.fetchAllAdmin();
        when(adminRepository.findAll()).thenReturn(list);
        assertEquals(list.size(), adminService.fetchAllAdmin().size());

    }

    @Test
    @DisplayName("negative test case of get all admin")
    void testGetAllAdminNegative() throws Exception{
        List<Admin> list = new ArrayList<>();
        list.add(admin1);
        list.add(admin2);
        adminService.fetchAllAdmin();
        when(adminRepository.findAll()).thenReturn(list);
        assertNotEquals(3, adminService.fetchAllAdmin().size());

    }

    



	
}
