package steps;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;
import utils.Directory;
import utils.Driver;

import java.io.File;

public class UiHook {

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            new File("/report/cucumber-reports/screenshots").mkdirs();
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            File sourceFile = ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(Directory.PROJECT_DIR + "/report/cucumber-reports/screenshots/" + screenshotName + ".png");
            try {
                FileCopyUtils.copy(sourceFile, destinationFile);
                String destinationFilePath = destinationFile.toString().replace(Directory.PROJECT_DIR + "\\report\\cucumber-reports\\", "");
                Reporter.addScreenCaptureFromPath(destinationFilePath);
            } catch (Exception e) {
                throw new AssertionError(e.getCause().getMessage());
            }
        }
    }
}
