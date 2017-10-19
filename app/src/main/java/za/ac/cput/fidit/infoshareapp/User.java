package za.ac.cput.fidit.infoshareapp;

import java.util.ArrayList;

/**
 * Created by root on 2017/08/24.
 */

public class User {
    String email;
    ArrayList<String> institutions;
    ArrayList<String> userRoles;
    ArrayList<Story> stories;
    int index=0;

    User(String email,ArrayList<String> institutions,ArrayList<String> userRoles)
    {
        this.email=email;
        this.institutions=institutions;
        this.userRoles=userRoles;
    }

    public void setStory(Story story){
        stories.add(index++,story);

    }

    public Story getStory(int index){
        return stories.get(index);

    }

}
