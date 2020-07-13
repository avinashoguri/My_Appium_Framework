package GenaralStore_App;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class ttts extends Base {

	@Test
	public void testtre() throws IOException, Throwable {
		System.out.println("print");
		
		Thread.sleep(5000);
		appiumStartServer();
		String appName="GeneralStore";
		driver=capabulities(appName);
		Assert.assertEquals(false, true);
		System.out.println("should fail");
	}
}
