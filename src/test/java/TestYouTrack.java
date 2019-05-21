import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TestYouTrack {
    WebDriver webDriver;
    LoginPage loginPage;
    NewIssuePage newIssuePage;
    IssuesPage issuesPage;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "chrome");
        webDriver = new ChromeDriver();

        loginPage = new LoginPage(webDriver);
        newIssuePage = new NewIssuePage(webDriver);
        issuesPage = new IssuesPage(webDriver);

        loginPage.logInAs("user", "password");
    }

    @Test
    public void testAddSimpleIssue() {
        String randomUUIDString = UUID.randomUUID().toString();
        newIssuePage.createIssue(randomUUIDString, randomUUIDString);
    }

    @After
    public void afterTest() {
        webDriver.quit();
    }
}
