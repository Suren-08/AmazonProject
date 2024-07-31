package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonheadPojo extends BaseClass{
public AmazonheadPojo() {
	PageFactory.initElements(driver, this);

}
@FindBy(xpath="//select[@id=\"searchDropdownBox\"]")
private WebElement all;    //(dropdown)

@FindBy(xpath="//input[@value=\"Go\"]")
private WebElement button;  //(tap)

@FindBy(xpath="//span[text()=\"Headphones, Earbuds & Accessories\"]")
private WebElement scrldwn;  //(scrolldown)

@FindBy(xpath="//span[text()=\"Headphones, Earbuds & Accessories\"]")
private WebElement button1;   //(tap)

@FindBy(xpath="//input[@placeholder=\"Search Amazon.in\"]")
private WebElement searchbar; //(passvalues) 

@FindBy(xpath="//input[@value=\"Go\"]")
private WebElement button2;   //(tap)

@FindBy(xpath="//span[text()=\"realme Buds 2 Wired in Ear Earphones with Mic (Black)\"]")
private WebElement earbuds;    //(scrolldown)

@FindBy(xpath="//span[text()=\"realme TechLife Buds T100 Bluetooth Truly Wireless in Ear Earbuds with mic, AI ENC for Calls, Google Fast Pair, 28 Hours Total Playback with Fast Charging and Low Latency Gaming Mode (Black)\"]")
private WebElement button3;    //(tap)

@FindBy(xpath="//img[@alt=\"Blue\"]")
private WebElement scrlblue;   //(scrolldown)

@FindBy(xpath="//img[@alt=\"Blue\"]")
private WebElement blueclick;   //(tap)(2sec)

@FindBy(xpath="//span[@class=\"a-button a-button-span11 a-button-base a-button-small\"]")
private WebElement gotocart;   //(tap)

@FindBy(xpath="//span[@data-csa-c-func-deps=\"aui-da-a-dropdown-button\"]")
private WebElement quantity;   //(tap)

@FindBy(xpath="//a[@id=\"quantity_3\"]")
private WebElement quty3;    //(tap)

@FindBy(xpath="//input[@value=\"Proceed to checkout\"]")
private WebElement proceed;   //(tap)(7sec)

public WebElement getAll() {
	return all;
}

public WebElement getButton() {
	return button;
}

public WebElement getScrldwn() {
	return scrldwn;
}

public WebElement getButton1() {
	return button1;
}

public WebElement getSearchbar() {
	return searchbar;
}

public WebElement getButton2() {
	return button2;
}

public WebElement getEarbuds() {
	return earbuds;
}

public WebElement getButton3() {
	return button3;
}

public WebElement getScrlblue() {
	return scrlblue;
}

public WebElement getBlueclick() {
	return blueclick;
}

public WebElement getGotocart() {
	return gotocart;
}

public WebElement getQuantity() {
	return quantity;
}

public WebElement getQuty3() {
	return quty3;
}

public WebElement getProceed() {
	return proceed;
}

}
