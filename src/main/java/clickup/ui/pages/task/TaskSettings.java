package clickup.ui.pages.task;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskSettings extends BasePage {
    @FindBy(css = "a[tooltipmodifier] div[class*=icon_remove]")
    private WebElement deleteIcon;

    public TaskSettings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void clickDeleteIcon() {
        webDriverActions.clickElement(deleteIcon);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
