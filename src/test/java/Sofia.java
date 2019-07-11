import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sofia {
    public static WebDriver driver;

    public static void setup(String link) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(link);
    }
    @Test(priority=1)
    public static void onlineStoreMainPage() {
        //Go to "https://www.fieldmuseum.org/". Main page should be displayed
        setup("https://www.fieldmuseum.org/");
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

    @Test(priority = 2)
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
    @Test(priority = 3)
    public static void FieldMuseumKidsItems() {
        //Verify the number of product items displayed on the first page page of Field Museum Kids is 24.
        List<WebElement> productsListPage1 = driver.findElements(By.xpath("//div[@class='ritems']//ul//li"));

        Assert.assertTrue(productsListPage1.size() == 24, "Count of displayed products on the Products Page is not 24: verification FAILED");

        //Click on "viewall" tab. Verify if all products are displayed on one page. Total Number of products is 330.
        driver.findElement(By.linkText("view all")).click();
        List<WebElement> totalPoductsList = driver.findElements(By.xpath("//div[@class='ritems']//ul//li"));

        Assert.assertTrue(!totalPoductsList.isEmpty(), "All products are displayed on a single page: verification FAILED");

    }

}
