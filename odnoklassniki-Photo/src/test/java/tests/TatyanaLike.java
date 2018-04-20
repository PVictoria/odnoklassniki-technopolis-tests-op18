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
    String myId;

    @Before
    public void deleteAllComments() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot21", "QA18testbott"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        String pathname = "C:/JavaProjects/myPhoto.jpg";
        myId = photoMainPage.addPhoto(pathname);
        userMainPage.clickLogout();
    }

    @Test
    public void likeToMyPhoto() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot21", "QA18testbott"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
<<<<<<< HEAD
        photoMainPage.openPhotoId(myId);
=======
        photoMainPage.openPhotoById(id);
>>>>>>> vikaP
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickLike();
        new ClickLikePromise(driver, photoPage).SetClickType(); //убрать сетклик , клик возвращает промис и вызываем нужный нам метод сами
        //photoPage.closePhoto();
        //photoMainPage.clickOpenPhotoForLike();
        //photoPage.clickLike();
        //new ClickLikePromise(driver, photoPage).SetClickType();
    }
}
