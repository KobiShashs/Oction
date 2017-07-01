package btinnolab.com.oction.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import btinnolab.com.oction.Fragments.AccountFragment;
import btinnolab.com.oction.Fragments.AuctionFragment;
import btinnolab.com.oction.Fragments.CreditsFragment;
import btinnolab.com.oction.R;
import btinnolab.com.oction.Utils.Utils;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_auction:
                    replaceFragment(new AuctionFragment());
                    return true;
                case R.id.navigation_credits:
                    replaceFragment(new CreditsFragment());
                    return true;
                case R.id.navigation_account:
                    replaceFragment(new AccountFragment());
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Custom Action Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Utils.initActionBar(MainActivity.this,getSupportActionBar(),getString(R.string.title_main_activity),false);

        replaceFragment(new AuctionFragment());


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    // This method for replacing current view within the new fragment
    public void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFrame,fragment,fragment.getTag()).addToBackStack(null).commit();

    }

}
