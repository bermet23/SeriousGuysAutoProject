import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

    public static void onlineStoreMainPage() {
        //Go to "https://www.fieldmuseum.org/". Main page should be displayed
        setup("https://www.fieldmuseum.org/");
        //Navigate to "http://store.fieldmuseum.org/". Verify if the Store page is displayed.
        driver.navigate().to("http://store.fieldmuseum.org/");
        if (driver.getTitle().contains("Online Store")) {
            System.out.println("Navigation to the Online Store: SUCCESSFUL!");
        } else {
            System.out.println("Navigation to the Online Store: FAILED!");
        }

        //Verify number of links under Exclusives Tab is 5.
        List<WebElement> ExclusivesTab = driver.findElements(By.xpath("//div[@id='sub_Exclusives']//li//a"));
        if (ExclusivesTab.size() == 5) {
            System.out.println("Number of submenues under the Exclusive Tab ==5 verification: PASSED");
        } else {
            System.out.println("Number of submenues under the Exclusive Tab ==5 verification: FAILED");
        }

        //Verify if each submenu under the Exclusives Tab is clickable.

        int countClicksExclusives = 0;
        for (WebElement exclusive : ExclusivesTab) {
            if (exclusive.getAttribute("href").contains("Exclusives")) {
                countClicksExclusives++;
            }
        }
        if (countClicksExclusives == ExclusivesTab.size()) {
            System.out.println("All " + ExclusivesTab.size() + " tabs under Exclusives Tab are clickable: verification PASSED");
        } else {
            System.out.println("All " + ExclusivesTab.size() + " tabs under Exclusives Tab are clickable: verification FAILED");
        }


        //Verify number of links under Areas Of Interest Tab is 8.
        List<WebElement> AreasOfInterestTab = driver.findElements(By.xpath("//div[@id='sub_Areas Of Interest']//li//a"));
        if (AreasOfInterestTab.size() == 8)

        {
            System.out.println("Number of submenues under the Areas Of Interest Tab ==8 verification: PASSED");
        } else

        {
            System.out.println("Number of submenues under the Areas Of Interest Tab ==8 verification: FAILED");
        }

//Verify if each submenu under the Areas Of Interest Tab is clickable.
        int countClicksAreasOfInterestTab = 0;
        for (WebElement tab : AreasOfInterestTab) {
            if (tab.getAttribute("href").contains("AreasOfInterest")) {
                countClicksAreasOfInterestTab++;
            }
        }
        if (countClicksAreasOfInterestTab == AreasOfInterestTab.size()) {
            System.out.println("All " + AreasOfInterestTab.size() + " tabs under  Areas Of Interest Tab are clickable: verification PASSED");
        } else {
            System.out.println("All " + AreasOfInterestTab.size() + " tabs under Areas Of Interest Tab are clickable: verification FAILED");
        }
        //Verify number of links under Apparel & Accessories Tab is 8.
        List<WebElement> ApparelAndAccessoriesTab = driver.findElements(By.xpath("//div[@id='sub_Apparel & Accessories']//li//a"));
        if (ApparelAndAccessoriesTab.size() == 8)

        {
            System.out.println("Number of submenues under the Apparel & Accessories Tab ==8 verification: PASSED");
        } else

        {
            System.out.println("Number of submenues under the Apparel & Accessories Tab ==8 verification: FAILED");
        }

        //Verify if each submenu under the Apparel & Accessories Tab is clickable.
        int countClicksApparelAndAccessories = 0;
        for (WebElement tab : ApparelAndAccessoriesTab) {
            if (tab.getAttribute("href").contains("Apparel")) {
                countClicksApparelAndAccessories++;
            }
        }
        if (countClicksApparelAndAccessories == ApparelAndAccessoriesTab.size()) {
            System.out.println("All " + ApparelAndAccessoriesTab.size() + " tabs under  Apparel & Accessories Tab are clickable: verification PASSED");
        } else {
            System.out.println("All " + ApparelAndAccessoriesTab.size() + " tabs under  Apparel & Accessories Tab are clickable: verification FAILED");
        }

        //Verify number of links under Home Tab is 7.
        List<WebElement> HomeTab = driver.findElements(By.xpath("//div[@id='sub_Home']//li//a"));
        if (HomeTab.size() == 7)

        {
            System.out.println("Number of submenues under the Home Tab ==7 verification: PASSED");
        } else

        {
            System.out.println("Number of submenues under the Home Tab ==7 verification: FAILED");
        }
        //Verify if each submenu under the Home Tab is clickable.
        int countClicksHome = 0;
        for (WebElement tab : HomeTab) {
            if (tab.getAttribute("href").contains("Home")) {
                countClicksHome++;
            }
        }
        if (countClicksHome == HomeTab.size()) {
            System.out.println("All " + HomeTab.size() + " tabs under  Home Tab are clickable: verification PASSED");
        } else {
            System.out.println("All " + HomeTab.size() + " tabs under Home Tab are clickable: verification FAILED");
        }
        //Verify number of links under Kids Tab is 4.
        List<WebElement> KidsTab = driver.findElements(By.xpath("//div[@id='sub_Kids']//li//a"));
        if (KidsTab.size() == 4)

        {
            System.out.println("Number of submenues under the Kids Tab ==4 verification: PASSED");
        } else

        {
            System.out.println("Number of submenues under the Kids Tab ==4 verification: FAILED");
        }
        //Verify if each submenu under the Kids Tab is clickable.
        int countClicksKids = 0;
        for (WebElement tab : KidsTab) {
            if (tab.getAttribute("href").contains("Kids")) {
                countClicksKids++;
            }
        }
        if (countClicksKids == KidsTab.size()) {
            System.out.println("All " + KidsTab.size() + " tabs under Kids Tab are clickable: verification PASSED");
        } else {
            System.out.println("All " + KidsTab.size() + " tabs under Kids Tab are clickable: verification FAILED");
        }

        //Verify number of links under Gifts Tab is 6.
        List<WebElement> GiftsTab = driver.findElements(By.xpath("//div[@id='sub_Gifts']//li//a"));
        if (GiftsTab.size() == 6)

        {
            System.out.println("Number of submenues under the Gifts Tab ==6 verification: PASSED");
        } else

        {
            System.out.println("Number of submenues under the Gifts Tab ==6 verification: FAILED");
        }

        //Verify if each submenu under the Gifts Tab is clickable.
        int countClicksGifts = 0;
        for (WebElement tab : GiftsTab) {
            if (tab.getAttribute("href").contains("Gifts")) {
                countClicksGifts++;
            }
        }
        if (countClicksGifts == GiftsTab.size()) {
            System.out.println("All " + GiftsTab.size() + " tabs under Gifts Tab are clickable: verification PASSED");
        } else {
            System.out.println("All " + GiftsTab.size() + " tabs under Gifts Tab are clickable: verification FAILED");
        }
    }
    public static void checkbox () {
        //Navigate to https://store.fieldmuseum.org/Kids/?a=67&sb=0&ipg=2. Verify if a new Field Museum Kids  page is displayed
        driver.navigate().to("https://store.fieldmuseum.org/Kids/?a=67&sb=0&ipg=24");

        if (driver.getTitle().contains("Field Museum Kids")) {
            System.out.println("Navigation to 'Field Museum Kids' page SUCCESSFUL");
        } else {
            System.out.println("Navigation to 'Field Museum Kids' page FAILED");
        }

        //Go to dropdown box SortItemsBy. Verify the number of options displayed is 5.
        WebElement sortBy = driver.findElement(By.xpath("//span[@class='pulldowns']//select[@class='sortby']"));
        Select selectSort = new Select(sortBy);

        List<WebElement> sortItemsList = selectSort.getOptions();
        if (sortItemsList.size() == 5) {
            System.out.println("Number of Options displayed under SortItemsBy equals to 5: PASSED");
        } else {
            System.out.println("Number of Options displayed under SortItemsBy equals to 5: FAILED");
        }
        //Verify if each of 5 options texts matches the texts in the optionsArr.
        String[] optionsArr = {"Sort by Featured Items", "Sort by: Newest Items", "Sort by: Top Sellers", "Sort by: Price high-low", "Sort by: Price low-high"};
        int optionsArrInd = 1;
        for (WebElement item : sortItemsList) {
            if (item.getText().equals(optionsArr[optionsArrInd])) {
                optionsArrInd++;
            }
        }
        if (optionsArrInd ==sortItemsList.size()) {
            System.out.println("All of the main tabs titles on the OnlineStore page match expected output: PASSED");
        }
        else {
            System.out.println("All of the main tabs titles on the OnlineStore page match expected output: PASSED");
        }

        //Verify the default displayed option matches "Sort by Featured Items"
        if (selectSort.getFirstSelectedOption().getText().equals("Sort by Featured Items")) {
            System.out.println("Option displayed by default matches 'Sort by Featured Items' verification: PASSED");
        } else {
            System.out.println("Option displayed by default matches 'Sort by Featured Items' verification: FAILED");
        }

    }


    public static void FieldMuseumKidsItems () throws InterruptedException {
        //Verify the number of product items displayed on the first page page of Field Museum Kids is 24.
        List<WebElement> productsListPage1 = driver.findElements(By.xpath("//div[@class='ritems']//ul//li"));

        if (productsListPage1.size() == 24) {
            System.out.println("Count of displayed products on the Products Page is 24: verification PASSED");
        } else {
            System.out.println("Count of displayed products on the Products Page is not 24: verification FAILED");
        }
//Click on "viewall" tab. Verify if all products are displayed on one page. Total Number of products is 330.
        driver.findElement(By.linkText("view all")).click();
        List<WebElement> totalPoductsList = driver.findElements(By.xpath("//div[@class='ritems']//ul//li"));
        if (totalPoductsList.size() == 330) {
            System.out.println("All products are displayed on a single page: verification PASSED");
        } else {
            System.out.println("All products are displayed on a single page: verification FAILED");
        }
        driver.close();
    }


}


