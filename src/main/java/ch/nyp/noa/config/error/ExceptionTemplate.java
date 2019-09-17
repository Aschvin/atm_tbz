package ch.nyp.noa.config.error;

import ch.nyp.noa.config.DateTimeUtil;
import ch.nyp.noa.config.UUIDGenerator;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

/**
 * @author Severin Weigold
 */
public class ExceptionTemplate extends LinkedHashMap<String, Object> {

    public ExceptionTemplate() {
        put("timestamp", DateTimeUtil.format(LocalDateTime.now()));
        put("uuid", UUIDGenerator.generateUUID());
    }

    @Override
    public Object put(String key, Object value) {
        if(!this.containsKey(key)) {
            return super.put(key, value);
        } else {
            return null;
        }
    }

    @Override
    public boolean replace(String key, Object oldValue, Object newValue) {
        if(!this.containsKey(key)) {
            return super.replace(key, oldValue, newValue);
        } else {
            return false;
        }
    }

    @Override
    public Object replace(String key, Object value) {
        if(!this.containsKey(key)) {
            return super.replace(key, value);
        } else {
            return null;
        }
    }
}
