import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class TextFieldPageElement extends PageElement {
    public TextFieldPageElement(final @NotNull WebDriver webDriver, final @NotNull String path) {
        super(webDriver, path);
    }

    public void setText(final @NotNull String text) {
        element.sendKeys(text);
    }
}
