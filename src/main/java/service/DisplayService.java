package service;

import java.util.Date;

public class DisplayService {
    public static int display( int i){
        TokenBucketService tokenBucketService=TokenBucketService.getInstance();
        if (!tokenBucketService.getToken())
            throw new RuntimeException("Error 429 , Too many Request for="+ i);

        System.out.println("Hello Shubham"+Thread.currentThread().getName());
        return 1;
    }
}
