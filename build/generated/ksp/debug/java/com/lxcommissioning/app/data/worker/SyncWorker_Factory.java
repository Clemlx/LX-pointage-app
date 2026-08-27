package com.lxcommissioning.app.data.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.lxcommissioning.app.data.local.ChantierDao;
import com.lxcommissioning.app.data.local.NoteDao;
import com.lxcommissioning.app.data.local.PointageDao;
import com.lxcommissioning.app.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class SyncWorker_Factory {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<ChantierDao> chantierDaoProvider;

  private final Provider<PointageDao> pointageDaoProvider;

  private final Provider<NoteDao> noteDaoProvider;

  public SyncWorker_Factory(Provider<ApiService> apiServiceProvider,
      Provider<ChantierDao> chantierDaoProvider, Provider<PointageDao> pointageDaoProvider,
      Provider<NoteDao> noteDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.chantierDaoProvider = chantierDaoProvider;
    this.pointageDaoProvider = pointageDaoProvider;
    this.noteDaoProvider = noteDaoProvider;
  }

  public SyncWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, apiServiceProvider.get(), chantierDaoProvider.get(), pointageDaoProvider.get(), noteDaoProvider.get());
  }

  public static SyncWorker_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<ChantierDao> chantierDaoProvider, Provider<PointageDao> pointageDaoProvider,
      Provider<NoteDao> noteDaoProvider) {
    return new SyncWorker_Factory(apiServiceProvider, chantierDaoProvider, pointageDaoProvider, noteDaoProvider);
  }

  public static SyncWorker newInstance(Context context, WorkerParameters params,
      ApiService apiService, ChantierDao chantierDao, PointageDao pointageDao, NoteDao noteDao) {
    return new SyncWorker(context, params, apiService, chantierDao, pointageDao, noteDao);
  }
}
