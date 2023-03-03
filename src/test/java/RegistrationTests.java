import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests {
    WebDriver wd;

    @BeforeMethod
public void preCondition(){
        wd=new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
    }

    @Test
   public void regPositiveTest(){
      //open login

        WebElement loginButt = wd.findElement(By.xpath("//a[@href='/login']"));
        loginButt.click();
        //fill login form
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;// int переобразовуем в интеджер
        WebElement emailImp = wd.findElement(By.xpath("//input[1]"));
        emailImp.click();
        emailImp.clear();
        emailImp.sendKeys("yarik777"+ i +"@gmail.com");//konkotinazy

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("987654Yy$");
        //submit by click registration
        wd.findElement(By.xpath("//button[2]")).click();
//    Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }
    @Test
    public void registrationWrongEmail(){
        WebElement login = wd.findElement(By.xpath("//a[@href='/login']"));
        login.click();
        WebElement inp1 = wd.findElement(By.xpath("//input[1]"));
        inp1.click();;
        inp1.clear();
        inp1.sendKeys("natalia.gmail.com");

        WebElement passworD = wd.findElement(By.xpath("//input[2]"));
        passworD.click();
        passworD.clear();
        passworD.sendKeys("1234567Nn$");

        wd.findElement(By.xpath("//button[2]")).click();

    //    Assert.assertTrue(wd.findElement(By.xpath("")).getText().equals("Wrong email or password"));
    }
    @Test
    public void registrationWrongPassword(){
        WebElement loginP = wd.findElement(By.xpath("//a[@href='/login']"));
        loginP.click();
        WebElement emaiL = wd.findElement(By.xpath("//input[1]"));
        emaiL.click();
        emaiL.clear();
        emaiL.sendKeys("yarik777@gmail.com");

        WebElement passwordN = wd.findElement(By.xpath("//input[2]"));
        passwordN.click();
        passwordN.clear();
        passwordN.sendKeys("123456N");

        wd.findElement(By.xpath("//button[2]")).click();
    }

    @AfterMethod
    public void postCondition(){
 //       wd.quit();
    }
}
