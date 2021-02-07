package com.trycloud.tests.base.Delaram_UserStory3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.testng.annotations.Test;

public class TC_1_access_file_module extends TestBase {


    @Test
    public void TC_1_access_file_module(){

     String username = ConfigurationReader.getProperty("username2");
        LoginUtils.loginToTryCloud(driver, username);






    }



}
