package com.lxcommissioning.app.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile ChantierDao _chantierDao;

  private volatile PointageDao _pointageDao;

  private volatile PhotoDao _photoDao;

  private volatile NoteDao _noteDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `pin` TEXT, `certifications` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Chantier` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `client` TEXT NOT NULL, `description` TEXT NOT NULL, `status` TEXT NOT NULL, `budgetHours` REAL NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `requiredCertifications` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `GeofenceZone` (`id` TEXT NOT NULL, `siteId` TEXT NOT NULL, `name` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `radius` REAL NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Pointage` (`id` TEXT NOT NULL, `siteId` TEXT NOT NULL, `startTime` INTEGER NOT NULL, `endTime` INTEGER, `durationMinutes` INTEGER NOT NULL, `syncStatus` TEXT NOT NULL, `isManual` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Photo` (`id` TEXT NOT NULL, `siteId` TEXT NOT NULL, `uri` TEXT NOT NULL, `remoteUrl` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `timestamp` INTEGER NOT NULL, `note` TEXT, `syncStatus` TEXT NOT NULL, `originalRetentionUntil` INTEGER, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Note` (`id` TEXT NOT NULL, `siteId` TEXT NOT NULL, `content` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `author` TEXT NOT NULL, `syncStatus` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '74f11e671fc37ed98f9099dee830eaf3')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `User`");
        db.execSQL("DROP TABLE IF EXISTS `Chantier`");
        db.execSQL("DROP TABLE IF EXISTS `GeofenceZone`");
        db.execSQL("DROP TABLE IF EXISTS `Pointage`");
        db.execSQL("DROP TABLE IF EXISTS `Photo`");
        db.execSQL("DROP TABLE IF EXISTS `Note`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(5);
        _columnsUser.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("pin", new TableInfo.Column("pin", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("certifications", new TableInfo.Column("certifications", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(db, "User");
        if (!_infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.lxcommissioning.app.data.models.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsChantier = new HashMap<String, TableInfo.Column>(10);
        _columnsChantier.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("client", new TableInfo.Column("client", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("budgetHours", new TableInfo.Column("budgetHours", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChantier.put("requiredCertifications", new TableInfo.Column("requiredCertifications", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChantier = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChantier = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChantier = new TableInfo("Chantier", _columnsChantier, _foreignKeysChantier, _indicesChantier);
        final TableInfo _existingChantier = TableInfo.read(db, "Chantier");
        if (!_infoChantier.equals(_existingChantier)) {
          return new RoomOpenHelper.ValidationResult(false, "Chantier(com.lxcommissioning.app.data.models.Chantier).\n"
                  + " Expected:\n" + _infoChantier + "\n"
                  + " Found:\n" + _existingChantier);
        }
        final HashMap<String, TableInfo.Column> _columnsGeofenceZone = new HashMap<String, TableInfo.Column>(7);
        _columnsGeofenceZone.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeofenceZone.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeofenceZone.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeofenceZone.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeofenceZone.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeofenceZone.put("radius", new TableInfo.Column("radius", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGeofenceZone.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeofenceZone = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGeofenceZone = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeofenceZone = new TableInfo("GeofenceZone", _columnsGeofenceZone, _foreignKeysGeofenceZone, _indicesGeofenceZone);
        final TableInfo _existingGeofenceZone = TableInfo.read(db, "GeofenceZone");
        if (!_infoGeofenceZone.equals(_existingGeofenceZone)) {
          return new RoomOpenHelper.ValidationResult(false, "GeofenceZone(com.lxcommissioning.app.data.models.GeofenceZone).\n"
                  + " Expected:\n" + _infoGeofenceZone + "\n"
                  + " Found:\n" + _existingGeofenceZone);
        }
        final HashMap<String, TableInfo.Column> _columnsPointage = new HashMap<String, TableInfo.Column>(7);
        _columnsPointage.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPointage.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPointage.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPointage.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPointage.put("durationMinutes", new TableInfo.Column("durationMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPointage.put("syncStatus", new TableInfo.Column("syncStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPointage.put("isManual", new TableInfo.Column("isManual", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPointage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPointage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPointage = new TableInfo("Pointage", _columnsPointage, _foreignKeysPointage, _indicesPointage);
        final TableInfo _existingPointage = TableInfo.read(db, "Pointage");
        if (!_infoPointage.equals(_existingPointage)) {
          return new RoomOpenHelper.ValidationResult(false, "Pointage(com.lxcommissioning.app.data.models.Pointage).\n"
                  + " Expected:\n" + _infoPointage + "\n"
                  + " Found:\n" + _existingPointage);
        }
        final HashMap<String, TableInfo.Column> _columnsPhoto = new HashMap<String, TableInfo.Column>(10);
        _columnsPhoto.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("uri", new TableInfo.Column("uri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("remoteUrl", new TableInfo.Column("remoteUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("syncStatus", new TableInfo.Column("syncStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("originalRetentionUntil", new TableInfo.Column("originalRetentionUntil", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPhoto = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPhoto = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPhoto = new TableInfo("Photo", _columnsPhoto, _foreignKeysPhoto, _indicesPhoto);
        final TableInfo _existingPhoto = TableInfo.read(db, "Photo");
        if (!_infoPhoto.equals(_existingPhoto)) {
          return new RoomOpenHelper.ValidationResult(false, "Photo(com.lxcommissioning.app.data.models.Photo).\n"
                  + " Expected:\n" + _infoPhoto + "\n"
                  + " Found:\n" + _existingPhoto);
        }
        final HashMap<String, TableInfo.Column> _columnsNote = new HashMap<String, TableInfo.Column>(6);
        _columnsNote.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("syncStatus", new TableInfo.Column("syncStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNote = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNote = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNote = new TableInfo("Note", _columnsNote, _foreignKeysNote, _indicesNote);
        final TableInfo _existingNote = TableInfo.read(db, "Note");
        if (!_infoNote.equals(_existingNote)) {
          return new RoomOpenHelper.ValidationResult(false, "Note(com.lxcommissioning.app.data.models.Note).\n"
                  + " Expected:\n" + _infoNote + "\n"
                  + " Found:\n" + _existingNote);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "74f11e671fc37ed98f9099dee830eaf3", "2767290c1f4a69416323252636290b15");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User","Chantier","GeofenceZone","Pointage","Photo","Note");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `Chantier`");
      _db.execSQL("DELETE FROM `GeofenceZone`");
      _db.execSQL("DELETE FROM `Pointage`");
      _db.execSQL("DELETE FROM `Photo`");
      _db.execSQL("DELETE FROM `Note`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChantierDao.class, ChantierDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PointageDao.class, PointageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PhotoDao.class, PhotoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NoteDao.class, NoteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ChantierDao chantierDao() {
    if (_chantierDao != null) {
      return _chantierDao;
    } else {
      synchronized(this) {
        if(_chantierDao == null) {
          _chantierDao = new ChantierDao_Impl(this);
        }
        return _chantierDao;
      }
    }
  }

  @Override
  public PointageDao pointageDao() {
    if (_pointageDao != null) {
      return _pointageDao;
    } else {
      synchronized(this) {
        if(_pointageDao == null) {
          _pointageDao = new PointageDao_Impl(this);
        }
        return _pointageDao;
      }
    }
  }

  @Override
  public PhotoDao photoDao() {
    if (_photoDao != null) {
      return _photoDao;
    } else {
      synchronized(this) {
        if(_photoDao == null) {
          _photoDao = new PhotoDao_Impl(this);
        }
        return _photoDao;
      }
    }
  }

  @Override
  public NoteDao noteDao() {
    if (_noteDao != null) {
      return _noteDao;
    } else {
      synchronized(this) {
        if(_noteDao == null) {
          _noteDao = new NoteDao_Impl(this);
        }
        return _noteDao;
      }
    }
  }
}
