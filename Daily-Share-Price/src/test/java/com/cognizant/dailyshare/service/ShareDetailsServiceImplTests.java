package com.cognizant.dailyshare.service;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import com.cognizant.dailyshare.controller.AuthClient;
import com.cognizant.dailyshare.model.AuthResponse;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.respository.ShareRepository;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ShareDetailsServiceImplTests {

	@Autowired
	private ShareDetailsServiceImpl serviceImpl;
	
	@MockBean
	AuthClient authClient;
	
	@MockBean
	private ShareRepository repository;
	
	/**
	 * Testing method to with a particular share name
	 */
	@Test
	public void testgetSharebyName() {
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		Mockito.when(repository.findByShareName("Amazon")).thenReturn(shareDetail);
		assertThat(serviceImpl.getSharebyName("Amazon")).isEqualTo(shareDetail);
		
	}
	
	/**
	 * Testing method to with a particular share id
	 */
	
	@Test
	public void testgetSharebyId() {
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		Mockito.when(repository.findByShareId("AMZ")).thenReturn(shareDetail);
		assertThat(serviceImpl.getSharebyId("AMZ")).isEqualTo(shareDetail);
		
	}
	
	/**
	 * Testing method for all share
	 */
	
	@Test
	public void testgetAllShares()
	{
		ShareDetails shareDetail1=new ShareDetails("AMZ","Amazon",2500.0);
		ShareDetails shareDetail2=new ShareDetails("GGL","Google",2000.0);
		ShareDetails shareDetail3=new ShareDetails("ABC","Alpabet",1300.0);
		ShareDetails shareDetail4=new ShareDetails("FFB","FaceBook",1400.0);
		List<ShareDetails> shareDetailsList=new ArrayList<>();
		shareDetailsList.add(shareDetail1);
		shareDetailsList.add(shareDetail2);
		shareDetailsList.add(shareDetail3);
		shareDetailsList.add(shareDetail4);
		Mockito.when(repository.findAll()).thenReturn(shareDetailsList);
		assertThat(serviceImpl.getAllShares()).isEqualTo(shareDetailsList);
	}
	
	/**
	 * Testing for a authorized user
	 */
	@Test
	void isSessionValid() {
		when(authClient.getValidity("token")).thenReturn(new AuthResponse("101", "admin", true));
		assertEquals(true,serviceImpl.isSessionValid("token"));
	}
	
	
	
}
