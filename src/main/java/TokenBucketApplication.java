import service.DisplayService;
import service.InitializeTokenBucket;
import java.sql.Timestamp;


public class TokenBucketApplication {
static int counter=0;
    public static void main(String[] args) {
        InitializeTokenBucket initializeTokenBucket=new InitializeTokenBucket();
        Timestamp startTime=new Timestamp(System.currentTimeMillis());
        Runnable task=()-> {
            for (int i = 0; i < 1000; i++) {
                try {
                    counter += DisplayService.display(i);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };

        Thread[] threads=new Thread[10];

        for (int i=0;i<threads.length;i++){
            threads[i]=new Thread(task);
            threads[i].start();
        }

        for (int k=0;k<threads.length;){
          if (!threads[k].isAlive())
              k++;
      }

        Timestamp endTime=new Timestamp(System.currentTimeMillis());
        System.out.println("Total Run Time="+(endTime.getTime()-startTime.getTime()));
        System.out.println("Number of Successfull hit="+counter);

    }
}
