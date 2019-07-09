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

    //Below three scenarious are Akcholpon test cases
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


    // End of Akcholpon's test cases

    // below three tesfaldet's test cases
    @Test
    public  void becomeAMember() {
        // Select the membership menu from the home page and open it.
        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();
        //check if tye logo and the title is displayed.
        WebElement Logo = driver.findElement(By.className("field-logo__wrapper"));
        Assert.assertTrue(Logo.isDisplayed());

        WebElement becomeMember = driver.findElement(By.linkText("Become a Member"));
        Assert.assertTrue(becomeMember.isDisplayed()) ;


        WebElement info = driver.findElement(By.xpath("//div[@class ='row']"));
        Assert.assertTrue(info.isDisplayed()) ;


    }
    @Test
    public  void membershipBox() throws InterruptedException{
        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();
        //locate the membership, discovery circle and founders council and open them.
        WebElement member = driver.findElement(By.id("accordion__button-1"));
        member.click();
        Thread.sleep(2000);
        WebElement dicoveryCircle = driver.findElement(By.id("accordion__button-18"));
        dicoveryCircle.click();
        Thread.sleep(2000);
        WebElement foundersCouncil = driver.findElement(By.id("accordion__button-25"));
        foundersCouncil.click();
        // check the all the texts and the prices are displayed in the  membership box .

        String familyPlus = driver.findElement(By.xpath("(//div[@class='membership-card__wrapper p-3 p-md-5']//div//div/h4)[1]")).getText();
        // String str = familyPlus.getText().trim();
        //"Family Plus
        Assert.assertTrue(familyPlus.contains("Family Plus"));

        WebElement isIncluded = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[1]"));
        String text = isIncluded.getText().trim();
        Assert.assertTrue(text.contains("Who's included?")) ;


        WebElement oneYear = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[2]"));
        String Year1 = oneYear.getText().trim();
        Assert.assertTrue(Year1.contains("One year")) ;


        WebElement twoYear = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[3]"));
        String Year2 = twoYear.getText().trim();
        Assert.assertTrue(Year2.contains("Two years")) ;

        WebElement twoAdultChildren = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[1]"));
        String twoAD = twoAdultChildren.getText().trim();
        Assert.assertTrue(twoAD.contains("Two adults, children*, and one guest")) ;


        WebElement price = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[2]"));
        String price1 = price.getText();
        Assert.assertTrue(price1.contains("$180")) ;

        WebElement price2 = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[3]"));
        String price3 = price2.getText().trim();
        Assert.assertTrue(price3.contains("$345")) ;


        WebElement joinButton = driver.findElement(By.xpath("//a[@href='#modal-1'][1]"));
        Assert.assertTrue(joinButton.isDisplayed()) ;

        WebElement renewButton = driver.findElement(By.xpath("//a[@href='#modal-2'][1]"));
        Assert.assertTrue(renewButton.isDisplayed());


    }
    @Test
    public void joinButton() throws InterruptedException {
        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();
        Thread.sleep(1000);
        WebElement member = driver.findElement(By.id("accordion__button-1"));
        member.click();
        WebElement joinButton = driver.findElement(By.xpath("//a[@href='#modal-1'][1]"));
        joinButton.click();


        Thread.sleep(1000);
        WebElement joinText = driver.findElement(By.xpath("(//div[@class='copy']/p[1])[9]"));
        String JT = joinText.getText();
        String text1 = "You chose Family Plus Membership. Do you want to purchase this membership for one or two years?";
        Assert.assertTrue(JT.contains(text1));
        Thread.sleep(1000);
        WebElement oneYearJoin = driver.findElement(By.xpath("(//a[.='One Year'])[6]"));
        oneYearJoin.click();


    }

    }
