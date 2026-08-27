package com.lxcommissioning.app.data.repository;

import com.lxcommissioning.app.data.local.PhotoDao;
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
public final class PhotoRepository_Factory implements Factory<PhotoRepository> {
  private final Provider<PhotoDao> photoDaoProvider;

  public PhotoRepository_Factory(Provider<PhotoDao> photoDaoProvider) {
    this.photoDaoProvider = photoDaoProvider;
  }

  @Override
  public PhotoRepository get() {
    return newInstance(photoDaoProvider.get());
  }

  public static PhotoRepository_Factory create(Provider<PhotoDao> photoDaoProvider) {
    return new PhotoRepository_Factory(photoDaoProvider);
  }

  public static PhotoRepository newInstance(PhotoDao photoDao) {
    return new PhotoRepository(photoDao);
  }
}
