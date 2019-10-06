package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ImdbBase {

    static WebDriver driver = new ChromeDriver();

    protected static void initBrowser(String url, String browser) {
        //configurar esperas

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navegar a imdb.com

        driver.get(url);

    }

    protected static void createUser(String user, String password) {
        //crear objeto para guardar locator de botón de sign in
        WebElement signInBtn = driver.findElement(By.id("imdb-signin-link"));

        //dar click en sign in

        signInBtn.click();

        //id = imdb-signin-link
        //dar click en create account

        WebElement createAccountBtn = driver.findElement(By.xpath("//a[text()= 'Create a New Account']"));

        createAccountBtn.click();
        //xpath = //a[text()= 'Create a New Account']

        //rellenar campos formulario

        WebElement yourNameField = driver.findElement(By.name("customerName"));
        yourNameField.sendKeys(user);

        int randomEmail = new Random().nextInt();
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(user + randomEmail + "@hotmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        WebElement passwordCheckField = driver.findElement(By.name("passwordCheck"));
        passwordCheckField.sendKeys(password);


        WebElement createNewAccountBtn = driver.findElement(By.id("continue"));

        createNewAccountBtn.click();

    }


    protected static void validateUser(String user){
        WebElement userLink = driver.findElement(By.id("navUserMenu"));
        String userTxt = userLink.getText();
        if (userTxt.equals(user)) {
            System.out.println("Test passed");

        } else {

            System.out.println("Test failed");
        }


    }


    protected static void closeBrowser(){
        driver.quit();
    }
}
