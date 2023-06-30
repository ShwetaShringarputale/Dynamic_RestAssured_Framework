package Request_Respository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Dynamic_Common_Utility_Method;

public class Dynamic_Put_Request_Respository {
	
	public static String BaseURI() 
	{
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String Put_Resource()
	{
		String put_Resource = "api/users/2";
		return put_Resource;
	}
	public static String Put_Req_TC1() throws IOException
	{
		ArrayList<String> Req_Data = Dynamic_Common_Utility_Method.ReadDataExcel("PutAPI","TC5");
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