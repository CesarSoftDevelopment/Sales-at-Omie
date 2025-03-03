package com.cesarsoftdevelopment.sales.di;

import com.cesarsoftdevelopment.sales.repository.SalesRepository;
import com.cesarsoftdevelopment.sales.usecase.GetSalesUseCase;
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
public final class SalesDomainModule_ProvideGetSalesUseCaseFactory implements Factory<GetSalesUseCase> {
  private final SalesDomainModule module;

  private final Provider<SalesRepository> salesRepositoryProvider;

  public SalesDomainModule_ProvideGetSalesUseCaseFactory(SalesDomainModule module,
      Provider<SalesRepository> salesRepositoryProvider) {
    this.module = module;
    this.salesRepositoryProvider = salesRepositoryProvider;
  }

  @Override
  public GetSalesUseCase get() {
    return provideGetSalesUseCase(module, salesRepositoryProvider.get());
  }

  public static SalesDomainModule_ProvideGetSalesUseCaseFactory create(SalesDomainModule module,
      Provider<SalesRepository> salesRepositoryProvider) {
    return new SalesDomainModule_ProvideGetSalesUseCaseFactory(module, salesRepositoryProvider);
  }

  public static GetSalesUseCase provideGetSalesUseCase(SalesDomainModule instance,
      SalesRepository salesRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideGetSalesUseCase(salesRepository));
  }
}
