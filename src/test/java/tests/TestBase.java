package tests;

import manager.ApplicationManager;
import manager.NGListener;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
@Listeners(NGListener.class)

public class TestBase {
//    WebDriver wd;
    public static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME)//прописали как дефолтный
);
//    @BeforeMethod ..перед всеми тоько в классе. определленные
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite (alwaysRun = true)//перед всеми тестами
    public void setUp(){

        app.init();
    }
    //    public void preCondition(){
    //     wd=new ChromeDriver();
    // wd.navigate().to("https://telranedu.web.app/home");
    //  wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   // }
 //  @AfterMethod
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        //       wd.quit();
        app.stop();
    }
    @BeforeMethod(alwaysRun = true)
    public void started(Method method){
        logger.info("### Start test"+ method.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void finished(){
        logger.info("### Finished###");
    }

 /* per   public void logout(){
        click(By.xpath("//button[.='Sign Out']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }
 //per   public boolean isElementPresent(By locator){
        return (wd.findElements(locator).size() > 0);
    }*/

 /*per   public void openLoginRegistration() {
   //     wd.findElement(By.xpath("//a[@href='/login']")).click();
         click(By.xpath("//a[@href='/login']"));
    }
    public void fillLoginRegistrationForm(String email,String password){
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }
    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }
    public void submitLogin(){
        click(By.xpath("//button[1]"));
    }
    //per public void click(By locator){
   //     wd.findElement(locator).click();
   // }
 /* per   public void type(By locator, String text){
        if(text !=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }*/

}
