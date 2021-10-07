package test;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CapturarCertificado {

    private WebDriver driver;

    @BeforeAll
    static void setup(){
    	WebDriverManager.chromedriver();
    }
    

    @BeforeEach
    void setupTest() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized");
    	driver = new ChromeDriver(options);
        driver.get("https://fpftech.com/principal");
        
    }

    @Test
    void CapturarListaCertificados(){
    	
    	driver.findElement(By.cssSelector("body > modal-container > div > div > app-lgpd-tou > div > "
    			+ "div.modal-body > div.d-flex.justify-content-end.mt-3.mb-1 > button.btn.btn-primary")).click();
    	
    	
    	driver.findElement(By.xpath("/html/body/app-root/app-empty-wrapper/app-home/app-wrapper-home/section/main/app"
    			+ "-home-certifications/section/div[2]/div/app-home-certifications-cards-slider/section/div[2]/article[5]/app-home-certifications-card/div/img")).click();
    	
    	
    	boolean contains = driver.getPageSource().contains("Certificação CSM");

        Assertions.assertTrue(contains);
    	
    }

    

    @AfterEach
    void teardown() {
        driver.quit();
    }
}