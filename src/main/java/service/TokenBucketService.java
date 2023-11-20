package service;

import dto.TokenBucket;
import java.util.Date;

public class TokenBucketService {

    public static final TokenBucketService tokenBucketService=new TokenBucketService();
    private boolean refil(){
        Date currentTime=new Date(System.currentTimeMillis());
       // System.out.println("RefilTime="+currentTime);
        if (currentTime.getTime()>TokenBucket.getBucketEndTime().getTime()){
            TokenBucket.setTokenCount(TokenBucket.getBucketSize());
            TokenBucket.setBucketEndTime(new Date(currentTime.getTime()+TokenBucket.getTimeSlotInMillis()));
            return true;
        }else
            return false;
    }
    public boolean getToken(){
        if (TokenBucket.getTokenCount()>0) {
            TokenBucket.setTokenCount(TokenBucket.getTokenCount()-1);
            return true;
        }
        else {
           if (!refil())
               return false;
           else
               return true;
        }
    }

    private TokenBucketService() {
    }

    public static TokenBucketService getInstance(){
        return tokenBucketService;
    }
}
