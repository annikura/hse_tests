import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class SingleIsuuePage extends Page {
    public SingleIsuuePage(final @NotNull WebDriver webDriver) {
        super(webDriver);
    }

    public Issue getIssue(final @NotNull String link) {
        goTo(link);
        ContentPageElement summaryElement = new ContentPageElement(webDriver, "//span[@id='id_l.I.ic.icr.it.issSum']");
        ContentPageElement descriptionElement;
        try {
            descriptionElement = new ContentPageElement(webDriver, "//div[@id='id_l.I.ic.icr.d.description']/div[@class='wiki text']");
            return new Issue(summaryElement.getContent(), descriptionElement.getContent());
        } catch (Exception e) {
            ContentPageElement noDescriptionElement = new ContentPageElement(webDriver, "//div[@id='id_l.I.ic.icr.d.description']");
            if (noDescriptionElement.getContent().equals("No description")) {
                return new Issue(summaryElement.getContent(), null);
            } else {
                throw e;
            }
        }
    }
}
