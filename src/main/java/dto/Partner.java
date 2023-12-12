package dto;

import constants.RateLimiterConstant;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Partner {
    String partnerId;
    Queue<String> partnerQueue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partner partner = (Partner) o;
        return Objects.equals(partnerId, partner.partnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerId);
    }

    long refilTime;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Queue<String> getPartnerQueue() {
        return partnerQueue;
    }

    public void setPartnerQueue(Queue<String> partnerQueue) {
        this.partnerQueue = partnerQueue;
    }

    public long getRefilTime() {
        return refilTime;
    }

    public void setRefilTime(long refilTime) {
        this.refilTime = refilTime;
    }

    public int getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public Partner(String partnerId) {
        this.partnerId = partnerId;
        this.partnerQueue = new LinkedList<>();
        this.refilTime = System.currentTimeMillis()+ RateLimiterConstant.TIME_WINDOW;
        this.tokenCount = RateLimiterConstant.BUCKET_SIZE;
    }

    int tokenCount;
}
