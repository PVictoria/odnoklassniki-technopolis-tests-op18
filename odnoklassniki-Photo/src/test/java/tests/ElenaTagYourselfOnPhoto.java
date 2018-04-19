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
    @Before
    public void beforeTagYourself(){
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        fio = userMainPage.getFIO();
        System.out.println(fio);
        //        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
  //      String pathname = "C:/Users/User/Desktop/car.jpg";
        //  photoMainPage.addPhoto(pathname);
        userMainPage.clickLogout();

    }
    @Test
    public void tagYourself() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage  = userMainPage.clickPhotosOnToolbar();

        String id = "__plpcte_target";
        photoMainPage.clickOpenPhotoLena(); //метод один айди передаем как параметр
        PhotoPage photoPage = new PhotoPage(driver);
        sleep(1000);
        System.out.println("1");
        photoPage.clickMarkFriends();
        sleep(1000);
        System.out.println("2");
        photoPage.clickBy(id, 400,150);
        sleep(1000);
        System.out.println("3");
        photoPage.clickOnSelf();
        sleep(2000);
        photoPage.clickDone();
        sleep(2000);
        Assert.assertTrue("Пользователь не отмечен", photoPage.isMarkSelf(fio));
        photoPage.closePhoto();
        userMainPage.clickLogout();

    }
}
