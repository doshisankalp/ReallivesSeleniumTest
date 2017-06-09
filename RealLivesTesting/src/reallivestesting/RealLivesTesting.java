package reallivestesting;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLivesTesting {

    WebDriver driver;

    public void testTabs() {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("http://neet.sandbox.oxwall.com/");

            driver.findElement(By.name("identity")).sendKeys("anish");
            driver.findElement(By.name("password")).sendKeys("akagod");
            driver.findElement(By.name("submit")).click();

            Thread.sleep(3000);

            driver.findElement(By.id("gmlink")).click();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));

            driver.findElement(By.xpath("/html/body/app-root/app-game-summery/div/div[1]/div[2]/a/img")).click();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.findElement(By.xpath("/html/body/app-root/app-create-life-animation/div/div[1]/div[1]/div[2]/div[2]/a/img")).click();

            Thread.sleep(10000);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            int age = -1;

            while (age < 5) {
                String age1 = js.executeScript("return document.getElementsByClassName(\"small_age\")[0].innerHTML").toString();

                age = Integer.parseInt(age1);

                System.out.println(age);

                while (true) {
                    try {
                        driver.findElement(By.xpath("/html/body/app-root/app-home/div/div/div[1]/div/div/ul/li[4]/app-age-a-year/a")).click();
                        break;
                    } catch (Exception ex) {
                    }

                }

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RealLivesTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        RealLivesTesting ob = new RealLivesTesting();
        ob.testTabs();
    }

}