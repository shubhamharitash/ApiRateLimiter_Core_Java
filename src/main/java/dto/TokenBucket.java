package dto;

import java.util.Date;

public class TokenBucket {

    static int bucketSize;
    static int tokenCount;
    static long timeSlotInMillis;
    static Date bucketEndTime;
    public TokenBucket(int bucketSize, int tokenCount, long timeSlotInMillis,  Date bucketEndTime) {
        this.bucketSize = bucketSize;
        this.tokenCount = tokenCount;
        this.timeSlotInMillis = timeSlotInMillis;
        this.bucketEndTime = bucketEndTime;
    }

    public static int getBucketSize() {
        return bucketSize;
    }


    public static int getTokenCount() {
        return tokenCount;
    }

    public static void setTokenCount(int tokenCount1) {
        tokenCount = tokenCount1;
    }

    public static long getTimeSlotInMillis() {
        return timeSlotInMillis;
    }



    public static Date getBucketEndTime() {
        return bucketEndTime;
    }

    public static void setBucketEndTime(Date bucketEndTime1) {
       bucketEndTime = bucketEndTime1;
    }


}
