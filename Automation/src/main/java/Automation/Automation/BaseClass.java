/**
 * 
 */
package Automation.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @author rahulsingh.tomar
 *
 */

public class BaseClass {
    static Properties prop;
	WebDriver driver;
	//Properties prop;
	@BeforeClass
	public void setEnviorment() throws IOException {
		prop = new Properties();
		String envFile = System.getenv().get("TEST_ENVIRONMENT");
		System.out.println("Environemnt Value Is :"+envFile);
		System.out.println(System.getProperty("user.dir") + File.separator + "config"+File.separator+envFile+".properties");
		//FileInputStream fp = new FileInputStream("C:\\Users\\r.singh.tomar\\git\\automation-testframwork\\Automation\\config\\smoke.properties");
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + File.separator + "config"+File.separator+envFile+".properties");
		prop.load(fp);
	}
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserExe\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun=true)
	public void captureScreenShot(ITestResult result,Method method) throws Exception {
		
		String teststatus = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			teststatus = "PASS";
			break;
		case ITestResult.FAILURE:
			teststatus = "FAIL";
			break;
		case ITestResult.SKIP:
			teststatus = "SKIP";
			break;
		}
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());

		String timestampPath = File.separator + "screenshots" + File.separator + method.getName() + "_" + teststatus+ "_" + timeStamp;

		String path = System.getProperty("user.dir") + File.separator + "Reports" + timestampPath;

		try {
			Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);
			ImageIO.write(fpScreenshot.getImage(), "jpg", new File(path + ".jpg"));
		} catch (Exception e) {
			throw new Exception();
		}
		driver.close();
	}
}
