package TestScenerio;

import TestComponent.BaseTest;
import org.example.pageObject.MainPage;
import org.example.pageObject.OrderPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HbTestScenerio extends BaseTest {




    @Test(groups = "ShoppingTest")
    public void test() throws IOException, InterruptedException {


        
        MainPage mainPage =new MainPage(driver);
        OrderPage orderPage =new OrderPage(driver);
        Thread.sleep(2500);
        mainPage.clickNotebook();
        mainPage.scrollDown();
        mainPage.selectApple();
        mainPage.sıralama();
        mainPage.ürünEkleme();
        mainPage.mesaj();
        mainPage.scrollUp();
        mainPage.goToCart();
        orderPage.sepettekiUrunKontrol();
        orderPage.alısverisiTamamla();




    }
}
