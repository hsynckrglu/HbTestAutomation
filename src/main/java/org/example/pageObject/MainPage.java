package org.example.pageObject;

import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;
    String ürünEklendiMesajText="Ürün sepete eklendi";

    String beklenenSayfaUrl="https://www.hepsiburada.com/";

    public MainPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//span[text()='Elektronik']")
    WebElement elektronikOption;

    @FindBy(xpath = ".//a[text()='Bilgisayar/Tablet']")
    WebElement bilgisayarTabletOption;

    @FindBy(xpath = ".//span[text()='Notebook']")
    WebElement notbookOption;


    @FindBy(xpath = ".//a[text()='Apple Dizüstü Bilgisayar Laptop']")
    WebElement appleCheckBox;

    @FindBy(xpath = ".//label[text()='Sıralama']")
    WebElement sıralamaCheckBox;

    @FindBy(xpath = ".//div[text()='Çok satanlar']")
    WebElement cokSatanlarOption;

    @FindBy(id = "shoppingCart")
    WebElement sepetimButton;

    @FindBy(id = "i1")
    WebElement secondUrun;

    @FindBy(xpath = ".//div[text()='Sepete ekle']")
    WebElement sepeteEkleButton;

    @FindBy(xpath = "//div[@id='markalar']//input[@placeholder='Filtrele']")
    WebElement filtreleTextBox;


    @FindBy(css = ".hb-toast-text")
    WebElement ürünEklendiMesajı;

    public void goToURL(WebDriver driver){

        this.driver.get("https://www.hepsiburada.com/");

    }


    public void checkGirisSayfasıURL(){
       String sayfaURL= this.driver.getCurrentUrl();
       Assert.assertEquals(sayfaURL,beklenenSayfaUrl);
        System.out.println("Control ok! :"+ sayfaURL);
    }

    public void clickNotebook() throws InterruptedException {

        Actions actions =new Actions(driver);


        actions.moveToElement(elektronikOption).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(bilgisayarTabletOption).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(notbookOption).click().build().perform();


    }

    public void scrollDown() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1300)");
        Thread.sleep(2000);


    }

    public void selectApple() throws InterruptedException {

        appleCheckBox.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(2000);



    }



    public void sıralama() throws InterruptedException {

        sıralamaCheckBox.click();
        Thread.sleep(1000);
        cokSatanlarOption.click();

        Thread.sleep(2000);
    }


    public void ürünEkleme() throws InterruptedException {
        Actions actions =new Actions(driver);
        actions.moveToElement(secondUrun).build().perform();

        sepeteEkleButton.click();
        Thread.sleep(1000);


    }

    public void mesaj() throws InterruptedException {
        Thread.sleep(2000);
        String textMesagge=  ürünEklendiMesajı.getText();


        Assert.assertEquals(textMesagge,ürünEklendiMesajText);
        System.out.println("control ok! : "+textMesagge);


    }


    public void scrollUp() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1300)");
        Thread.sleep(2000);

    }

    public OrderPage goToCart() throws InterruptedException {

        sepetimButton.click();
        Thread.sleep(2000);

        OrderPage orderPage = new OrderPage(driver);
        return orderPage;

    }
}
