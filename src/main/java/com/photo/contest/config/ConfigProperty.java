package com.photo.contest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class ConfigProperty {
	
	
	@Value("${site.name}")
	private String sitename;
	@Value("${index.name}")
	private String indexName;
	@Value("${index.image}")
	private String indexImage;
	@Value("${header.left}")
	private String headerLeft;
	@Value("${header.middle}")
	private String headerMiddle;
	@Value("${header.right}")
	private String headerRight;
	@Value("${judgepage.image}")
	private String judgepageImage;
	@Value("${homepage.image}")
	private String homepageImage;
		
	@Value("${base.path}")
	private String basePath;
	@Value("${file.maxsize}")
	private Long maxSize;
	@Value("${chargeing.type.category_wise.netive}")
	private String chargeingTypeCategoryWiseNetive;
	@Value("${chargeing.type.category_wise.foreign}")
	private String chargeingTypeCategoryWiseForeign;
	@Value("${chargeing.type.indivisual_photo_wise.netive}")
	private String chargeingTypeIndivisualPhotoWiseNetive;
	@Value("${chargeing.type.indivisual_photo_wise.foreign}")
	private String chargeingTypeIndivisualPhotoWiseForeign;
	@Value("${chargeing.type.overall.netive}")
	private String chargeingTypeOverallNetive;
	@Value("${chargeing.type.overall.foreign}")
	private String chargeingTypeOverallForeign;
	@Value("${category.one}")
	private String categoryOne;
	@Value("${category.two}")
	private String categoryTwo;
	@Value("${category.three}")
	private String categoryThree;
	@Value("${category.four}")
	private String categoryFour;
	@Value("${category.five}")
	private String categoryFive;
	@Value("${category.six}")
	private String categorySix;
	@Value("${category.saven}")
	private String categorySeven;
	@Value("${category.eight}")
	private String categoryEight;
	@Value("${category.nine}")
	private String categoryNine;
	@Value("${category.ten}")
	private String categoryTen;
	@Value("${category.one.netive}")
	private String categoryOneNetive;
	@Value("${category.two.netive}")
	private String categoryTwoNetive;
	@Value("${category.three.netive}")
	private String categoryThreeNetive;
	@Value("${category.four.netive}")
	private String categoryFourNetive;
	@Value("${category.five.netive}")
	private String categoryFiveNetive;
	@Value("${category.six.netive}")
	private String categorySixNetive;
	@Value("${category.saven.netive}")
	private String categorySevenNetive;
	@Value("${category.eight.netive}")
	private String categoryEightNetive;
	@Value("${category.nine.netive}")
	private String categoryNineNetive;
	@Value("${category.ten.netive}")
	private String categoryTenNetive;
	@Value("${overall}")
	private String overall;
	@Value("${overall.netive}")
	private String overallNetive;
	@Value("${netive.country}")
	private String netiveCountry;
	@Value("${netive.currency.name}")
	private String netiveCurrencyName;
	@Value("${foreign.currency.name}")
	private String foreignCurrencyName;
	@Value("${close.date}")
	private String closeDate;
	
	@Value("${file.maxlongestSideResolution}")
	private String fileMaxlongestSideResolution;
	@Value("${file.minlongestSideResolution}")
	private String fileMinlongestSideResolution;
	
	@Value("${judging.startdate}")
	private String judgingStartdate;
	@Value("${judging.enddate}")
	private String judgingEnddate;
	@Value("${judg.loginurl}")
	private String judgloginurl;
	
	@Value("${salon.name}")
	private String salonName;
	@Value("${salon.patronage}")
	private String salonPatronage;
	@Value("${result.dest}")
	private String resultDest;
	@Value("${result.date}")
	private String resultDate;
	
	@Value("${mail.sender}")
	private String mailsender;	
	@Value("${mail.password}")
	private String mailpassword;	
	@Value("${registrarionsuccess.comment}")
	private String registrarionsuccesscomment;
	@Value("${registrarionsuccess.image}")
	private String registrarionsuccessimage;
	
	
	
	public ConfigProperty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigProperty(String sitename, String indexName, String indexImage, String headerLeft, String headerMiddle,
			String headerRight, String judgepageImage, String homepageImage, String basePath, Long maxSize,
			String chargeingTypeCategoryWiseNetive, String chargeingTypeCategoryWiseForeign,
			String chargeingTypeIndivisualPhotoWiseNetive, String chargeingTypeIndivisualPhotoWiseForeign,
			String chargeingTypeOverallNetive, String chargeingTypeOverallForeign, String categoryOne,
			String categoryTwo, String categoryThree, String categoryFour, String categoryFive, String categorySix,
			String categorySeven, String categoryEight, String categoryNine, String categoryTen,
			String categoryOneNetive, String categoryTwoNetive, String categoryThreeNetive, String categoryFourNetive,
			String categoryFiveNetive, String categorySixNetive, String categorySevenNetive, String categoryEightNetive,
			String categoryNineNetive, String categoryTenNetive, String overall, String overallNetive,
			String netiveCountry, String netiveCurrencyName, String foreignCurrencyName, String closeDate,
			String fileMaxlongestSideResolution, String fileMinlongestSideResolution, String judgingStartdate,
			String judgingEnddate, String judgloginurl, String salonName, String salonPatronage, String resultDest,
			String resultDate, String mailsender, String mailpassword, String registrarionsuccesscomment,
			String registrarionsuccessimage) {
		super();
		this.sitename = sitename;
		this.indexName = indexName;
		this.indexImage = indexImage;
		this.headerLeft = headerLeft;
		this.headerMiddle = headerMiddle;
		this.headerRight = headerRight;
		this.judgepageImage = judgepageImage;
		this.homepageImage = homepageImage;
		this.basePath = basePath;
		this.maxSize = maxSize;
		this.chargeingTypeCategoryWiseNetive = chargeingTypeCategoryWiseNetive;
		this.chargeingTypeCategoryWiseForeign = chargeingTypeCategoryWiseForeign;
		this.chargeingTypeIndivisualPhotoWiseNetive = chargeingTypeIndivisualPhotoWiseNetive;
		this.chargeingTypeIndivisualPhotoWiseForeign = chargeingTypeIndivisualPhotoWiseForeign;
		this.chargeingTypeOverallNetive = chargeingTypeOverallNetive;
		this.chargeingTypeOverallForeign = chargeingTypeOverallForeign;
		this.categoryOne = categoryOne;
		this.categoryTwo = categoryTwo;
		this.categoryThree = categoryThree;
		this.categoryFour = categoryFour;
		this.categoryFive = categoryFive;
		this.categorySix = categorySix;
		this.categorySeven = categorySeven;
		this.categoryEight = categoryEight;
		this.categoryNine = categoryNine;
		this.categoryTen = categoryTen;
		this.categoryOneNetive = categoryOneNetive;
		this.categoryTwoNetive = categoryTwoNetive;
		this.categoryThreeNetive = categoryThreeNetive;
		this.categoryFourNetive = categoryFourNetive;
		this.categoryFiveNetive = categoryFiveNetive;
		this.categorySixNetive = categorySixNetive;
		this.categorySevenNetive = categorySevenNetive;
		this.categoryEightNetive = categoryEightNetive;
		this.categoryNineNetive = categoryNineNetive;
		this.categoryTenNetive = categoryTenNetive;
		this.overall = overall;
		this.overallNetive = overallNetive;
		this.netiveCountry = netiveCountry;
		this.netiveCurrencyName = netiveCurrencyName;
		this.foreignCurrencyName = foreignCurrencyName;
		this.closeDate = closeDate;
		this.fileMaxlongestSideResolution = fileMaxlongestSideResolution;
		this.fileMinlongestSideResolution = fileMinlongestSideResolution;
		this.judgingStartdate = judgingStartdate;
		this.judgingEnddate = judgingEnddate;
		this.judgloginurl = judgloginurl;
		this.salonName = salonName;
		this.salonPatronage = salonPatronage;
		this.resultDest = resultDest;
		this.resultDate = resultDate;
		this.mailsender = mailsender;
		this.mailpassword = mailpassword;
		this.registrarionsuccesscomment = registrarionsuccesscomment;
		this.registrarionsuccessimage = registrarionsuccessimage;
	}





	public String getIndexName() {
		return indexName;
	}


	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}


	public String getIndexImage() {
		return indexImage;
	}


	public void setIndexImage(String indexImage) {
		this.indexImage = indexImage;
	}


	public String getHeaderLeft() {
		return headerLeft;
	}


	public void setHeaderLeft(String headerLeft) {
		this.headerLeft = headerLeft;
	}


	public String getHeaderMiddle() {
		return headerMiddle;
	}


	public void setHeaderMiddle(String headerMiddle) {
		this.headerMiddle = headerMiddle;
	}


	public String getHeaderRight() {
		return headerRight;
	}


	public void setHeaderRight(String headerRight) {
		this.headerRight = headerRight;
	}


	public String getJudgepageImage() {
		return judgepageImage;
	}


	public void setJudgepageImage(String judgepageImage) {
		this.judgepageImage = judgepageImage;
	}


	public String getHomepageImage() {
		return homepageImage;
	}


	public void setHomepageImage(String homepageImage) {
		this.homepageImage = homepageImage;
	}


	public String getBasePath() {
		return basePath;
	}


	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}


	public Long getMaxSize() {
		return maxSize;
	}


	public void setMaxSize(Long maxSize) {
		this.maxSize = maxSize;
	}


	public String getChargeingTypeCategoryWiseNetive() {
		return chargeingTypeCategoryWiseNetive;
	}


	public void setChargeingTypeCategoryWiseNetive(String chargeingTypeCategoryWiseNetive) {
		this.chargeingTypeCategoryWiseNetive = chargeingTypeCategoryWiseNetive;
	}


	public String getChargeingTypeCategoryWiseForeign() {
		return chargeingTypeCategoryWiseForeign;
	}


	public void setChargeingTypeCategoryWiseForeign(String chargeingTypeCategoryWiseForeign) {
		this.chargeingTypeCategoryWiseForeign = chargeingTypeCategoryWiseForeign;
	}


	public String getChargeingTypeIndivisualPhotoWiseNetive() {
		return chargeingTypeIndivisualPhotoWiseNetive;
	}


	public void setChargeingTypeIndivisualPhotoWiseNetive(String chargeingTypeIndivisualPhotoWiseNetive) {
		this.chargeingTypeIndivisualPhotoWiseNetive = chargeingTypeIndivisualPhotoWiseNetive;
	}


	public String getChargeingTypeIndivisualPhotoWiseForeign() {
		return chargeingTypeIndivisualPhotoWiseForeign;
	}


	public void setChargeingTypeIndivisualPhotoWiseForeign(String chargeingTypeIndivisualPhotoWiseForeign) {
		this.chargeingTypeIndivisualPhotoWiseForeign = chargeingTypeIndivisualPhotoWiseForeign;
	}


	public String getChargeingTypeOverallNetive() {
		return chargeingTypeOverallNetive;
	}


	public void setChargeingTypeOverallNetive(String chargeingTypeOverallNetive) {
		this.chargeingTypeOverallNetive = chargeingTypeOverallNetive;
	}


	public String getChargeingTypeOverallForeign() {
		return chargeingTypeOverallForeign;
	}


	public void setChargeingTypeOverallForeign(String chargeingTypeOverallForeign) {
		this.chargeingTypeOverallForeign = chargeingTypeOverallForeign;
	}


	public String getCategoryOne() {
		return categoryOne;
	}


	public void setCategoryOne(String categoryOne) {
		this.categoryOne = categoryOne;
	}


	public String getCategoryTwo() {
		return categoryTwo;
	}


	public void setCategoryTwo(String categoryTwo) {
		this.categoryTwo = categoryTwo;
	}


	public String getCategoryThree() {
		return categoryThree;
	}


	public void setCategoryThree(String categoryThree) {
		this.categoryThree = categoryThree;
	}


	public String getCategoryFour() {
		return categoryFour;
	}


	public void setCategoryFour(String categoryFour) {
		this.categoryFour = categoryFour;
	}


	public String getCategoryFive() {
		return categoryFive;
	}


	public void setCategoryFive(String categoryFive) {
		this.categoryFive = categoryFive;
	}


	public String getCategorySix() {
		return categorySix;
	}


	public void setCategorySix(String categorySix) {
		this.categorySix = categorySix;
	}


	public String getCategorySeven() {
		return categorySeven;
	}


	public void setCategorySeven(String categorySeven) {
		this.categorySeven = categorySeven;
	}


	public String getCategoryEight() {
		return categoryEight;
	}


	public void setCategoryEight(String categoryEight) {
		this.categoryEight = categoryEight;
	}


	public String getCategoryNine() {
		return categoryNine;
	}


	public void setCategoryNine(String categoryNine) {
		this.categoryNine = categoryNine;
	}


	public String getCategoryTen() {
		return categoryTen;
	}


	public void setCategoryTen(String categoryTen) {
		this.categoryTen = categoryTen;
	}


	public String getCategoryOneNetive() {
		return categoryOneNetive;
	}


	public void setCategoryOneNetive(String categoryOneNetive) {
		this.categoryOneNetive = categoryOneNetive;
	}


	public String getCategoryTwoNetive() {
		return categoryTwoNetive;
	}


	public void setCategoryTwoNetive(String categoryTwoNetive) {
		this.categoryTwoNetive = categoryTwoNetive;
	}


	public String getCategoryThreeNetive() {
		return categoryThreeNetive;
	}


	public void setCategoryThreeNetive(String categoryThreeNetive) {
		this.categoryThreeNetive = categoryThreeNetive;
	}


	public String getCategoryFourNetive() {
		return categoryFourNetive;
	}


	public void setCategoryFourNetive(String categoryFourNetive) {
		this.categoryFourNetive = categoryFourNetive;
	}


	public String getCategoryFiveNetive() {
		return categoryFiveNetive;
	}


	public void setCategoryFiveNetive(String categoryFiveNetive) {
		this.categoryFiveNetive = categoryFiveNetive;
	}


	public String getCategorySixNetive() {
		return categorySixNetive;
	}


	public void setCategorySixNetive(String categorySixNetive) {
		this.categorySixNetive = categorySixNetive;
	}


	public String getCategorySevenNetive() {
		return categorySevenNetive;
	}


	public void setCategorySevenNetive(String categorySevenNetive) {
		this.categorySevenNetive = categorySevenNetive;
	}


	public String getCategoryEightNetive() {
		return categoryEightNetive;
	}


	public void setCategoryEightNetive(String categoryEightNetive) {
		this.categoryEightNetive = categoryEightNetive;
	}


	public String getCategoryNineNetive() {
		return categoryNineNetive;
	}


	public void setCategoryNineNetive(String categoryNineNetive) {
		this.categoryNineNetive = categoryNineNetive;
	}


	public String getCategoryTenNetive() {
		return categoryTenNetive;
	}


	public void setCategoryTenNetive(String categoryTenNetive) {
		this.categoryTenNetive = categoryTenNetive;
	}


	public String getOverall() {
		return overall;
	}


	public void setOverall(String overall) {
		this.overall = overall;
	}


	public String getOverallNetive() {
		return overallNetive;
	}


	public void setOverallNetive(String overallNetive) {
		this.overallNetive = overallNetive;
	}


	public String getNetiveCountry() {
		return netiveCountry;
	}


	public void setNetiveCountry(String netiveCountry) {
		this.netiveCountry = netiveCountry;
	}


	public String getNetiveCurrencyName() {
		return netiveCurrencyName;
	}


	public void setNetiveCurrencyName(String netiveCurrencyName) {
		this.netiveCurrencyName = netiveCurrencyName;
	}


	public String getForeignCurrencyName() {
		return foreignCurrencyName;
	}


	public void setForeignCurrencyName(String foreignCurrencyName) {
		this.foreignCurrencyName = foreignCurrencyName;
	}


	public String getCloseDate() {
		return closeDate;
	}


	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}


	public String getFileMaxlongestSideResolution() {
		return fileMaxlongestSideResolution;
	}


	public void setFileMaxlongestSideResolution(String fileMaxlongestSideResolution) {
		this.fileMaxlongestSideResolution = fileMaxlongestSideResolution;
	}


	public String getFileMinlongestSideResolution() {
		return fileMinlongestSideResolution;
	}


	public void setFileMinlongestSideResolution(String fileMinlongestSideResolution) {
		this.fileMinlongestSideResolution = fileMinlongestSideResolution;
	}


	public String getJudgingStartdate() {
		return judgingStartdate;
	}


	public void setJudgingStartdate(String judgingStartdate) {
		this.judgingStartdate = judgingStartdate;
	}


	public String getJudgingEnddate() {
		return judgingEnddate;
	}


	public void setJudgingEnddate(String judgingEnddate) {
		this.judgingEnddate = judgingEnddate;
	}


	public String getJudgloginurl() {
		return judgloginurl;
	}


	public void setJudgloginurl(String judgloginurl) {
		this.judgloginurl = judgloginurl;
	}


	public String getSalonName() {
		return salonName;
	}


	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}


	public String getSalonPatronage() {
		return salonPatronage;
	}


	public void setSalonPatronage(String salonPatronage) {
		this.salonPatronage = salonPatronage;
	}


	public String getResultDest() {
		return resultDest;
	}


	public void setResultDest(String resultDest) {
		this.resultDest = resultDest;
	}


	public String getResultDate() {
		return resultDate;
	}


	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}


	public String getMailsender() {
		return mailsender;
	}


	public void setMailsender(String mailsender) {
		this.mailsender = mailsender;
	}


	public String getMailpassword() {
		return mailpassword;
	}


	public void setMailpassword(String mailpassword) {
		this.mailpassword = mailpassword;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getRegistrarionsuccesscomment() {
		return registrarionsuccesscomment;
	}

	public void setRegistrarionsuccesscomment(String registrarionsuccesscomment) {
		this.registrarionsuccesscomment = registrarionsuccesscomment;
	}

	public String getRegistrarionsuccessimage() {
		return registrarionsuccessimage;
	}

	public void setRegistrarionsuccessimage(String registrarionsuccessimage) {
		this.registrarionsuccessimage = registrarionsuccessimage;
	}
				
}
