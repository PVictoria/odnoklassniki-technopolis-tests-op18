package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        return element.isDisplayed();
    }

    public void clickAlbum(){
        element.click();
    }


}
