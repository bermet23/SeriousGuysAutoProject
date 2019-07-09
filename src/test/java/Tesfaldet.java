import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tesfaldet {

    WebDriver driver;
    @BeforeMethod

    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.fieldmuseum.org/");

    }
    @Test(priority = 1)
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
    @Test(priority = 2)
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
    @Test(priority = 3)
    public void joinButton() throws InterruptedException{
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
}


