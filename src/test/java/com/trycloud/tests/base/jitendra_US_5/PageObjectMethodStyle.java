package com.trycloud.tests.base.jitendra_US_5;

import com.trycloud.tests.pages.Jitendra_US_5.HomePage;
import com.trycloud.tests.pages.Jitendra_US_5.Login;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectMethodStyle {

    @Test
    public void Login_TryCloud() {

        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        Login login = new Login();

        String username = ConfigurationReader.getProperty("username1");
        login.inputUsername.sendKeys(username);

        String password = ConfigurationReader.getProperty("password");
        login.inputPassword.sendKeys(password);

        login.loginButton.click();
    }

    @Test
    public void HomePage_TryCloud(){

        HomePage homePage = new HomePage();
    }
}
