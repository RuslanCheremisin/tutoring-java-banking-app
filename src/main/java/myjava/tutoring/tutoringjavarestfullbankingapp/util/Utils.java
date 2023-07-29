package myjava.tutoring.tutoringjavarestfullbankingapp.util;

import java.util.Optional;

public class Utils {
    public static boolean optionalIsPresent(Object o){
        Optional<Object> optional = Optional.of(o);
        if (optional.isPresent()){
            return true;
        }else {
            throw new IllegalArgumentException(o.toString()+ " is null!");
        }
    }
}
