import dto.Partner;
import service.RateLimiterService;

public class RateLimiterApplication {
    public static void main(String[] args) {
        RateLimiterService rateLimiterService=new RateLimiterService();

        for (int i=0;i<100;i++) {
            rateLimiterService.rateLimit("Amazon");
            rateLimiterService.rateLimit("Netflix");
            rateLimiterService.rateLimit("Hotstar");
            rateLimiterService.rateLimit("microsoft");
            rateLimiterService.rateLimit("figma");
        }

    }
}
