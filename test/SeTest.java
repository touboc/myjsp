package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeTest {
	public static void main(String[] args) throws IOException, InterruptedException{
		
		 System.setProperty("webdriver.chrome.driver" ,
				 "C:\\My\\chromedriver.exe");


	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--start-maximized");
//	        options.addArguments("--window-size=1920, 1080");
//	        options.addArguments("--disable-infobars");
//	        options.addArguments("--verbose");
//	        options.addArguments("--log-path=C:\\My\\eclipse\\chromedriver.log");
	        
	        options.setBinary("C:\\My\\chrome-win64\\chrome.exe");   
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080"); 
	        options.addArguments("--disable-extensions");
	        options.setExperimentalOption("useAutomationExtension", false);
	        options.addArguments("--proxy-server='direct://'");
	        options.addArguments("--proxy-bypass-list=*");
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--start-maximized");
	        options.addArguments("--ignore-certificate-errors");
		 
	        WebDriver driver = new ChromeDriver(options);
//	        driver.wait(1000*10);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
//			 for(int i= 1; i<=13153/50+1;i++) {
			 for(int i= 1; i<=1;i++) {
	     if (i==1) {   
		 driver.get("https://doda.jp/DodaFront/View/CompanySearch.action?ind=01L&pr=13&sid=CompanyTop_kw");
	     }else {
	    	 driver.get("https://doda.jp/DodaFront/View/CompanySearch.action?ind=01L&pr=13&sid=CompanyTop_kw&page="+i);
	     }
	     

//	     Thread.sleep(1000*10);
//	     int next_page = i+1;
	     By addItem = By.xpath("//a[contains(@href, 'page="+(i+1)+"')]");
	     //NG WebElement elements2 = driver.findElement(By.xpath("//a[text()='page="+next_page+"']/@href"));
	     //NG WebElement elements2 = driver.findElement(By.xpath("//a[contains(text(), 'page=2')]/@href"));
	     //OK WebElement elements2 = driver.findElement(By.xpath("//a[contains(@href, 'page=2')]"));
	     
	     WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(addItem));
//	     WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(addItem));
			 
		 //WebElement elements = driver.findElement(By.className("company"));
		 String s1 = driver.findElement(By.className("company")).getText();
		 
		 List<WebElement> elements = driver.findElements(By.className("company"));
		 WebElement targetElement = null;
		 for (WebElement element: elements ) {
//		     if (element.getAttribute("aria-label").contains("Publickey")) {
//		         targetElement = element;
//		     }
//			 System.out.println(element.getText());
//			 SeTest.write_info(element.getText());
		 }
		 
//		 elements = driver.findElements(By.xpath("//span[contains(text(), 'ñº')]"));
		 List<WebElement> elements2 = driver.findElements(By.xpath("//span[contains(text(), 'è]ã∆àıêî')]/following-sibling::span"));
		 for (WebElement element: elements2 ) {
//			 System.out.println(element.getAttribute("innerHTML"));
			 
		 }
		 for (int j=0;j<elements.size();j++ ) {
//			 System.out.println(elements.get(j).getText() + "\t"+elements2.get(j).getAttribute("innerHTML"));
			 String log=elements.get(j).getText() + "\t"+elements2.get(j).getAttribute("innerHTML");
			 SeTest.write_info(log);
		 }
		 
//		 WebElement elements2 = driver.findElement(By.className("pager__buttonNext"));
//		 WebElement elements2 = driver.findElement(By.xpath("//button[@class='pager__buttonNext pager__button']"));
//		 String s2 = elements2.getText();
//		 elements2.click();

		 }
		 
		 
		 
	}
	
	
	public static void  write_info(String content) throws IOException{
		String file_name = "c:\\my\\temp\\test0602.txt";
		PrintWriter pw;
		pw = new PrintWriter(new BufferedWriter(new FileWriter(file_name, true)));
		pw.println(content);
		pw.close();
	}
}
