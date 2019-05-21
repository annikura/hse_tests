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

        int numberOfBoxes = webDriver.findElements(By.xpath("//a[@class='issue-toggler toggleDescrAnchor']")).size();

        for (int i = 0; i < numberOfBoxes; i++) {
            WebElement element = webDriver.findElements(By.xpath("//a[@class='issueId issueIdAnchor ']")).get(i);
            SingleIsuuePage singleIssuePage = new SingleIsuuePage(webDriver);
            Issue issue = singleIssuePage.getIssue(element.getAttribute("href"));
            if (issue.getSummary().equals(summary)) {
                result.add(issue);
            }
            goTo(LINK);
        }
        return result;
    }
}
