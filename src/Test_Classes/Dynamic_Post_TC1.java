package Test_Classes;

import java.io.IOException;

import org.testng.Assert;

import Common_API_Methods.Dynamic_Common_Utility_Method;
import Common_API_Methods.Dynamic_Post_API_Methods;
import Request_Respository.Dynamic_Post_Request_Respository;
import io.restassured.path.json.JsonPath;

public class Dynamic_Post_TC1 {
	
	public static void Extractor() throws IOException//method return nothing only execute it
	{
		
		//Extract Response Status Code
		int statusCode = Dynamic_Post_API_Methods.ResponseStatusCode(
				Dynamic_Post_Request_Respository.BaseURI(), 
				Dynamic_Post_Request_Respository.Post_Resource(), 
				Dynamic_Post_Request_Respository.Post_Req_TC1());
		System.out.println(statusCode);
		
		//Extract Request Body
		JsonPath JPost_Req = new JsonPath(Dynamic_Post_Request_Respository.Post_Req_TC1());
		String post_req_name =  JPost_Req.getString("name");
		String post_req_job = JPost_Req.getString("job");
		
		//Parse Response
		String ResponseBody = Dynamic_Post_API_Methods.ResponseBody(
				Dynamic_Post_Request_Respository.BaseURI(), 
				Dynamic_Post_Request_Respository.Post_Resource(), 
				Dynamic_Post_Request_Respository.Post_Req_TC1());
		Dynamic_Common_Utility_Method.EvidenceCreator("Post_TC1",Dynamic_Post_Request_Respository.Post_Req_TC1(),ResponseBody ,statusCode);
		System.out.println(ResponseBody);
			
		JsonPath JPost = new JsonPath(ResponseBody);
		String post_res_name=JPost.getString("name");
        String post_res_job=JPost.getString("job");
		
        //Validate Response Body
		Assert.assertEquals(post_res_name,post_req_name);
        Assert.assertEquals(post_res_job,post_req_job);
		
		
	}
	
}
