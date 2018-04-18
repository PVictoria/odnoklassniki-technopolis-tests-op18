package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * Created by таня on 18.04.2018.
 */
public class ClickLikePromise {
    //private Logger LOGGER;// = Logger.getLogger(ClickLikePromise);
    //public static final By =;
    private final WebDriver driver;
    private  final PhotoPage photoPage;
    public static final By CHECK_LIKE = By.xpath("//*[contains(@class, 'photo-layer_klass __active __anim')]");


    public ClickLikePromise(WebDriver driver, PhotoPage photoPage){
        this.driver = driver;
        this.photoPage = photoPage;
    }

    public PhotoPage andClickLikeOn(){
        System.out.println("Лайк был поставлен");
        return new PhotoPage(driver);
    }

    public PhotoPage andClickLikeOff(){
        System.out.println("Лайк был снят");
        return new PhotoPage(driver);
    }

    public PhotoPage SetClickType(){
        if(photoPage.isElementPresent(CHECK_LIKE)){
            return new ClickLikePromise(driver, photoPage).andClickLikeOn();
        }
        else {
            return new ClickLikePromise(driver, photoPage).andClickLikeOff();
        }
    }

}
