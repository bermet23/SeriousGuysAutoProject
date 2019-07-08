import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Aidina {
    public static void TestMuseum() throws InterruptedException{
        //Automated by Aidina Bekturova (Team: Serious guys)
        //my source code covers seven scenarios.
        //my first step was about to able to open the https://www.fieldmuseum.org  page.
        //and able to click "Menu" icon and display up coming page.
        //and i had to check all seven options from "Menu" page that had more options under general options.
        //my source code checks ,if user can open general page,can able to click,can able to hover over all options
        //can open the page and go back to the general page.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fieldmuseum.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        //opening field museum browser.


        //navigating and clicking "Menu" icon
        WebElement menu = driver.findElement(By.xpath("//button[@class='header__menu-open js-menu-open']"));
        menu.click();
        //finding all links from that page and looping.I used "Action" class to hover over  through my elements.
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class ='menu-full__nav-list pt-3']//a"));
//        Iterator<WebElement> listIterator1 = links.iterator();
//        while (listIterator1.hasNext()) {
//            Thread.sleep(200);
//            action.moveToElement(listIterator1.next()).build().perform();
//        }

        //this line just a command that opens next window for me.
        String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
        //Storing my main page.
        String mHandle = driver.getWindowHandle();
        //Storing my current url.
        String mainUrl = driver.getCurrentUrl();
        //looping though each link and opening pages one by one.
        for (WebElement l : links) {
            l.sendKeys(click);
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            String general = it.next();
            driver.switchTo().window(it.next());
            String temp = "";
            Thread.sleep(500);
            if (!mainUrl.equals(driver.getCurrentUrl())) {
                //System.out.println("Verification passed");
                temp = "Verification passed";
            } else {
                //System.out.println("Verification failed");
                temp = "Verification failed";
            }
            if(!driver.getCurrentUrl().contains("harris")) {
                System.out.println(driver.getTitle().substring(0, driver.getTitle().indexOf("|")) + " : " + temp);
            }

            driver.close();
            Thread.sleep(500);
            driver.switchTo().window(mHandle);

        }
        System.out.println("=======================================================================");

    }

    public static void main(String[] args) throws InterruptedException {
        //Automated by Aidina Bekturova (Team: Serious guys)
        //my source code covers seven scenarios.
        //my first step was about to able to open the https://www.fieldmuseum.org  page.
        //and able to click "Menu" icon and display up coming page.
        //and i had to check all seven options from "Menu" page that had more options under general options.
        //my source code checks ,if user can open general page,can able to click,can able to hover over all options
        //can open the page and go back to the general page.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.get("https://www.fieldmuseum.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        //opening field museum browser.


        //navigating and clicking "Menu" icon
        WebElement menu = driver.findElement(By.xpath("//button[@class='header__menu-open js-menu-open']"));
        menu.click();
        //finding all links from that page and looping.I used "Action" class to hover over  through my elements.
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class ='menu-full__nav-list pt-3']//a"));
//        Iterator<WebElement> listIterator1 = links.iterator();
//        while (listIterator1.hasNext()) {
//            Thread.sleep(200);
//            action.moveToElement(listIterator1.next()).build().perform();
//        }

        //this line just a command that opens next window for me.
        String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
        //Storing my main page.
        String mHandle = driver.getWindowHandle();
        //Storing my current url.
        String mainUrl = driver.getCurrentUrl();
        //looping though each link and opening pages one by one.
        for (WebElement l : links) {
            l.sendKeys(click);
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            String general = it.next();
            driver.switchTo().window(it.next());
            String temp = "";
            if (!mainUrl.equals(driver.getCurrentUrl())) {
                //System.out.println("Verification passed");
                temp = "Verification passed";
            } else {
                //System.out.println("Verification failed");
                temp = "Verification failed";
            }
            System.out.println(driver.getTitle().substring(0, driver.getTitle().indexOf("|")) + " : " + temp);


            driver.close();
            Thread.sleep(500);
            driver.switchTo().window(mHandle);
        }
        System.out.println("=======================================================================");
    }
}
