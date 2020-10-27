package pagesObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;
import utils.Driver;
import java.util.concurrent.TimeUnit;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//button[contains(text(), 'przejdź dalej')]")
    public static WebElement przejdzDalejButton;

    @FindBy(xpath = "//input[@type=\"search\"]")
    public static WebElement searchBox;

    @FindBy(xpath = "//span[contains(text(), 'Smartfony i telefony komórkowe')]")
    public static WebElement smartphoneFilter;

    @FindBy(xpath = "(//a[contains(.,'iPhone 11')][@data-role='LinkItemAnchor'])[1]")
    public static WebElement iPhone11Filter;

    public HomePage startingAllegro() throws InterruptedException {
        Driver.getInstance();
        Driver.getInstance().navigate().to("http://allegro.pl");
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HomePage();
    }

    public HomePage itemsSearching(String itemName) throws InterruptedException {
        if (przejdzDalejButton.isDisplayed()) {
            przejdzDalejButton.click();
        }
        Actions.type(searchBox, itemName);
        Actions.click(smartphoneFilter, "dds");
        Actions.click(iPhone11Filter, "Click on iPhone 11");

        return new HomePage();
    }

}
