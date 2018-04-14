package core.examples;

import core.HelperBase;
import org.openqa.selenium.WebDriver;

/**
 * Пример страницы, первый/старый дизайн
 */
public class ExamplePage extends HelperBase implements ExampleInterface {

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public boolean isSmthgPresent() {
        return false;
    }
}
