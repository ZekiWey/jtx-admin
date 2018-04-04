package com.jtx.admin.controller;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = Maps.newHashMap();
        map.put("10","桔子");
        map.put("500","苹果");
        map.put("1000","葡萄");

        Map<String,String> map1 = Maps.newHashMap();


      /*  Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            map1.put(map.get(key),key);
        }*/
        for (String s : map.keySet()) {
            map1.put(map.get(s),s);
        }


        System.out.println(map1.get("桔子"));
    }
}
