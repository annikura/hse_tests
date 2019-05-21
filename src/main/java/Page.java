import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    final protected WebDriver webDriver;

    public Page(final @NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void goTo(final @NotNull String page) {
        webDriver.navigate().to(page);
    }
}
