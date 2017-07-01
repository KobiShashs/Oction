package btinnolab.com.oction.Auctions;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

import btinnolab.com.oction.Utils.QueryUtils;


/**
 * Created by user on 7/1/2017.
 */

public class AuctionLoader extends AsyncTaskLoader<List<Auction>> {
    private static final String LOG_TAG = AuctionLoader.class.getName();
    /** Query URL */
    private String mUrl;
    private boolean mCurrent;

    private List<Auction> auctions = new ArrayList<>() ;
    public AuctionLoader(Context context,String url,boolean current){

        super(context);
        mUrl=url;
        mCurrent=current;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Auction> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Auction> auctions= QueryUtils.fetchAuctionData(mUrl,mCurrent);
        return auctions;
    }

}
