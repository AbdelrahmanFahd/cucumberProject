package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernamePF;

    @FindBy(name = "password")
    WebElement passwordPF;

    public WebElement usernamePOM() {

        return driver.findElement(By.id("username"));

    }

    public WebElement passwordPOM() {

        return driver.findElement(By.name("password"));

    }

    public WebElement flashPOM() {

        return driver.findElement(By.id("flash"));

    }

    public By logoutPOM() {
        return By.cssSelector("a[href=\"/logout\"]");
    }

    public void loginSteps(String username, String password) {

        // Enter UserName using POM Design Pattern
        usernamePF.clear();
        usernamePOM().sendKeys(username);

        // Enter Password using POM Design Pattern
        passwordPOM().sendKeys(password);
//        passwordPOM().sendKeys(Keys.ENTER);
    }


}
