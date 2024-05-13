package demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
     //   WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(3000);
        
        //WebElement name = driver.findElement(By.xpath("//div[contains(@class,'ndJi5d') and @jsname='LwH6nd']"));
        WebElement name = driver.findElement(By.xpath("(//input[contains(@class,'whsOnd') and @jsname='YPqjbf'])[1]"));
        name.sendKeys("Girish Kumar");
        
        WebElement textArea = driver.findElement(By.xpath("//textarea[contains(@class,'KHxj8b')]"));
        long epochTime = System.currentTimeMillis();
        String finalepochTime = "I want to be the best QA Engineer!"+epochTime;
        textArea.sendKeys(finalepochTime);
        
        WebElement experienceRadio = driver.findElement(By.xpath("(//div[contains(@class,'Od2TWd')])[1]"));
        experienceRadio.click();
        
        for(int i=1; i<=4; i++) {
	        WebElement learnedAtCrio = driver.findElement(By.xpath("(//div[contains(@class,'uVccjd')])["+i+"]"));
	        learnedAtCrio.click();
        }
        
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("window.scrollBy(0,200)");
        
        WebElement howTobeAddressed = driver.findElement(By.xpath("(//div[contains(@class,'MocG8c') and @jsname='wQNmvb'])[1]"));
        howTobeAddressed.click();
        
        Thread.sleep(2000);
        
        WebElement mrOption = driver.findElement(By.xpath("(//div//div//span[text()='Mr'])[2]"));
        mrOption.click();
        
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(3000);
        
      /*  LocalDate currentDate = LocalDate.now();
        
        // Subtract 7 days from the current date
        LocalDate sevenDaysAgo = currentDate.minusDays(7);
        
        // Define a formatter for "mm/dd/yyyy" format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        // Format the date as "mm/dd/yyyy"
        String formattedDate = sevenDaysAgo.format(formatter);
        System.out.println(formattedDate);
        
        WebElement dateAgo = driver.findElement(By.xpath("(//div//input[contains(@class,'whsOnd') and @jsname='YPqjbf'])[2]"));
        dateAgo.click();
        dateAgo.sendKeys(formattedDate);  */
        
        
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date previousDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = dateFormat.format(previousDate);
        WebElement date = driver.findElement(By.xpath("(//div//input[contains(@class,'whsOnd') and @jsname='YPqjbf'])[2]"));
        date.sendKeys(formatedDate);
        
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = currentTime.format(formatter);
        
        int hour = currentTime.getHour()-12;
        String hourValue = Integer.toString(hour);
        int minute = currentTime.getMinute();
        String minuteValue = Integer.toString(minute);
        String am_pm = formattedTime.substring(formattedTime.length() - 2);
        
        WebElement hourPart = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
        hourPart.sendKeys(hourValue);
        
        WebElement minutePart = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
        minutePart.sendKeys(minuteValue);
        
        Thread.sleep(3000);
        
//        WebElement amPM = driver.findElement(By.xpath("(//div[contains(@class,'ry3kXd') and @jsname='d9BH4c'])[2]"));
//        if(am_pm.equals("AM")) {
//        	amPM.click();
//        }else {
//        	amPM.click();
//        }
        
        WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit']"));
        submitBtn.click();
        
        Thread.sleep(3000);
        
        WebElement message = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println(message.getText());
        
               
        Thread.sleep(2000);
        System.out.println("end Test case: testCase01");
        Thread.sleep(8000);
    }
}