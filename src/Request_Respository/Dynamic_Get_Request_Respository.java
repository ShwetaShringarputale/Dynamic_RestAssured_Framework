package Request_Respository;

public class Dynamic_Get_Request_Respository {

	public static String BaseURI() //String is return type which give value return string 
	{
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String Get_Resource()
	{
		String get_Resource = "api/users?page=2";
		return get_Resource;
	}
}
