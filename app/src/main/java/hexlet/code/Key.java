package hexlet.code;

import lombok.Data;

@Data
public class Key {

    private final String status;
    private final Object value1;
    private Object value2;

    public Key(String status, Object value1, Object value2) {
        this.status = status;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Key(String status, Object value) {
        this.status = status;
        this.value1 = value;
    }
}
