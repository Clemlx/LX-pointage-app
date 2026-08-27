package com.lxcommissioning.app.di;

import com.lxcommissioning.app.data.local.AppDatabase;
import com.lxcommissioning.app.data.local.ChantierDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideChantierDaoFactory implements Factory<ChantierDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideChantierDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ChantierDao get() {
    return provideChantierDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideChantierDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideChantierDaoFactory(databaseProvider);
  }

  public static ChantierDao provideChantierDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideChantierDao(database));
  }
}
