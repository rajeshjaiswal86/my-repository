package com.test.utils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import com.test.constant.Constant;
import com.test.vo.InputVO;
import com.test.vo.ValidateVO;
/**
 * 
 * @author Rajesh
 *
 */
public class ValidationUtils {
	   public static ValidateVO validateInput(InputVO inputVO){
			
		    ValidateVO validateVO = new ValidateVO();
			List<String>  resultList = new ArrayList<String>();
			boolean errorFlag=false;
			
			if(inputVO!=null && StringUtils.isBlank(inputVO.getName())){
				resultList.add(Constant.ERROR_MSG_NAME);
				errorFlag=true;
			}
			if(inputVO!=null && StringUtils.isBlank(inputVO.getEmail())){
				resultList.add(Constant.ERROR_MSG_EMAIL);
				errorFlag=true;
			}
			if(inputVO!=null && StringUtils.isBlank(inputVO.getMobileNumber())){
				resultList.add(Constant.ERROR_MSG_MOBILE_NUM);
				errorFlag=true;
			}
			if(inputVO!=null && StringUtils.isBlank(inputVO.getResidentialStatus())){
				resultList.add(Constant.ERROR_MSG_RESI_STATUS);
				errorFlag=true;
			}
		    if(inputVO!=null && inputVO.getPermanentAddress()!=null){
		    	if(StringUtils.isBlank(inputVO.getPermanentAddress().getLine1())){
		    		resultList.add(Constant.ERROR_MSG_PERM_ADD_LINE1);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getPermanentAddress().getLine2())){
		    		resultList.add(Constant.ERROR_MSG_PERM_ADD_LINE2);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getPermanentAddress().getPincode())){
		    		resultList.add(Constant.ERROR_MSG_PERM_ADD_PIN_CODE);
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getPermanentAddress().getCity())){
		    		resultList.add(Constant.ERROR_MSG_PERM_ADD_CITY);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getPermanentAddress().getState())){
		    		resultList.add(Constant.ERROR_MSG_PERM_ADD_STATE);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getPermanentAddress().getCountry())){
		    		resultList.add(Constant.ERROR_MSG_PERM_ADD_COUNTRY);
		    		errorFlag=true;
		    	}
			}
		    else{
		    	resultList.add(Constant.ERROR_MSG_PERM_ADD_MANDATORY);
		    	errorFlag=true;
		    }
		    if(inputVO!=null && inputVO.getPermanentAddress()!=null
		    		         && inputVO.getCorrespondenceAddress()!=null
		    		         && (!inputVO.getPermanentAddress().getLine1().equalsIgnoreCase(inputVO.getCorrespondenceAddress().getLine1())
		    		        	 || !inputVO.getPermanentAddress().getLine2().equalsIgnoreCase(inputVO.getCorrespondenceAddress().getLine2())
		    		        	 || !inputVO.getPermanentAddress().getPincode().equalsIgnoreCase(inputVO.getCorrespondenceAddress().getPincode())
		    		        	 || !inputVO.getPermanentAddress().getCity().equalsIgnoreCase(inputVO.getCorrespondenceAddress().getCity())
		    		        	 || !inputVO.getPermanentAddress().getState().equalsIgnoreCase(inputVO.getCorrespondenceAddress().getState())
		    		        	 || !inputVO.getPermanentAddress().getCountry().equalsIgnoreCase(inputVO.getCorrespondenceAddress().getCountry()))){
		    	if(StringUtils.isBlank(inputVO.getCorrespondenceAddress().getLine1())){
		    		resultList.add(Constant.ERROR_MSG_CORR_ADD_LINE1);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getCorrespondenceAddress().getLine2())){
		    		resultList.add(Constant.ERROR_MSG_CORR_ADD_LINE2);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getCorrespondenceAddress().getPincode())){
		    		resultList.add(Constant.ERROR_MSG_CORR_ADD_PIN_CODE);
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getCorrespondenceAddress().getCity())){
		    		resultList.add(Constant.ERROR_MSG_CORR_ADD_CITY);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getCorrespondenceAddress().getState())){
		    		resultList.add(Constant.ERROR_MSG_CORR_ADD_STATE);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getCorrespondenceAddress().getCountry())){
		    		resultList.add(Constant.ERROR_MSG_CORR_ADD_COUNTRY);
		    		errorFlag=true;
		    	}
		    	
		    }
		    if(inputVO!=null && inputVO.getPermanentAddress()!=null
		    		         && StringUtils.isNotBlank(inputVO.getResidentialStatus())
		    		         && inputVO.getResidentialStatus().equalsIgnoreCase("Indian")
		    		         && inputVO.getOverseasAddress()!=null){
		    	resultList.add(Constant.ERROR_MSG_OVER_ADD_IF_RESI_INDIAN);
		    	errorFlag=true;
		    }
		    if(inputVO!=null && inputVO.getPermanentAddress()!=null
			         && StringUtils.isNotBlank(inputVO.getResidentialStatus())
			         && inputVO.getResidentialStatus().equalsIgnoreCase("NRI")
			         && inputVO.getOverseasAddress()!=null){
		    	if(StringUtils.isBlank(inputVO.getOverseasAddress().getLine1())){
		    		resultList.add(Constant.ERROR_MSG_OVER_ADD_LINE1);
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getOverseasAddress().getLine2())){
		    		resultList.add(Constant.ERROR_MSG_OVER_ADD_LINE2);
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getOverseasAddress().getPincode())){
		    		resultList.add(Constant.ERROR_MSG_OVER_ADD_PIN_CODE);
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getOverseasAddress().getCity())){
		    		resultList.add(Constant.ERROR_MSG_OVER_ADD_CITY);	
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getOverseasAddress().getState())){
		    		resultList.add(Constant.ERROR_MSG_OVER_ADD_STATE);
		    		errorFlag=true;
		    	}
		    	if(StringUtils.isBlank(inputVO.getOverseasAddress().getCountry())){
		    		resultList.add(Constant.ERROR_MSG_OVER_ADD_COUNTRY);	
		    		errorFlag=true;
		    	}
		    	
		    }
		    validateVO.setErrorList(resultList);
		    validateVO.setErrorFlag(errorFlag);
			return validateVO;
		}
}
