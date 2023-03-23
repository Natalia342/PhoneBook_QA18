package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
   }
@Test
    public void loginPositive(){
        User user = User.builder()
                .email("vasiatal@gmail.com")
                .password("Vasia$1234")
                .build();

   // String email ="vasiatal@gmail.com";
   // String password ="Vasia$1234";
    app.getUser().openLoginRegistration();
//    app.getUser().fillLoginRegistrationForm(email,password);
    app.getUser().fillLoginRegistrationForm(user);
    app.getUser().submitLogin();
 //   Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
 //  Assert.assertTrue(isLogged());
    Assert.assertTrue(app.getUser().isLogged());
}
@Test
    public void loginWrongEmail(){
        User user=User.builder()
                .email("vasiatalgmail.com")
                .password("Vasia$1234")
                .build();
    app.getUser().openLoginRegistration();
  //  String email="vasiatalgmail.com";
  //  String password ="Vasia$1234";
    app.getUser().fillLoginRegistrationForm(user);
    app.getUser().submitLogin();

//    Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
}
   @Test
    public void loginWrongPassword(){
        User user= User.builder()
                .email("vasiatal@gmail.com")
                .password("Vasia34")
                .build();
 //       String email="vasiatal@gmail.com";
 //       String password ="Vasia34";
        app.getUser().openLoginRegistration();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();

 //     Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
    }
//    @AfterMethod
//    public void postCondition(){
        //       wd.quit();
//    }
}
