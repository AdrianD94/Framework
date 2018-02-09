package pages;

import models.LoginModel;
import org.apache.xpath.operations.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * In primul rand sa nu uitam, clasele incep cu litera mare, iar metodele cu litera mica
 * In folderul pages, facem urmatoarele lucruri:
 * - facem cate o clasa pentru fiecare pagina pe care lucram (de ex: Login page), astfel fiecare pagina devine un obiect
 * - in fiecare pagina definim toate elementele din ea (de ex: in Login page avem: username fields, password field si login button)
 * - in fiecare pagina definim metode care vor reprezenta actiunile pe care le vom face in teste. (dat click-uri, completat field-uri, etc.) .
 * Pentru asta, ne vom folosi ca input, de ce avem in models, adica, de ex, in LoginModel avem ce citim din json files "username, password, errormessage". Username si password
 * il vom lua therefore ca input din model. Vedeti mai jos metoda "loginFlow".
 */

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driverLn) {
        {
            this.driver = driverLn;
        }

    }

    @FindBy(how = How.NAME, using = "userEmail")
    private WebElement userEmailField;
    @FindBy(how = How.NAME, using = "userPassword")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login-box-cn\"]/form/div[4]/button")
    private WebElement loginButton;

    public void loginFlow (LoginModel model) throws InterruptedException{
        userEmailField.clear();
       // userEmailField.sendKeys(model.getEmailAddress());
        passwordField.clear();
       // passwordField.sendKeys(model.getPassword());
        loginButton.click();
    }
}
