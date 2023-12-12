package service;
import constants.RateLimiterConstant;
import dto.Partner;
import javafx.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    Map<String, Partner> partnerHitMap=new HashMap<>();
    public void rateLimit(String partnerId){

        if (!partnerHitMap.containsKey(partnerId)){
            Partner partner=new Partner(partnerId);
            partner.getPartnerQueue().add("Hello Shubham from "+partner.getPartnerId());
            partnerHitMap.put(partner.getPartnerId(), partner);
            pollQueue(partner.getPartnerId());
        }else {
            Partner partner=partnerHitMap.get(partnerId);
            if(partner.getTokenCount()>0){
                partner.getPartnerQueue().add("Hello Shubham from " + partner.getPartnerId());
                partnerHitMap.put(partner.getPartnerId(), partner);
                pollQueue(partner.getPartnerId());
            }else {
                long currentTime = System.currentTimeMillis();
                if (currentTime > partner.getRefilTime()) {
                    partner.setTokenCount(RateLimiterConstant.BUCKET_SIZE);
                    partner.setRefilTime(currentTime + RateLimiterConstant.TIME_WINDOW);
                    pollQueue(partner.getPartnerId());
                } else {//limit exceeded
                    System.out.println("Limit Exceeded Slowing queue for "+partner.getPartnerId());
                }
                partner.getPartnerQueue().add("Hello Shubham from " + partner.getPartnerId());
                partnerHitMap.put(partner.getPartnerId(), partner);
            }
        }

    }

    public  void pollQueue(String partnerId){
        Partner partner=partnerHitMap.get(partnerId);
        while (!partner.getPartnerQueue().isEmpty() && partner.getTokenCount()>0) {
            partner.setTokenCount(partner.getTokenCount()-1);
            System.out.println(partner.getPartnerQueue().poll()+" Size= "+partner.getPartnerQueue().size());
        }
        partnerHitMap.put(partnerId,partner);
    }
}
