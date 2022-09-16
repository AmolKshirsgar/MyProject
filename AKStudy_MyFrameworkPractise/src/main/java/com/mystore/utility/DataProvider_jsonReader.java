package com.mystore.utility;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvider_jsonReader
{
	public List<HashMap<String,String>> getJsonDataMap(String filePath) throws IOException
	{
		//read json to String
		String jsonContent=FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);  //StandardCharsets.UTF_8 this will remove error from 'readFileToString' from above line
		
		//string to Hashmap using jacksonDatabind dependencies(we hv to add this dependency in POM.XML)
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});	
		
		return data;
	}

}
