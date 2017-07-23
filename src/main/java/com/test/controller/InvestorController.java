package com.test.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.service.InvestorService;
import com.test.utils.ValidationUtils;
import com.test.vo.InputVO;
import com.test.vo.OutputVO;
import com.test.vo.ValidateVO;
/**
 * 
 * @author Rajesh
 *
 */
@Controller
public class InvestorController {
	@Autowired
	private InvestorService invService;
	
    @RequestMapping(value = "/createInvestor", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
	public @ResponseBody
    ResponseEntity<?> createInvestor(@RequestBody InputVO inputVO) {
    
    OutputVO outputVO = new OutputVO();
	ValidateVO validateVO=new ValidateVO();
	validateVO = ValidationUtils.validateInput(inputVO);
    if(validateVO!=null && validateVO.isErrorFlag()){
    	outputVO.setResponseList(validateVO.getErrorList());
    }
    else{
	    outputVO = invService.createInvestor(inputVO);
	}
	return new ResponseEntity<OutputVO>(outputVO,HttpStatus.OK);

	}
    @RequestMapping(value = "/updateInvestor", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.PUT)
	public @ResponseBody
    ResponseEntity<?> updateInvestor(@RequestBody InputVO inputVO) {
    
    OutputVO outputVO = new OutputVO();
	ValidateVO validateVO=new ValidateVO();
	validateVO = ValidationUtils.validateInput(inputVO);
    if(validateVO!=null && validateVO.isErrorFlag()){
    	outputVO.setResponseList(validateVO.getErrorList());
    }
    else{
	    outputVO = invService.updateInvestor(inputVO);
	}
	return new ResponseEntity<OutputVO>(outputVO,HttpStatus.OK);

	}
}