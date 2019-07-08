/*
        This class will run all the automation scripts from the Serious Guys members
*/

public class Main {
    public static void main(String[] args) throws InterruptedException{

        System.out.println("\nStart of Sofia's Test Cases");
            Sofia.onlineStoreMainPage();
            Sofia.checkbox();
            Sofia.FieldMuseumKidsItems();
        System.out.println("\nEnd of Sofia's Test Cases");

        System.out.println("\nStart of Saim's Test Cases");
            Saim.PlanYourVisitLinkedPagesTestCase();
            Saim.PlanYourVisitLearnMorePageURLSTestCase();
            Saim.PlanYourVisitTicketInformationTestCase();
        System.out.println("\nEnd of Saim's Test Cases");

        System.out.println("\nStart of Muhammet's Test Cases");
            Muhammet.CheckingEvents();
            Muhammet.CheckingGiftsPriceUnder10();
            Muhammet.CheckingGiftsPrice10To20();
        System.out.println("\nEnd of Muhammet's Test Cases");

        System.out.println("\nStart of Akcholpon's Test Cases");
            Akcholpon.filterEventsByChoosingAudience();
            Akcholpon.filterEventsByChoosingDate();
            Akcholpon.lookAtEventsDetails();
        System.out.println("\nEnd of Akcholpon's Test Cases");

        System.out.println("\nStart of Tesfaldet's Test Cases");
            Tesfaldet.becomeAMember();
            Tesfaldet.membershipBox();
            Tesfaldet.joinBotton();
        System.out.println("\nEnd of Tesfaldet's Test Cases");

        System.out.println("\nStart of Aidina's Test Cases");
            Aidina.TestMuseum();
        System.out.println("\nEnd of Aidina's Test Cases");

    }
}
