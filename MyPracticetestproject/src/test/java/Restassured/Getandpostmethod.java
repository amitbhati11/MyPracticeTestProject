package Restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class Getandpostmethod {
	@DataProvider(name="testdata")
	public Object [][] postdata() {
		
		return new Object [][] {
			{"Subhash","sharma",2},{"Mithun","manahas",1} 
			
		};
		
	}
	
//	@Test(dataProvider="testdata")
	
	public void postmethod(String F_name,String L_name,int SubID) {
		
		baseURI="http://localhost:3000";
		JSONObject req=new JSONObject();
		
		req.put("F_name", F_name);
		req.put("L_name",L_name);
		req.put("SubID", SubID);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).
		when().post("/users").
		then().statusCode(201).log().all();
		
		}

	@Test
	
	public void getnmethod() {
		baseURI="http://localhost:3000";
		given().when().get("/users").then()
		.statusCode(200).log().all();
		
	}
}
