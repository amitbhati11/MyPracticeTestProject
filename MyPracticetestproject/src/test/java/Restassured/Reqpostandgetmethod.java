package Restassured;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Reqpostandgetmethod {
	
	@DataProvider(name="postdata")
	
	public Object [][] postdatam(){
		
		return new Object [][] {
			{"Siba","SQA"},{"NIKI","TESTQ"}
			
		};
	}
	
	@Test(dataProvider="postdata")
	public void postmethod(String name, String job) {
		baseURI="https://reqres.in";
		JSONObject req=new JSONObject();
		req.put("name", name);
		req.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().post("/api/users").
		then().statusCode(201).log().all();
	}
	@Test
	
	public void getmethod() {
		baseURI="https://reqres.in";
		
		given().when().get("/api/users/2").then().statusCode(200).log().all();
	}

}
