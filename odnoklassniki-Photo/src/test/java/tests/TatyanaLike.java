package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.PhotoMainPage.OPEN_PHOTO_FOR_LIKE;

/**
 * Created by таня on 18.04.2018.
 */
public class TatyanaLike extends TestBase {
    //тест-кейс поставить лайк своему фото
    // в before??
    String id = "img_866106130788";
    @Test
    public void likeToMyPhoto() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.openPhotoId(id);
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickLike();
        new ClickLikePromise(driver, photoPage).SetClickType();
        photoPage.closePhoto();
        photoMainPage.clickOpenPhotoForLike();
        photoPage.clickLike();
        new ClickLikePromise(driver, photoPage).SetClickType();
    }
}
