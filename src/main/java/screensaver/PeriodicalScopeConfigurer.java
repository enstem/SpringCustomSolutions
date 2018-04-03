package screensaver;

import com.sun.jmx.snmp.Timestamp;
import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by дмитро on 03.04.2018.
 */
public class PeriodicalScopeConfigurer implements Scope {

    private Map<String,Pair<Timestamp,Object>>map = new HashMap<String, Pair<Timestamp, Object>>();
    public Object get(String name, ObjectFactory<?> objectFactory) {

        Timestamp timestamp = new Timestamp();
        if(map.containsKey(name)){
            Pair<Timestamp, Object> pair = map.get(name);
            Timestamp objectTimestamp = pair.getKey();
            long diff = timestamp.getDateTime() - objectTimestamp.getDateTime();
            if((diff) > 5000){
                map.put(name, new Pair<Timestamp, Object>(new Timestamp(), objectFactory.getObject()));
            }
        }else{
            map.put(name, new Pair<Timestamp, Object>(new Timestamp(), objectFactory.getObject()));
        }

        return map.get(name).getValue();
    }

    public Object remove(String s) {
        return null;
    }

    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    public Object resolveContextualObject(String s) {
        return null;
    }

    public String getConversationId() {
        return null;
    }
}
