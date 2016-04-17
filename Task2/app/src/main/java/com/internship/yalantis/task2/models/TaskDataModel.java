package com.internship.yalantis.task2.models;

import com.google.gson.annotations.SerializedName;

public class TaskDataModel {
    @SerializedName("title")
    private String mTitle;
    @SerializedName("image")
    private String mImage;
    @SerializedName("like_count")
    private String mLikeCount;
    @SerializedName("content")
    private String mContent;
    @SerializedName("date")
    private String mDate;
    @SerializedName("time")
    private String mTime;

    /**
     *
     * @return
     * The mTitle
     */
    public String getmTitle() {
        return mTitle;
    }

    /**
     *
     * @param mTitle
     * The mTitle
     */
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    /**
     *
     * @return
     * The mImage
     */
    public String getmImage() {
        return mImage;
    }

    /**
     *
     * @param mImage
     * The mImage
     */
    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    /**
     *
     * @return
     * The mLikeCount
     */
    public String getmLikeCount() {
        return mLikeCount;
    }

    /**
     *
     * @param mLikeCount
     * The like_count
     */
    public void setmLikeCount(String mLikeCount) {
        this.mLikeCount = mLikeCount;
    }

    /**
     *
     * @return
     * The mContent
     */
    public String getmContent() {
        return mContent;
    }

    /**
     *
     * @param mContent
     * The mContent
     */
    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    /**
     *
     * @return
     * The mDate
     */
    public String getmDate() {
        return mDate;
    }

    /**
     *
     * @param mDate
     * The mDate
     */
    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    /**
     *
     * @return
     * The mTime
     */
    public String getmTime() {
        return mTime;
    }

    /**
     *
     * @param mTime
     * The mTime
     */
    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
