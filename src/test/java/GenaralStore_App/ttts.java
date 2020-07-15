package GenaralStore_App;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import resources.AppiumBase;

public class ttts extends AppiumBase {
	String appName="GeneralStore";
	
	@Test
	public void testtre() throws IOException, Throwable {
		System.out.println("print");
		
		Thread.sleep(5000);
		//startServer();
		appiumServer("start");
		driver=capabilities(appName);
		//Assert.assertEquals(false, true);
		
		appiumServer("stop");
		
		System.out.println("server stoped");
	}
}
