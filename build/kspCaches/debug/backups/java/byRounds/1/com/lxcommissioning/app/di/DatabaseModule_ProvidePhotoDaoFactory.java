package com.lxcommissioning.app.di;

import com.lxcommissioning.app.data.local.AppDatabase;
import com.lxcommissioning.app.data.local.PhotoDao;
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
public final class DatabaseModule_ProvidePhotoDaoFactory implements Factory<PhotoDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvidePhotoDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PhotoDao get() {
    return providePhotoDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvidePhotoDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvidePhotoDaoFactory(databaseProvider);
  }

  public static PhotoDao providePhotoDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePhotoDao(database));
  }
}
