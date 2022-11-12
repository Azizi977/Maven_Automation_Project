package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        //       options.addArguments("start-maximized","incognito");
        options.addArguments("start-fullscreen");
        //       options.addArguments("headless");
        //for windows use "start-maximized
        //       options.addArguments("start-maximized");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to site
        driver.navigate().to("https://www.fideliscare.org");
        //sleep
        Thread.sleep(2000);

        //click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on find a doctor search icon (which will launch a new tab)
        driver.findElement(By.xpath("//*[@class= 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait a bit
        Thread.sleep(2000);

        //store tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to new tab
        driver.switchTo().window(tabs.get(1));

        //enter a zip code on search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait a bit
        Thread.sleep(2000);
        //close the find doctor tab
        driver.close();
        //click on  get coverage from homr page
        driver.switchTo().window(tabs.get(0));
        //go to home page
        driver.navigate().to("https://www.fideliscare.org");
        //sleep
        Thread.sleep(2000);
        //click on get coverage, first match index 0
      //  driver.findElements(By.xpath("//*[text() = 'get coverage']"));
        driver.findElement(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).click();
        //sleep
        Thread.sleep(2000);



    }//end of main
}//end of class
