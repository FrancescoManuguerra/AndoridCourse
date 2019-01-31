package com.manuguerra.fasteat;

import android.util.Patterns;

public class Utilities {
    public static int size_password=6;

    //Controlla se l'email è sintatticamente corretta
    public static boolean emailControll(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    //Controlla la lunghezza della password
    public static boolean passwordControll(String password){
        //6 CARATTERI
        return (password.length()>=size_password);
    }
    //Controlla la lunghezza della password e il match con la password di conferma
    public static boolean passwordControll(String password,String confirm_password){
        //6 CARATTERI
        if(password.length()>=size_password && confirm_password.equals(password))return true;
        else return false;
    }
    //Controlla se mantiene la sintassi dei numeri telefonici
    public static boolean numberControll(String number){
        return Patterns.PHONE.matcher(number).matches();
    }
}
