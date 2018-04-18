package tests;

import core.*;
import model.TestBot;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaAddDescription extends TestBase{

    String description = "Описание...";

    @Test
    public void addDescription() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();

        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickOpenPhotoLena();

        DescInterface exampleInterface = new DescFactory().get(driver);
        org.junit.Assert.assertTrue("Комментарии при невыполнении условия", exampleInterface.isDescEmpty()); //??


        PhotoPage photoPage = new PhotoPage(driver);
        photoPage.clickAddDescription();
        photoPage.typeDescrName(description);
        photoPage.clickSaveDescription();

        Assert.assertTrue(photoPage.isAddDescription(description), "Описание не добавлено");
        photoPage.closePhoto();
        //

    }
}
