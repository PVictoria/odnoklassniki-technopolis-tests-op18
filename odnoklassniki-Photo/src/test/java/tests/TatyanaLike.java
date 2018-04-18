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
    @Test
    public void likeToMyPhoto() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhotoForLike();
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickLike();
        //проверка
        //Assert.assertTrue("Лайк не поставлен", photoPage.isLike());
        new ClickLikePromise(driver, photoPage).SetClickType();
    }
}
