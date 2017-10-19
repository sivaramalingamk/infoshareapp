package za.ac.cput.fidit.infoshareapp;

import java.util.ArrayList;

/**
 * Created by root on 2017/08/24.
 */

public class CurrentUser extends User{
    //login is used to denote the array list index of the institution and userRole to login by default any negative value

    private static byte login=-1;


    CurrentUser(String email, ArrayList<String> institutions, ArrayList<String> userRoles) {
        super(email, institutions, userRoles);
    }

    void login(byte index){
        login=index;//set the login index of the institution and userRole
    }



}
