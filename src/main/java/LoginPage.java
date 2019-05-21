import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public LoginPage(@NotNull WebDriver webDriver) {
        super(webDriver);
    }

    public void logInAs(final @NotNull String login, final @NotNull String password) {
        goTo("http://localhost:8080/login");
        TextFieldPageElement loginField = new TextFieldPageElement(webDriver, "//input[@name='l.L.login']");
        TextFieldPageElement passwordField = new TextFieldPageElement(webDriver, "//input[@name='l.L.password']");
        loginField.setText(login);
        passwordField.setText(password);
        ButtonPageElement logInButton = new ButtonPageElement(webDriver, "//input[@id='id_l.L.loginButton']");
        logInButton.click();
    }
}
