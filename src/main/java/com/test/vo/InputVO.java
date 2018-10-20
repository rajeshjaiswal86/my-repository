package com.test.vo;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author Rajesh
 *
 */
@Entity
@Table(name = "INVESTOR")
@JsonIgnoreProperties
public class InputVO {
	private long id;
	private String name;
	private String email;
	private String mobileNumber;
	private String residentialStatus;
	private PermanentAddVO permanentAddress;
	private CorrespondenceAddVO correspondenceAddress;
	private OverseasAddVO overseasAddress;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "MOBILE_NUMBER")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Column(name = "RESIDENTIAL_STATUS")
	public String getResidentialStatus() {
		return residentialStatus;
	}

	public void setResidentialStatus(String residentialStatus) {
		this.residentialStatus = residentialStatus;
	}
	@Embedded
	public PermanentAddVO getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(PermanentAddVO permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	@Embedded
	public CorrespondenceAddVO getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(
			CorrespondenceAddVO correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}
	@Embedded
	public OverseasAddVO getOverseasAddress() {
		return overseasAddress;
	}

	public void setOverseasAddress(OverseasAddVO overseasAddress) {
		this.overseasAddress = overseasAddress;
	}
}
