package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnect;
import vo.ChargingPost;

public class ImportDAO {
	public void save(ChargingPost cp) throws Exception {
		String sql = "insert into cp values(?,?,?,?,?,?)";
	    PreparedStatement pstmt = null ;   
	    DBConnect dbc= null;   
	  
	        try{   
	         
	            dbc = new DBConnect() ;   
	            pstmt = dbc.getConnection().prepareStatement(sql) ; 
	            pstmt.setString(1,cp.getName()) ;   
	            pstmt.setString(2,cp.getLocation().toString()); 
	            pstmt.setString(3,cp.getAddress()) ;   
	            pstmt.setString(4,cp.getCity()) ;   
	            pstmt.setString(5,cp.getArea()) ; 
	            pstmt.setString(6,cp.getStreet_id()) ;   
	  
	            pstmt.executeUpdate();
	            
	            pstmt.close() ;   
	        }catch (SQLException e){   
	           e.printStackTrace();  
	        }finally{   
	            dbc.close() ;   
	        }   
		}
}
