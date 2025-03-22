package dataProviders;

import org.testng.annotations.Test;
import utilities.ExcelRead;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "successfulLogIn")
	public Object[][] dp1() throws IOException {
		return new Object[][] { new Object[] { ExcelRead.getStringData(0, 0), 
											   ExcelRead.getStringData(0, 1) }, };
	}

	@DataProvider(name = "unsuccessfulLogin")
	public Object[][] dp() {
		return new Object[][] { new Object[] { "admi", "admin" }, 
								new Object[] { "admin", "adm" },
								new Object[] { "adm", "adm" } };
	}
}
