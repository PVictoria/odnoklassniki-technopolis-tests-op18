package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlbumWrapper {


    private WebElement element;
    private WebDriver driver;

    private static final By ALBUN_TITLE = By.xpath(".//div[contains(@class,'photo-album_t')]");

    public AlbumWrapper(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }

    /**
     * Возвращает true если альбом отображается
     */
    public boolean isExist() {
        //return element.findElement(ALL_AlBUMS).isDisplayed();
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickAlbum(){
        element.click();
    }

    public String getAlbumName(){
        WebElement albumName = element.findElement(ALBUN_TITLE);
        return albumName.getText();
    }



}
