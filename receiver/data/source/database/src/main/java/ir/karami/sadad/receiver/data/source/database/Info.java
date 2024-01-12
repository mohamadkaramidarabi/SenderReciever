package ir.karami.sadad.receiver.data.source.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "info")
public class Info {

    public Info() {
        this(null,false);
    }
    @Ignore
    public Info(String cachedValue) {
        this(cachedValue,false);
    }
    @Ignore
    public Info(String cachedValue, boolean isSent) {
        this.cachedValue = cachedValue;
        this.isSent = isSent;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "cached_value")
    public String cachedValue;

    @ColumnInfo(name = "is_sent",defaultValue = "0")
    public boolean isSent;
}
