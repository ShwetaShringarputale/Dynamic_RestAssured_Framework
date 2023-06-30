package Test_Classes;

import java.io.IOException;

import Common_API_Methods.Dynamic_Common_Utility_Method;
import Common_API_Methods.Dynamic_Get_API_Methods;
import Request_Respository.Dynamic_Get_Request_Respository;

public class Dynamic_Get_TC1 {
	
	public static void Extractor() throws IOException
	{
		String baseURI = Dynamic_Get_Request_Respository.BaseURI();
		String resource = Dynamic_Get_Request_Respository.Get_Resource();
		
		int statusCode = Dynamic_Get_API_Methods.ResponseStatusCode(baseURI,resource);
		System.out.println(statusCode);
		
		String ResponseBody = Dynamic_Get_API_Methods.ResponseBody(baseURI, resource);
		System.out.println(ResponseBody);
		Dynamic_Common_Utility_Method.EvidenceCreator("Get_TC1",Dynamic_Get_Request_Respository.Get_Resource(),ResponseBody ,statusCode);
		
	}

}
