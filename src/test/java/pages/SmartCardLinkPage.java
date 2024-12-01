package pages;

import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class SmartCardLinkPage {

    public SmartCardLinkPage() {
        PageFactory.initElements(Driver.getDriver, this);
    }


}
