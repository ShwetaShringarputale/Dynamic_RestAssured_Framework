package Request_Respository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Dynamic_Common_Utility_Method;

public class Dynamic_Post_Request_Respository {
	
	public static String BaseURI() //String is return type which give value return string 
	{
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String Post_Resource()
	{
		String post_Resource = "api/users";
		return post_Resource;
	}
	public static String Post_Req_TC1() throws IOException
	{
		ArrayList<String> Req_Data = Dynamic_Common_Utility_Method.ReadDataExcel("PostAPI","TC1");
		System.out.println(Req_Data);
		String Req_name = Req_Data.get(1);
		String Req_job = Req_Data.get(2);
		String requestBody ="{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return requestBody;
	}
	
}

