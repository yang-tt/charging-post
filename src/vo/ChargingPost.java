package vo;

import java.io.Serializable;

public class ChargingPost implements Serializable{
   private String name;
   private location location;
   private String address;
   private String province;
   private String city;
   private String area;
   private String telephone;
   private String street_id;
   private int detail;
   private String uid;
  
   public ChargingPost(){
	   super();
   }
   public ChargingPost(String name,String address){
	   this.name=name;
	   this.address=address;
   }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public location getLocation() {
	return location;
}
public void setLocation(location location) {
	this.location = location;
}

public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getStreet_id() {
	return street_id;
}
public void setStreet_id(String street_id) {
	this.street_id = street_id;
}
public int getDetail() {
	return detail;
}
public void setDetail(int detail) {
	this.detail = detail;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}

public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
@Override
public String toString() {
	return "ChargingPost [name=" + name + ", location=" + location + ", address=" + address + ", province=" + province
			+ ", city=" + city + ", area=" + area + ", telephone=" + telephone + ", street_id=" + street_id
			+ ", detail=" + detail + ", uid=" + uid + "]";
}



   
   
}
