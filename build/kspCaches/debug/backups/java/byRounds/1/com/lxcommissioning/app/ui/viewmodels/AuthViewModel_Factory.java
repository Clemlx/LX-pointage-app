package com.lxcommissioning.app.ui.viewmodels;

import com.lxcommissioning.app.data.local.UserDao;
import com.lxcommissioning.app.data.remote.ApiService;
import com.lxcommissioning.app.data.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<ApiService> apiServiceProvider;

  private final Provider<UserDao> userDaoProvider;

  public AuthViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<ApiService> apiServiceProvider, Provider<UserDao> userDaoProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.apiServiceProvider = apiServiceProvider;
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(authRepositoryProvider.get(), apiServiceProvider.get(), userDaoProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<ApiService> apiServiceProvider, Provider<UserDao> userDaoProvider) {
    return new AuthViewModel_Factory(authRepositoryProvider, apiServiceProvider, userDaoProvider);
  }

  public static AuthViewModel newInstance(AuthRepository authRepository, ApiService apiService,
      UserDao userDao) {
    return new AuthViewModel(authRepository, apiService, userDao);
  }
}
