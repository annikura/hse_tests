import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class IssuesPage extends Page{
    private final static String LINK = "http://localhost:8080/issues/";

    public IssuesPage(final @NotNull WebDriver webDriver) {
        super(webDriver);
    }

    public List<Issue> findIssuesBySummary(final @NotNull String summary) {
        goTo(LINK);
        List<Issue> result = new ArrayList<>();

        List<WebElement> elements = webDriver.findElements(By.xpath("//a[@class='issue-summary']"));
        for (WebElement element : elements) {
            SingleIssuePage singleIssuePage = new SingleIssuePage(webDriver);
            Issue issue = singleIssuePage.getIssue("http://localhost:8080" + element.getAttribute("href"));
            if (issue.getSummary().equals(summary)) {
                result.add(issue);
            }
            goTo(LINK);
        }
        return result;
    }
}
