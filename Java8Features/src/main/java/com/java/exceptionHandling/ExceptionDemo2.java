package com.java.exceptionHandling;

public class ExceptionDemo2 {

    static int anyMethod()
    {
        try
        {
            return 10;
        }
        catch (Exception e) 
        {
            return 20;
        }
        finally
        {
            return 30;
        }
    }
     
    public static void main(String[] args) 
    {   
        System.out.println(anyMethod());
    }
}