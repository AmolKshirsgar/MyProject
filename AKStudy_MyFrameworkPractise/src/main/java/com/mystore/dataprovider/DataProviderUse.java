//Use Data Parameter ny HashMap method

package com.mystore.dataprovider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.mystore.utility.DataProvider_jsonReader;


public class DataProviderUse extends DataProvider_jsonReader 
{
	@DataProvider   //use for login for 2 users
//		public Object[][] CredentialsLogin() throws IOException
//		{
//			//create json file use below method i.e getJsonDataMap and provide path of file in below argument and execute as per requiremet
//			 List<HashMap<String, String>>data=getJsonDataMap(System.getProperty("user.dir")+"\\TestData\\CredentialsLogin.json");
//			 return new Object[][] {{data.get(0)},{data.get(1)}};
//		}
	
	
	//logiin with one user
	public Object[] CredentialsLogin() throws IOException
	{
		//create json file use below method i.e getJsonDataMap and provide path of file in below argument and execute as per requiremet
		 List<HashMap<String, String>>data=getJsonDataMap(System.getProperty("user.dir")+"\\TestData\\CredentialsLogin.json");
		 return new Object[] {data.get(0)};
	}


	@DataProvider  //use for createaccount page
	public Object[] CredentialsCreateAccount() throws IOException
	{
		List<HashMap<String, String>>data=getJsonDataMap(System.getProperty("user.dir")+"\\TestData\\CredentialsCreateAccount.json");
		 return new Object[] {data.get(0)};
	}
	
	@DataProvider  //use for Address product select page
	public Object[] CredentialsLoginAddressPage() throws IOException
	{
		 List<HashMap<String, String>>data=getJsonDataMap(System.getProperty("user.dir")+"\\TestData\\CredentialsLoginAddressPage.json");
		 return new Object[] {data.get(0)};
	}
}		
		
		



