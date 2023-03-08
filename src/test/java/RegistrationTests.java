import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
//    WebDriver wd;

   @BeforeMethod
   public void preCondition(){
       if(isLogged()){
           logout();
       }
   }
   /*     public void preCondition(){
       wd=new ChromeDriver();
       wd.navigate().to("https://telranedu.web.app/home");
       wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }*/

    @Test
   public void regPositiveTest(){
      //open login

    //    WebElement loginButt = wd.findElement(By.xpath("//a[@href='/login']"));
    //    loginButt.click();
        //fill login form
        openLoginRegistration();
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;// int переобразовуем в интеджер
        String email = "yarik777"+ i +"@gmail.com";
        String password = "987654Yy$";
        fillLoginRegistrationForm(email,password);
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
        submitRegistration();
 //1,2       pause(5000);

    Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
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
         openLoginRegistration();
         int i = (int)(System.currentTimeMillis() / 1000) % 3600;
         String email = "yarik777"+ i +"gmail.com";
         String password = "987654Yy$";
         fillLoginRegistrationForm(email,password);
         submitRegistration();

        //    Assert.assertTrue(wd.findElement(By.xpath("")).getText().equals("Wrong email or password"));
    }
    @Test
    public void registrationWrongPassword(){
        openLoginRegistration();
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        String email = "yarik777"+ i +"@gmail.com";
        String password = "987654$";
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        //    Assert.assertTrue(wd.findElement(By.xpath("")).getText().equals("Wrong email or password"));

    }

    @AfterMethod
    public void postCondition(){
 //       wd.quit();
    }
}
