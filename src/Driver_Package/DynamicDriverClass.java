package Driver_Package;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Common_API_Methods.Dynamic_Common_Utility_Method;

public class DynamicDriverClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		ArrayList<String> TestCaseToRun = Dynamic_Common_Utility_Method.ReadDataExcel("TestCase","TestToExecute");
		System.out.println(TestCaseToRun);
		
		int count = TestCaseToRun.size();
		
		for(int i=1 ; i<count ; i++)
		{
			String TestCaseName = TestCaseToRun.get(i);
			System.out.println("Test Case to Execute is : " +TestCaseName+ ".");
			
			// call the testcaseclass on runtime by using java.lang.reflect package
			Class<?> TestClassName = Class.forName("Test_Classes."+TestCaseName);
			
			// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
			Method executemethod=TestClassName.getDeclaredMethod("Extractor");
		
			// set the accessibility of method true 
			executemethod.setAccessible(true);
			
			// create the instance of testclass captured in variable name testclassname
			Object instanceoftestclass=TestClassName.getDeclaredConstructor().newInstance();
			
			// execute the testclass captured in variable name testclass name
			executemethod.invoke(instanceoftestclass);
		}
		

	}

}
