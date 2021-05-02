package com.cognizant.dailyshare.service;

import java.util.List;

import com.cognizant.dailyshare.model.ShareDetails;

public interface ShareDetailsService {
	public List<ShareDetails> getAllShares();
	public ShareDetails getSharebyName(String shareName);
	public List<Double> getSharebyIdList(List<String> shareId);
	public Boolean isSessionValid(String token);
}
