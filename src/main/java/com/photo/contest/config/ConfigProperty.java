package com.photo.contest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class ConfigProperty {
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
	
	
	public ConfigProperty() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public ConfigProperty(String basePath, Long maxSize, String chargeingTypeCategoryWiseNetive,
			String chargeingTypeCategoryWiseForeign, String chargeingTypeIndivisualPhotoWiseNetive,
			String chargeingTypeIndivisualPhotoWiseForeign, String chargeingTypeOverallNetive,
			String chargeingTypeOverallForeign, String categoryOne, String categoryTwo, String categoryThree,
			String categoryFour, String categoryFive, String categorySix, String categorySeven, String categoryEight,
			String categoryNine, String categoryTen, String categoryOneNetive, String categoryTwoNetive,
			String categoryThreeNetive, String categoryFourNetive, String categoryFiveNetive, String categorySixNetive,
			String categorySevenNetive, String categoryEightNetive, String categoryNineNetive, String categoryTenNetive,
			String overall, String overallNetive, String netiveCountry, String netiveCurrencyName,
			String foreignCurrencyName, String closeDate) {
		super();
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




	
}
