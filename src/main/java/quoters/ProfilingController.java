package quoters;

/**
 * Created by дмитро on 03.04.2018.
 */
public class ProfilingController implements ProfilingControllerMBean{
    private boolean enabled=true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
