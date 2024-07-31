package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonloginPojo extends BaseClass {
public AmazonloginPojo() {
	PageFactory.initElements(driver, this);

}
@FindBy(xpath="//span[text()=\"Account & Lists\"]")
private WebElement sign;       //(mousehover)

@FindBy(xpath="//span[@class=\"nav-action-inner\"][1]")
private WebElement signin;     //(tap)

@FindBy(xpath="//input[@class=\"a-input-text a-span12 auth-autofocus auth-required-field\"]")
private WebElement email;      //(pressandreleasekey)

@FindBy(xpath="//input[@autocomplete=\"current-password\"]")
private WebElement password;   

@FindBy(xpath="//input[@aria-labelledby=\"auth-signin-button-announce\"]")
private WebElement button;      //(tap)

public WebElement getSign() {
	return sign;
}

public WebElement getSignin() {
	return signin;
}

public WebElement getEmail() {
	return email;
}

public WebElement getPassword() {
	return password;
}

public WebElement getButton() {
	return button;
}


}
