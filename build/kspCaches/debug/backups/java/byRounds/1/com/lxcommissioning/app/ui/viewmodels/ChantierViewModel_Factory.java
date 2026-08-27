package com.lxcommissioning.app.ui.viewmodels;

import com.lxcommissioning.app.data.repository.ChantierRepository;
import com.lxcommissioning.app.data.repository.NoteRepository;
import com.lxcommissioning.app.data.repository.PhotoRepository;
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
public final class ChantierViewModel_Factory implements Factory<ChantierViewModel> {
  private final Provider<ChantierRepository> repositoryProvider;

  private final Provider<NoteRepository> noteRepositoryProvider;

  private final Provider<PhotoRepository> photoRepositoryProvider;

  public ChantierViewModel_Factory(Provider<ChantierRepository> repositoryProvider,
      Provider<NoteRepository> noteRepositoryProvider,
      Provider<PhotoRepository> photoRepositoryProvider) {
    this.repositoryProvider = repositoryProvider;
    this.noteRepositoryProvider = noteRepositoryProvider;
    this.photoRepositoryProvider = photoRepositoryProvider;
  }

  @Override
  public ChantierViewModel get() {
    return newInstance(repositoryProvider.get(), noteRepositoryProvider.get(), photoRepositoryProvider.get());
  }

  public static ChantierViewModel_Factory create(Provider<ChantierRepository> repositoryProvider,
      Provider<NoteRepository> noteRepositoryProvider,
      Provider<PhotoRepository> photoRepositoryProvider) {
    return new ChantierViewModel_Factory(repositoryProvider, noteRepositoryProvider, photoRepositoryProvider);
  }

  public static ChantierViewModel newInstance(ChantierRepository repository,
      NoteRepository noteRepository, PhotoRepository photoRepository) {
    return new ChantierViewModel(repository, noteRepository, photoRepository);
  }
}
