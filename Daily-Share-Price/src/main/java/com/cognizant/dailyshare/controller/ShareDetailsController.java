package com.cognizant.dailyshare.controller;
/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.dailyshare.exception.ShareNotFoundException;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.service.ShareDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ShareDetailsController {
	
	@Autowired
	private ShareDetailsService service;
	
	/**
	 * This method returns all shares list
	 * @param token
	 * @return
	 */
	@GetMapping("/dailyAllSharePrice")
	public List<ShareDetails> getAllDailySharePrice(@RequestHeader("Authorization") String token){
		log.info("START :: Method :: getAllDailySharePrice() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching all shares after authorization");
			return service.getAllShares();
		}
		return null;
		
	}
	
	/**
	 * This method returns share detail for the share name passed in argument
	 * @param token
	 * @param shareName
	 * @return
	 */
	@GetMapping("/dailySharePrice/name/{shareName}")
	public ShareDetails getDailySharePrice(@RequestHeader("Authorization") String token,@PathVariable String shareName) {
		log.info("START :: Method :: getDailySharePrice() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching share with particular share name after authorization");
			return service.getSharebyName(shareName);
		}
		return null;
	}
	
	/**
	 * This method returns share detail for the share id passed in argument
	 * @param token
	 * @param shareId
	 * @return
	 * @throws ShareNotFoundException
	 */
	@GetMapping("/dailySharePrice/id/{shareId}")
	public ShareDetails getDailySharePriceById(@RequestHeader("Authorization") String token,@PathVariable String shareId) throws ShareNotFoundException {
		log.info("START :: Method :: getDailySharePriceById() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching share with particular share id after authorization");
		 	return service.getSharebyId(shareId);
		 }
		return null;
	}
	/**
	 * This method returns list of stock values
	 * @param token
	 * @param shareId
	 * @return
	 */
	@GetMapping("/dailySharePrice/{shareId}")
	public List<Double> getDailySharePriceByIDList(@RequestHeader("Authorization") String token,@PathVariable(value="shareId") List<String> shareId){
		log.info("START :: Method :: getDailySharePriceByIDList() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching list of stock values after authorization");
			return service.getSharebyIdList(shareId);
		}
		return null;
	}
	
	
	
}
