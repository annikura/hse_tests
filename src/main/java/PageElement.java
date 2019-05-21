import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageElement {
    protected final WebElement element;

    public PageElement(final @NotNull WebDriver webDriver, final @NotNull String path) {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }

}
