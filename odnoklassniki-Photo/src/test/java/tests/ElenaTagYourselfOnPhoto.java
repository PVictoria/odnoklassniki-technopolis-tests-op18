package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaTagYourselfOnPhoto extends TestBase{

    String pathname = "C:/Users/User/Desktop/man.jpg";
    TestBot testBot = new TestBot("QA18testbot9 ", "QA18testbot");
    String fio;
    String id;
    @Before
    public void beforeTagYourself(){
        id = HelperTest.loadPhoto(driver, testBot, pathname);
        /*new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        fio = userMainPage.getFIO();
        System.out.println(fio);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        String pathname = "C:/Users/User/Desktop/man.jpg";
        id = photoMainPage.addPhoto(pathname);
        userMainPage.clickLogout();*/

    }
    @Test
    public void tagYourself() throws Exception{
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        fio = userMainPage.getFIO();
        PhotoMainPage photoMainPage  = userMainPage.clickPhotosOnToolbar();

        String idImg = "__plpcte_target";
        String selfId = "plpp_markSelf";
        PhotoPage photoPage = photoMainPage.openPhotoById(id);
        photoPage.clickMarkFriends();
        photoPage.clickBy(idImg);
        photoPage.clickBy(selfId);
        photoPage.clickDone();
        Assert.assertTrue("Пользователь не отмечен", photoPage.isMarkSelf(fio));
        photoPage.closePhoto();
        userMainPage.clickLogout();
    }

    @After
    public void deletePhotoAfterTest(){
        HelperTest.deletePhoto(driver, testBot, id);
    }
}
