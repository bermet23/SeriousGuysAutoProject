import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Akcholpon {

    WebDriver driver;


    @Test
    public void filterEventsByChoosingAudience() throws InterruptedException{

        Thread.sleep(2000);

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@href='https://www.fieldmuseum.org/our-events']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText(),"EVENTS");
        Thread.sleep(2000);


        //clicking Audience box, to be able to choose audience to filter events
        driver.findElement(By.xpath("//div[@class='multi-select']")).click();

        String  boxText = driver.findElement(By.xpath("//div[@class='multi-select active']")).getText();
        Thread.sleep(2000);

        Assert.assertTrue(boxText.contains("Audience"));

        //clicking on Families checkbox from given options
        driver.findElement(By.xpath("(//li[@class='checkbox'])[1]")).click();
        Thread.sleep(2000);


        WebElement selected = driver.findElement(By.xpath("//li[@class='checkbox']/input"));

        Assert.assertTrue(selected.isSelected());
        Thread.sleep(2000);


        //clicking on Apply botton to be able to see only filtered events
        driver.findElement(By.xpath("//div[@class='multi-select__options-footer']//button")).click();

        String pageText = driver.findElement(By.xpath("//button[@class='tag tag--blue tag--closable']/span")).getText();
        Thread.sleep(2000);

        Assert.assertTrue(pageText.contains("FAMILIES"));

    }


    /*
    TestCase 2 :User should able to filter upcoming events by selecting date and month
    */

    @Test
    public void filterEventsByChoosingDate() throws InterruptedException{

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        String pageTest = driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText();

        Assert.assertTrue(pageTest.equals("EVENTS"));

        //checking if Calendar is displayed on the Events page
        WebElement calendar = driver.findElement(By.xpath("//div[@class='react-calendar event-calendar']"));
        Assert.assertTrue(calendar.isDisplayed());

        //clicking to ">" button on Calendar to be able to choose next month
        driver.findElement(By.xpath("//div[@class='react-calendar__navigation']//button[4]")).click();

        String  calendarText = driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).getText();
        Assert.assertTrue(calendarText.contains("August"));

        Thread.sleep(2000);
        //clicking to "<" button on Calendar to be able to choose previous month
        driver.findElement(By.xpath("//div[@class='react-calendar__navigation']//button[2]")).click();

        String calendarTextTwo = driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).getText();
        Assert.assertTrue(calendarTextTwo.contains("July"));

        //choosing date from selected month
        driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']//button[15]")).click();

        String dateText = driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']//button[15]")).getText();
        Assert.assertTrue(dateText.contains("14"));

    }


    /*
    Test Case 3: User should able to choose any of Events
    and see details of Event by clicking on it
     */

    @Test
    public  void lookAtEventsDetails(){


        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        String pageTest = driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText();

        Assert.assertTrue(pageTest.equals("EVENTS"));

        //Opening event page by clicking on one of the given Upcoming Events

        driver.findElement(By.xpath("//a[@href='/our-events/fossils-flicks-bugs-life']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("fossils-flicks-bugs-life"));

    }
}

