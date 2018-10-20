package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.test.dao.InvestorDAO;
import com.test.vo.InputVO;
import com.test.vo.OutputVO;

/**
 * 
 * @author Rajesh
 * 
 */
@Repository
public class InvestorDAOImpl implements InvestorDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public OutputVO createInvestor(InputVO inputVO) throws DataAccessException {
		OutputVO outputVO = new OutputVO();
		List<String> outputList = new ArrayList<String>();
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Long key = (Long) session.save(inputVO);
			tx.commit();
			outputVO.setId(key.toString());
			outputList.add("Investor details saved successfully !");
			outputVO.setResponseList(outputList);
		} catch (HibernateException ex) {
			try {
				outputList.add("Excepion in saving investor details !");
				outputVO.setResponseList(outputList);
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Could not rollback transaction" + rbe);
			}

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return outputVO;
	}

	@Override
	public OutputVO updateInvestor(InputVO inputVO) {
		OutputVO outputVO = new OutputVO();
		List<String> outputList = new ArrayList<String>();
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(inputVO);
			tx.commit();
			outputVO.setId(Long.toString(inputVO.getId()));
			outputList.add("Investor details updated successfully !");
			outputVO.setResponseList(outputList);
		} catch (HibernateException ex) {
			try {
				outputList.add("Excepion in updating investor details !");
				outputVO.setResponseList(outputList);
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Could not rollback transaction" + rbe);
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return outputVO;
	}

}
