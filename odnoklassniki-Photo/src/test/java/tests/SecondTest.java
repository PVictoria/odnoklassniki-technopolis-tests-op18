package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import static core.AlbumPage.NEW_ALBUM_NAME;
import static core.PhotoMainPage.OPEN_ALBOM;
import static core.PhotoMainPage.OPEN_PHOTO_FOR_COM;
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
    /*@Test
    public void testPhotoAlbumCreation() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot21 ", "QA18testbott"));


     //  new UserMainPage(driver).clickPhotosOnToolbar();
       UserMainPage userMainPage = new UserMainPage(driver);
       userMainPage.clickPhotosOnToolbar();
    /////////////////////////добавлние описания к фото///////////////////////////

       /* PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhoto(photoMainPage.OPEN_PHOTO);
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickAddDescription();
        String description = "Описание...";
        photoPage.typeDescrName(description);
        photoPage.clickSaveDescription();

        Assert.assertTrue("Описание не добавлено", photoPage.isAddDescription(description));
        //sleep(1000);
        photoPage.phLogout();*/
    //////////////////////////////////////////////////////////////////////////////
       /* PhotoMainPage photoMainPage1 = new PhotoMainPage(driver);
        photoMainPage1.clickOpenPhoto(photoMainPage1.OPEN_PHOTO);
        System.out.println("1");
        PhotoPage photoPage1 = new PhotoPage(driver);
        System.out.println("2");
       // photoPage1.clickRorate();
        photoPage1.clickMarkFriends();
        sleep(1000);
        System.out.println("3");
        photoPage1.clickOnMarkMessage();
        sleep(5000);
        System.out.println("4");
        photoPage1.clickOnPhoto();
        System.out.println("5");
        sleep(500);
        photoPage1.clickOnMyself();
        photoPage1.clickDone();*/

        /*Assert.assertTrue("Пользователь не отмечен", photoPage1.);
        //sleep(1000);
        photoPage.phLogout();*/
    ////////////////////////////////////////////////////////


        /*photoMainPage.clickCreateAlbum();
        String pa = "PhotoAlbum!!!";
        photoMainPage.typePhotoName(pa);
        photoMainPage.clickCreateButton();

        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(pa));
        userMainPage.clickLogout();


    }*/

    //тест-кейс 8  Виктория
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
    /*@Test
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


    }*/

    //тест-кейс добавление коммента Таня
    /*@Test
    public void addCommentUnderPhoto() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot21", "QA18testbott"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhoto(OPEN_PHOTO_FOR_COM);
        String com = "New comment";
        PhotoPage photopage = new PhotoPage(driver);
        photopage.setAddComment(com);
        photopage.clickSetAddComment();
        //проверка
        Assert.assertTrue("Коммент не добавлен", photopage.isAddComment(com));
       

    }*/

    //тест-кейсизменение названия альбома
    @Test
    public void changeAlbomsName() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.openAlbom(OPEN_ALBOM);
        AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEditAlbum();
        albumPage.editAlbumName();
        albumPage.returnToPhoto();
        //проверка
        Assert.assertTrue("Имя альбома не изменено", albumPage.isChangeAlbumsName(NEW_ALBUM_NAME));
    }


}