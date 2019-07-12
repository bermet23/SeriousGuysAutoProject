import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainTestNG {
    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        CD.driver = driver;
        driver.get("https://www.fieldmuseum.org");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void close() {
        driver.close();
    }


    //Below three scenarios are Muhammet's test cases

    @Test
    public void CheckingEvents() throws InterruptedException {

//Clicks "Menu" button
        driver.findElement(By.xpath("//button[@class='header__menu-open js-menu-open']")).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Clicks "Event" button
        driver.findElement(By.xpath("//a[.='Events']")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Thread.sleep(2000);

        //9 time
//9 time clicks to the next arrow on calendar
        WebElement nextArrow = driver.findElement(By.xpath("//button[contains(@class,'next-button')]"));
//1
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//2
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//3
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//4
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//5
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//6
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//7
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//8
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//9
        nextArrow.click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Checks date on Calendar "April,28,2020"
        WebElement calendar = driver.findElement(By.xpath("//button[.='April 2020']"));
        Assert.assertEquals(calendar.getText(), ("April 2020"),"Date is not the same");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Clicks calendar to "April 28"
        driver.findElement(By.xpath("//button[.='28']")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

//Checks if there's no events to that day
       Assert.assertTrue(driver.findElement(By.xpath("//button[.='No More Content to Display']")).isDisplayed());

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

        Assert.assertEquals(driver.getCurrentUrl(), "https://store.fieldmuseum.org/Gifts/", "You are not in Gift webPage");

//Clicks "Under $10" checkbox
        driver.findElement(By.xpath("//input[@name='t_67']")).click();
        Thread.sleep(2000);

//Checks checkBox is selected
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='t_67']")).isSelected(), "#1 Checkbox is not selected");

        scrl.executeScript("window.scrollBy(0,3200)");
        Thread.sleep(2000);

//Clicks "view all" button
        driver.findElement(By.xpath("//a[.=' view all ']")).click();

        String[] prices = {"$7.99", "$6.99", "$9.99", "$9.99", "$8.99", "$8.99", "$9.99", "$9.99", "$8.99", "$6.99", "$8.99", "$8.99", "$7.99", "$7.99", "$3.99", "$7.99", "$9.99", "$5.99", "$4.99", "$6.99", "$9.99", "$7.99", "$8.99", "$8.99", "$8.99", "$9.99", "$7.99", "$9.99", "$7.99", "$7.99", "$7.95", "$7.99", "$9.99", "$5.99"};

//Getting prices from webPage
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='price']"));



//Checking prices from WebPage with given prices at AC
        Assert.assertEquals(price.size(), prices.length, "price.size are not the same");

        for (int i = 0; i >= price.size(); i++) {

            Assert.assertEquals(price.get(i), (prices[i]));
        }
    }
    @Test
    public void CheckingGiftsPrice10To20() throws InterruptedException {

        JavascriptExecutor scrl = (JavascriptExecutor) driver;


//Clicks "Store' button
        driver.findElement(By.xpath("//li[@class='header__nav-bar-item d-md-block d-none']/a[.='Store']")).click();

//Clicks "Gifts" button
        driver.findElement(By.xpath("//li[@class='have_sub'][6]")).click();
        Thread.sleep(2000);

//Checks webpage
        Assert.assertEquals(driver.getCurrentUrl(), "https://store.fieldmuseum.org/Gifts/", "#1 You are not in that webPage");

//Clicking checkBox "10$ - 20$"
        driver.findElement(By.xpath("//input[@name='t_70']")).click();
        Thread.sleep(2000);
        //  driver.findElements(By.xpath("//span[@class='price']"));
        List<WebElement> price = driver.findElements(By.className("price"));




//Checking prices from WebPage with given prices at AC
        String[] prices = {"$44.99", "$44.99", "$55.00", "$55.00", "$46.00", "$59.00", "$49.99", "$59.95", "$46.99", "$45.99", "$45.00", "$45.99", "$45.00", "$45.00", "$50.00", "$42.99", "$42.99,", "$49.99", "$44.99", "$59.99", "$44.99", "$44.99", "$59.99", "$59.99"};
        Assert.assertEquals(price.size(),prices.length);

            for (int i = 0; i >= price.size(); i++) {

                Assert.assertEquals(price.get(i),(prices[i]));

                }

    }

    // End of Muhammet's Test Cases

    //Below three scenarios are Akcholpon's Test Cases

    @Test
    public void filterEventsByChoosingAudience() throws InterruptedException {

        Thread.sleep(2000);

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@href='https://www.fieldmuseum.org/our-events']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText(), "EVENTS");
        Thread.sleep(2000);


        //clicking Audience box, to be able to choose audience to filter events
        driver.findElement(By.xpath("//div[@class='multi-select']")).click();

        String boxText = driver.findElement(By.xpath("//div[@class='multi-select active']")).getText();
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
    public void filterEventsByChoosingDate() throws InterruptedException {

        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        String pageTest = driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText();

        Assert.assertTrue(pageTest.equals("EVENTS"));

        //checking if Calendar is displayed on the Events page
        WebElement calendar = driver.findElement(By.xpath("//div[@class='react-calendar event-calendar']"));
        Assert.assertTrue(calendar.isDisplayed());

        //clicking to ">" button on Calendar to be able to choose next month
        driver.findElement(By.xpath("//div[@class='react-calendar__navigation']//button[4]")).click();

        String calendarText = driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).getText();
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
    public void lookAtEventsDetails() {


        //Opening Events page by clicking on All upcoming events button
        driver.findElement(By.xpath("//a[@class='mt-auto btn btn--tertiary']")).click();

        String pageTest = driver.findElement(By.xpath("//div[@class='col-12 basic-page__hero']//h1")).getText();

        Assert.assertTrue(pageTest.equals("EVENTS"));

        //Opening event page by clicking on one of the given Upcoming Events

        driver.findElement(By.xpath("//a[@href='/our-events/fossils-flicks-bugs-life']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("fossils-flicks-bugs-life"));

    }


    // End of Akcholpon's test cases

    // Below three Tesfaldet's test cases

    @Test
    public void becomeAMember() {
        // Select the membership menu from the home page and open it.
        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();
        //check if the logo and the title is displayed.
        WebElement Logo = driver.findElement(By.className("field-logo__wrapper"));
        Assert.assertTrue(Logo.isDisplayed());

        WebElement becomeMember = driver.findElement(By.linkText("Become a Member"));
        Assert.assertTrue(becomeMember.isDisplayed());


        WebElement info = driver.findElement(By.xpath("//div[@class ='row']"));
        Assert.assertTrue(info.isDisplayed());

    }

    @Test
    public void membershipBox() throws InterruptedException {
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
        Assert.assertTrue(text.contains("Who's included?"));


        WebElement oneYear = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[2]"));
        String Year1 = oneYear.getText().trim();
        Assert.assertTrue(Year1.contains("One year"));


        WebElement twoYear = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[3]"));
        String Year2 = twoYear.getText().trim();
        Assert.assertTrue(Year2.contains("Two years"));

        WebElement twoAdultChildren = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[1]"));
        String twoAD = twoAdultChildren.getText().trim();
        Assert.assertTrue(twoAD.contains("Two adults, children*, and one guest"));


        WebElement price = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[2]"));
        String price1 = price.getText();
        Assert.assertTrue(price1.contains("$180"));

        WebElement price2 = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[3]"));
        String price3 = price2.getText().trim();
        Assert.assertTrue(price3.contains("$345"));


        WebElement joinButton = driver.findElement(By.xpath("//a[@href='#modal-1'][1]"));
        Assert.assertTrue(joinButton.isDisplayed());

        WebElement renewButton = driver.findElement(By.xpath("//a[@href='#modal-2'][1]"));
        Assert.assertTrue(renewButton.isDisplayed());


    }

    @Test
    public void joinButton() throws InterruptedException {
// clicking the join button and go to the next page
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

    // End of Tesfaldet's Test Cases

    // Below three scenarios are Saim's Test Cases

    /*
        Plan Your Visit Linked Pages Test Case evaluates users going to Plan your visit page and being able to
        to click on the following linked pages and correctly being take to the clicked page: Exhibitions, Directions
        and Parking, Maps Guide, Amenities, Grainger Science Hub, Public Tours, Discovery Squad , and Meet a Scientist

     */

    @Test
    public void PlanYourVisitLinkedPages(){
        JavascriptExecutor jse = (JavascriptExecutor) CD.driver;

        jse.executeScript("scroll(0, 700);");
        CD.FindAndClick("link", "Visit Information");

        Assert.assertTrue(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit"));

        List<WebElement> links = CD.driver.findElements(By.xpath("//div[@class='container']/ul//a"));

        String [] expectedLinks = {"https://www.fieldmuseum.org/exhibitions","https://www.fieldmuseum.org/visit/directions-parking","https://www.fieldmuseum.org/visit/maps-guides","https://www.fieldmuseum.org/visit/amenities","https://www.fieldmuseum.org/exhibitions/grainger-science-hub","https://www.fieldmuseum.org/visit/daily-events/public-tours","https://www.fieldmuseum.org/visit/daily-events/discovery-squad","https://www.fieldmuseum.org/our-events/meet-scientist"};

        for(int i=0; i < links.size(); i++) {
            links = CD.driver.findElements(By.xpath("//div[@class='container']/ul//a"));
            links.get(i).click();
            Assert.assertEquals(CD.driver.getCurrentUrl(),expectedLinks[i]);
            CD.driver.navigate().back();
        }

    }

    /*
        Plan Your Visit Learn More Page URLS Test Case goes to the 'plan your visit' page from the field museum web page and
        verifies if all the 'learn more' links on the page are linked to the correct urls
        -> learnMore List holds all the 'learn more' button elements
        -> learnMoreNames List gets corresponding names to the 'learn more' buttons
        -> learnMOreLinks array holds all the correct expected url links
    */
    @Test

    public void PlanYourVisitLearnMorePageURLS(){
        CD.FindAndClick("link", "Visit Information");

        Assert.assertTrue(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit"));

        CD.ScrollPage(1500);

        List<WebElement> learnMore = CD.driver.findElements(By.xpath("//div[@class='entity entity-paragraphs-item paragraphs-item-titled-list-with-button']//a"));

        String[] learnMoreLinks = {"https://www.fieldmuseum.org/join-give/become-member",
                "https://www.citypass.com/chicago?mv_source=field&campaign=visit",
                "https://gocity.com/en-us/?kbid=5657&utm_medium=aff&utm_source=myap&utm_campaign=5657&utm_content=Your%20Default%20Affiliate%20Link",
                "http://www.chicityclerk.com/chicagocitykey",
                "https://www.fieldmuseum.org/our-events/free-admission-days"};

        CD.CreateMainHandle();

        for (int i = 0; i < learnMore.size(); i++) {
            learnMore = CD.driver.findElements(By.xpath("//div[@class='entity entity-paragraphs-item paragraphs-item-titled-list-with-button']//a"));
            learnMore.get(i).click();

                for(String handle : CD.driver.getWindowHandles()) {
                    if(!handle.equals(CD.mainHandle)) {
                        CD.switchWindow(handle);
                        break;
                    }
                }

            Assert.assertEquals(CD.driver.getCurrentUrl(),learnMoreLinks[i]);
            CD.driver.close();
            CD.switchWindow(CD.mainHandle);
        }

    }

    /*
        Plan Your Visit Ticket Information Test Case goes to the 'plan your visit' page after going to the main field museum
        web page and verifies if all the ticket information displayed on the page is as expected.
        -> The expected prices are stored in a String array called 'eachPrice'
        -> Each WebElement corresponding to the prices are stored into a List called 'prices'
        -> A loop is run  that checks the prices depending on the type of pass and the age of the person getting the pass and verifies
            if the prices match the expected price
   */

    @Test
    public void PlanYourVisitTicketInformation() {

        CD.FindAndClick("link", "Visit Information");
        Assert.assertTrue(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit"));

        CD.ScrollPage(450);

        List<WebElement> prices = CD.driver.findElements(By.xpath("//ul[@class='pricing-table']/li/span[2]"));

        String[] eachPrice = {"$40/38", "$29/27", "$35/33", "$34/32", "$25/23", "$30/28", "$26/24", "$19/17", "$23/21"};

        for (int i = 0, r = 0; i < 3; i++, r += 3) {
            Assert.assertTrue(prices.get(r).getText().equals(eachPrice[r]));
            Assert.assertTrue(prices.get(r + 1).getText().equals(eachPrice[r + 1]));
            Assert.assertTrue(prices.get(r + 2).getText().equals(eachPrice[r + 2]));
        }

    }

    // End of Saim's Test Cases

    // Below are Aidina's test cases


//      public void TestMesuem2() throws InterruptedException{

    //finding all links from that page and looping.I used "Action" class to hover over  through my elements.
    @Test
    public void testM() throws InterruptedException {
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class ='menu-full__nav-list pt-3']//a"));
        Thread.sleep(2000);
        //this line just a command that opens next window for me.
        String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
        //Storing my main page.

        //Storing my current url.

        String mainUrl = driver.getCurrentUrl();
        //looping though each link and opening pages one by one.


        for (WebElement l : links) {
            l.sendKeys(click);
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            String general = it.next();
            System.out.println(driver.getTitle());
            Thread.sleep(500);
            Assert.assertEquals(mainUrl, driver.getCurrentUrl());
            Thread.sleep(500);
            driver.switchTo().window(it.next());
            driver.close();

            driver.switchTo().window(general);

        }


    }

    // End of Aidina's Test Cases

    // Below are Sofia's three test scenarios

    @Test
    public static void onlineStoreMainPage() {
        //Navigate to "http://store.fieldmuseum.org/". Verify if the Store page is displayed.
        driver.navigate().to("http://store.fieldmuseum.org/");
        Assert.assertTrue(driver.getTitle().contains("Online Store"), "Navigation to the Online Store: FAILED!");


        //Verify number of links under Exclusives Tab is 5.
        List<WebElement> ExclusivesTab = driver.findElements(By.xpath("//div[@id='sub_Exclusives']//li//a"));
        Assert.assertTrue(ExclusivesTab.size() == 5, "Number of submenues under the Exclusive Tab ==5 verification: FAILED");


        //Verify if each submenu under the Exclusives Tab is clickable.

        int countClicksExclusives = 0;
        for (WebElement exclusive : ExclusivesTab) {
            if (exclusive.getAttribute("href").contains("Exclusives")) {
                countClicksExclusives++;
            }
        }
        Assert.assertTrue(countClicksExclusives == ExclusivesTab.size(), "All " + ExclusivesTab.size() + " tabs under Exclusives Tab are clickable: verification FAILED");

        //Verify number of links under Areas Of Interest Tab is 8.
        List<WebElement> AreasOfInterestTab = driver.findElements(By.xpath("//div[@id='sub_Areas Of Interest']//li//a"));
        Assert.assertTrue(AreasOfInterestTab.size() == 8, "Number of submenues under the Areas Of Interest Tab ==8 verification: FAILED");

        //Verify if each submenu under the Areas Of Interest Tab is clickable.
        int countClicksAreasOfInterestTab = 0;
        for (WebElement tab : AreasOfInterestTab) {
            if (tab.getAttribute("href").contains("AreasOfInterest")) {
                countClicksAreasOfInterestTab++;
            }
        }
        Assert.assertTrue(countClicksAreasOfInterestTab == AreasOfInterestTab.size(), "All " + AreasOfInterestTab.size() + " tabs under Areas Of Interest Tab are clickable: verification FAILED");

        //Verify number of links under Apparel & Accessories Tab is 8.
        List<WebElement> ApparelAndAccessoriesTab = driver.findElements(By.xpath("//div[@id='sub_Apparel & Accessories']//li//a"));
        Assert.assertTrue(ApparelAndAccessoriesTab.size() == 8, "Number of submenues under the Apparel & Accessories Tab ==8 verification: FAILED");


        //Verify if each submenu under the Apparel & Accessories Tab is clickable.
        int countClicksApparelAndAccessories = 0;
        for (WebElement tab : ApparelAndAccessoriesTab) {
            if (tab.getAttribute("href").contains("Apparel")) {
                countClicksApparelAndAccessories++;
            }
        }
        Assert.assertTrue(countClicksApparelAndAccessories == ApparelAndAccessoriesTab.size(), "All " + ApparelAndAccessoriesTab.size() + " tabs under  Apparel & Accessories Tab are clickable: verification FAILED");


        //Verify number of links under Home Tab is 7.
        List<WebElement> HomeTab = driver.findElements(By.xpath("//div[@id='sub_Home']//li//a"));
        Assert.assertTrue(HomeTab.size() == 7, "Number of submenues under the Home Tab ==7 verification: FAILED");

        //Verify if each submenu under the Home Tab is clickable.
        int countClicksHome = 0;
        for (WebElement tab : HomeTab) {
            if (tab.getAttribute("href").contains("Home")) {
                countClicksHome++;
            }
        }
        Assert.assertTrue(countClicksHome == HomeTab.size(), "All " + HomeTab.size() + " tabs under Home Tab are clickable: verification FAILED");


        //Verify number of links under Kids Tab is 4.
        List<WebElement> KidsTab = driver.findElements(By.xpath("//div[@id='sub_Kids']//li//a"));
        Assert.assertTrue(KidsTab.size() == 4, "Number of submenues under the Kids Tab ==4 verification: FAILED");

        //Verify if each submenu under the Kids Tab is clickable.
        int countClicksKids = 0;
        for (WebElement tab : KidsTab) {
            if (tab.getAttribute("href").contains("Kids")) {
                countClicksKids++;
            }
        }
        Assert.assertTrue(countClicksKids == KidsTab.size(), "All " + KidsTab.size() + " tabs under Kids Tab are clickable: verification FAILED");

        //Verify number of links under Gifts Tab is 6.
        List<WebElement> GiftsTab = driver.findElements(By.xpath("//div[@id='sub_Gifts']//li//a"));
        Assert.assertTrue(GiftsTab.size() == 6, "Number of submenues under the Gifts Tab ==6 verification: FAILED");

        //Verify if each submenu under the Gifts Tab is clickable.
        int countClicksGifts = 0;
        for (WebElement tab : GiftsTab) {
            if (tab.getAttribute("href").contains("Gifts")) {
                countClicksGifts++;
            }
        }
        Assert.assertTrue(countClicksGifts == GiftsTab.size(), "All " + GiftsTab.size() + " tabs under Gifts Tab are clickable: verification FAILED");


    }

    @Test
    public static void checkbox() {
        //Navigate to https://store.fieldmuseum.org/Kids/?a=67&sb=0&ipg=2. Verify if a new Field Museum Kids  page is displayed
        driver.navigate().to("https://store.fieldmuseum.org/Kids/?a=67&sb=0&ipg=24");

        Assert.assertTrue(driver.getTitle().contains("Field Museum Kids"), "Navigation to 'Field Museum Kids' page FAILED");

        //Go to dropdown box SortItemsBy. Verify the number of options displayed is 5.
        WebElement sortBy = driver.findElement(By.xpath("//span[@class='pulldowns']//select[@class='sortby']"));
        Select selectSort = new Select(sortBy);

        List<WebElement> sortItemsList = selectSort.getOptions();
        Assert.assertTrue(sortItemsList.size() == 5, "Number of Options displayed under SortItemsBy equals to 5: FAILED");

        //Verify if each of 5 options texts matches the texts in the optionsArr.
        String[] optionsArr = {"Sort by Featured Items", "Sort by: Newest Items", "Sort by: Top Sellers", "Sort by: Price high-low", "Sort by: Price low-high"};
        int optionsArrInd = 1;
        for (WebElement item : sortItemsList) {
            if (item.getText().equals(optionsArr[optionsArrInd])) {
                optionsArrInd++;
            }
        }
        Assert.assertTrue(optionsArrInd == sortItemsList.size(), "All of the main tabs titles on the OnlineStore page match expected output: PASSED");

        //Verify the default displayed option matches "Sort by Featured Items"
        Assert.assertTrue(selectSort.getFirstSelectedOption().getText().equals("Sort by Featured Items"), "Option displayed by default matches 'Sort by Featured Items' verification: FAILED");
    }

    @Test
    public static void FieldMuseumKidsItems() {
        driver.navigate().to("https://store.fieldmuseum.org/Kids/?a=67&sb=0&ipg=24");
        //Verify the number of product items displayed on the first page page of Field Museum Kids is 24.
        List<WebElement> productsListPage1 = driver.findElements(By.xpath("//div[@class='ritems']//ul//li"));

        Assert.assertTrue(productsListPage1.size() == 24, "Count of displayed products on the Products Page is not 24: verification FAILED");

        //Click on "viewall" tab. Verify if all products are displayed on one page. Total Number of products is 330.
        driver.findElement(By.linkText("view all")).click();
        List<WebElement> totalPoductsList = driver.findElements(By.xpath("//div[@class='ritems']//ul//li"));

        Assert.assertTrue(!totalPoductsList.isEmpty(), "All products are displayed on a single page: verification FAILED");

    }


}
