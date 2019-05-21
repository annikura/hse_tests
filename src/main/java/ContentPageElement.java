import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class ContentPageElement extends PageElement {
    public ContentPageElement(final @NotNull WebDriver webDriver, final @NotNull String path) {
        super(webDriver, path);
    }

    public String getContent() {
        return element.getText();
    }
}
