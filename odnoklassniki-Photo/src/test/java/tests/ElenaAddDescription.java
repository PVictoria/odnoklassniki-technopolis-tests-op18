package tests;

import core.*;
import model.TestBot;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaAddDescription extends TestBase{

    @Test
    public void addDescription() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        /////////////////////////добавлние описания к фото///////////////////////////

        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhotoLena();
        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickAddDescription();
        String description = "Описание...";
        photoPage.typeDescrName(description);
        photoPage.clickSaveDescription();

        Assert.assertTrue(photoPage.isAddDescription(description), "Описание не добавлено");
                photoPage.phLogout();

    }
}
