package btinnolab.com.oction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private FragmentManager fragmentManager;
    //TODO remove this line
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_auction:
                    replaceFragment(new AuctionFragment());
                    //TODO remove this line
                    //mTextMessage.setText(R.string.title_auction);
                    return true;
                case R.id.navigation_credits:
                    replaceFragment(new CreditsFragment());
                    //TODO remove this line
                    //mTextMessage.setText(R.string.title_credits);
                    return true;
                case R.id.navigation_account:
                    replaceFragment(new AccountFragment());
                    //TODO remove this line
                    //mTextMessage.setText(R.string.title_account);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    //This method for replacing current view within the new fragment
    public void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,fragment,fragment.getTag()).addToBackStack(null).commit();

    }

}
