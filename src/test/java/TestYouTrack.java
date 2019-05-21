import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestYouTrack {
    WebDriver webDriver;
    LoginPage loginPage;
    NewIssuePage newIssuePage;
    IssuesPage issuesPage;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");

        webDriver = new FirefoxDriver();

        loginPage = new LoginPage(webDriver);
        newIssuePage = new NewIssuePage(webDriver);
        issuesPage = new IssuesPage(webDriver);

        loginPage.logInAs("root", "qwerty");
    }

    @Test
    public void testAddSimpleIssue() {
        String randomUUIDString = UUID.randomUUID().toString();
        newIssuePage.createIssue(randomUUIDString, randomUUIDString + "1");
        List<Issue> issuesList = issuesPage.findIssuesBySummary(randomUUIDString);
        assertEquals(1, issuesList.size());
        assertEquals(randomUUIDString, issuesList.get(0).getSummary());
        assertEquals(randomUUIDString + "1", issuesList.get(0).getDescription());
    }

    @Test
    public void testAddIssueWithEmptyDescription() {
        String randomUUIDString = UUID.randomUUID().toString();
        newIssuePage.createIssue(randomUUIDString, "");
        List<Issue> issuesList = issuesPage.findIssuesBySummary(randomUUIDString);
        assertEquals(1, issuesList.size());
        assertEquals(randomUUIDString, issuesList.get(0).getSummary());
        assertNull(issuesList.get(0).getDescription());
    }

    @Test
    public void testAddDuplicateIssue() {
        String randomUUIDString = UUID.randomUUID().toString();
        newIssuePage.createIssue(randomUUIDString, "1");
        newIssuePage.createIssue(randomUUIDString, "2");
        List<Issue> issuesList = issuesPage.findIssuesBySummary(randomUUIDString);
        assertEquals(2, issuesList.size());
    }

    @Test
    public void testTryAddingEmptyIssue() {
        newIssuePage.createIssue("", "");
        List<Issue> issuesList = issuesPage.findIssuesBySummary("");
        assertEquals(0, issuesList.size());
    }

    @After
    public void afterTest() {
        webDriver.quit();
    }
}
