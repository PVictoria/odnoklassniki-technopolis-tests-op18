package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlbumPage extends HelperBase {
    private static final By ALBUM = By.xpath(".//*[text() = 'I' ]"); //локатор содержит имя альбома!!
    public  AlbumPage(WebDriver driver){
        super(driver);
    }
    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(ALBUM));
    }

   public void clickEditButton(){
        click(By.xpath("(.//div[contains(@class,'photo-menu_edit')])"));
   }
    public void clickOnPhoto(){
        click(By.xpath("(.//span[contains(@class,'selectable-card')])[1]"));// плохой локатор, тут тоже можно ваппер
    }
    public void choseTargetAlbum(){
        click(By.xpath("(.//a[contains(@class,'custom-isl_choice')])"));//выпадает окно
        click(By.xpath("((.//div[contains(@class,'drop-lst')])/descendant::li[contains(@class, 'custom-isl')])[3]"));//как вытащить textContent??

    }
    public void clickButtonMove() {
        click(By.xpath("(.//a[contains(@class,'button_move') ])"));
    }
    public boolean isPhotoMoved(){
        final By INFO = By.xpath(".//div[starts-with(@class, 'iblock') ]");
        return isElementPresent(INFO);
    }
}
