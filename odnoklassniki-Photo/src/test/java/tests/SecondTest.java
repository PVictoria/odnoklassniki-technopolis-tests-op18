package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.AlbumPage.NEW_ALBUM_NAME;
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