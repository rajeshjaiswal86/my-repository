package com.test.service;

import com.test.vo.InputVO;
import com.test.vo.OutputVO;
/**
 * 
 * @author Rajesh
 *
 */
public interface InvestorService {
	public OutputVO createInvestor(InputVO inputVO);
	public OutputVO updateInvestor(InputVO inputVO);
}
