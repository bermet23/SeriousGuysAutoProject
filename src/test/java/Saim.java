import org.openqa.selenium.*;
import java.util.List;

public class Saim {
    public static void main(String[] args) throws InterruptedException{
        PlanYourVisitTicketInformationTestCase();
    }

        /*
                Plan Your Visit Linked Pages Test Case evaluates users going to Plan your visit page and being able to
                to click on the following linked pages and correctly being take to the clicked page: Exhibitions, Directions
                and Parking, Maps Guide, Amenities, Grainger Science Hub, Public Tours, Discovery Squad , and Meet a Scientist

        */

    public static void PlanYourVisitLinkedPagesTestCase() throws InterruptedException{

        System.out.println("---------------------------------------------\n'Plan Your Visit' Linked Pages Test Case\n---------------------------------------------");

        CD.SetChromeDriverMethod("https://www.fieldmuseum.org/");
        JavascriptExecutor jse = (JavascriptExecutor) CD.driver;
        int sleep = 1000;

        Thread.sleep(sleep);
        jse.executeScript("scroll(0, 700);");
        Thread.sleep(sleep);

        CD.FindAndClick("link","Visit Information");
        Thread.sleep(sleep);
        System.out.println("Navigate to Visit Page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit")));
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-26236");
        System.out.println("Navigate to Exhibitions page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/exhibitions")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-14156");
        System.out.println("Navigate to Directions and Parking page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit/directions-parking")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-6686");
        System.out.println("Navigate to Maps Guide page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit/maps-guides")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-23831");
        System.out.println("Navigate to Amenities page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit/amenities")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-21926");
        System.out.println("Navigate to Grainger Science Hub page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/exhibitions/grainger-science-hub")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-26731");
        System.out.println("Navigate to Public Tours page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit/daily-events/public-tours")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-16666");
        System.out.println("Navigate to Discovery Squad page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit/daily-events/discovery-squad")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.FindAndClick("id","card__title-text-9901");
        System.out.println("Navigate to Meet a Scientist page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/our-events/meet-scientist")));
        Thread.sleep(sleep);
        CD.driver.navigate().back();
        Thread.sleep(sleep);

        CD.driver.close();
        System.out.println("------------------------------------------------\nEnd of 'Plan Your Visit' Linked Pages Test Case\n------------------------------------------------");


    }

        /*
                Plan Your Visit Learn More Page URLS Test Case goes to the 'plan your visit' page from the field museum web page and
                verifies if all the 'learn more' links on the page are linked to the correct urls
                -> learnMore List holds all the 'learn more' button elements
                -> learnMoreNames List gets corresponding names to the 'learn more' buttons
                -> learnMOreLinks array holds all the correct expected url links
        */

    public static void PlanYourVisitLearnMorePageURLSTestCase() throws InterruptedException{
        System.out.println("---------------------------------------------\n'Plan Your Visit' Learn More Links Test Case\n---------------------------------------------");

        CD.SetChromeDriverMethod("https://www.fieldmuseum.org/");
        int sleep = 2000;

        CD.FindAndClick("link","Visit Information");
        Thread.sleep(sleep);
        System.out.println("Navigate to Visit Page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit")));

        CD.ScrollPage(1500);

        List<WebElement> learnMore= CD.driver.findElements(By.xpath("//div[@class='entity entity-paragraphs-item paragraphs-item-titled-list-with-button']//a"));
        List<WebElement> learnMoreNames = CD.driver.findElements(By.xpath("//div[@class='entity entity-paragraphs-item paragraphs-item-titled-list-with-button']//h3"));
        String [] learnMoreLinks = {"https://www.fieldmuseum.org/join-give/become-member",
                "https://www.citypass.com/chicago?mv_source=field&campaign=visit",
                "https://gocity.com/en-us/?kbid=5657&utm_medium=aff&utm_source=myap&utm_campaign=5657&utm_content=Your%20Default%20Affiliate%20Link",
                "http://www.chicityclerk.com/chicagocitykey",
                "https://www.fieldmuseum.org/our-events/free-admission-days"};


        for(int i=0; i < learnMore.size(); i++) {
            String elementLink = learnMore.get(i).getAttribute("href");
            System.out.println(learnMoreNames.get(i).getText() + " link matches: " + CD.passOrFail(elementLink.equals(learnMoreLinks[i])));
        }

        CD.driver.close();
        System.out.println("------------------------------------------------\nEnd of 'Plan Your Visit' Learn More Links Test Case\n------------------------------------------------");
        System.out.println();

    }

        /*
                Plan Your Visit Ticket Information Test Case goes to the 'plan your visit' page after going to the main field museum
                web page and verifies if all the ticket information displayed on the page is as expected.
                -> The expected prices are stored in a String array called 'eachPrice'
                -> Each WebElement corresponding to the prices are stored into a List called 'prices'
                -> A loop is run  that checks the prices depending on the type of pass and the age of the person getting the pass and verifies
                    if the prices match the expected price
        */

    public static void PlanYourVisitTicketInformationTestCase() throws InterruptedException{
        System.out.println("---------------------------------------------\n'Plan Your Visit' Ticket Information Test Case\n---------------------------------------------");

        CD.SetChromeDriverMethod("https://www.fieldmuseum.org/");
        int sleep = 2000;

        CD.FindAndClick("link","Visit Information");
        Thread.sleep(sleep);
        System.out.println("Navigate to Visit Page: " + CD.passOrFail(CD.driver.getCurrentUrl().equals("https://www.fieldmuseum.org/visit")));

        CD.ScrollPage(450);

        List<WebElement> prices = CD.driver.findElements(By.xpath("//ul[@class='pricing-table']/li/span[2]"));

        String [] eachPrice = {"$40/38","$29/27","$35/33","$34/32","$25/23","$30/28","$26/24","$19/17","$23/21"};
        String [] type = {"All Access Pass","Discovery Pass","Basic Admission"};

        for(int i=0,r=0; i < 3; i++, r+=3) {
            System.out.println(type[i] +" Adults price matched: " + CD.passOrFail(prices.get(r).getText().equals(eachPrice[r])));
            System.out.println(type[i] +" Children price matched: " + CD.passOrFail(prices.get(r+1).getText().equals(eachPrice[r+1])));
            System.out.println(type[i] +" Basic Admission price matched: " + CD.passOrFail(prices.get(r+2).getText().equals(eachPrice[r+2])));
        }
        Thread.sleep(4000);
        CD.driver.close();
        System.out.println("------------------------------------------------------\nEnd of 'Plan Your Visit' Ticket Information Test Case\n------------------------------------------------------");
        System.out.println();

    }


}
