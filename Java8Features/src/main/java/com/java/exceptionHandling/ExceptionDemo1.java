package com.java.exceptionHandling;

public class ExceptionDemo1 {

    public static void main(String[] args) 
    {   
        try
        {
            int[] a = {1, 2, 3, 4};
             
            int i = a[4];
        }
        catch (NumberFormatException e) 
        {
            System.out.println(1);
        }
        catch (NullPointerException e) 
        {
            System.out.println(2);
        }
        catch (ArrayIndexOutOfBoundsException e) 
        {
            System.out.println(3);
        }
    }
}