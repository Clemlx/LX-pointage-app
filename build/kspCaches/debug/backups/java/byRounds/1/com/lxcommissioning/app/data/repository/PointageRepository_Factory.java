package com.lxcommissioning.app.data.repository;

import com.lxcommissioning.app.data.local.PointageDao;
import com.lxcommissioning.app.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class PointageRepository_Factory implements Factory<PointageRepository> {
  private final Provider<PointageDao> pointageDaoProvider;

  private final Provider<ApiService> apiServiceProvider;

  public PointageRepository_Factory(Provider<PointageDao> pointageDaoProvider,
      Provider<ApiService> apiServiceProvider) {
    this.pointageDaoProvider = pointageDaoProvider;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public PointageRepository get() {
    return newInstance(pointageDaoProvider.get(), apiServiceProvider.get());
  }

  public static PointageRepository_Factory create(Provider<PointageDao> pointageDaoProvider,
      Provider<ApiService> apiServiceProvider) {
    return new PointageRepository_Factory(pointageDaoProvider, apiServiceProvider);
  }

  public static PointageRepository newInstance(PointageDao pointageDao, ApiService apiService) {
    return new PointageRepository(pointageDao, apiService);
  }
}
