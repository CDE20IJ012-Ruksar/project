package com.cognizant.auth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.auth.model.UserData;
import com.cognizant.auth.repository.UserRepository;
import com.cognizant.auth.service.AdminDetailsService;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * 		With the @SpringBootTest annotation, Spring Boot provides a 
 * 		convenient way to start up an application context to be used in a test
 * 		@RunWith is an annotation to use test runners
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDetailsServiceTest {

	@Autowired
	AdminDetailsService adminDetailService;

	@MockBean
	UserRepository userRepository;

	/**
	 * to test the test_loadUserByUsername()
	 */
	@Test
	public void test_loadUserByUsernameTest() {
		
		UserData user1=new UserData ("admin","admin","admin", null);
		Optional<UserData > data =Optional.of(user1) ;
		when(userRepository.findById("admin")).thenReturn(data);
		UserDetails loadUserByUsername = adminDetailService.loadUserByUsername("admin");
		assertEquals(user1.getUserid(),loadUserByUsername.getUsername());
	}
}
