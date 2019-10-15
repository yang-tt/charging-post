package dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vo.ChargingPost;
public class Anatomy {

	public static void load(String path) throws Exception {  
	   ObjectMapper mapper = new ObjectMapper();
	   ImportDAO im=new ImportDAO();
		 String jsonData="";
        BufferedReader reader = null;

		try {
			///////////
		 FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
			reader = new BufferedReader(inputStreamReader);
			String temp = null;
			int counter=0;
			while ((temp = reader.readLine()) != null) {
				jsonData =jsonData+ temp;
				counter++;
				System.out.println(counter+temp);
			}
			//System.out.println(jsonData);
			
		   List<ChargingPost> list= mapper.readValue(jsonData, new TypeReference<List<ChargingPost>>() {});   
		       for(ChargingPost cp:list){
		    	   System.out.println(cp);
		    	   im.save(cp);
		       }    
	        } catch (JsonParseException e) {
	            e.printStackTrace(); 
	        } catch (JsonMappingException e) {
	           e.printStackTrace(); 
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        } finally {reader.close();} 
	     }
	public static void main(String[] args) throws Exception{
               Anatomy.load("C:\\Users\\Li He\\Desktop\\test.json");
	           //Anatomy.load("http://api.map.baidu.com/place/v2/search?query=³äµç×®&region=±±¾©&output=json&page_size=20&ak=GFpaROLgaOQoIgUYZih1CxTGfGDiVB0u");
	}
	
}
