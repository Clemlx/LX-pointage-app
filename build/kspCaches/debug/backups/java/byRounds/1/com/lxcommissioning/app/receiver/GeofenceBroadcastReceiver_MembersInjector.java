package com.lxcommissioning.app.receiver;

import com.lxcommissioning.app.data.local.PointageDao;
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
public final class GeofenceBroadcastReceiver_MembersInjector implements MembersInjector<GeofenceBroadcastReceiver> {
  private final Provider<PointageDao> pointageDaoProvider;

  public GeofenceBroadcastReceiver_MembersInjector(Provider<PointageDao> pointageDaoProvider) {
    this.pointageDaoProvider = pointageDaoProvider;
  }

  public static MembersInjector<GeofenceBroadcastReceiver> create(
      Provider<PointageDao> pointageDaoProvider) {
    return new GeofenceBroadcastReceiver_MembersInjector(pointageDaoProvider);
  }

  @Override
  public void injectMembers(GeofenceBroadcastReceiver instance) {
    injectPointageDao(instance, pointageDaoProvider.get());
  }

  @InjectedFieldSignature("com.lxcommissioning.app.receiver.GeofenceBroadcastReceiver.pointageDao")
  public static void injectPointageDao(GeofenceBroadcastReceiver instance,
      PointageDao pointageDao) {
    instance.pointageDao = pointageDao;
  }
}
