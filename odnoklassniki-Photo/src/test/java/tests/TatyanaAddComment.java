package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.PhotoMainPage.OPEN_PHOTO_FOR_COM;
import static java.lang.Thread.sleep;

/**
 * Created by таня on 18.04.2018.
 */
public class TatyanaAddComment extends TestBase{
    //тест-кейс добавление коммента Таня
    //залить фото???
    //удалить все комментарии

    @Before
    public void deleteAllComments() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot21", "QA18testbott"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhotoForCom();
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.delAllCom();
        sleep(5000);
        photoPage.closePhoto();
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickLogout();
    }

    @Test
    public void addCommentUnderPhoto() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot21", "QA18testbott"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhotoForCom();
        String com = "New comment20";
        PhotoPage photopage = new PhotoPage(driver);
        photopage.setAddComment(com);
        photopage.clickSetAddComment();
        //проверка
        Assert.assertTrue("Коммент не добавлен", photopage.isAddComment(com));
    }
}
