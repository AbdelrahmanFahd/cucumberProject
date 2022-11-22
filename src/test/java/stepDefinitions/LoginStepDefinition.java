package stepDefinitions;
import Pages.LoginPage;
import io.cucumber.java.af.En;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.annotation.Annotation;

public class LoginStepDefinition {
    WebDriver driver;
    LoginPage login;

    @Given("Open Browser")
    public void open_browser() {
        // 1: Bridge between test scripts and browsers

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        // 2: New Object of WebDriver
        driver = new ChromeDriver();

        // 3: New Object of LoginPage
        login = new LoginPage(driver);

        // 4: Maximize screen and Sleep 3 seconds

        driver.manage().window().maximize();
//        Thread.sleep(1000);
    }

    @And("user navigate to login Page")
    public void login_page() {
        //Login Page
        driver.navigate().to("http://the-internet.herokuapp.com/login");
    }

    @When("user enter valid username and password")
    public void user_enter_valid_username_and_password() {
        // Enter username , password
        login.loginSteps("tomsmith", "SuperSecretPassword!");
    }

    @And("user click on login button")
    public void user_click_on_login_button() {
        // Enter
        login.passwordPOM().sendKeys(Keys.ENTER);
    }

    //Expected Result
    @Then("user could login successfully")
    public void user_could_login_successfully_and_go_to_home_page() {

        String ExpectedResult = "You logged into a secure area!";
        String ActualResult = login.flashPOM().getText();

        Assert.assertTrue(ActualResult.contains(ExpectedResult));

    }

    @And("go to home page")
    public void home_page() {

        Assert.assertEquals("http://the-internet.herokuapp.com/secure", driver.getCurrentUrl());

    }

}
