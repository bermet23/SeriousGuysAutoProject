import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Muhammet {

    public static void CheckingEvents() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fieldmuseum.org/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

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

        System.out.println("Poetry Pop-Up: Faceted Poetry: " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/poetry-pop-faceted-poetry")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fossils & Flicks: Men In Black"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[2]")).click();
        Thread.sleep(2000);

//Checks "Fossils & Flicks: Men In Black" page is opened
        System.out.println("\"Fossils & Flicks: Men In Black\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/fossils-flicks-men-black")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fantastic Bug Encounters! Member Viewing and Presentation"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[3]")).click();
        Thread.sleep(2000);

//Checks "Fantastic Bug Encounters! Member Viewing and Presentation" page is opened
        System.out.println("\"Fantastic Bug Encounters! Member Viewing and Presentation\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/fantastic-bug-encounters-member-viewing-and-presentation")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Member-only Docent Tours: Birds of North America"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[4]")).click();
        Thread.sleep(2000);

//Checks "Member-only Docent Tours: Birds of North America" page is opened
        System.out.println("\"Member-only Docent Tours: Birds of North America\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/member-only-docent-tours-birds-north-america")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fossils & Flicks: A Bug’s Life"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[5]")).click();
        Thread.sleep(2000);

//Checks "Fossils & Flicks: A Bug’s Life" page is opened
        System.out.println("\"Fossils & Flicks: A Bug’s Life\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/fossils-flicks-bugs-life")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Poetry Pop-Up: Fantastic Bug Encounters"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[6]")).click();
        Thread.sleep(2000);

//Checks "Poetry Pop-Up: Fantastic Bug Encounters" page is opened
        System.out.println("\"Poetry Pop-Up: Fantastic Bug Encounters\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/poetry-pop-fantastic-bug-encounters")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Fossils & Flicks: Toy Story"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[7]")).click();
        Thread.sleep(2000);

//Checks "Fossils & Flicks: Toy Story" page is opened
        System.out.println("\"Fossils & Flicks: Toy Story\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/fossils-flicks-toy-story")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Meet a Scientist: The Value of Seeds"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[8]")).click();
        Thread.sleep(2000);

//Checks "Meet a Scientist: The Value of Seeds" page is opened
        System.out.println("\"Meet a Scientist: The Value of Seeds\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/meet-scientist-value-seeds")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to "Meet a Scientist: Processing New Acquisitions in Anthropology"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[9]")).click();
        Thread.sleep(2000);

//Checks "Meet a Scientist: Processing New Acquisitions in Anthropology" is opened
        System.out.println("\"Meet a Scientist: Processing New Acquisitions in Anthropology\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/meet-scientist-processing-new-acquisitions-anthropology")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks "Poetry Pop-Up: Odes to SUE"
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[10]")).click();
        Thread.sleep(2000);

//Checks "Poetry Pop-Up: Odes to SUE" page is opened
        System.out.println("\"Poetry Pop-Up: Odes to SUE\": " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/poetry-pop-odes-sue")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to Fossils & Flicks: Bee Movie
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[11]")).click();
        Thread.sleep(2000);

//Checks Fossils & Flicks: Bee Movie page is opened
        System.out.println("Fossils & Flicks: Bee Movie: " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/fossils-flicks-bee-movie")));

        driver.navigate().back();
        Thread.sleep(2000);

//Clicks to Fossils & Flicks: Finding Dory
        driver.findElement(By.xpath("(//a[@class='calendar-full__title h2 mb-0 mb-3 d-inline-block'])[12]")).click();
        Thread.sleep(2000);

//Checks Fossils & Flicks: Finding Dory page is opened
        System.out.println("Fossils & Flicks: Finding Dory: " + CD.passOrFail(driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/fossils-flicks-finding-dory")));

        driver.navigate().back();
        Thread.sleep(2000);

//        JavascriptExecutor jv = (JavascriptExecutor) driver;
//        jv.executeScript("scroll(0, 4500);");
//        Thread.sleep(3000);


        driver.close();


    }

    public static void CheckingGiftsPriceUnder10() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fieldmuseum.org/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        JavascriptExecutor scrl = (JavascriptExecutor) driver;


//Clicks "Store' button
        driver.findElement(By.xpath("//li[@class='header__nav-bar-item d-md-block d-none']/a[.='Store']")).click();

//Clicks "Gifts" button
        driver.findElement(By.xpath("//li[@class='have_sub'][6]")).click();
        Thread.sleep(2000);

//Checks webpage

        System.out.println("Right webpage is opened: " + CD.passOrFail(driver.getCurrentUrl().equals("https://store.fieldmuseum.org/Gifts/")));

//Clicks "Under $10" checkbox
        driver.findElement(By.xpath("//input[@name='t_67']")).click();
        Thread.sleep(2000);

//Checks checkBox is selected
        System.out.println("Check box is selected: " + CD.passOrFail(driver.findElement(By.xpath("//input[@name='t_67']")).isSelected()));

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

        driver.close();
    }

    public static void CheckingGiftsPrice10To20() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fieldmuseum.org/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        JavascriptExecutor scrl = (JavascriptExecutor) driver;


//Clicks "Store' button
        driver.findElement(By.xpath("//li[@class='header__nav-bar-item d-md-block d-none']/a[.='Store']")).click();

//Clicks "Gifts" button
        driver.findElement(By.xpath("//li[@class='have_sub'][6]")).click();
        Thread.sleep(2000);

//Checks webpage
        System.out.println("Right webpage is opened: " + CD.passOrFail(driver.getCurrentUrl().equals("https://store.fieldmuseum.org/Gifts/")));

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

        driver.close();
    }


}

