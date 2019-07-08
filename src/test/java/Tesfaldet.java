import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tesfaldet {
    public static void main(String[] args) {
        joinBotton();
    }

    public static void becomeAMember() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fieldmuseum.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        // Select the membership menu from the home page and open it.
        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();
        //check if tye logo and the title is displayed.
        WebElement Logo = driver.findElement(By.className("field-logo__wrapper"));
        if (Logo.isDisplayed()) {
            System.out.println("logo is displayed");
        } else {
            System.out.println("logo is not displayed");
        }
        WebElement becomeMember = driver.findElement(By.linkText("Become a Member"));
        if (becomeMember.isDisplayed()) {
            System.out.println("Become a Member is displayed");
        } else {
            System.out.println("Become a Member is not displayed");
        }
        WebElement info = driver.findElement(By.xpath("//div[@class ='row']"));
        if (info.isDisplayed()) {
            System.out.println("info is displayed");
        } else {
            System.out.println("info is not displayed");
        }
        //locate the membership, discovery circle and founders council and open them.
        WebElement member = driver.findElement(By.id("accordion__button-1"));
        member.click();
        WebElement dicoveryCircle = driver.findElement(By.id("accordion__button-18"));
        dicoveryCircle.click();
        WebElement foundersCouncil = driver.findElement(By.id("accordion__button-25"));
        foundersCouncil.click();
        driver.close();
    }

    public static void membershipBox() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.fieldmuseum.org/");

        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();

        // check the all the texts and the prices are displayed in the  membership box .
        WebElement familyPlus = driver.findElement(By.xpath("(//div[@class='membership-card__wrapper p-3 p-md-5']//div//div/h4)[1]"));
        String str = familyPlus.getText().trim();

        if (str.equals("Family Plus")) {
            System.out.println("Family plus is displayed");
        } else {
            System.out.println("Family plus is not displayed");
        }
        WebElement isIncluded = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[1]"));
        String text = isIncluded.getText().trim();
        if (text.equals("Who's included?")) {
            System.out.println("Who is included is displayed");
        } else {
            System.out.println("Who is included is not displayed");
        }
        WebElement oneYear = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[2]"));
        String Year1 = oneYear.getText().trim();
        if (Year1.equals("One year")) {
            System.out.println("One year is displayed");
        } else {
            System.out.println("One year is not displayed");
        }
        WebElement twoYear = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//table//thead//tr/th)[3]"));
        String Year2 = twoYear.getText().trim();
        if (Year2.equals("Two years")) {
            System.out.println("Two year is displayed");
        } else {
            System.out.println("Two year is not displayed");
        }
        WebElement twoAdultChildren = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[1]"));
        String twoAD = twoAdultChildren.getText().trim();
        if (twoAD.equals("Two adults, children*, and one guest")) {
            System.out.println("Two AD is displayed");
        } else {
            System.out.println("Two AD is not displayed");
        }
        WebElement price = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[2]"));
        String price1 = price.getText();
        if (price1.equals("$180")) {
            System.out.println("Price is equal to the value");
        } else {
            System.out.println("Price is not equal to the value");
        }
        WebElement price2 = driver.findElement(By.xpath("(//div[@class ='col-12 mb-4 mb-md-0 copy']//tbody//tr/td)[3]"));
        String price3 = price2.getText().trim();
        if (price3.equals("$345")) {
            System.out.println("the value is the same");
        } else {
            System.out.println("the value is not the same");
        }
        WebElement joinButton = driver.findElement(By.xpath("//a[@href='#modal-1'][1]"));
        if (joinButton.isDisplayed()) {
            System.out.println("Join button is displayed");
        } else {
            System.out.println("Join button is not displayed");
        }
        WebElement renewButton = driver.findElement(By.xpath("//a[@href='#modal-2'][1]"));
        if (renewButton.isDisplayed()) {
            System.out.println("Renew button is displayed");
        } else {
            System.out.println("Renew button is not displayed");
        }

        // driver.switchTo().frame(1);
        // driver.switchTo().frame();
        driver.close();
    }

    public static void joinBotton() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.fieldmuseum.org/");
        WebElement membership = driver.findElement(By.xpath("//ul[@class='header__nav-bar-list js-nav-bar-list']/../ul/li[5]/a"));
        membership.click();
        WebElement joinText = driver.findElement(By.xpath("(//div[@class='copy']/p[1])[9]"));
        String JT = joinText.getText();
        String text1 = "You chose Family Plus Membership. Do you want to purchase this membership for one or two years?";
        System.out.println(JT);
        if (JT.equals(text1)) {
            System.out.println("Text is displayed");
        } else {
            System.out.println("Text is not displayed");
        }

//        WebElement oneYearjoin = driver.findElement(By.xpath("(//a[.='One Year'])[6]"));
//        oneYearjoin.click();

       driver.close();

    }
}


