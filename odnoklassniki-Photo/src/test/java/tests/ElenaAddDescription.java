package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by User on 18.04.2018.
 */
import org.junit.Assert;

public class ElenaAddDescription extends TestBase{

    String pathname = "C:/Users/таня/Pictures/Penguins.jpg";//"C:/Users/User/Desktop/УНИВЕР/Тестирование/car.jpg";
    TestBot testBot = new TestBot("QA18testbot9 ", "QA18testbot");
    String idPhoto;
    String description = "Описание...";

    @Before
    public void beforeAddDescription() throws InterruptedException {
        idPhoto = HelperTest.loadPhoto(driver, testBot, pathname);
       /* new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        String pathname = "C:/Users/User/Desktop/car.jpg";
        id = photoMainPage.addPhoto(pathname);
        userMainPage.clickLogout();*/
    }

    @Test
    public void addDescription() throws Exception{
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        PhotoPage photoPage = photoMainPage.openPhotoById(idPhoto);

        DescInterface photoInterface = new DescFactory().getPage(driver);
        photoInterface.clickAddDescription();
        photoInterface.typeDescrName(description);
        photoInterface.clickSaveDescription();

        Assert.assertTrue( "Описание не добавлено", photoPage.isAddDescription(description));
        photoPage.closePhoto();
        userMainPage.clickLogout();
    }

    @After
    public void deletePhotoAfterTest(){
        HelperTest.deletePhoto(driver, testBot, idPhoto);
    }
}
