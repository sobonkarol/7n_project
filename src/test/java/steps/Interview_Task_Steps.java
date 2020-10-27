package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Driver;
import utils.Pages;

public class Interview_Task_Steps extends Pages {
    @Given("^User go to Allegro\\.pl$")
    public void userGoToAllegroPl() throws InterruptedException {
        homePage.startingAllegro();
    }

    @When("^User is searching for \"([^\"]*)\"$")
    public void userSearchingFor(String itemName) throws InterruptedException {
        homePage.itemsSearching(itemName);
    }

    @And("^User is searching for black iPhone$")
    public void userIsSearchingForBlackIPhone() {
        offersPage.filterOutBlackPhone();
    }

    @And("^Number of available offers on the first page is displayed$")
    public void numberOfAvailableOffersOnTheFirstPageIsDisplayed() throws InterruptedException {
        offersPage.printOutNumberOfOffersOnTheFirstPage();
    }

    @Then("^The highest price on the first page is displayed$")
    public void theHighestPriceOnTheFirstPageIsDisplayed() {
        offersPage.printOutHighestPriceOnTheFirstPage();
        Driver.getInstance().close(); // closing the browser
    }
}
