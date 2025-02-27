package test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeTest3 {
	public static void main(String[] args) throws IOException, InterruptedException,Exception{
		
		 System.setProperty("webdriver.edge.driver" ,
				 "C:\\My\\msedgedriver.exe");
	
		 EdgeOptions options = new EdgeOptions();
	        options.addArguments("--start-maximized");
//	        options.addArguments("--window-size=1920, 1080");
//	        options.addArguments("--disable-infobars");
//	        options.addArguments("--verbose");
//	        options.addArguments("--log-path=C:\\My\\eclipse\\chromedriver.log");
//		 options.setBinary("C:\\My\\eclipse\\chrome-win64\\chrome.exe");
		 options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		 EdgeDriver driver = new EdgeDriver(options);
//	        driver.wait(1000*10);
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	     driver.get("https://www.google.com");
	       driver.get("https://automationintesting.com/selenium/testpage/");
    	 
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,350)", "");
    	 
    	 captureScreen2("C:\\My\\temp\\"+getFileName()+".png");

    	 driver.quit();
		 
	}
	
	public static void captureScreen(String fileName) throws Exception {
		   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   Rectangle screenRectangle = new Rectangle(screenSize);
		   Robot robot = new Robot();
		   BufferedImage image = robot.createScreenCapture(screenRectangle);
		   ImageIO.write(image, "png", new java.io.File(fileName));
		}
	
	public static void captureScreen2(String fileName) throws Exception {
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        robot.keyRelease(KeyEvent.VK_ALT);    
        Thread.sleep(1500);
        RenderedImage image = (RenderedImage)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.imageFlavor);
        ImageIO.write(image, "png", new java.io.File(fileName));
		}
	
	public static String getFileName()  {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();

		// Define the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

		// Format the current date and time
		String formattedNow = now.format(formatter);
		
		return formattedNow;
	}
	
	public static void  write_info(String content) throws IOException{
		String file_name = "c:\\my\\temp\\test.txt";
		PrintWriter pw;
		pw = new PrintWriter(new BufferedWriter(new FileWriter(file_name, true)));
		pw.println(content);
		pw.close();
	}
}
