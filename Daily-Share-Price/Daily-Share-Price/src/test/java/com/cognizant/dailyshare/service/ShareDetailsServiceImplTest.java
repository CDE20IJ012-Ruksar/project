package com.cognizant.dailyshare.service;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.respository.ShareRepository;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShareDetailsServiceImplTest {

	@Autowired
	private ShareDetailsServiceImpl serviceImpl;
	
	@MockBean
	private ShareRepository repository;
	
	@Test
	public void testgetSharebyName() {
		ShareDetails shareDetail=new ShareDetails();
		shareDetail.setShareId("AMZ");
		shareDetail.setShareName("AMAZON");
		shareDetail.setShareValue(2500.0);
		Mockito.when(repository.findByShareName("AMAZON")).thenReturn(shareDetail);
		assertThat(serviceImpl.getSharebyName("AMAZON")).isEqualTo(shareDetail);
		
	}
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
}
