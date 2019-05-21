import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class NewIssuePage extends Page {
    public NewIssuePage(final @NotNull WebDriver webDriver) {
        super(webDriver);
    }

    public void createIssue(final @NotNull String summary, final @NotNull String description) {
        goTo("http://localhost:8080/issues/#newissue=yes");
        TextFieldPageElement summaryField = new TextFieldPageElement(webDriver, "//textarea[@name='l.I.ni.ei.eit.summary']");
        TextFieldPageElement descriptionField = new TextFieldPageElement(webDriver, "//textarea[@name='l.I.ni.ei.eit.description']");
        summaryField.setText(summary);
        descriptionField.setText(description);
        ButtonPageElement buttonPageElement = new ButtonPageElement(webDriver, "//button[@class='jt-button submit-btn']");
        buttonPageElement.click();
    }
}
