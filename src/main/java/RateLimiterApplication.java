import service.RateLimiterService;

import java.sql.Timestamp;


public class RateLimiterApplication {
static int counter=0;
    public static void main(String[] args) {
        RateLimiterService rateLimiterService=new RateLimiterService();

        for (int i=0;i<10;i++) {
            System.out.println(rateLimiterService.rateLimit(
                    1)+"customerId=1");
            System.out.println(rateLimiterService.rateLimit(2)+"customerId=2");
            System.out.println(rateLimiterService.rateLimit(3)+"customerId=3");
            System.out.println(rateLimiterService.rateLimit(4)+"customerId=4");
            System.out.println(rateLimiterService.rateLimit(5)+"customerId=5");
        }

    }
}
