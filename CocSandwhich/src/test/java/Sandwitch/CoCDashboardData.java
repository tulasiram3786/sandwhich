package Sandwitch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CoC.CoCDashboard;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CoCDashboardData {
	
	
	
	
	public static ArrayList<CoCDashboard> getCoCDashboardData() throws InterruptedException {
//		--------------------------------------------------------------------------------------------
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("aliceblue@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		// this is used to click the instance name on the ui page
		driver.findElement(By.xpath("//div[@class='jss11']")).click();

		// select the location west 1 or west2
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(0);


//		--------------------------------------------------------------------------------------------
		
		ArrayList<CoCDashboard> cocFinalArrNew = new ArrayList<CoCDashboard>();

		List<WebElement> allinstancenames = driver.findElements(By
				.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[3]"));
		for (WebElement wb1 : allinstancenames) {
			wb1.click();
			Thread.sleep(500);
			List<WebElement> tabledata = driver
					.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
			Thread.sleep(500);
			ArrayList<String> seven = new ArrayList<String>();
			CoCDashboard cocObj = new CoCDashboard();
			try {
				int i = 1;
				for (WebElement wb3 : tabledata) {

					if (wb3.getText().indexOf("Hostname:") >= 0) { // Hostname
						String hostname = wb3.getText().split(":")[1].trim();
						cocObj.setHostname(hostname);
					}

					if (wb3.getText().indexOf("OS:") >= 0) { // OS
						String os = wb3.getText().split(":")[1].trim();
						cocObj.setOS(os);
					}

					if (wb3.getText().indexOf("Public IP:") >= 0) { // Public IP
						if (wb3.getText().split(":").length > 1) {
							String publicIP = wb3.getText().split(":")[1].trim();
							cocObj.setPublicIP(publicIP);
						}
					}

//					if(wb3.getText().indexOf("Private IP:") >= 0) { //Other Private IP
//						if (wb3.getText().split(":").length > 1) {
//							ArrayList<String> privateIP1 = wb3.getText().split(":")[1].trim();
//							ArrayList<String> privateIP2 = wb3.getText().split(":")[2].trim();
//							ArrayList<String> privateIP3 = wb3.getText().split(":")[3].trim();
//							ArrayList<String> privateIP4 = wb3.getText().split(":")[4].trim();
//							
//							cocObj.setPrivateIPArr(privateIP1);
//							cocObj.setPrivateIPArr(privateIP2);
//							cocObj.setPrivateIPArr(privateIP3);
//							cocObj.setPrivateIPArr(privateIP4);
//						}
//					}

					if (wb3.getText().indexOf("Capacity:") >= 0) { // Capacity
						String capacity = wb3.getText().split(":")[1].trim();

						capacity = capacity.replace(" | ", "@");
						double cpu = Double. parseDouble(capacity.split("@")[0]);
						String ram = capacity.split("@")[1];
						String HDD = capacity.split("@")[2];

						cocObj.setCapacity_CPU(cpu);
						cocObj.setCapacity_RAM(ram);
						cocObj.setCapacity_HDD(HDD);
					}

					if (wb3.getText().indexOf("Private IP:") >= 0 && tabledata.size() == i) { // Private IP
						String privateIP = wb3.getText().split(":")[1].trim();
						System.out.println(privateIP);
						cocObj.setPrivateIP(privateIP);
					}
					i = i + 1;
					Thread.sleep(500);
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			cocFinalArrNew.add(cocObj);
			tabledata = null;
		}
		
		return cocFinalArrNew;
	}
	
	@Test(priority = 1)
	public void ui() throws InterruptedException, IOException {
		
		ArrayList<CoCDashboard> cocFinalArrNew = new ArrayList<CoCDashboard>();
		try {
			cocFinalArrNew = getCoCDashboardData();
		}catch(Exception e) {
			
		}
		
		for (int i = 0; i < cocFinalArrNew.size(); i++) {
			System.out.println(cocFinalArrNew.get(i).getHostname());
			System.out.println(cocFinalArrNew.get(i).getOS());
			System.out.println(cocFinalArrNew.get(i).getPublicIP());
		//	System.out.println(cocFinalArrNew.get(i).getPrivateIPArr());
			System.out.println(cocFinalArrNew.get(i).getCapacity_CPU());
			System.out.println(cocFinalArrNew.get(i).getCapacity_RAM());
			System.out.println(cocFinalArrNew.get(i).getCapacity_HDD());
			System.out.println(cocFinalArrNew.get(i).getPrivateIP());
			System.out.println("==========================================================");
		}
	}
}
