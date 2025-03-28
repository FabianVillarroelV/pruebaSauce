package scripts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class pruebaSauce {


    private static WebDriver driver;
    private static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    private WebDriverWait wait;

    @BeforeEach
    public void preCondiciones() {
        //Enlazar el webDriver al browser de nuestro sistema
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        //Instanciar el webdriver
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @Test

    public void CP001_LOGIN() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
         /*
         driver.findElement(By.id("continue")).click();
         String resultadoEsperado = "We cannot find an account with that email address";
         String resultadoActual = driver.findElement(By.xpath("//span[@class='a-list-item'][contains(.,'We cannot find an account with that email address')]")).getText();
         Assertions.assertEquals(resultadoEsperado, resultadoActual);

          */
    }

    @Test
    public void CP002_Comprar() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("shopping_cart_container")).click();


    }
    @Test
    public void CP003_Gestionar_Compra() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Fabian");
        driver.findElement(By.id("last-name")).sendKeys("Villarroel");
        driver.findElement(By.id("postal-code")).sendKeys("620000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String resultadoEsperado = "Thank you for your order!";
        String resultadoActual = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assertions.assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    public void CP003_Cerrar() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Fabian");
        driver.findElement(By.id("last-name")).sendKeys("Villarroel");
        driver.findElement(By.id("postal-code")).sendKeys("620000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String resultadoEsperado = "Thank you for your order!";
        String resultadoActual = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assertions.assertEquals(resultadoEsperado, resultadoActual);
        driver.findElement(By.id("back-to-products")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @AfterEach
    public void posCondiciones() {
        driver.close();
    }
}      
