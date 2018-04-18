package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.AlbumPage.newAlbumName;
import static core.PhotoMainPage.OPEN_ALBUM;
import static core.PhotoMainPage.OPEN_PHOTO_FOR_COM;
import static core.PhotoMainPage.OPEN_PHOTO_FOR_LIKE;
import static java.lang.Thread.sleep;

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
    @Test
    public void testPhotoAlbumCreation() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));

     //  new UserMainPage(driver).clickPhotosOnToolbar();
       UserMainPage userMainPage = new UserMainPage(driver);
       userMainPage.clickPhotosOnToolbar();
    /////////////////////////добавлние описания к фото///////////////////////////

        /*PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhotoLena();
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickAddDescription();
        String description = "Описание...";
        photoPage.typeDescrName(description);
        photoPage.clickSaveDescription();

        Assert.assertTrue("Описание не добавлено", photoPage.isAddDescription(description));
                photoPage.phLogout();*/
    //////////////////////////////отметка себя на фото////////////////////////////
     /*   PhotoMainPage photoMainPage1 = new PhotoMainPage(driver);
        photoMainPage1.clickOpenPhotoLena();
        System.out.println("1");
        PhotoPage photoPage1 = new PhotoPage(driver);
        System.out.println("2");
=======
        //  new UserMainPage(driver).clickPhotosOnToolbar();
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        /////////////////////////добавлние описания к фото///////////////////////////

        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
//        photoMainPage.clickOpenPhoto(photoMainPage.OPEN_PHOTO);
//        PhotoPage photoPage = new PhotoPage(driver);
//        photoPage.clickAddDescription();
//        String description = "Описание...";
//        photoPage.typeDescrName(description);
//        photoPage.clickSaveDescription();
//
//        Assert.assertTrue("Описание не добавлено", photoPage.isAddDescription(description));
//        //sleep(1000);
//        photoPage.phLogout();
        //////////////////////////////////////////////////////////////////////////////
        PhotoMainPage photoMainPage1 = new PhotoMainPage(driver);
        photoMainPage1.clickOpenPhoto(photoMainPage1.OPEN_PHOTO); //метод один айди передаем как параметр
        System.out.println("1");
        PhotoPage photoPage1 = new PhotoPage(driver);
        System.out.println("2");
        // photoPage1.clickRorate();
>>>>>>> f4176c7f19ea49c9a9b3a264ef7d4e683e489355
        photoPage1.clickMarkFriends();
        sleep(1000);
        System.out.println("3");
       // photoPage1.clickOnMarkMessage();
        sleep(5000);
        System.out.println("4");
        photoPage1.clickOnPhoto();//
        System.out.println("5");
        sleep(500);
        photoPage1.clickOnMyself();
        photoPage1.clickDone();


        //Assert.assertTrue("Пользователь не отмечен", photoPage1.);
        //sleep(1000);
<<<<<<< HEAD
        photoPage.phLogout();*/
    /////////////////////////удаление фото при редактирование///////////////////////////
        PhotoMainPage photoMainPage2 = new PhotoMainPage(driver);
        photoMainPage2.clickPersonalPhoto();
        AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEdit();
        albumPage.clickDelete();
        albumPage.isDeleted();
        sleep(8000);
        albumPage.recoveryPhoto();

        ////////////////////////////////////////////////////////
        /*photoMainPage.clickCreateAlbum();
=======
       // photoPage.phLogout();
    ////////////////////////////////////////////////////////


        photoMainPage.clickCreateAlbum();
>>>>>>> f4176c7f19ea49c9a9b3a264ef7d4e683e489355
        String pa = "PhotoAlbum!!!";
        photoMainPage.typePhotoName(pa);
        photoMainPage.clickCreateButton();

        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(pa));
        userMainPage.clickLogout();
<<<<<<< HEAD
        driver.navigate().refresh();*/
    }

    //Создание Альбома - наш самый первый автотест
    //
    @Test
    public void testPhotoAlbumCreation1() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));


     //  new UserMainPage(driver).clickPhotosOnToolbar();
       UserMainPage userMainPage = new UserMainPage(driver);
       userMainPage.clickPhotosOnToolbar();

        PhotoMainPage photoMainPage = new PhotoMainPage(driver);

        photoMainPage.clickCreateAlbum();
        String pa = "PhotoAlbum!!!";
        photoMainPage.typePhotoName(pa);
        photoMainPage.clickCreateButton();

        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(pa));
        userMainPage.clickLogout();
    }
}