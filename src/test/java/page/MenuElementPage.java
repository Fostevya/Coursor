package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuElementPage {

    private WebElement menuWithSubMenuTab;
    private WebElement menuItemInMenu;
    private WebElement subMenuForMenuItem;
    private WebDriverWait wait;
    private Actions builder;

    public MenuElementPage(WebDriver driver) {
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[contains(.,'Menu With Sub Menu')]"))));
        menuWithSubMenuTab = driver.findElement(By.xpath("//a[contains(.,'Menu With Sub Menu')]"));
    }

    public void menuWithSubMenuTabClick(WebDriver driver) {
        builder.click(menuWithSubMenuTab).build().perform();
        driver.switchTo().frame(1);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu"))));
        menuItemInMenu = driver.findElement(By.id("ui-id-2"));
    }

    public void moveCoursorToMenuItemOnMenu(WebDriver driver) {
        builder.moveToElement(menuItemInMenu).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[li[@id='ui-id-3']]"))));
        subMenuForMenuItem = driver.findElement(By.xpath("//ul[li[@id='ui-id-3']]"));
    }

    public boolean subMenuIsVisible() {
        return subMenuForMenuItem.isDisplayed();
    }
}
