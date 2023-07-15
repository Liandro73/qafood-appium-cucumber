package br.com.liandro.qafood.steps;

import br.com.liandro.qafood.page.PageObjectFactory;
import br.com.liandro.qafood.page.PageObjectHelper;
import br.com.liandro.qafood.page.object.HomePageObject;
import br.com.liandro.qafood.page.object.LoginPageObject;
import br.com.liandro.qafood.steps.hooks.Hooks;
import br.com.liandro.qafood.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {

    protected AppiumDriver driver;
    protected WebDriverWait waitDriver;
    protected Scenario scenario;
    protected String scenarioName;

    /**
     * Pages singleton
     */
    protected PageObjectFactory pageObjectFactory;
    protected PageObjectHelper pageObjectHelper;
    protected LoginPageObject loginPageObject;
    protected HomePageObject homePageObject;

    public BaseSteps() {
        driver = DriverManager.getDriver();
        waitDriver = DriverManager.getWaitDriver();
        this.pageObjectFactory = new PageObjectFactory(driver);
        this.pageObjectHelper = pageObjectFactory.getPageObjectHelper();
        this.loginPageObject = pageObjectFactory.getLoginPageObject();
        this.homePageObject = pageObjectFactory.getHomePageObject();
        this.scenario = Hooks.getRunningScenario();
        scenarioName = scenario.getName();
    }

}
