package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    @DataProvider//po files.csv
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();//sozdali kollekziy

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));

        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{User.builder().email(split[0]).password(split[1]).build()});
            line = reader.readLine();

        }

        return list.iterator();
    }
}
