package utils;

import pagesObjects.HomePage;
import pagesObjects.OffersPage;


public class Pages {

    protected HomePage homePage;
    protected OffersPage offersPage;

    public Pages() {
        homePage = new HomePage();
        offersPage = new OffersPage();
    }
}
