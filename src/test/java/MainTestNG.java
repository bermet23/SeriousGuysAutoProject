import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTestNG {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        CD.driver = driver;
        driver.get("https://www.fieldmuseum.org");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    @Test
    public void CheckingEvents() throws InterruptedException {

//Clicks "Menu" button
        driver.findElement(By.xpath("//button[@class='header__menu-open js-menu-open']")).click();
        Thread.sleep(2000);

//Clicks "Event" button
        driver.findElement(By.xpath("//a[.='Events']")).click();
        Thread.sleep(2000);

//Clicks calendar to "July 10"
        driver.findElement(By.xpath("//time[@datetime='2019-07-10T00:00:00.000']")).click();
        Thread.sleep(2000);

//Clicks to "Poetry Pop-Up: Faceted Poetry"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[1]")).click();
        Thread.sleep(2000);

//Checks "Poetry Pop-Up: Faceted Poetry" page is opened

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/poetry-pop-faceted-poetry", "#1 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fossils & Flicks: Men In Black"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[2]")).click();
        Thread.sleep(2000);

//Checks "Fossils & Flicks: Men In Black" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/fossils-flicks-men-black", "#2 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fantastic Bug Encounters! Member Viewing and Presentation"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[3]")).click();
        Thread.sleep(2000);

//Checks "Fantastic Bug Encounters! Member Viewing and Presentation" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/fantastic-bug-encounters-member-viewing-and-presentation", "#3 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Member-only Docent Tours: Birds of North America"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[4]")).click();
        Thread.sleep(2000);

//Checks "Member-only Docent Tours: Birds of North America" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/member-only-docent-tours-birds-north-america", "#4 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fossils & Flicks: A Bug’s Life"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[5]")).click();
        Thread.sleep(2000);

//Checks "Fossils & Flicks: A Bug’s Life" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/fossils-flicks-bugs-life", "#5 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Poetry Pop-Up: Fantastic Bug Encounters"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[6]")).click();
        Thread.sleep(2000);

//Checks "Poetry Pop-Up: Fantastic Bug Encounters" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/poetry-pop-fantastic-bug-encounters", "#6 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fossils & Flicks: Toy Story"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[7]")).click();
        Thread.sleep(2000);

//Checks "Fossils & Flicks: Toy Story" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/fossils-flicks-toy-story", "#7 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Meet a Scientist: The Value of Seeds"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[8]")).click();
        Thread.sleep(2000);

//Checks "Meet a Scientist: The Value of Seeds" page is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/meet-scientist-value-seeds", "#8 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Meet a Scientist: Processing New Acquisitions in Anthropology"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[9]")).click();
        Thread.sleep(2000);

//Checks "Meet a Scientist: Processing New Acquisitions in Anthropology" is opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fieldmuseum.org/our-events/meet-scientist-processing-new-acquisitions-anthropology", "#9 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks "Poetry Pop-Up: Odes to SUE"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[10]")).click();
        Thread.sleep(2000);

//Checks "Poetry Pop-Up: Odes to SUE" page is opened
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.fieldmuseum.org/our-events/poetry-pop-odes-sue","#10 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to Fossils & Flicks: Bee Movie
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[11]")).click();
        Thread.sleep(2000);

//Checks Fossils & Flicks: Bee Movie page is opened
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.fieldmuseum.org/our-events/fossils-flicks-bee-movie","#11 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to Fossils & Flicks: Finding Dory
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[12]")).click();
        Thread.sleep(2000);

//Checks Fossils & Flicks: Finding Dory page is opened
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.fieldmuseum.org/our-events/fossils-flicks-finding-dory","#12 You are not in that webPage");

        driver.navigate().back();
        Thread.sleep(2000);

//        JavascriptExecutor jv = (JavascriptExecutor) driver;
//        jv.executeScript("scroll(0, 4500);");
//        Thread.sleep(3000);





    }

    @Test
    public void CheckingGiftsPriceUnder10() throws InterruptedException {


        JavascriptExecutor scrl = (JavascriptExecutor) driver;


//Clicks "Store' button
        driver.findElement(By.xpath("//li[@class='header__nav-bar-item d-md-block d-none']/a[.='Store']")).click();

//Clicks "Gifts" button
        driver.findElement(By.xpath("//li[@class='have_sub'][6]")).click();
        Thread.sleep(2000);

//Checks webpage

        Assert.assertEquals(driver.getCurrentUrl(),"https://store.fieldmuseum.org/Gifts/","You are not in Gift webPage");

//Clicks "Under $10" checkbox
        driver.findElement(By.xpath("//input[@name='t_67']")).click();
        Thread.sleep(2000);

//Checks checkBox is selected
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='t_67']")).isSelected(),"#1 Checkbox is not selected");

        scrl.executeScript("window.scrollBy(0,3200)");
        Thread.sleep(2000);

//Clicks "view all" button
        driver.findElement(By.xpath("//a[.=' view all ']")).click();

        String[] prices = {"$7.99", "$6.99", "$9.99", "$9.99", "$8.99", "$8.99", "$9.99", "$9.99", "$8.99", "$6.99", "$8.99", "$8.99", "$7.99", "$7.99", "$3.99", "$7.99", "$9.99", "$5.99", "$4.99", "$6.99", "$9.99", "$7.99", "$8.99", "$8.99", "$8.99", "$9.99", "$7.99", "$9.99", "$7.99", "$7.99", "$7.95", "$7.99", "$9.99", "$5.99"};

//Getting prices from webPage
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='price']"));

        boolean check = true;

//Checking prices from WebPage with given prices at AC
        if (price.size() == prices.length) {
            for (int i = 0; i >= price.size(); i++) {

                if (price.get(i).equals(prices[i])) {
                    check = true;

                } else {
                    check = false;
                    break;
                }
            }
            System.out.println("Checking prices: " + check);
        } else {
            System.out.println("Failed");
        }


    }

    @Test
    public  void CheckingGiftsPrice10To20() throws InterruptedException {

        JavascriptExecutor scrl = (JavascriptExecutor) driver;


//Clicks "Store' button
        driver.findElement(By.xpath("//li[@class='header__nav-bar-item d-md-block d-none']/a[.='Store']")).click();

//Clicks "Gifts" button
        driver.findElement(By.xpath("//li[@class='have_sub'][6]")).click();
        Thread.sleep(2000);

//Checks webpage
        Assert.assertEquals(driver.getCurrentUrl(),"https://store.fieldmuseum.org/Gifts/","#1 You are not in that webPage");

//Clicking checkBox "10$ - 20$"
        driver.findElement(By.xpath("//input[@name='t_70']")).click();
        Thread.sleep(2000);
        //  driver.findElements(By.xpath("//span[@class='price']"));
        List<WebElement> price = driver.findElements(By.className("price"));

        boolean check = true;


//Checking prices from WebPage with given prices at AC
        String[] prices = {"$44.99", "$44.99", "$55.00", "$55.00", "$46.00", "$59.00", "$49.99", "$59.95", "$46.99", "$45.99", "$45.00", "$45.99", "$45.00", "$45.00", "$50.00", "$42.99", "$42.99,", "$49.99", "$44.99", "$59.99", "$44.99", "$44.99", "$59.99", "$59.99"};
        if (price.size() == prices.length) {
            for (int i = 0; i >= price.size(); i++) {

                if (price.get(i).equals(prices[i])) {
                    check = true;

                } else {
                    check = false;
                    break;
                }
            }
            System.out.println("Checking prices: " + check);
        } else {
            System.out.println("Failed");
        }
    }



}
