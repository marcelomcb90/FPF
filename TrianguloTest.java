package test;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrianguloTest {

    private WebDriver driver;

    @BeforeAll
    static void setup(){
        WebDriverManager.chromedriver();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("http://vanilton.net/triangulo/");
    }

    @Test
    void testeTrianguloEquilatero(){

        driver.findElement(By.name("V1")).sendKeys("4");
        driver.findElement(By.name("V2")).sendKeys("4");
        driver.findElement(By.name("V3")).sendKeys("4");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String textoAtual = driver.findElement(By.xpath("/html/body/div[4]")).getText();

        Assertions.assertEquals("Equilátero", textoAtual);
    }

    @Test
    void testeTrianguloEscaleno(){

        driver.findElement(By.name("V1")).sendKeys("4");
        driver.findElement(By.name("V2")).sendKeys("2");
        driver.findElement(By.name("V3")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String textoAtual = driver.findElement(By.xpath("/html/body/div[4]")).getText();

        Assertions.assertEquals("Escaleno", textoAtual);
    }

    @Test
    void testeTrianguloIsoceles(){

        driver.findElement(By.name("V1")).sendKeys("4");
        driver.findElement(By.name("V2")).sendKeys("4");
        driver.findElement(By.name("V3")).sendKeys("8");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String textoAtual = driver.findElement(By.xpath("/html/body/div[4]")).getText();

        Assertions.assertEquals("Isósceles", textoAtual);
    }

    @Test
    void testeTrianguloError(){
        driver.findElement(By.name("V1")).sendKeys("4");
        driver.findElement(By.name("V2")).sendKeys("4");

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        boolean contains = driver.getPageSource().contains("Digite os valores dos vértices do triângulo para identificar o seu tipo");

        Assertions.assertTrue(contains);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
    
    
}