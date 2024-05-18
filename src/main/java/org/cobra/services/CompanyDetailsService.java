package org.cobra.services;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.cobra.models.CompanyDetails;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CompanyDetailsService {
	
	public static CompanyDetails getCompanyDetails(File file) {
		
		CompanyDetails company = new CompanyDetails();
		
		try {
		  Object obj=	new JSONParser().parse(new FileReader(file));
		  JSONObject jo = (JSONObject) obj; 
		  company.setCompanyName((String)jo.get("company_name"));
		  company.setCompanyLocation((String)jo.get("company_location"));
		  company.setCompanyMob((String)jo.get("company_mob"));
		  company.setCompanyReg((String)jo.get("company_reg"));
		  
		  
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return company;
	}

}
