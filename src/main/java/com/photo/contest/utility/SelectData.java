package com.photo.contest.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.photo.contest.dto.ClubDTO;
import com.photo.contest.model.OrganizerClub;

@Component
public class SelectData {
	
	
	public List<String> genderData(){
		
		List<String> gerderList =new ArrayList<>();
		gerderList.add("Sex");
		gerderList.add("Female");
		gerderList.add("Male");
		return gerderList;
		
	}
	
	public List<String> getCategoryList(Map<String, Integer> categoryMap){
		
		List<String> categoryList = new ArrayList<String>(categoryMap.keySet());
		
		return categoryList;
		
	}
	
	
	public Map<String,String> organizerClubList(List<OrganizerClub> organizerClubDTOList) {

		Map<String,String> clubData = new HashMap<>();
		clubData.put("", "select club name");
		if (organizerClubDTOList.size() > 0) {
			for (OrganizerClub organizerClub : organizerClubDTOList) {
				 clubData.put(organizerClub.getOrganizerclubname(), organizerClub.getOrganizerclubname());
			    }
		   }
		 return clubData;
	}
	
   public Map<String,String> countryData(){
	   
	   Map<String,String> countryList =new HashMap<>();
	   
	   countryList.put("","Select Country");
	   countryList.put("Afghanistan","Afghanistan");
	   countryList.put("Åland Islands","Åland Islands");
	   countryList.put("Albania","Albania");
	   countryList.put("Algeria","Algeria");
	   countryList.put("American Samoa","American Samoa");
	   countryList.put("Andorra","Andorra");
	   countryList.put("Angola","Angola");
	   countryList.put("Anguilla","Anguilla");
	   countryList.put("Antarctica","Antarctica");
	   countryList.put("Antigua and Barbuda","Antigua and Barbuda");
	   countryList.put("Argentina","Argentina");
	   countryList.put("Armenia","Armenia");
	   countryList.put("Aruba","Aruba");
	   countryList.put("Australia","Australia");
	   countryList.put("Austria","Austria");
	   countryList.put("Azerbaijan","Azerbaijan");
	   countryList.put("Bahamas","Bahamas");
	   countryList.put("Bahrain","Bahrain");
	   countryList.put("Bangladesh","Bangladesh");
	   countryList.put("Barbados","Barbados");
	   countryList.put("Belarus","Belarus");
	   countryList.put("Belgium","Belgium");
	   countryList.put("Belize","Belize");
	   countryList.put("Benin","Benin");
	   countryList.put("Bermuda","Bermuda");
	   countryList.put("Bhutan","Bhutan");
	   countryList.put("Bolivia, Plurinational State of","Bolivia, Plurinational State of");
	   countryList.put("Bonaire, Sint Eustatius and Saba","Bonaire, Sint Eustatius and Saba");
	   countryList.put("Bosnia and Herzegovina","Bosnia and Herzegovina");
	   countryList.put("Botswana","Botswana");
	   countryList.put("Bouvet Island","Bouvet Island");
	   countryList.put("Brazil","Brazil");
	   countryList.put("British Indian Ocean Territory","British Indian Ocean Territory");
	   countryList.put("Brunei Darussalam","Brunei Darussalam");
	   countryList.put("Bulgaria","Bulgaria");
	   countryList.put("Burkina Faso","Burkina Faso");
	   countryList.put("Burundi","Burundi");
	   countryList.put("Cambodia","Cambodia");
	   countryList.put("Cameroon","Cameroon");
	   countryList.put("Canada","Canada");
	   countryList.put("Cape Verde","Cape Verde");
	   countryList.put("Cayman Islands","Cayman Islands");
	   countryList.put("Central African Republic","Central African Republic");
	   countryList.put("Chad","Chad");
	   countryList.put("Chile","Chile");
	   countryList.put("China","China");
	   countryList.put("Christmas Island","Christmas Island");
	   countryList.put("Cocos (Keeling) Islands","Cocos (Keeling) Islands");
	   countryList.put("Colombia","Colombia");
	   countryList.put("Comoros","Comoros");
	   countryList.put("Congo","Congo");
	   countryList.put("Congo, the Democratic Republic of the","Congo, the Democratic Republic of the");
	   countryList.put("Cook Islands","Cook Islands");
	   countryList.put("Costa Rica","Costa Rica");
	   countryList.put("Côte d'Ivoire","Côte d'Ivoire");
	   countryList.put("Croatia","Croatia");
	   countryList.put("Cuba","Cuba");
	   countryList.put("Curaçao","Curaçao");
	   countryList.put("Cyprus","Cyprus");
	   countryList.put("Czech Republic","Czech Republic");
	   countryList.put("Denmark","Denmark");
	   countryList.put("Djibouti","Djibouti");
	   countryList.put("Dominica","Dominica");
	   countryList.put("Dominican Republic","Dominican Republic");
	   countryList.put("Ecuador","Ecuador");
	   countryList.put("Egypt","Egypt");
	   countryList.put("El Salvador","El Salvador");
	   countryList.put("Equatorial Guinea","Equatorial Guinea");
	   countryList.put("Eritrea","Eritrea");
	   countryList.put("Estonia","Estonia");
	   countryList.put("Ethiopia","Ethiopia");
	   countryList.put("Falkland Islands (Malvinas)","Falkland Islands (Malvinas)");
	   countryList.put("Faroe Islands","Faroe Islands");
	   countryList.put("Fiji","Fiji");
	   countryList.put("Finland","Finland");
	   countryList.put("France","France");
	   countryList.put("French Guiana","French Guiana");
	   countryList.put("French Polynesia","French Polynesia");
	   countryList.put("French Southern Territories","French Southern Territories");
	   countryList.put("Gabon","Gabon");
	   countryList.put("Gambia","Gambia");
	   countryList.put("Georgia","Georgia");
	   countryList.put("Germany","Germany");
	   countryList.put("Ghana","Ghana");
	   countryList.put("Gibraltar","Gibraltar");
	   countryList.put("Greece","Greece");
	   countryList.put("Greenland","Greenland");
	   countryList.put("Grenada","Grenada");
	   countryList.put("Guadeloupe","Guadeloupe");
	   countryList.put("Guam","Guam");
	   countryList.put("Guatemala","Guatemala");
	   countryList.put("Guernsey","Guernsey");
	   countryList.put("Guinea","Guinea");
	   countryList.put("Guinea-Bissau","Guinea-Bissau");
	   countryList.put("Guyana","Guyana");
	   countryList.put("Haiti","Haiti");
	   countryList.put("Heard Island and McDonald Islands","Heard Island and McDonald Islands");
	   countryList.put("Holy See (Vatican City State)","Holy See (Vatican City State)");
	   countryList.put("Honduras","Honduras");
	   countryList.put("Hong Kong","Hong Kong");
	   countryList.put("Hungary","Hungary");
	   countryList.put("Iceland","Iceland");
	   countryList.put("India","India");
	   countryList.put("Indonesia","Indonesia");
	   countryList.put("Iran, Islamic Republic of","Iran, Islamic Republic of");
	   countryList.put("Iraq","Iraq");
	   countryList.put("Ireland","Ireland");
	   countryList.put("Isle of Man","Isle of Man");
	   countryList.put("Israel","Israel");
	   countryList.put("Italy","Italy");
	   countryList.put("Jamaica","Jamaica");
	   countryList.put("Japan","Japan");
	   countryList.put("Jersey","Jersey");
	   countryList.put("Jordan","Jordan");
	   countryList.put("Kazakhstan","Kazakhstan");
	   countryList.put("Kenya","Kenya");
	   countryList.put("Kiribati","Kiribati");
	   countryList.put("Korea, Democratic People's Republic of","Korea, Democratic People's Republic of");
	   countryList.put("Korea, Republic of","Korea, Republic of");
	   countryList.put("Kuwait","Kuwait");
	   countryList.put("Kyrgyzstan","Kyrgyzstan");
	   countryList.put("Lao People's Democratic Republic","Lao People's Democratic Republic");
	   countryList.put("Latvia","Latvia");
	   countryList.put("Lebanon","Lebanon");
	   countryList.put("Lesotho","Lesotho");
	   countryList.put("Liberia","Liberia");
	   countryList.put("Libya","Libya");
	   countryList.put("Liechtenstein","Liechtenstein");
	   countryList.put("Lithuania","Lithuania");
	   countryList.put("Luxembourg","Luxembourg");
	   countryList.put("Macao","Macao");
	   countryList.put("Macedonia, the former Yugoslav Republic of","Macedonia, the former Yugoslav Republic of");
	   countryList.put("Madagascar","Madagascar");
	   countryList.put("Malawi","Malawi");
	   countryList.put("Malaysia","Malaysia");
	   countryList.put("Maldives","Maldives");
	   countryList.put("Mali","Mali");
	   countryList.put("Malta","Malta");
	   countryList.put("Marshall Islands","Marshall Islands");
	   countryList.put("Martinique","Martinique");
	   countryList.put("Mauritania","Mauritania");
	   countryList.put("Mauritius","Mauritius");
	   countryList.put("Mayotte","Mayotte");
	   countryList.put("Mexico","Mexico");
	   countryList.put("Micronesia, Federated States of","Micronesia, Federated States of");
	   countryList.put("Moldova, Republic of","Moldova, Republic of");
	   countryList.put("Monaco","Monaco");
	   countryList.put("Mongolia","Mongolia");
	   countryList.put("Montenegro","Montenegro");
	   countryList.put("Montserrat","Montserrat");
	   countryList.put("Morocco","Morocco");
	   countryList.put("Mozambique","Mozambique");
	   countryList.put("Myanmar","Myanmar");
	   countryList.put("Namibia","Namibia");
	   countryList.put("Nauru","Nauru");
	   countryList.put("Nepal","Nepal");
	   countryList.put("Netherlands","Netherlands");
	   countryList.put("New Caledonia","New Caledonia");
	   countryList.put("New Zealand","New Zealand");
	   countryList.put("Nicaragua","Nicaragua");
	   countryList.put("Niger","Niger");
	   countryList.put("Nigeria","Nigeria");
	   countryList.put("Niue","Niue");
	   countryList.put("Norfolk Island","Norfolk Island");
	   countryList.put("Northern Mariana Islands","Northern Mariana Islands");
	   countryList.put("Norway","Norway");
	   countryList.put("Oman","Oman");
	   countryList.put("Pakistan","Pakistan");
	   countryList.put("Palau","Palau");
	   countryList.put("Palestinian Territory, Occupied","Palestinian Territory, Occupied");
	   countryList.put("Panama","Panama");
	   countryList.put("Papua New Guinea","Papua New Guinea");
	   countryList.put("Paraguay","Paraguay");
	   countryList.put("Peru","Peru");
	   countryList.put("Philippines","Philippines");
	   countryList.put("Pitcairn","Pitcairn");
	   countryList.put("Poland","Poland");
	   countryList.put("Portugal","Portugal");
	   countryList.put("Puerto Rico","Puerto Rico");
	   countryList.put("Qatar","Qatar");
	   countryList.put("Réunion","Réunion");
	   countryList.put("Romania","Romania");
	   countryList.put("Russian Federation","Russian Federation");
	   countryList.put("Rwanda","Rwanda");
	   countryList.put("Saint Barthélemy","Saint Barthélemy");
	   countryList.put("Saint Helena, Ascension and Tristan da Cunha","Saint Helena, Ascension and Tristan da Cunha");
	   countryList.put("Saint Kitts and Nevis","Saint Kitts and Nevis");
	   countryList.put("Saint Lucia","Saint Lucia");
	   countryList.put("Saint Martin (French part)","Saint Martin (French part)");
	   countryList.put("Saint Pierre and Miquelon","Saint Pierre and Miquelon");
	   countryList.put("Samoa","Samoa");
	   countryList.put("San Marino","San Marino");
	   countryList.put("Sao Tome and Principe","Sao Tome and Principe");
	   countryList.put("Saudi Arabia","Saudi Arabia");
	   countryList.put("Senegal","Senegal");
	   countryList.put("Serbia","Serbia");
	   countryList.put("Seychelles","Seychelles");
	   countryList.put("Sierra Leone","Sierra Leone");
	   countryList.put("Singapore","Singapore");
	   countryList.put("Sint Maarten (Dutch part)","Sint Maarten (Dutch part)");
	   countryList.put("Slovakia","Slovakia");
	   countryList.put("Slovenia","Slovenia");
	   countryList.put("Solomon Islands","Solomon Islands");
	   countryList.put("Somalia","Somalia");
	   countryList.put("South Africa","South Africa");
	   countryList.put("South Georgia and the South Sandwich Islands","South Georgia and the South Sandwich Islands");
	   countryList.put("South Sudan","South Sudan");
	   countryList.put("Spain","Spain");
	   countryList.put("Sri Lanka","Sri Lanka");
	   countryList.put("Sudan","Sudan");
	   countryList.put("Suriname","Suriname");
	   countryList.put("Svalbard and Jan Mayen","Svalbard and Jan Mayen");
	   countryList.put("Swaziland","Swaziland");
	   countryList.put("Sweden","Sweden");
	   countryList.put("Switzerland","Switzerland");
	   countryList.put("Syrian Arab Republic","Syrian Arab Republic");
	   countryList.put("Taiwan, Province of China","Taiwan, Province of China");
	   countryList.put("Tajikistan","Tajikistan");
	   countryList.put("Tanzania, United Republic of","Tanzania, United Republic of");
	   countryList.put("Thailand","Thailand");
	   countryList.put("Timor-Leste","Timor-Leste");
	   countryList.put("Togo","Togo");
	   countryList.put("Tokelau","Tokelau");
	   countryList.put("Tonga","Tonga");
	   countryList.put("Trinidad and Tobago","Trinidad and Tobago");
	   countryList.put("Tunisia","Tunisia");
	   countryList.put("Turkey","Turkey");
	   countryList.put("Turkmenistan","Turkmenistan");
	   countryList.put("Turks and Caicos Islands","Turks and Caicos Islands");
	   countryList.put("Tuvalu","Tuvalu");
	   countryList.put("Uganda","Uganda");
	   countryList.put("Ukraine","Ukraine");
	   countryList.put("United Arab Emirates","United Arab Emirates");
	   countryList.put("United Kingdom","United Kingdom");
	   countryList.put("United States","United States");
	   countryList.put("United States Minor Outlying Islands","United States Minor Outlying Islands");
	   countryList.put("Uruguay","Uruguay");
	   countryList.put("Uzbekistan","Uzbekistan");
	   countryList.put("Vanuatu","Vanuatu");
	   countryList.put("Venezuela, Bolivarian Republic of","Venezuela, Bolivarian Republic of");
	   countryList.put("Viet Nam","Viet Nam");
	   countryList.put("Virgin Islands, British","Virgin Islands, British");
	   countryList.put("Virgin Islands, U.S.","Virgin Islands, U.S.");
	   countryList.put("Wallis and Futuna","Wallis and Futuna");
	   countryList.put("Western Sahara","Western Sahara");
	   countryList.put("Yemen","Yemen");
	   countryList.put("Zambia","Zambia");
	   countryList.put("Zimbabwe","Zimbabwe");

	   
		return countryList;
		
	}
   
   public List<String> clubData(List<ClubDTO> clubList){	   
	   List<String> clubData = new ArrayList<String>(); 
	   
	   System.out.println("clubList="+clubList);
	   clubData.add(0, "  Select Club  ");
	   if( clubList!=null) {
	   for(ClubDTO c : clubList) 
		   clubData.add(c.getClub()+" >> "+c.getMembers_count()+" Members");	
	      }
	   return clubData;		   
   }
   
   public Map<String,String> fileProcessType(){	   
	   Map<String,String>  processData = new HashMap<>();	   
	   processData.put("0","Select  ");
	   processData.put("1","All Participate");
	   processData.put("2","Paid Participate");
	   
	return processData;
	   
   }

}
