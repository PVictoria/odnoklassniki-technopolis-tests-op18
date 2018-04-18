package tests;

import core.*;
import model.TestBot;

import static java.lang.Thread.sleep;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaTagYourselfOnPhoto extends TestBase{

    public void tagYourself() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();

        PhotoMainPage photoMainPage1 = new PhotoMainPage(driver);
        photoMainPage1.clickOpenPhotoLena(); //метод один айди передаем как параметр
        System.out.println("1");
        PhotoPage photoPage = new PhotoPage(driver);
        System.out.println("2");
        // photoPage1.clickRorate();
        photoPage.clickMarkFriends();
        sleep(1000);
        System.out.println("3");
        // photoPage1.clickOnMarkMessage();
        sleep(5000);
        System.out.println("4");
        photoPage.clickOnPhoto();//
        System.out.println("5");
        sleep(500);
        photoPage.clickOnSelf();
        photoPage.clickDone();

        //Assert.assertTrue("Пользователь не отмечен", photoPage1.);
        //sleep(1000);
        photoPage.phLogout();

    }
}
