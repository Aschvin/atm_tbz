package ch.nyp.noa.config.error;

public class ViolatedField {

    private String field;
    private Object value;

    public ViolatedField(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getValue() {
        return value != null ? value : "null";
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
