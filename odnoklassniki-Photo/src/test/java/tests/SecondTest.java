package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import java.util.List;

//   String s = driver.findElement(By.xpath("string(.//*[@id='hook_Block_ProLink'])")).getText();
//        List<WebElement> wes = (List<WebElement>) driver.findElements(By.xpath("(.//div[@class='col-card_num']/node())"));
//        String s = wes.get(2).getText();
//        System.out.print(s);
//        "string(.//*[@id='hook_Block_ProLink'])"
//
//                "string(.//div[@class='col-card_num']/node()[2])")).toString();
//  System.out.print(s);


public class SecondTest extends TestBase {

    //Создание Альбома
<<<<<<< HEAD
    @Test
    public void testPhotoAlbumCreation() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));


     //  new UserMainPage(driver).clickPhotosOnToolbar();
       UserMainPage userMainPage = new UserMainPage(driver);
       userMainPage.clickPhotosOnToolbar();

        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhoto();
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickAddDescription();
        String description = "Описание...";
        photoPage.typeDescrName(description);
        photoPage.clickSaveDescription();

        Assert.assertTrue("Описание не добавлено", photoPage.isAddDescription(description));
        //sleep(1000);
        photoPage.phLogout();

        /*photoMainPage.clickCreateAlbum();
        String pa = "PhotoAlbum!!!";
        photoMainPage.typePhotoName(pa);
        photoMainPage.clickCreateButton();

        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(pa));
        userMainPage.clickLogout();*/


    }

    //тест-кейс 8  Виктория
=======
>>>>>>> d2d9317647d737189a4143dd9358066f2a92e1aa
//    @Test
//    public void testPhotoAlbumCreation() throws Exception {
//
//        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
//
//
//     //  new UserMainPage(driver).clickPhotosOnToolbar();
//       UserMainPage userMainPage = new UserMainPage(driver);
//       userMainPage.clickPhotosOnToolbar();
//
//        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
//
//        photoMainPage.clickCreateAlbum();
//        String pa = "PhotoAlbum!!!";
//        photoMainPage.typePhotoName(pa);
//        photoMainPage.clickCreateButton();
//
//        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(pa));
//        userMainPage.clickLogout();
//
//
//    }

    //тест-кейс 8  Виктория
    @Test
    public void transferPhotosFromAlbumToAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);

        photoMainPage.clickOnAlbum();
        AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEditButton();
        albumPage.clickOnPhoto();
        albumPage.choseTargetAlbum();
        albumPage.clickButtonMove();
        Assert.assertTrue("Фото не перенесены", albumPage.isPhotoMoved());
       // проверка


    }

}