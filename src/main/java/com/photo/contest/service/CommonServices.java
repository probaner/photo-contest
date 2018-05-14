package com.photo.contest.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.MailRecipientDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.model.Users;
import com.photo.contest.utility.CommonUtil;



@Service
public class CommonServices {

	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private ConfigProperty configProperty;

	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	public boolean userIsNative(UserDTO userDTO) {
		List<String> netiveCountryList = Arrays.asList(configProperty.getNetiveCountry().split(","));
		if (netiveCountryList.contains(userDTO.getCountry().toUpperCase()))
			return true;
		else
			return false;

	}

	public void sendRegistrationConfirmMail(Users users) {

		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();

		mailRecipientDTO.setSender("salonechnchy@gmail.com");
		mailRecipientDTO.setRecipient(users.getEmail());
		mailRecipientDTO.setMessage("Registration Sucess \nRegistration Id:" + users.getUserId() + "\nUser Id: "
				+ users.getEmail() + "\n Password: " + users.getPassword() + " \n");
		mailRecipientDTO.setSubject("Registration Success");
		commonUtil.doSendEmail(mailRecipientDTO, null);

	}

	public void sendCreateCouponCodeMailforaUser(Users users, String couponCode, String bcc) {
		MailRecipientDTO mailRecipientDTO = new MailRecipientDTO();
		mailRecipientDTO.setSender("salonechnchy@gmail.com");
		mailRecipientDTO.setRecipient(users.getEmail());
		mailRecipientDTO.setMessage("couponCode=" + couponCode);
		mailRecipientDTO.setSubject("Coupon Code Details");

		commonUtil.doSendEmail(mailRecipientDTO, bcc);
	}

	public void sendQueryEmail(MailRecipientDTO mailRecipientDTO) {
		mailRecipientDTO.setRecipient("salonechnchy@gmail.com");

		commonUtil.doSendEmail(mailRecipientDTO, null);
	}

	public UserDTO createCurrentUserDTO(Users user, UserDTO userDTO) {

		userDTO.setUserid(user.getUserId());
		userDTO.setFirstname(user.getFirstName());
		userDTO.setLastname(user.getLastName());
		// userDTO.setLastname(user.getLastName());
		userDTO.setCountry(user.getCountry());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}

	public boolean checkPersentInpout(String value) {
		String pattern = "(\\d{1,2})";
		if (value.matches(pattern))
			return true;
		else
			return false;
	}

	public boolean checkNumberOnly(String value) {
		String regex = "\\d+";
		System.out.println(value.matches(regex));

		return value.matches(regex);
	}

	public String createCouponCode(Integer id, String fName, String lName) {

		return (lName.substring(lName.length() - 1, lName.length())
				+ fName.substring(fName.length() - 1, fName.length()) + "-" + id.toString().substring(1, 6));
	}

	public String saveFile(String directoryName, CommonsMultipartFile image) {

		String saveDirName = commonUtil.directoryCheck(directoryName);

		String fileName = image.getOriginalFilename();
		File uplodedFile = new File(saveDirName, fileName);
		try {
			image.transferTo(uplodedFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveDirName;
	}

	public void deleteFileFromDirectory(String fileName) {

		String filePath = configProperty.getBasePath() + File.separator + fileName;

		try {
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getExpairStatus() {
		if (commonUtil.findNumberofDaysBetweenTwoDate(configProperty.getCloseDate(),
				commonUtil.getDateTime().substring(0, commonUtil.getDateTime().indexOf(" "))) >= 0)
			return true;
		else
			return false;
	}

}
