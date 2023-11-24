package service;

import constants.RateLimiterConstant;
import javafx.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    Map<Integer, Pair<Integer,Long>> customerHitMap=new HashMap<>();
    public boolean rateLimit(int customerId){
        if (!customerHitMap.containsKey(customerId)){
            Pair pair=new Pair(RateLimiterConstant.BUCKET_SIZE-1,System.currentTimeMillis()+RateLimiterConstant.TIME_WINDOW);
            customerHitMap.put(customerId,pair);
            return true;
        }else {
            if (customerHitMap.get(customerId).getKey()>0){
                Pair pair=new Pair(customerHitMap.get(customerId).getKey()-1,customerHitMap.get(customerId).getValue());
                customerHitMap.put(customerId,pair);
                return true;
            }else {
                long currentTime=System.currentTimeMillis();
                if (currentTime>customerHitMap.get(customerId).getValue()){
                    Pair pair=new Pair(RateLimiterConstant.BUCKET_SIZE-1,System.currentTimeMillis()+RateLimiterConstant.TIME_WINDOW);
                    customerHitMap.put(customerId,pair);
                    return true;
                }else {
                    return false;
                }
            }
        }

    }
}
