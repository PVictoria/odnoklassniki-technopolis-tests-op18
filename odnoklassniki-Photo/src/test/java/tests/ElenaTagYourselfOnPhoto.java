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
        photoMainPage.openPhotoById(id); //метод один айди передаем как параметр
        String selfId = "plpp_markSelf";
        photoMainPage.openPhotoId(id);
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickMarkFriends();
<<<<<<< HEAD


        photoPage.clickBy(id, 300,200);


        sleep(1000);
        System.out.println("3");
        // photoPage1.clickOnMarkMessage();
        sleep(5000);
        System.out.println("4");
       // photoPage.clickBy();
        //photoPage.clickOnPhoto();//
        System.out.println("5");
        sleep(500);

        sleep(1000);
        System.out.println("2");
        photoPage.clickBy(id, 400,150);
        System.out.println("3");
        photoPage.clickOnSelf();
        sleep(1000);
=======
        photoPage.clickBy(idImg);
        photoPage.clickBy(selfId);
>>>>>>> Lena
        photoPage.clickDone();
        Assert.assertTrue("Пользователь не отмечен", photoPage.isMarkSelf(fio));
        photoPage.closePhoto();
        userMainPage.clickLogout();
    }
}
