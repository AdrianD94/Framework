package models;

import org.apache.xpath.operations.String;

/**
 * Aici punem setteri si getteri pt ce vom citi din Json file.
 * Asadar, in json file vom da "emailAddress", "password", "errorMessage" , scrise exact ca variabilele de aici
 * Totul este la general, nu aici legam modelul de json file. Aici doar definim modelul.
 * Practic, clasa LoginModel raspunde la intrebarea: "Pt login, ce input voi citi din json file?"
 */

public class LoginModel {

    private String emailAddress;
    private String password;
    private String errorMessage;
    private boolean isValidCredentials;

    public boolean isValidCredentials() {
        return isValidCredentials;
    }

    public void setValidCredentials(boolean validCredentials) {
        isValidCredentials = validCredentials;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
