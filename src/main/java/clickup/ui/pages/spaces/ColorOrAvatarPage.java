package clickup.ui.pages.spaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ColorOrAvatarPage extends BasePage {
    @FindBy(css = ".cu-btn.cu-btn_m.cu-create-project-modal__next.ng-star-inserted")
    private WebElement nextButton;

    public ColorOrAvatarPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the next button.
     *
     * @return a Share space page
     * @author Jorge Caceres
     */
    public ShareSpacePage clickNextButton() {
        webDriverActions.clickElement(nextButton);
        return new ShareSpacePage(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(nextButton);
    }
}
