package com.qait.happyhours.dao;

import java.util.List;

import com.qait.happyhours.domain.Deal;

public interface DealDao {

	List<Deal> getMatchingDealsBySearchStr(String searchStr);

	List<Deal> getAllDealsList();

}