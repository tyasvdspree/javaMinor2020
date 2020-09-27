package assignments.javaminor;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringModBean {

    public String reverse(String inputString){
        return new StringBuilder(inputString).reverse().toString();
    }

    public Integer count(String inputString){
        Pattern p = Pattern.compile("\\b\\S+\\b");
        Matcher m = p.matcher(inputString);
        if(m.find()){
            return m.groupCount();
        }
        return 0;
    }
}
