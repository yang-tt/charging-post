package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;
import vo.ChargingPost;

public class BreakDown {
	 public static void load(){
	  // ArrayList<ChargingPost> arrayList = new ArrayList<>();
	    try {
          String path ="C:\\Users\\Li He\\Desktop\\test.json";
          ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(path);
       
       Map<String, List<ChargingPost>> result = objectMapper.readValue(BreakDown.class.getResource(path),new TypeReference<Map<String, List<ChargingPost>>>() {});

        int size = result.get("data").size();

        for (int j=0; j<size; j++) {
    	  Object o =  result.get("data").get(j);
    	  JSONObject jo =  JSONObject.fromObject(o);
    	  ChargingPost  cp = new ChargingPost();
    	  cp.setName(jo.getString("name"));
    	  cp.setAddress(jo.getString("address"));
          //arrayList.add(cp); 
    	  ImportDAO im=new ImportDAO();
    	  //im.save(jo.getString("name"),jo.getString("address"));
          System.out.println(cp);
       } 
	       
	    } catch (Exception e) {
	         e.printStackTrace();
	   }
         // return arrayList;
	    }

		 public static void main(String[] args){
			 BreakDown.load();
		 }
	 }
