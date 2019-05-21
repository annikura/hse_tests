import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class ButtonPageElement extends PageElement {
    public ButtonPageElement(final @NotNull WebDriver webDriver, final @NotNull String path) {
        super(webDriver, path);
    }

    public void click() {
        element.click();
    }
}
