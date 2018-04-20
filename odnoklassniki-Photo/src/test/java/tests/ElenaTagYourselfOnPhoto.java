package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaTagYourselfOnPhoto extends TestBase{
    String fio;
    String id;
    @Before
    public void beforeTagYourself(){
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        fio = userMainPage.getFIO();
        System.out.println(fio);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        String pathname = "C:/Users/User/Desktop/man.jpg";
        id = photoMainPage.addPhoto(pathname);
        userMainPage.clickLogout();

    }
    @Test
    public void tagYourself() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage  = userMainPage.clickPhotosOnToolbar();

        String idImg = "__plpcte_target";
        String selfId = "plpp_markSelf";
        photoMainPage.openPhotoId(id);
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickMarkFriends();
        photoPage.clickBy(idImg);
        photoPage.clickBy(selfId);
        photoPage.clickDone();
        Assert.assertTrue("Пользователь не отмечен", photoPage.isMarkSelf(fio));
        photoPage.closePhoto();
        userMainPage.clickLogout();
    }
}
