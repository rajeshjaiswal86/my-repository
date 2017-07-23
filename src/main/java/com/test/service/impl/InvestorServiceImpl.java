package com.test.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.dao.InvestorDAO;
import com.test.service.InvestorService;
import com.test.vo.InputVO;
import com.test.vo.OutputVO;
/**
 * 
 * @author Rajesh
 *
 */
@Service
public class InvestorServiceImpl implements InvestorService{
    @Autowired
    private InvestorDAO invDAO;
	@Override
	public OutputVO createInvestor(InputVO inputVO) {
		return invDAO.createInvestor(inputVO);
	}
	@Override
	public OutputVO updateInvestor(InputVO inputVO) {
		return invDAO.updateInvestor(inputVO);	
	}

}
