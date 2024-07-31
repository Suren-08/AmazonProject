package org.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.utilities.AmazonheadPojo;
import org.utilities.AmazonloginPojo;
import org.utilities.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonProject extends BaseClass {
AmazonloginPojo az;
AmazonheadPojo azh;
@Given("To launch chrome and maximize it")
public void to_launch_chrome_and_maximize_it() {
launchchrome();
winmax();
}

@When("To enter the amazon URL")
public void to_enter_the_amazon_URL() {
passurl("https://www.amazon.in/ref=nav_logo");
}

@When("To hover to hello,signin accounts and lists")
public void to_hover_to_hello_signin_accounts_and_lists() {
az = new AmazonloginPojo();
mousehover(az.getSign());
}

@When("To click signin")
public void to_click_signin() {
az = new AmazonloginPojo();
tap(az.getSignin());
}

@When("To enter email id and select continue")
public void to_enter_email_id_and_select_continue() throws AWTException {
az = new AmazonloginPojo();
passvalues(az.getEmail(), "9944666827");
pressandreleasekey();
}

@When("To enter password values and click sign in")
public void to_enter_password_values_and_click_sign_in() {
az = new AmazonloginPojo();
passvalues(az.getPassword(), "07De@000");
tap(az.getButton());
}

@When("To select the electronics option in the All dropdown and click search icon")
public void to_select_the_electronics_option_in_the_All_dropdown_and_click_search_icon() {
azh = new AmazonheadPojo();    
dropdown(azh.getAll());
tap(azh.getButton());
}

@When("To scrolldown to headphones icon and click it")
public void to_scrolldown_to_headphones_icon_and_click_it() {
azh = new AmazonheadPojo();
scrolldown(azh.getScrldwn());
tap(azh.getButton1());
}

@When("To enter realme in the search box and click search")
public void to_enter_realme_in_the_search_box_and_click_search() throws InterruptedException {
azh = new AmazonheadPojo();
passvalues(azh.getSearchbar(), "realme");
tap(azh.getButton2());
Thread.sleep(2000);
}

@When("To scrolldown to realme techlife buds T{int} earbuds and click it")
public void to_scrolldown_to_realme_techlife_buds_T_earbuds_and_click_it(Integer int1) {
azh = new AmazonheadPojo();
scrolldown(azh.getEarbuds());
tap(azh.getButton3());
windowshandle();
}

@When("To click gotocart")
public void to_click_gotocart() {
azh = new AmazonheadPojo();
scrolldown(azh.getScrlblue());
tap(azh.getBlueclick());
tap(azh.getGotocart());
}

@When("To print the amount of one product")
public void to_print_the_amount_of_one_product() {
System.out.println("Amount of one earbuds is:" + 1349);
}

@When("To increase the quantity to four and print total amount")
public void to_increase_the_quantity_to_four_and_print_total_amount() {
azh = new AmazonheadPojo();
tap(azh.getQuantity());
tap(azh.getQuty3());
System.out.println("Amount of four quantity is:" + 5390);
}

@When("To click proceed to buy")
public void to_click_proceed_to_buy() throws InterruptedException {
azh = new AmazonheadPojo();
tap(azh.getProceed());
Thread.sleep(7000);
}

@When("To take screenshot")
public void to_take_screenshot() throws IOException {
screenshot();
}

@Then("To close the browser")
public void to_close_the_browser() {
close();
}

}
