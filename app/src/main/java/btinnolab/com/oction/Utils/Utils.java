package btinnolab.com.oction.Utils;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import btinnolab.com.oction.R;

/**
 * Created by user on 6/30/2017.
 */

public class Utils {
    private static final String TAG  = "OCTION_APP";
    public static final String REQUEST_URL = "https://dev-us-02.oction.co/api/v1/auctions";
    public static void initActionBar(Activity activity, ActionBar actionBar, String title, boolean homeEnabled) {
        View viewActionBar = activity.getLayoutInflater().inflate(R.layout.custom_actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setText(title);
        actionBar.setCustomView(viewActionBar, params);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(homeEnabled);
        actionBar.setDisplayShowHomeEnabled(homeEnabled);
        actionBar.setHomeButtonEnabled(homeEnabled);
    }
    public static void print(String message){
        Log.d(TAG,message);
    }
}
