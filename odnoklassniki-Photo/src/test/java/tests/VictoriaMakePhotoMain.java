package tests;

import core.*;
import model.TestBot;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class VictoriaMakePhotoMain extends TestBase {

    TestBot testBot = new TestBot("pvikka@mail.ru", "123654v");
    String albumName = "Личные фото";
    String photoId;


    @Before
    public void loadPhoto() {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        String pathname = "C:/JavaProjects/myPhoto.jpg";
        photoId = photoMainPage.addPhoto(pathname);
        //проверка, что фото добавлено
    }

    @Test
    public void makePhotoMain() {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumName);

<<<<<<< HEAD
        //PhotoPage photoPage = albumPage.clickOnPhoto(photoId); //внутри эдита
=======
       // PhotoPage photoPage = albumPage.clickOnPhoto(photoId); //внутри эдита
>>>>>>> Lena

       // albumPage.chosePhoto();


    }


}
