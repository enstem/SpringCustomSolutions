package quoters;

import quoters.customanotations.DeprecatedClass;
import quoters.customanotations.InjectRandomInt;
import quoters.customanotations.PostProxy;
import quoters.customanotations.Profiling;

import javax.annotation.PostConstruct;

/**
 * Created by дмитро on 02.04.2018.
 */
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter{
    private String message;
    @InjectRandomInt(min=2,max=5)
    private int repeat;

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @PostConstruct
    public void init(){
        System.out.println("phase2");
        System.out.println(repeat);
    }
    public TerminatorQuoter() {
        System.out.println("phase1");

    }



    public void setMessage(String message) {
        this.message = message;
    }
@PostProxy
    public void sayQuote() {
    System.out.println("phase3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = "+message);
        }


    }


}
