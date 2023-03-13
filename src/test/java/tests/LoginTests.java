package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
//    @BeforeMethod
//    public void preCondition(){
//        if(isLogged()){
//            logout();
//        }
//    }
@Test
    public void loginPositive(){
    app.getUser().openLoginRegistration();
    String email ="vasiatal@gmail.com";
    String password ="Vasia$1234";
    app.getUser().fillLoginRegistrationForm(email,password);
    app.getUser().submitLogin();
 //   Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
 //  Assert.assertTrue(isLogged());
    Assert.assertTrue(app.getUser().isLogged());
}
@Test
    public void loginWrongEmail(){
    app.getUser().openLoginRegistration();
    String email="vasiatalgmail.com";
    String password ="Vasia$1234";
    app.getUser().fillLoginRegistrationForm(email,password);
    app.getUser().submitLogin();

//    Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
}
    @Test
    public void loginWrongPassword(){
        app.getUser().openLoginRegistration();
        String email="vasiatal@gmail.com";
        String password ="Vasia34";
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitLogin();

 //     Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
    }
//    @AfterMethod
//    public void postCondition(){
        //       wd.quit();
//    }
}
