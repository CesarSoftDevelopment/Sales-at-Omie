package com.cesarsoftdevelopment.sales.di;

import com.cesarsoftdevelopment.sales.repository.SalesRepository;
import com.cesarsoftdevelopment.sales.usecase.SaveSaleUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
    "KotlinInternalInJava"
})
public final class SalesDomainModule_ProvideSaveSaleUseCaseFactory implements Factory<SaveSaleUseCase> {
  private final SalesDomainModule module;

  private final Provider<SalesRepository> salesRepositoryProvider;

  public SalesDomainModule_ProvideSaveSaleUseCaseFactory(SalesDomainModule module,
      Provider<SalesRepository> salesRepositoryProvider) {
    this.module = module;
    this.salesRepositoryProvider = salesRepositoryProvider;
  }

  @Override
  public SaveSaleUseCase get() {
    return provideSaveSaleUseCase(module, salesRepositoryProvider.get());
  }

  public static SalesDomainModule_ProvideSaveSaleUseCaseFactory create(SalesDomainModule module,
      Provider<SalesRepository> salesRepositoryProvider) {
    return new SalesDomainModule_ProvideSaveSaleUseCaseFactory(module, salesRepositoryProvider);
  }

  public static SaveSaleUseCase provideSaveSaleUseCase(SalesDomainModule instance,
      SalesRepository salesRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSaveSaleUseCase(salesRepository));
  }
}
