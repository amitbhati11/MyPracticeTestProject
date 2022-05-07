package Restassured;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Reqputpatchndeletemethods {

	@DataProvider(name="test_put")
	public Object [][] putdata(){
		return new Object [][] {
			{"sourav","test"},{"Rash","bowl"}
		};
	}
//	@Test(dataProvider="test_put")
	
	public void putmethod(String name,String job) {
		baseURI="https://reqres.in";
		JSONObject rp=new JSONObject();
		rp.put("name", name);
		rp.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rp.toJSONString()).when().put("/api/users/2").
		then().statusCode(200).log().all();
	}
	
	@DataProvider(name="test_patch")
	public Object [][] patchdata(){
		return new Object [][] {
			{"Alut","batsmen"}
		};
	}
//	@Test(dataProvider="test_patch")
	
	public void patchmethod(String name,String job) {
		baseURI="https://reqres.in";
		JSONObject rp=new JSONObject();
		rp.put("name", name);
		rp.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rp.toJSONString()).when().patch("/api/users/2").
		then().statusCode(200).log().all();
	}
	
	@Test
	
	public void  deletem(){
		
		baseURI="https://reqres.in";
		
		given().when().delete("/api/users?page=2").then().statusCode(204).log().all();
		
		
	}
}
