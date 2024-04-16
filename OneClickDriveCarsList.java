package introductionselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneClickDriveCarsList {

	public static void main(String[] args) throws InterruptedException {
		        // Set the path of the ChromeDriver executable
		System.setProperty("webDriver.chrome.driver", "C:\\Users\\G15\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		        // Initialize ChromeDriver
		        WebDriver driver = new ChromeDriver();
		        
		        // Navigate to the webpage
		        driver.get("https://www.oneclickdrive.com/nissan-rental-car-dubai");
		        
		      Thread.sleep(5000);
		         findAndSplitCarsByName(driver);

		        
		        // Taking screenshots for each step
		        takeScreenshot(driver, "initial_page");
		        takeScreenshot(driver, "after_finding_and_splitting_cars");

		        // Close the browser
		    }

		    // Function to find elements by class name and split into two lists
		    private static void findAndSplitCarsByName(WebDriver driver) {

		        List<WebElement> carElements = driver.findElements(By.className("cars"));
		        System.out.println("Number of elements found: " + carElements.size());

		        List<String> stringList = OneClickDriveCarsList.convertToStringList(carElements);

		        // Now 'stringList' contains the text content of each WebElement in 'webElements'
		        
		     // Splitting into two lists based on name length
		        List<String> shortCars = new ArrayList<>();
		        List<String> longCars = new ArrayList<>();

		        for (String carName : stringList) {
		            if (carName.length() < 3) {
		                shortCars.add(carName);
		            } else {
		                longCars.add(carName);
		            }
		        }
		        // Printing the results
		        System.out.println("Short Cars: " + shortCars);
		        System.out.println("Long Cars: " + longCars);
		        
		    }
		    // Method to take a screenshot and save it with a given name
		    private static void takeScreenshot(WebDriver driver, String screenshotName) {
		        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        try {
		            FileUtils.copyFile(screenshot, new File("C:\\Users\\G15\\Downloads\\" + screenshotName + ".png"));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    public static List<String> convertToStringList(List<WebElement> webElements) {
		        List<String> stringList = new ArrayList<>();

		        for (WebElement element : webElements) {
		            stringList.add(element.getText());
		        }

		        return stringList;
		    }
		}
