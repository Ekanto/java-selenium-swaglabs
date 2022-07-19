package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static File screenShot(WebDriver driver) throws IOException {
		Date dt = new Date();
		String st = dt.toString().replace(" ", "-").replace(":", "-");
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File(".//screenshot//" + st + ".png"));
		return ss;
	}

}
