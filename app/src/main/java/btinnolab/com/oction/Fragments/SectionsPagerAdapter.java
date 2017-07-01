package btinnolab.com.oction.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import btinnolab.com.oction.R;

/**
 * Created by user on 6/29/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public static int PAGES_NUMBER = 2;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AuctionCurrentFragment();
            case 1:
                return new AuctionUpcomingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGES_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_auction_current);
            case 1:
                return mContext.getString(R.string.title_auction_upcoming);
        }
        return null;
    }
}
