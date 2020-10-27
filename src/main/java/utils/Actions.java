package utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import com.cucumber.listener.Reporter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
    public Actions() {
    }

    public static void submit(WebElement element) {
        try {
            waitForElement(element);
            element.submit();
        } catch (Exception var2) {
            Assert.fail(var2.getCause().getMessage());
        }

    }

    public static void click(WebElement element, String name) {
        try {
            waitForButton(element);
            highlight(element);
            element.click();
        } catch (Exception var3) {
            Assert.fail(var3.getCause().getMessage());
        }

    }

    public static void type(WebElement element, String text) {
        try {
            waitForElement(element);
            element.clear();
            element.sendKeys(new CharSequence[]{text});
        } catch (Exception var3) {
            Assert.fail(var3.getCause().getMessage());
        }

    }

    public static void ghostClick(WebElement element, String name) {
        try {
            waitForElement(element);
            highlight(element);
            JavascriptExecutor e = (JavascriptExecutor)Driver.getInstance();
            e.executeScript("arguments[0].click();", new Object[]{element});
        } catch (Exception var3) {
            Assert.fail(var3.getCause().getMessage());
        }

    }

    public static void doubleClick(WebElement element, String name) {
        try {
            highlight(element);
            JavascriptExecutor e = (JavascriptExecutor)Driver.getInstance();
            e.executeScript("evObj = document.createEvent('MouseEvents');evObj.initMouseEvent('dblclick', true, true, document.defaultView,0,0,0,0,0,false,false,false,false,0,null); arguments[0].dispatchEvent(evObj);", new Object[]{element});
        } catch (NoSuchElementException var3) {
            Assert.fail("Element : '" + name + "' is not displayed on page.");
        } catch (java.util.NoSuchElementException var4) {
            Assert.fail("Element : '" + name + "' is not displayed on page");
        } catch (NullPointerException var5) {
            Assert.fail("Element : '" + name + "' is empty check your code");
        } catch (TimeoutException var6) {
            Assert.fail("Element : '" + name + "' is not displayed on page or cannot be interacted with.");
        } catch (Exception var7) {
            Assert.fail(var7.getCause().getMessage());
        }

    }

    public static void waitForElement(WebElement element) {
        Awaitility.with().pollDelay(100L, TimeUnit.MILLISECONDS).and().pollInterval(200L, TimeUnit.MILLISECONDS).await().ignoreExceptions().until(() -> {
            return element.isDisplayed();
        });
    }

    public static void waitForButton(WebElement element) {
        Awaitility.with().pollDelay(1L, TimeUnit.SECONDS).and().pollInterval(500L, TimeUnit.MILLISECONDS).await().atMost(15L, TimeUnit.SECONDS).ignoreExceptions().until(() -> {
            return element.isEnabled();
        });
    }

    public static void clearText(WebElement element, String name) {
        try {
            waitForElement(element);
            element.clear();
        } catch (Exception var3) {
            Assert.fail("Clear text on " + name + " was not completed");
        }

    }

    public static void selectByValue(WebElement element, String value, String name) {
        try {
            Select e = new Select(element);
            e.selectByValue(value);
        } catch (Exception var4) {
            Assert.fail("Select By : '" + value + "' was not completed");
        }

    }

    public static void waitForList(List<WebElement> list, String name) {
        int i;
        for(i = 0; list.size() == 0 && i < 12; ++i) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }

        if (i >= 12) {
            Assert.fail("List : '" + name + "' was not successfully displayed.");
        }

    }

    public static void acceptAlert(String name) {
        try {
            Driver.getInstance().switchTo().alert().accept();
        } catch (Exception var2) {
            Assert.fail("Accepting an alert : '" + name + "' was not completed");
        }

    }

    public static List<WebElement> getListOfElementsByXpath(String xpath) {
        for(int i = 0; i < 10 && Driver.getInstance().findElements(By.xpath(xpath)).size() == 0; ++i) {
            sleep(1000L);
            ++i;
        }

        if (Driver.getInstance().findElements(By.xpath(xpath)).size() == 0) {
            Assert.fail("List with xpath: " + xpath + " was empty");
        }

        return Driver.getInstance().findElements(By.xpath(xpath));
    }

    private static void highlight(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getInstance();
        jse.executeScript("arguments[0].style.border='3px ridge green'", new Object[]{element});
    }

    public static void scrollToElement(WebElement element, String name) {
        try {
            waitForElement(element);
            org.openqa.selenium.interactions.Actions e = new org.openqa.selenium.interactions.Actions(Driver.getInstance());
            e.moveToElement(element).perform();
        } catch (NoSuchElementException var3) {
            Assert.fail("Element : '" + name + "' is not displayed on page.");
        } catch (java.util.NoSuchElementException var4) {
            Assert.fail("Element : '" + name + "' is not displayed on page");
        } catch (NullPointerException var5) {
            Assert.fail("Element : '" + name + "' is empty check your code");
        } catch (TimeoutException var6) {
            Assert.fail("Element : '" + name + "' is not displayed on page or cannot be interacted with.");
        }

    }

    public static void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getInstance();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
    }

    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 10L);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void mouseOver(WebElement element, String name) {
        try {
            String javaScript = "var element = arguments[0];var mouseEventObj = document.createEvent('MouseEvents');mouseEventObj.initEvent( 'mouseover', true, true );element.dispatchEvent(mouseEventObj);";
            ((JavascriptExecutor)Driver.getInstance()).executeScript(javaScript, new Object[]{element});
        } catch (Exception var3) {
            Assert.fail(var3.getCause().getMessage());
        }

    }

    public static void selectByString(WebElement element, String value, String name) {
        try {
            scrollToElement(element, name);
            Select select = new Select(element);
            select.selectByVisibleText(value);
        } catch (Exception var4) {
            Assert.fail(var4.getCause().getMessage());
        }

    }

    public static void waitForElement(WebElement element, String name) {
        try {
            scrollToElement(element, name);
            element.isDisplayed();
        } catch (Exception var3) {
            Assert.fail(var3.getCause().getMessage());
        }

    }

    public static void openContextMenu(WebElement element, String name) {
        try {
            waitForElement(element, name);
            (new org.openqa.selenium.interactions.Actions(Driver.driver)).contextClick(element).perform();
        } catch (Exception var3) {
            Assert.fail(var3.getCause().getMessage());
        }

    }

    public static void sleep(long msDelay) {
        try {
            Thread.sleep(msDelay);
        } catch (InterruptedException var3) {
        }

    }

    public static void checkElementIsNotVisible(WebElement element, String elementName) {
        try {
            element.isDisplayed();
            Assert.fail("Element " + elementName + " is visible on the page.");
        } catch (NoSuchElementException var3) {
            Reporter.addStepLog("Element" + elementName + " is not visible");
        }

    }
}

