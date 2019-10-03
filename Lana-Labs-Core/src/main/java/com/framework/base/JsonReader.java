package com.framework.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonReader {
	
		
	public static Object[][] getdata(String JSON_path, String typeData, int totalDataRow, int totalColumnEntry) {
		JsonParser jsonParser =  new JsonParser();
		JsonObject jsonObj = null;
		
		try {
			jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
		} catch (JsonIOException e) {
			
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
        JsonArray array = (JsonArray) jsonObj.get(typeData);
        return searchJsonElement(array, totalDataRow, totalColumnEntry);
	}
	
	public static Object[][] searchJsonElement(JsonArray jsonArray, int totalDataRow, int totalColumnEntry) 
	{			
		Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
        int i =0;
        int j = 0;
        for (JsonElement jsonElement : jsonArray) 
        {
             for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) 
             {
            	 matrix[i][j] = entry.getValue().toString().replace("\"","");
                 j++;   
            }
            i++;
            j = 0;
        }
        return matrix;
	}
}



