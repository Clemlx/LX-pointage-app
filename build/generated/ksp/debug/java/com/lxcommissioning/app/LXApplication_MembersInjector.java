package com.lxcommissioning.app;

import androidx.hilt.work.HiltWorkerFactory;
import com.lxcommissioning.app.data.worker.SyncManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class LXApplication_MembersInjector implements MembersInjector<LXApplication> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  private final Provider<SyncManager> syncManagerProvider;

  public LXApplication_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider,
      Provider<SyncManager> syncManagerProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
    this.syncManagerProvider = syncManagerProvider;
  }

  public static MembersInjector<LXApplication> create(
      Provider<HiltWorkerFactory> workerFactoryProvider,
      Provider<SyncManager> syncManagerProvider) {
    return new LXApplication_MembersInjector(workerFactoryProvider, syncManagerProvider);
  }

  @Override
  public void injectMembers(LXApplication instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
    injectSyncManager(instance, syncManagerProvider.get());
  }

  @InjectedFieldSignature("com.lxcommissioning.app.LXApplication.workerFactory")
  public static void injectWorkerFactory(LXApplication instance, HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }

  @InjectedFieldSignature("com.lxcommissioning.app.LXApplication.syncManager")
  public static void injectSyncManager(LXApplication instance, SyncManager syncManager) {
    instance.syncManager = syncManager;
  }
}
