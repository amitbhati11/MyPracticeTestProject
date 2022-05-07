package Restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class deleteputnpatchmethods {
	
	@DataProvider(name="test_put")
	
	public Object [][] putmethod(){
		
		return new Object [] []{
			{"Subhash","singh",2},{"Mithun","chakarboty",1}
		};
	}
	
	//@Test(dataProvider="test_put")
	public void putexample(String F_name,String L_name,int SubID) {
		baseURI="http://localhost:3000";
		
		JSONObject rt=new JSONObject();
		rt.put("F_name",F_name );
		rt.put("L_name",L_name);
		rt.put("SubID", SubID);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rt.toJSONString()).when()
		.put("/users").then().statusCode(404).log().all();
	}
	
@DataProvider(name="test_patch")
	
	public Object [][] patchmethod(){
		
		return new Object [] []{
			{"Subhash","bingla",2}
		};
	}
	
	@Test(dataProvider="test_patch")
	public void patchexample(String F_name,String L_name,int SubID) {
		baseURI="http://localhost:3000";
		
		JSONObject rt=new JSONObject();
		rt.put("F_name",F_name );
		rt.put("L_name",L_name);
		rt.put("SubID", SubID);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rt.toJSONString()).when()
		.patch("/users").then().statusCode(404).log().all();
	}
	
	
	@DataProvider(name="test_delete")
	
	public Object [] deletem() {
		return new Object [] {
				3,4
		};
	}
	@Test(dataProvider="test_delete")
	
	public void deleteexapmles(int id) {
		
		baseURI="http://localhost:3000";
		given().when().delete("/users").then().statusCode(404).log().all();
	}


}
