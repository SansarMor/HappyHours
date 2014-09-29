package com.qait.happyhours.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qait.happyhours.dao.DealDao;
import com.qait.happyhours.domain.Deal;
import com.qait.happyhours.domain.User;

@Repository("dealDao")
public class DealDaoImpl extends GenericDaoImpl<User, Long> implements DealDao {

	@Override
	public List<Deal> getMatchingDealsBySearchStr(String searchStr) {

		List<Deal> dealList = new ArrayList<Deal>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();

			String queryString = "select distinct d from Deal d join fetch d.dealOffersList ol where d.title like '%"
					+ searchStr
					+ "%' or ol.offerName like '%"
					+ searchStr
					+ "%'";

			Query query = session.createQuery(queryString);
			dealList = query.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			session.close();

		}
		return dealList;
	}

	@Override
	public List<Deal> getAllDealsList() {
		List<Deal> dealList = new ArrayList<Deal>();
		Session session = null;
		try {
			session = getSessionFactory().openSession();

			String queryString = "from Deal";

			Query query = session.createQuery(queryString);
			dealList = query.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			session.close();

		}
		return dealList;
	}
}
