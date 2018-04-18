package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by User on 18.04.2018.
 */
public class PhotoWrapper {

    private WebElement element;
    private WebDriver driver;

    public PhotoWrapper(WebElement element, WebDriver driver) { //Lena
        this.driver = driver;
        this.element = element;
    }

    /**
     * Возвращает true если альбом отображается
     */
    public boolean isExist() {
        return element.isDisplayed();
    }

    public void clickPhoto(){
        element.click();
    }
    public String getPhotoDel(){
       // WebElement photoName= element.findElement(By.xpath(".//*[@class = 'va_target rotate__0deg']"));
        WebElement photoDel= element.findElement(By.xpath(".//*[@class = 'ic ic_i_remove']"));
        return photoDel.getText(); //?
    }
}
