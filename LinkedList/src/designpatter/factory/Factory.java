package designpatter.factory;

import java.util.Iterator;

public class Factory {
   public static Employee getEmployee(String type){
       if(type.equalsIgnoreCase("web developer")){
          return  new WebDeveloper();
       } else if (type.equalsIgnoreCase("java developer")) {
           return new JavaDeveloper();
       }else if(type.equalsIgnoreCase("Ui Developer")){
           return null;
       }else {
           return null;
       }
   }
}