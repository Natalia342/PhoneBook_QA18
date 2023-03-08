import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logout();
        }
    }
@Test
    public void loginPositive(){
    openLoginRegistration();
    String email ="vasiatal@gmail.com";
    String password ="Vasia$1234";
    fillLoginRegistrationForm(email,password);
    submitLogin();
    Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));

}
@Test
    public void loginWrongEmail(){
    openLoginRegistration();
    String email="vasiatalgmail.com";
    String password ="Vasia$1234";
    fillLoginRegistrationForm(email,password);
    submitLogin();

//    Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
}
    @Test
    public void loginWrongPassword(){
        openLoginRegistration();
        String email="vasiatal@gmail.com";
        String password ="Vasia34";
        fillLoginRegistrationForm(email,password);
        submitLogin();

 //     Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
    }
    @AfterMethod
    public void postCondition(){
        //       wd.quit();
    }
}
