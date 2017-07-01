package btinnolab.com.oction.Auctions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import btinnolab.com.oction.Auctions.Auction;
import btinnolab.com.oction.R;
import btinnolab.com.oction.Utils.Utils;

/**
 * Created by user on 7/1/2017.
 */

public class AuctionAdapter extends ArrayAdapter<Auction>{

    public AuctionAdapter(Context context, List<Auction> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.auction_list_item, parent, false);
            holder = new ViewHolder();
            holder.auctionImageView = (ImageView)convertView.findViewById(R.id.imageView);
            holder.auctionTitleTextView = (TextView) convertView.findViewById(R.id.auctionTitle);
            holder.auctionDescriptionTextView = (TextView) convertView.findViewById(R.id.auctionDescription);
            holder.auctionPresentPriceTextView = (TextView)convertView.findViewById(R.id.auctionPrice);
            holder.dateTextView = (TextView) convertView.findViewById(R.id.auctionStartIn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Auction currentAuction = getItem(position);
        Picasso.with(getContext())
                .load(currentAuction.getAuctionProfileImage())
                .placeholder(R.mipmap.ic_launcher_oction)
                .error(R.mipmap.ic_launcher)
                .into(holder.auctionImageView);
        holder.auctionTitleTextView.setText(currentAuction.getAuctionTitle());
        holder.auctionDescriptionTextView.setText(currentAuction.getAuctionDescription());
        holder.auctionPresentPriceTextView.setText(getContext().getString(R.string.str_value_price_and_currency,currentAuction.getAuctionCurrency(),currentAuction.getAuctionPrice()));
       holder.dateTextView.setText(DistanceBetweenDates(currentAuction.getAuctionStartTime(),currentAuction.getAuctionEndTime()));
        // Return the list item view that is now showing the appropriate data
        return convertView;
    }

    static class ViewHolder {
        private ImageView auctionImageView;
        private TextView auctionTitleTextView;
        private TextView auctionDescriptionTextView;
        private TextView auctionPresentPriceTextView;
        private TextView dateTextView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String DistanceBetweenDates(String dateStr1, String dateStr2){
        String result="Not Avialable yet";
        if(dateStr1!=null && dateStr2!=null) {

            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date1 = simpleDateFormat.parse(dateStr1);
                Date date2 = simpleDateFormat.parse(dateStr2);
                long different = date2.getTime() - date1.getTime();
                long secondsInMilli = 1000;
                long minutesInMilli = secondsInMilli * 60;
                long hoursInMilli = minutesInMilli * 60;
                long daysInMilli = hoursInMilli * 24;

                long elapsedDays = different / daysInMilli;
                different = different % daysInMilli;

                long elapsedHours = different / hoursInMilli;
                different = different % hoursInMilli;

                long elapsedMinutes = different / minutesInMilli;
                different = different % minutesInMilli;

                long elapsedSeconds = different / secondsInMilli;

                result = elapsedDays + "d " + elapsedHours + "hr " + elapsedMinutes + "min";
            } catch (ParseException e) {
                e.printStackTrace();

            }
        }
        else
        {
            Utils.print("hey");
        }

        return result;

    }
}
