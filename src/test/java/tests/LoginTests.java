package tests;

import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
   @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
   }
@Test(dataProvider = "loginModelDto", dataProviderClass = ProviderData.class, invocationCount = 1, groups = {"smoke"})
    public void loginPositive(User data){
     //   User user = User.builder()
     //           .email("vasiatal@gmail.com")
     //           .password("Vasia$1234")
     //           .build();

   // String email ="vasiatal@gmail.com";
   // String password ="Vasia$1234";
    app.getUser().openLoginRegistration();
//    app.getUser().fillLoginRegistrationForm(email,password);
    app.getUser().fillLoginRegistrationForm(data);
    app.getUser().submitLogin();
 //   Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
 //  Assert.assertTrue(isLogged());
    Assert.assertTrue(app.getUser().isLogged());
}
    @Test
    public void loginPositiveConfig(){

        app.getUser().openLoginRegistration();
        app.getUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isLogged());
    }

@Test(groups = {"smoke","regress"})
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
 //   Assert.assertTrue(app.getUser().isAlertPresent());//метод закроет аллерт
    Assert.assertTrue(app.getUser().isLogged());
//    Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
}
   @Test(groups = {"regress"})
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
       Assert.assertTrue(app.getUser().isLogged());
 //     Assert.assertTrue(wd.findElement(By.xpath("//div[.='Login Failed with code 401']")).getText().equals("Login Failed with code 401"));
    }
//    @AfterMethod
//    public void postCondition(){
        //       wd.quit();
//    }
}
