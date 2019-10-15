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
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import net.sf.json.JSONArray;
import vo.ChargingPost;
public class Anatomy2 {

	public static void load(String path) throws Exception {  
	   ObjectMapper mapper = new ObjectMapper();
	   ImportDAO im=new ImportDAO();
		 String jsonData="";
        BufferedReader reader = null;

		try {

		
	     	 URL url = new URL(path);                           
			 HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();             
			 httpURLConnection.setReadTimeout(5000);             
			 httpURLConnection.setRequestMethod("GET");  
			 if(httpURLConnection.getResponseCode() == 200){                  
				 InputStream inputStream = httpURLConnection.getInputStream();                  
				 InputStreamReader isr = new InputStreamReader(inputStream,"UTF-8");                 
				 BufferedReader br = new BufferedReader(isr);                 
			 String temp1 = null;                  
			 String jsonsb ="";     
			 int counter=0;
			 
			 while((temp1 = br.readLine()) != null){ 
				 counter++;
				 System.out.println(counter+temp1);
				 if(counter==1|counter==2|counter==3|counter==4|counter==5){}
				 else if(counter==6){ 
					 jsonsb=jsonsb+"["+temp1;
					// System.out.println(counter+temp1);
				 }else{
					 jsonsb=jsonsb+temp1;
					// System.out.println(counter+temp1);
				 }
			 }
			 jsonsb=jsonsb.substring(0, jsonsb.lastIndexOf('}')-1)+"]";
			  
			 List<ChargingPost> list= mapper.readValue(jsonsb, new TypeReference<List<ChargingPost>>() {});   
			   
			 for(ChargingPost cp:list){
		    	   System.out.println(cp);
		    	   im.save(cp);
		    	}   
			 }
		
	        } catch (JsonParseException e) {
	            e.printStackTrace(); 
	        } catch (JsonMappingException e) {
	           e.printStackTrace(); 
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
	     }
	public static void main(String[] args) throws Exception{
	    for(int i=1;i<=19;i++){
	           Anatomy2.load("http://api.map.baidu.com/place/v2/search?query=充电桩&region=北京&output=json&page_size=20&page_num="+i+"&ak=GFpaROLgaOQoIgUYZih1CxTGfGDiVB0u");
         }
	         //  Anatomy2.load("http://api.map.baidu.com/place/v2/search?query=充电桩&region=北京&output=json&page_size=20&ak=GFpaROLgaOQoIgUYZih1CxTGfGDiVB0u");
	}
	
}
