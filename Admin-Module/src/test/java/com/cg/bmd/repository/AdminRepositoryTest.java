/* package com.cg.bmd.repository;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cg.bmd.entities.Admin;

@DataJpaTest

public class AdminRepositoryTest {
	
	@Autowired
	private AdminRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		// it follows builder design pattern - used @Builder - lombok annotation in
		// Customer class
		Admin admin = Admin.builder().adminName("shravika").email("shravika@gmail.com").password("Shravs@5")
				.build();
		//entityManager.persist(customer);

		List<Admin> admins = Arrays.asList(
				Admin.builder().adminName("shravika").email("shravika@gmail.com").password("Shravs@5").build(),
				Admin.builder().adminName("suraj").email("suraj@gmail.com").password("Suraj@34").build());
		repo.saveAll(admins);
	}

	@Test
	@DisplayName("Get Admin when id matches")
	@Disabled
	void testFindById() {
		Admin admin = repo.findById(1).get();
		assertEquals("shravika", admin.getAdminName());
	}

	@Test
	@DisplayName("Get All Admins")
	void testFindAll() {
		List<Admin> admins = repo.findAll();
		assertEquals(2, admins.size());
	}



}
*/
