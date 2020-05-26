package li.dongpo.tc.service;

public class SampleLogger {
    public void after(){
        System.out.println(this.getClass().getCanonicalName());
        System.out.println("aspect after");
    }
}
