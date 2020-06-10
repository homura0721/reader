package cn.edu.scujcc;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreference  {
    private static MyPreference INSTANCE=null;
    private Context context;
    private SharedPreferences prefs;
    private MyPreference(){}
    public static MyPreference getInstance(){
        if (null==INSTANCE){

        }
        return INSTANCE;
    }
    public void setup(Context ctx){
        this.context=ctx;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String currentUser(){
        return prefs.getString(UserLab.USER_CURRENT,"未登录");
    }
    public String currentToken(){
        return prefs.getString(UserLab.USER_TOKEN,"");
    }


    public void saveUser(String username, String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(UserLab.USER_CURRENT,username );
        editor.putString(UserLab.USER_TOKEN,(String)token);
        editor.apply();
    }
}

