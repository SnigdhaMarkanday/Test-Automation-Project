package TestNG_Lab;

import org.testng.annotations.DataProvider;

public class Proj6 
{
	@DataProvider(name = "loginTestData")
	public static Object[][] loginInfo() 
	{
		Object[][] Data = new Object[1][2];
		
		Data[0][0] = "500077256@stu.upes.ac.in";
		Data[0][1] = "R171219035";
		
		return Data;
	}
}

