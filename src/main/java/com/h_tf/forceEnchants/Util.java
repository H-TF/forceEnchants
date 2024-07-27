package com.h_tf.forceEnchants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String stringReplace(String replace , String content) {
        String regEx="["+content+"\",lvl:[0-9]s]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(replace);
        return matcher.replaceAll("").trim();
    }
}
