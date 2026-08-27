package com.lxcommissioning.app.data.repository;

import com.lxcommissioning.app.data.local.ChantierDao;
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
public final class ChantierRepository_Factory implements Factory<ChantierRepository> {
  private final Provider<ChantierDao> chantierDaoProvider;

  public ChantierRepository_Factory(Provider<ChantierDao> chantierDaoProvider) {
    this.chantierDaoProvider = chantierDaoProvider;
  }

  @Override
  public ChantierRepository get() {
    return newInstance(chantierDaoProvider.get());
  }

  public static ChantierRepository_Factory create(Provider<ChantierDao> chantierDaoProvider) {
    return new ChantierRepository_Factory(chantierDaoProvider);
  }

  public static ChantierRepository newInstance(ChantierDao chantierDao) {
    return new ChantierRepository(chantierDao);
  }
}
