import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class SingleIssuePage extends Page {
    public SingleIssuePage(final @NotNull WebDriver webDriver) {
        super(webDriver);
    }

    public Issue getIssue(final @NotNull String link) {
        goTo(link);
        ContentPageElement summaryElement = new ContentPageElement(webDriver, "//span[@id='id_l.I.ic.icr.it.issSum']");
        ContentPageElement descriptionElement = new ContentPageElement(webDriver, "//div[@id='id_l.I.ic.icr.d.description']/div[@class='wiki text']");
        return new Issue(summaryElement.getContent(), descriptionElement.getContent());
    }
}
