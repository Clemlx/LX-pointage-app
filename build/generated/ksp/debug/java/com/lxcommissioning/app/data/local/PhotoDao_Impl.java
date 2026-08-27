package com.lxcommissioning.app.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.lxcommissioning.app.data.models.Photo;
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
public final class PhotoDao_Impl implements PhotoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Photo> __insertionAdapterOfPhoto;

  private final Converters __converters = new Converters();

  public PhotoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPhoto = new EntityInsertionAdapter<Photo>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Photo` (`id`,`siteId`,`uri`,`remoteUrl`,`latitude`,`longitude`,`timestamp`,`note`,`syncStatus`,`originalRetentionUntil`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Photo entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getSiteId());
        statement.bindString(3, entity.getUri());
        if (entity.getRemoteUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRemoteUrl());
        }
        statement.bindDouble(5, entity.getLatitude());
        statement.bindDouble(6, entity.getLongitude());
        statement.bindLong(7, entity.getTimestamp());
        if (entity.getNote() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getNote());
        }
        final String _tmp = __converters.fromSyncStatus(entity.getSyncStatus());
        statement.bindString(9, _tmp);
        if (entity.getOriginalRetentionUntil() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getOriginalRetentionUntil());
        }
      }
    };
  }

  @Override
  public Object insertPhoto(final Photo photo, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPhoto.insert(photo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Photo>> getPhotosForSite(final String siteId) {
    final String _sql = "SELECT * FROM Photo WHERE siteId = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, siteId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Photo"}, new Callable<List<Photo>>() {
      @Override
      @NonNull
      public List<Photo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "siteId");
          final int _cursorIndexOfUri = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfRemoteUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteUrl");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final int _cursorIndexOfOriginalRetentionUntil = CursorUtil.getColumnIndexOrThrow(_cursor, "originalRetentionUntil");
          final List<Photo> _result = new ArrayList<Photo>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Photo _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpSiteId;
            _tmpSiteId = _cursor.getString(_cursorIndexOfSiteId);
            final String _tmpUri;
            _tmpUri = _cursor.getString(_cursorIndexOfUri);
            final String _tmpRemoteUrl;
            if (_cursor.isNull(_cursorIndexOfRemoteUrl)) {
              _tmpRemoteUrl = null;
            } else {
              _tmpRemoteUrl = _cursor.getString(_cursorIndexOfRemoteUrl);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            final SyncStatus _tmpSyncStatus;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSyncStatus);
            _tmpSyncStatus = __converters.toSyncStatus(_tmp);
            final Long _tmpOriginalRetentionUntil;
            if (_cursor.isNull(_cursorIndexOfOriginalRetentionUntil)) {
              _tmpOriginalRetentionUntil = null;
            } else {
              _tmpOriginalRetentionUntil = _cursor.getLong(_cursorIndexOfOriginalRetentionUntil);
            }
            _item = new Photo(_tmpId,_tmpSiteId,_tmpUri,_tmpRemoteUrl,_tmpLatitude,_tmpLongitude,_tmpTimestamp,_tmpNote,_tmpSyncStatus,_tmpOriginalRetentionUntil);
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
