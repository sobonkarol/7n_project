package pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;
import utils.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OffersPage {
    public OffersPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//span[text() = 'czarny']")
    public static WebElement czarnyFilter;

    @FindAll(@FindBy(xpath = "//article[@data-role=\"offer\"]"))
    public static List<WebElement> offers;

    @FindBy(xpath = "//article[@data-role=\"offer\"]//span[@class=\"_1svub _lf05o\"]")
    public static List<WebElement> price;

    public OffersPage filterOutBlackPhone() {
        Actions.click(czarnyFilter, "Click on 'Czarny' filter");
        return new OffersPage();
    }

    public OffersPage printOutNumberOfOffersOnTheFirstPage() throws InterruptedException {
        System.out.println("Liczba dostępnych ofert na pierwszej stronie wyników: " + offers.size());
        Thread.sleep(4000);
        return new OffersPage();
    }


    public OffersPage printOutHighestPriceOnTheFirstPage() {
        List<String> prices = new ArrayList<String>();
        for (WebElement e : price) {
            prices.add(e.getText());
        }

        System.out.println("Największa cena na pierwszej stronie wyników: " + Collections.max(prices, null));
        return new OffersPage();
    }


}
