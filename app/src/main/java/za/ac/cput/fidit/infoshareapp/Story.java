package za.ac.cput.fidit.infoshareapp;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by root on 2017/08/24.
 */

public class Story {
    String institution;
    Date date;
    Time time;
    String text;
    ArrayList<User> likes;
    ArrayList<User> dlikes;
    ArrayList<Comment> comments;

    Story(String institution, Date date, Time time, String text){
        this.institution=institution;
        this.date=date ;
        this.time=time;
        this.text=text;
    }

    void addLike(User usr){
        likes.add(usr);
    }

    void addDlikes(User usr){
        dlikes.add(usr);
    }

    void addComment(Comment cmnt){
        comments.add(cmnt);
    }


}
