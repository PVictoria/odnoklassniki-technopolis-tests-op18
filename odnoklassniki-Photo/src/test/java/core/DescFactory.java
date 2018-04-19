package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.04.2018.
 */
public class DescFactory { //Lena

    private final static By CLEAR_DESC =  By.xpath(".//*[text() = 'Добавить описание']");
    public DescInterface get(WebDriver driver) {
        //условие
        if (isDescEmpty(driver)) {
            return new ClearDescPage(driver);
        } else {
            return new DescPresentPage(driver);
        }
    }

    private boolean isDescEmpty(WebDriver driver) {

        if (isElementPresent(CLEAR_DESC)){

        }
        //здесь должен быть код, который определит на какой странице мы находимся ExamplePage или ExamplePageNew
        return true;
    }
}
