import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Akcholpon {

  /*
    TestCase 1 :User should able to filter upcoming events by selecting audience type
    */


    public static void filterEventsByChoosingAudience(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Opening Field Museum page
        driver.get("https://www.fieldmuseum.org");

        if(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/")){
            System.out.println("Field Museum Page: Passed");
        }else{
            System.out.println("Field Museum Page: Failed");
        }

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        if(driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText().equals("EVENTS")){
            System.out.println("Events page: Passed");
        }else{
            System.out.println("Events page: Failed");
        }


        //clicking Audience box, to be able to choose audience to filter events
        driver.findElement(By.xpath("//div[@class='multi-select']")).click();
        if(driver.findElement(By.xpath("//div[@class='multi-select active']")).getText().contains("Audience")){
            System.out.println("Audience box: Passed");
        }else{
            System.out.println("Audience box: Failed");
        }


        //clicking on Families checkbox from given options
        driver.findElement(By.xpath("(//li[@class='checkbox'])[1]")).click();

        if(driver.findElement(By.xpath("//li[@class='checkbox']/input")).isSelected()){
            System.out.println("Families checkbox: Passed");
        }else{
            System.out.println("Families checkbox: Failed");
        }


        //clicking on Apply botton to be able to see only filtered events
        driver.findElement(By.xpath("//div[@class='multi-select__options-footer']//button")).click();

        if(driver.findElement(By.xpath("//button[@class='tag tag--blue tag--closable']/span")).getText().contains("FAMILIES")){
            System.out.println("Families filtered: Passed");
        }else {
            System.out.println("Families filtered: Failed");
        }
        driver.close();
    }


    /*
    TestCase 2 :User should able to filter upcoming events by selecting date and month
    */

    public static void filterEventsByChoosingDate() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Opening Field Museum page
        driver.get("https://www.fieldmuseum.org");

        if(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/")){
            System.out.println("Field Museum Page: Passed");
        }else{
            System.out.println("Field Museum Page: Failed");
        }

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        if(driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText().equals("EVENTS")){
            System.out.println("Events page: Passed");
        }else{
            System.out.println("Events page: Failed");
        }

        //checking if Calendar is displayed on the Events page
        if(driver.findElement(By.xpath("//div[@class='react-calendar event-calendar']")).isDisplayed()){
            System.out.println("Calendar displayed: Passed");
        }else{
            System.out.println("Calendar displayed: Failed");
        }

        //clicking to ">" button on Calendar to be able to choose next month
        driver.findElement(By.xpath("//div[@class='react-calendar__navigation']//button[4]")).click();

        if(driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).getText().contains("August")){
            System.out.println("Next month botton: Passed");
        }else{
            System.out.println("Next month botton: Failed");
        }

        Thread.sleep(2000);
        //clicking to "<" button on Calendar to be able to choose previous month
        driver.findElement(By.xpath("//div[@class='react-calendar__navigation']//button[2]")).click();

        if(driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).getText().contains("July")){
            System.out.println("Previous month botton: Passed");
        }else{
            System.out.println("Previous month botton: Failed");
        }

        //choosing date from selected month
        driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']//button[15]")).click();

        if(driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']//button[15]")).getText().contains("14")){
            System.out.println("Choosing date: Passed");
        }else{
            System.out.println("Choosing date: Failed");
        }
        driver.close();
    }


    /*
    Test Case 3: User should able to choose any of Events
    and see details of Event by clicking on it
     */

    public static void lookAtEventsDetails(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Opening Field Museum page
        driver.get("https://www.fieldmuseum.org");

        if(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/")){
            System.out.println("Field Museum Page: Passed");
        }else{
            System.out.println("Field Museum Page: Failed");
        }

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        if(driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText().equals("EVENTS")){
            System.out.println("Events page: Passed");
        }else{
            System.out.println("Events page: Failed");
        }

        //Opening event page by clicking on one of the given Upcoming Events

        driver.findElement(By.xpath("//a[@href='/our-events/fossils-flicks-bugs-life']")).click();

        if(driver.getCurrentUrl().contains("fossils-flicks-bugs-life")){
            System.out.println("Opening event details page: Passed");
        }else {
            System.out.println("Opening event details page: Failed");
        }
        driver.close();
    }
}

