package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
//    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

   /*     public void preCondition(){
       wd=new ChromeDriver();
       wd.navigate().to("https://telranedu.web.app/home");
       wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }*/

    @Test(groups = {"smoke"})
   public void regPositiveTest(){
      //open login

    //    WebElement loginButt = wd.findElement(By.xpath("//a[@href='/login']"));
    //    loginButt.click();
        //fill login form
        app.getUser(). openLoginRegistration();
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;// int переобразовуем в интеджер
        User user= User.builder()
                .email("yarik777"+ i +"@gmail.com")
                .password("987"+i+"Yy$")
                .build();
        logger.info("registrationPositiveTest starts with: " + user.getEmail()+" & "+ user.getPassword());

   //     String email = "yarik777"+ i +"@gmail.com";
   //     String password = "987654Yy$";
        app.getUser(). fillLoginRegistrationForm(user);
        /*      WebElement emailImp = wd.findElement(By.xpath("//input[1]"));
        emailImp.click();
        emailImp.clear();
        emailImp.sendKeys("yarik777"+ i +"@gmail.com");//konkotinazy

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("987654Yy$");

        //submit by click registration
        wd.findElement(By.xpath("//button[2]")).click();*/
        app.getUser(). submitRegistration();
 //1,2       pause(5000);
        logger.info("registrationPositiveTest completed");
 //   Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));
    }
 //   public void pause(int time){

 //2       FluentWait<WebDriver> wait = new FluentWait<>(wd);
 //2       wait.withTimeout(Duration.ofSeconds(time));
  //1      try {
  //1          Thread.sleep(time);
  //1      } catch (InterruptedException e) {
  //1          throw new RuntimeException(e);
  //1      }
  //  }

     @Test
    public void registrationWrongEmail(){
         app.getUser().openLoginRegistration();
         int i = (int)(System.currentTimeMillis() / 1000) % 3600;
         User user= User.builder()
                 .email("yarik777"+ i +"gmail.com")
                 .password("987"+i+"Yy$")
                 .build();
    //     String email = "yarik777"+ i +"gmail.com";
    //     String password = "987654Yy$";
         app.getUser().fillLoginRegistrationForm(user);
         app.getUser().submitRegistration();


         Assert.assertTrue(app.getUser().isErrorFormatMessage());
         Assert.assertTrue(app.getUser().isAlertPresent());//метод закроет аллерт
        //    Assert.assertTrue(wd.findElement(By.xpath("")).getText().equals("Wrong email or password"));
    }
    @Test
    public void registrationWrongPassword(){
        app.getUser(). openLoginRegistration();
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        User user= User.builder()
                .email("yarik777"+ i +"@gmail.com")
                .password("987"+i+"$")
                .build();
    //    String email = "yarik777"+ i +"@gmail.com";
    //    String password = "987654$";

        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();



        Assert.assertTrue(app.getUser().isErrorFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());//метод закроет аллерт
        //    Assert.assertTrue(wd.findElement(By.xpath("")).getText().equals("Wrong email or password"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
 //       wd.quit();
    }
}
