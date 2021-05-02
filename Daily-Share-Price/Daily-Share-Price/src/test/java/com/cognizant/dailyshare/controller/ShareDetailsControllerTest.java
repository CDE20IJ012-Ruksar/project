package com.cognizant.dailyshare.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.dailyshare.model.AuthResponse;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.service.ShareDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ShareDetailsController.class)

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
		
		Mockito.when(serviceImpl.getAllShares()).thenReturn(shareDetailsList);
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get("/dailyAllSharePrice")
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "token");
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expectedJson=this.mapToJson(shareDetailsList);
		String outputJson=result.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(outputJson);
		
	}
	
	/**
	 * testing method that returns share by passing share name
	 * @throws Exception
	 */
	@Test
	public void testgetDailySharePrice() throws Exception 
	{
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		String inputInJson=this.mapToJson(shareDetail);
		Mockito.when(serviceImpl.getSharebyName(Mockito.anyString())).thenReturn(shareDetail);
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get("/dailySharePrice/name/Amazon")
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "token");
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expectedJson=this.mapToJson(shareDetail);
		String outputJson=result.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(outputJson);
	}
	
	
/**
 * Maps object into JSON string.Uses Jackson ObjectMapper	
 */
private String mapToJson(Object object) throws JsonProcessingException{
	ObjectMapper objectMapper=new ObjectMapper();
	return objectMapper.writeValueAsString(object);
	
}
	
	
	
}
