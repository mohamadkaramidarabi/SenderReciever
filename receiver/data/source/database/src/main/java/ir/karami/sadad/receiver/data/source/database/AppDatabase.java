package ir.karami.sadad.receiver.data.source.database;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RenameColumn;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Info.class}, version = 3,
        autoMigrations = {
                @AutoMigration(from = 1, to = 2, spec = AppDatabase.CachedValueColumnNameMigration.class)
        }
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract InfoDao getInfoDao();

    @RenameColumn(fromColumnName = "string", toColumnName = "cached_value", tableName = "info")
    static class CachedValueColumnNameMigration implements AutoMigrationSpec {
    }

    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE info ADD COLUMN is_sent INTEGER NOT NULL DEFAULT 0");
        }
    };
}