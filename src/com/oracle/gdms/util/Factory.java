package com.oracle.gdms.util;

import java.util.ResourceBundle;

public class Factory {

    private Factory(){}
    private static final Factory fac = null;
    public static Factory getInstance(){
        return fac == null ? new Factory() : fac ;

    }

    public Object getObj(String key){
        ResourceBundle b = ResourceBundle.getBundle("config/obj");
        String classname = b.getString(key);
        Object o = null;
        try{
            o = Class.forName(classname).newInstance();
            }catch (Exception e){
            e.printStackTrace();
        }

        return o;
    }
}
