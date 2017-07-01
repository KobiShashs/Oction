package btinnolab.com.oction.Auctions;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.SoftReference;

/**
 * Created by user on 6/30/2017.
 */

public class Auction {
    @SerializedName("user_name")
    private String auctionUserName;

    @SerializedName("name")
    private String auctionName;

    @SerializedName("profileImage")
    private String auctionProfileImage;

    @SerializedName("userId")
    private long auctionUserID;

    @SerializedName("title")
    private String auctionTitle;

    @SerializedName("description")
    private String auctionDescription;

    @SerializedName("productPrice")
    private double auctionProductPrice;

    @SerializedName("product_id")
    private long auctionProductID;

    @SerializedName("productCurrency")
    private String auctionProductCurrency;

    @SerializedName("auctionId")
    private long auctionID;

    @SerializedName("startingPrice")
    private long auctionStartingPrice;

    @SerializedName("currency")
    private String auctionCurrency;

    @SerializedName("price")
    private double auctionPrice;

    @SerializedName("unique_id")
    private String auctionUniqueID;

    @SerializedName("start_time")
    private String auctionStartTime;

    @SerializedName("start_time_unix")
    private long auctionStartTimeUnix;

    @SerializedName("end_time")
    private String auctionEndTime;

    @SerializedName("end_time_unix")
    private long auctionEndTimeUnix;

    @SerializedName("minimumPrice")
    private double auctionMinimumPrice;

    @SerializedName("bidCount")
    private int auctionBidCount;

    @SerializedName("auctionsHeldCount")
    private int auctionAuctionsHeldCount;

    @SerializedName("bidderCount")
    private int auctionBidderCount;

    @SerializedName("id")
    private long mediaID;

    @SerializedName("media")
    private String mediaMedia;

    @SerializedName("title")
    private String mediaTitle;

    @SerializedName("product_id")
    private long mediaProductID;

    // CTOR
    public Auction(Auction auction){
        setAuctionUserName(auction.getAuctionUserName());
        setAuctionName(auction.getAuctionName());
        setAuctionProfileImage(auction.getAuctionProfileImage());
        setAuctionUserID(auction.getAuctionUserID());
        setAuctionTitle(auction.getAuctionTitle());
        setAuctionDescription(auction.getAuctionDescription());
        setAuctionProductPrice(auction.getAuctionProductPrice());
        setAuctionProductID(auction.getAuctionProductID());
        setAuctionProductCurrency(auction.getAuctionProductCurrency());
        setAuctionID(auction.getAuctionID());
        setAuctionStartingPrice(auction.getAuctionStartingPrice());
        setAuctionCurrency(auction.getAuctionCurrency());
        setAuctionPrice(auction.getAuctionPrice());
        setAuctionUniqueID(auction.getAuctionUniqueID());
        setAuctionStartTime(auction.getAuctionStartTime());
        setAuctionStartTimeUnix(auction.getAuctionStartTimeUnix());
        setAuctionEndTime(auction.getAuctionEndTime());
        setAuctionEndTimeUnix(auction.getAuctionEndTimeUnix());
        setAuctionMinimumPrice(auction.getAuctionMinimumPrice());
        setAuctionBidCount(auction.getAuctionBidCount());
        setAuctionAuctionsHeldCount(auction.getAuctionAuctionsHeldCount());
        setAuctionBidderCount(auction.getAuctionBidderCount());
        setMediaID(auction.getMediaID());
        setMediaMedia(auction.getMediaMedia());
        setMediaTitle(auction.getMediaTitle());
        setMediaProductID(auction.getMediaProductID());
    }
    // CTOR parsing within json
    public Auction(JSONObject auction){
       try {
           JSONObject AuctionCurrentObj = auction.getJSONObject("auction");
           JSONArray MediaCurrentObj = auction.getJSONArray("media");
           JSONObject MediaCurrentObjInternal = MediaCurrentObj.getJSONObject(0);
           setAuctionUserName(AuctionCurrentObj.optString("user_name"));
           setAuctionName(AuctionCurrentObj.optString("name"));
           setAuctionProfileImage(AuctionCurrentObj.optString("profileImage"));
           setAuctionUserID(AuctionCurrentObj.optLong("userId"));
           setAuctionTitle(AuctionCurrentObj.optString("title"));
           setAuctionDescription(AuctionCurrentObj.optString("description"));
           setAuctionProductPrice(AuctionCurrentObj.optDouble("productPrice"));
           setAuctionProductID(AuctionCurrentObj.optLong("product_id"));
           setAuctionProductCurrency(AuctionCurrentObj.optString("productCurrency"));
           setAuctionID(AuctionCurrentObj.optLong("auctionId"));
           setAuctionStartingPrice(AuctionCurrentObj.optLong("startingPrice"));
           setAuctionCurrency(AuctionCurrentObj.optString("currency"));
           setAuctionPrice(AuctionCurrentObj.optDouble("price"));
           setAuctionUniqueID(AuctionCurrentObj.optString("unique_id"));
           setAuctionStartTime(AuctionCurrentObj.optString("start_time"));
           setAuctionStartTimeUnix(AuctionCurrentObj.optLong("start_time_unix"));
           setAuctionEndTime(AuctionCurrentObj.optString("end_time"));
           setAuctionEndTimeUnix(AuctionCurrentObj.optLong("end_time_unix"));
           setAuctionMinimumPrice(AuctionCurrentObj.optDouble("minimumPrice"));
           setAuctionBidCount(AuctionCurrentObj.optInt("bidCount"));
           setAuctionAuctionsHeldCount(AuctionCurrentObj.optInt("auctionsHeldCount"));
           setAuctionBidderCount(AuctionCurrentObj.optInt("bidderCount"));
           setMediaID(MediaCurrentObjInternal.optLong("id"));
           setMediaMedia(MediaCurrentObjInternal.optString("name"));
           setMediaTitle(MediaCurrentObjInternal.optString("title"));
           setMediaProductID(MediaCurrentObjInternal.optLong("product_id"));
       }
       catch (JSONException e){
           e.printStackTrace();
       }
    }
    public String getAuctionUserName() {
        return auctionUserName;
    }

    public void setAuctionUserName(String auctionUserName) {
        this.auctionUserName = auctionUserName;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public String getAuctionProfileImage() {
        return auctionProfileImage;
    }

    public void setAuctionProfileImage(String auctionProfileImage) {
        this.auctionProfileImage = auctionProfileImage;
    }

    public long getAuctionUserID() {
        return auctionUserID;
    }

    public void setAuctionUserID(long auctionUserID) {
        this.auctionUserID = auctionUserID;
    }

    public String getAuctionTitle() {
        return auctionTitle;
    }

    public void setAuctionTitle(String auctionTitle) {
        this.auctionTitle = auctionTitle;
    }

    public String getAuctionDescription() {
        return auctionDescription;
    }

    public void setAuctionDescription(String auctionDescription) {
        this.auctionDescription = auctionDescription;
    }

    public double getAuctionProductPrice() {
        return auctionProductPrice;
    }

    public void setAuctionProductPrice(double auctionProductPrice) {
        this.auctionProductPrice = auctionProductPrice;
    }

    public long getAuctionProductID() {
        return auctionProductID;
    }

    public void setAuctionProductID(long auctionProductID) {
        this.auctionProductID = auctionProductID;
    }

    public String getAuctionProductCurrency() {
        return auctionProductCurrency;
    }

    public void setAuctionProductCurrency(String auctionProductCurrency) {
        this.auctionProductCurrency = auctionProductCurrency;
    }

    public long getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(long auctionID) {
        this.auctionID = auctionID;
    }

    public long getAuctionStartingPrice() {
        return auctionStartingPrice;
    }

    public void setAuctionStartingPrice(long auctionStartingPrice) {
        this.auctionStartingPrice = auctionStartingPrice;
    }

    public String getAuctionCurrency() {
        return auctionCurrency;
    }

    public void setAuctionCurrency(String auctionCurrency) {
        this.auctionCurrency = auctionCurrency;
    }

    public double getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(double auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getAuctionUniqueID() {
        return auctionUniqueID;
    }

    public void setAuctionUniqueID(String auctionUniqueID) {
        this.auctionUniqueID = auctionUniqueID;
    }

    public String getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(String auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public long getAuctionStartTimeUnix() {
        return auctionStartTimeUnix;
    }

    public void setAuctionStartTimeUnix(long auctionStartTimeUnix) {
        this.auctionStartTimeUnix = auctionStartTimeUnix;
    }

    public String getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(String auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public long getAuctionEndTimeUnix() {
        return auctionEndTimeUnix;
    }

    public void setAuctionEndTimeUnix(long auctionEndTimeUnix) {
        this.auctionEndTimeUnix = auctionEndTimeUnix;
    }

    public double getAuctionMinimumPrice() {
        return auctionMinimumPrice;
    }

    public void setAuctionMinimumPrice(double auctionMinimumPrice) {
        this.auctionMinimumPrice = auctionMinimumPrice;
    }

    public int getAuctionBidCount() {
        return auctionBidCount;
    }

    public void setAuctionBidCount(int auctionBidCount) {
        this.auctionBidCount = auctionBidCount;
    }

    public int getAuctionAuctionsHeldCount() {
        return auctionAuctionsHeldCount;
    }

    public void setAuctionAuctionsHeldCount(int auctionAuctionsHeldCount) {
        this.auctionAuctionsHeldCount = auctionAuctionsHeldCount;
    }

    public int getAuctionBidderCount() {
        return auctionBidderCount;
    }

    public void setAuctionBidderCount(int auctionBidderCount) {
        this.auctionBidderCount = auctionBidderCount;
    }

    public long getMediaID() {
        return mediaID;
    }

    public void setMediaID(long mediaID) {
        this.mediaID = mediaID;
    }

    public String getMediaMedia() {
        return mediaMedia;
    }

    public void setMediaMedia(String mediaMedia) {
        this.mediaMedia = mediaMedia;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public long getMediaProductID() {
        return mediaProductID;
    }

    public void setMediaProductID(long mediaProductID) {
        this.mediaProductID = mediaProductID;
    }










}
