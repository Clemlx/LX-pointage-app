package com.lxcommissioning.app.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.lxcommissioning.app.data.models.Chantier;
import com.lxcommissioning.app.data.models.GeofenceZone;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChantierDao_Impl implements ChantierDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Chantier> __insertionAdapterOfChantier;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<GeofenceZone> __insertionAdapterOfGeofenceZone;

  private final EntityDeletionOrUpdateAdapter<Chantier> __deletionAdapterOfChantier;

  public ChantierDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChantier = new EntityInsertionAdapter<Chantier>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Chantier` (`id`,`name`,`address`,`client`,`description`,`status`,`budgetHours`,`createdAt`,`updatedAt`,`requiredCertifications`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Chantier entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getAddress());
        statement.bindString(4, entity.getClient());
        statement.bindString(5, entity.getDescription());
        statement.bindString(6, entity.getStatus());
        statement.bindDouble(7, entity.getBudgetHours());
        statement.bindLong(8, entity.getCreatedAt());
        statement.bindLong(9, entity.getUpdatedAt());
        final String _tmp = __converters.fromStringList(entity.getRequiredCertifications());
        statement.bindString(10, _tmp);
      }
    };
    this.__insertionAdapterOfGeofenceZone = new EntityInsertionAdapter<GeofenceZone>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `GeofenceZone` (`id`,`siteId`,`name`,`latitude`,`longitude`,`radius`,`isActive`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GeofenceZone entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getSiteId());
        statement.bindString(3, entity.getName());
        statement.bindDouble(4, entity.getLatitude());
        statement.bindDouble(5, entity.getLongitude());
        statement.bindDouble(6, entity.getRadius());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfChantier = new EntityDeletionOrUpdateAdapter<Chantier>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Chantier` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Chantier entity) {
        statement.bindString(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertChantier(final Chantier chantier,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChantier.insert(chantier);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertGeofenceZone(final GeofenceZone zone,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGeofenceZone.insert(zone);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteChantier(final Chantier chantier,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfChantier.handle(chantier);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Chantier>> getAllChantiers() {
    final String _sql = "SELECT * FROM Chantier ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Chantier"}, new Callable<List<Chantier>>() {
      @Override
      @NonNull
      public List<Chantier> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfClient = CursorUtil.getColumnIndexOrThrow(_cursor, "client");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBudgetHours = CursorUtil.getColumnIndexOrThrow(_cursor, "budgetHours");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfRequiredCertifications = CursorUtil.getColumnIndexOrThrow(_cursor, "requiredCertifications");
          final List<Chantier> _result = new ArrayList<Chantier>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Chantier _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final String _tmpClient;
            _tmpClient = _cursor.getString(_cursorIndexOfClient);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final double _tmpBudgetHours;
            _tmpBudgetHours = _cursor.getDouble(_cursorIndexOfBudgetHours);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final List<String> _tmpRequiredCertifications;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfRequiredCertifications);
            final List<String> _tmp_1 = __converters.toStringList(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.util.List<java.lang.String>', but it was NULL.");
            } else {
              _tmpRequiredCertifications = _tmp_1;
            }
            _item = new Chantier(_tmpId,_tmpName,_tmpAddress,_tmpClient,_tmpDescription,_tmpStatus,_tmpBudgetHours,_tmpCreatedAt,_tmpUpdatedAt,_tmpRequiredCertifications);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getChantierById(final String id, final Continuation<? super Chantier> $completion) {
    final String _sql = "SELECT * FROM Chantier WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Chantier>() {
      @Override
      @Nullable
      public Chantier call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfClient = CursorUtil.getColumnIndexOrThrow(_cursor, "client");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBudgetHours = CursorUtil.getColumnIndexOrThrow(_cursor, "budgetHours");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfRequiredCertifications = CursorUtil.getColumnIndexOrThrow(_cursor, "requiredCertifications");
          final Chantier _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final String _tmpClient;
            _tmpClient = _cursor.getString(_cursorIndexOfClient);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final double _tmpBudgetHours;
            _tmpBudgetHours = _cursor.getDouble(_cursorIndexOfBudgetHours);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final List<String> _tmpRequiredCertifications;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfRequiredCertifications);
            final List<String> _tmp_1 = __converters.toStringList(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.util.List<java.lang.String>', but it was NULL.");
            } else {
              _tmpRequiredCertifications = _tmp_1;
            }
            _result = new Chantier(_tmpId,_tmpName,_tmpAddress,_tmpClient,_tmpDescription,_tmpStatus,_tmpBudgetHours,_tmpCreatedAt,_tmpUpdatedAt,_tmpRequiredCertifications);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<GeofenceZone>> getZonesForSite(final String siteId) {
    final String _sql = "SELECT * FROM GeofenceZone WHERE siteId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, siteId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"GeofenceZone"}, new Callable<List<GeofenceZone>>() {
      @Override
      @NonNull
      public List<GeofenceZone> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "siteId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfRadius = CursorUtil.getColumnIndexOrThrow(_cursor, "radius");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<GeofenceZone> _result = new ArrayList<GeofenceZone>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GeofenceZone _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpSiteId;
            _tmpSiteId = _cursor.getString(_cursorIndexOfSiteId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final float _tmpRadius;
            _tmpRadius = _cursor.getFloat(_cursorIndexOfRadius);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new GeofenceZone(_tmpId,_tmpSiteId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpRadius,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
