package com.lxcommissioning.app.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.lxcommissioning.app.data.models.Pointage;
import com.lxcommissioning.app.data.models.SyncStatus;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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
public final class PointageDao_Impl implements PointageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pointage> __insertionAdapterOfPointage;

  private final Converters __converters = new Converters();

  public PointageDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPointage = new EntityInsertionAdapter<Pointage>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Pointage` (`id`,`siteId`,`startTime`,`endTime`,`durationMinutes`,`syncStatus`,`isManual`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Pointage entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getSiteId());
        statement.bindLong(3, entity.getStartTime());
        if (entity.getEndTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getEndTime());
        }
        statement.bindLong(5, entity.getDurationMinutes());
        final String _tmp = __converters.fromSyncStatus(entity.getSyncStatus());
        statement.bindString(6, _tmp);
        final int _tmp_1 = entity.isManual() ? 1 : 0;
        statement.bindLong(7, _tmp_1);
      }
    };
  }

  @Override
  public Object insertPointage(final Pointage pointage,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPointage.insert(pointage);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Pointage>> getAllPointages() {
    final String _sql = "SELECT * FROM Pointage ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Pointage"}, new Callable<List<Pointage>>() {
      @Override
      @NonNull
      public List<Pointage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "siteId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMinutes");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final int _cursorIndexOfIsManual = CursorUtil.getColumnIndexOrThrow(_cursor, "isManual");
          final List<Pointage> _result = new ArrayList<Pointage>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Pointage _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpSiteId;
            _tmpSiteId = _cursor.getString(_cursorIndexOfSiteId);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDurationMinutes;
            _tmpDurationMinutes = _cursor.getLong(_cursorIndexOfDurationMinutes);
            final SyncStatus _tmpSyncStatus;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSyncStatus);
            _tmpSyncStatus = __converters.toSyncStatus(_tmp);
            final boolean _tmpIsManual;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsManual);
            _tmpIsManual = _tmp_1 != 0;
            _item = new Pointage(_tmpId,_tmpSiteId,_tmpStartTime,_tmpEndTime,_tmpDurationMinutes,_tmpSyncStatus,_tmpIsManual);
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
  public Flow<List<Pointage>> getPointagesForSite(final String siteId) {
    final String _sql = "SELECT * FROM Pointage WHERE siteId = ? ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, siteId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Pointage"}, new Callable<List<Pointage>>() {
      @Override
      @NonNull
      public List<Pointage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "siteId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMinutes");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final int _cursorIndexOfIsManual = CursorUtil.getColumnIndexOrThrow(_cursor, "isManual");
          final List<Pointage> _result = new ArrayList<Pointage>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Pointage _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpSiteId;
            _tmpSiteId = _cursor.getString(_cursorIndexOfSiteId);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDurationMinutes;
            _tmpDurationMinutes = _cursor.getLong(_cursorIndexOfDurationMinutes);
            final SyncStatus _tmpSyncStatus;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSyncStatus);
            _tmpSyncStatus = __converters.toSyncStatus(_tmp);
            final boolean _tmpIsManual;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsManual);
            _tmpIsManual = _tmp_1 != 0;
            _item = new Pointage(_tmpId,_tmpSiteId,_tmpStartTime,_tmpEndTime,_tmpDurationMinutes,_tmpSyncStatus,_tmpIsManual);
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
  public Flow<Pointage> getActivePointage() {
    final String _sql = "SELECT * FROM Pointage WHERE endTime IS NULL LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Pointage"}, new Callable<Pointage>() {
      @Override
      @Nullable
      public Pointage call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "siteId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMinutes");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final int _cursorIndexOfIsManual = CursorUtil.getColumnIndexOrThrow(_cursor, "isManual");
          final Pointage _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpSiteId;
            _tmpSiteId = _cursor.getString(_cursorIndexOfSiteId);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDurationMinutes;
            _tmpDurationMinutes = _cursor.getLong(_cursorIndexOfDurationMinutes);
            final SyncStatus _tmpSyncStatus;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSyncStatus);
            _tmpSyncStatus = __converters.toSyncStatus(_tmp);
            final boolean _tmpIsManual;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsManual);
            _tmpIsManual = _tmp_1 != 0;
            _result = new Pointage(_tmpId,_tmpSiteId,_tmpStartTime,_tmpEndTime,_tmpDurationMinutes,_tmpSyncStatus,_tmpIsManual);
          } else {
            _result = null;
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
