package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    WebDriver driver;

    String BeklenenTittle= "Üye Giriş Sayfası & Üye Ol - Hepsiburada";
    String sepettekiUrunText ="SEÇİLEN ÜRÜNLER (1)";

    public OrderPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@class='active_3fZys']")
    WebElement sepettekiUrun;

    @FindBy(id = "continue_step_btn")
    WebElement alısverisiTamamlaButton;







    public void sepettekiUrunKontrol() throws InterruptedException {
        Thread.sleep(1500);
        String sepetText= sepettekiUrun.getText();
        if (sepetText.equals(sepettekiUrunText)){
            System.out.println("Eklediğiniz ürün sepette mevcuttur!");
        }else {
            System.out.println("Eklediğiniz ürün sepette mevcut değildir!");
        }
    }


    public void alısverisiTamamla() throws InterruptedException {

        alısverisiTamamlaButton.click();
        Thread.sleep(3000);
        String üyeolTitle= driver.getTitle();

        if (üyeolTitle.equals(BeklenenTittle)){
            System.out.println("Başarıyla login ekranına yönlendirilmiştir.");
        }else {
            System.out.println("Login ekranına yönlendirme başarısız!");
        }

    }





}
