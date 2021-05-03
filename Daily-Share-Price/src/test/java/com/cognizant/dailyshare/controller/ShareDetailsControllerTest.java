package com.cognizant.dailyshare.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.service.ShareDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ShareDetailsController.class)
class ShareDetailsControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ShareDetailsServiceImpl serviceImpl;
	
	/**
	 * testing method that returns all shares
	 * @throws Exception
	 */
	@Test
	public void testgetAllDailySharePrice() throws Exception 
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
		when(serviceImpl.getAllShares()).thenReturn(shareDetailsList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/dailyAllSharePrice")
				.content(this.mapToJson(shareDetailsList))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
	}
	
	/**
	 * testing method that returns share by passing share name
	 * @throws Exception
	 */
	@Test
	public void testgetDailySharePriceByName() throws Exception 
	{
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		when(serviceImpl.getSharebyName("Amazon")).thenReturn(shareDetail);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/dailySharePrice/name/Amazon").content(this.mapToJson(shareDetail))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
		
	}
	
	/**
	 * testing method that returns share by passing share id
	 * @throws Exception
	 */
	@Test
	public void testgetDailySharePriceById() throws Exception 
	{
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		when(serviceImpl.getSharebyId("AMZ")).thenReturn(shareDetail);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/dailySharePrice/id/AMZ").content(this.mapToJson(shareDetail))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
	}
	
	/**
	 * testing method that returns BadRequest error by passing wrong input
	 * @throws Exception
	 *
	 */
	@Test()
	public void testgetDailySharePriceByNameNegative() throws Exception
	{
		ShareDetails shareDetail=new ShareDetails("KTK","Kotak",5500.0);
		when(serviceImpl.getSharebyName("Kotak")).thenReturn(shareDetail);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/dailySharePrice/name/Kotak").content(this.mapToJson(shareDetail))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
		
	}
	
	
	/**
	 * Maps object into JSON string.Uses Jackson ObjectMapper	
	 */
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}

	

