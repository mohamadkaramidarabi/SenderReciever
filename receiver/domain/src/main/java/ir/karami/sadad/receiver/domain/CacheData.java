package ir.karami.sadad.receiver.domain;

public class CacheData {
    public CacheData(String value) {
        this(value, false, 0);
    }

    public CacheData(String value, boolean isSent, int id) {
        this.value = value;
        this.isSent = isSent;
        this.id = id;
    }

    public int id;
    public String value;
    public boolean isSent;

    public void setSent(boolean sent) {
        isSent = sent;
    }
    public boolean getSent() {
        return isSent;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
