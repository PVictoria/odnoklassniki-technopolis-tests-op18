package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlbumWrapper {


    private WebElement element;
    private WebDriver driver;

    //private static final By ALL_AlBUMS = By.xpath("(.//div[@class='photo-album_cnt'])");

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
        WebElement albumName= element.findElement(By.xpath(".//div[contains(@class,'photo-album_t')]"));
        return albumName.getText();
    }
//    public String getText(){
//        return element.getText();
//    }



}
