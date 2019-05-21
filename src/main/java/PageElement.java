import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageElement {
    protected final WebElement element;

    public PageElement(final @NotNull WebDriver webDriver, final @NotNull String path) {
        element = webDriver.findElement(By.id(path));
    }

}
