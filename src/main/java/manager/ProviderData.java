package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProviderData {

@DataProvider
    public Iterator <Object[]> loginModelDto(){
    List<Object[]> list = new ArrayList<>();//sozdali kollekziy
    list.add(new Object[]{
            User.builder().email("vasiatal@gmail.com").password("Vasia$1234").build()});
    list.add(new Object[]{
            User.builder().email("vasiatal@gmail.com").password("Vasia$1234").build()});
    list.add(new Object[]{
            User.builder().email("vasiatal@gmail.com").password("Vasia$1234").build()});
//    list.add(new Object[]{"vasiatal@gmail.com","Vasia$1234"});
//    list.add(new Object[]{"vasiatal@gmail.com","Vasia$1234"});


    return list.iterator();

}
}
