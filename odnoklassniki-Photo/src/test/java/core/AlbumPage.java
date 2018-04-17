package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AlbumPage extends HelperBase {
    public static final String NEW_ALBUM_NAME = "NewName1";
    private static final By ALBUM = By.xpath(".//*[text() = 'I' ]"); //локатор содержит имя альбома!!
    public static final By FIND_ALBUM_NAME = By.xpath(".//*[contains(@class,'it_w')]//*[@data-module='PhotoEdit']");
    public static final By RETERN_TO_PHOTO_FROM_EDIT = By.xpath("//*[contains(@class,'tico_img ic12')]//parent::span[@class='tico tico__12']//parent::*[@class='al']");
    public static final By EDIT_ALBUM_LOCATOR = By.xpath("//*[contains(@class,'tico_img ic12')]/parent::span[@class='tico tico__12']/parent::a");
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
    public void choseTargetAlbum(String albumName){ //БУДУ ПЕРЕПИСЫВАТЬ
        click(By.xpath("(.//a[contains(@class,'custom-isl_choice')])"));//выпадает окно
      //  click(By.xpath("((.//div[contains(@class,'drop-lst')])/descendant::li[contains(@class, 'custom-isl')])[3]"));//как вытащить textContent??

        List<WebElement> albumList = new ArrayList<WebElement>();
        albumList = driver.findElements(By.xpath("((.//div[contains(@class,'drop-lst')])/descendant::li[contains(@class, 'custom-isl')])"));
        boolean flag = false;
        for (WebElement album : albumList) {
            if ( album.getText().equals(albumName)){
                album.click();
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Альбом " + albumName + " не найден", flag);


    }
    public void clickMoveButton() {
        click(By.xpath("(.//a[contains(@class,'button_move') ])"));
    }
    public boolean isPhotoMoved(){
        final By INFO = By.xpath(".//div[starts-with(@class, 'iblock') ]");
        return isElementPresent(INFO);
    }
    public void editAlbumName(){
        click(FIND_ALBUM_NAME);
        type(NEW_ALBUM_NAME,FIND_ALBUM_NAME);

    }
    public void returnToPhoto(){
        click(RETERN_TO_PHOTO_FROM_EDIT);
    }
    public  void clickEditAlbum(){
        click(EDIT_ALBUM_LOCATOR);
    }
    public boolean isChangeAlbumsName(String name){
        final By NAME_CHANGED = By.xpath(".//*[text() = '" + name + "' ]");
        return isElementPresent(NAME_CHANGED);

    }

    public  void clickDeleteButton (){
       // click (By.xpath(".//div[contains(@class, 'photo-panel_info')]/descendant::a[contains(@href , 'RemoveUserAlbums')]"));
       click(By.linkText("Удалить альбом"));
        //driver.findElement(By.id("hook_FormButton_button_delete_confirm")).click();
    }
    public void confirmAlbumDeletion(){
        click(By.id("hook_FormButton_button_delete_confirm"));
    }
}
