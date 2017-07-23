package com.test.dao;
import com.test.vo.InputVO;
import com.test.vo.OutputVO;
/**
 * 
 * @author Rajesh
 *
 */
public interface InvestorDAO {
	public OutputVO createInvestor(InputVO inputVO);
	public OutputVO updateInvestor(InputVO inputVO);
}
