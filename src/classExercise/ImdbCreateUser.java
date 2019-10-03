    package classExercise;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    import java.util.Random;
    import java.util.concurrent.TimeUnit;

    public class ImdbCreateUser {

    public static void main (String args[])
    {
    //arrancar el navegador

    WebDriver driver = new ChromeDriver();


    //configurar esperas

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    //navegar a imdb.com

    driver.get("https://www.imdb.com");


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
    yourNameField.sendKeys("Pedro");

    int randomEmail  = new Random().nextInt();
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("pedro" + randomEmail + "@hotmail.com");

    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("test1234");

    WebElement passwordCheckField  = driver.findElement(By.name("passwordCheck"));
    passwordCheckField .sendKeys("test1234");


    WebElement createNewAccountBtn = driver.findElement(By.id("continue"));


    createNewAccountBtn.click();


    WebElement userLink = driver.findElement(By.id("navUserMenu"));

    String userTxt= userLink.getAttribute();

    if(userTxt.equals("Pedro"))
    {
        System.out.println("Test passed");

    }
    else
    {

        System.out.println("Test failed");
    }

    driver.quit();

    // Your name => name = 'customerName'
    // Email => name = 'email'
    // Password => name = 'password'
    // Re-enter password => name = 'passwordCheck'
    // Create button => id = 'continue'

    //click botón create


    //validar que en el link de usuario aparezca nombre ingresado en formulario


    }

    }
