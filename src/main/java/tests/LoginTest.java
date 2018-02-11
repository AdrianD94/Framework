package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends BaseTest{
    @DataProvider(name = "LoginJson")
    public Iterator<Object[]> jsonLoginDataProvider() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Collection<Object[]> dp = new ArrayList<>();

        File[] files = getListOfFiles("loginJson");
        for (File f : files) {
            LoginModel m = objectMapper.readValue(f, LoginModel.class);
            dp.add(new Object[]{m});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "LoginJson")
    public void mainLoginTest(LoginModel loginModel) throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginFlow(loginModel);

        if (loginModel.isValidCredentials() == false){
            Assert.assertEquals(loginPage.getLoginError(),loginModel.getErrorMessage());
        } else{
            System.out.println("Hurray");
        }

    }
}
