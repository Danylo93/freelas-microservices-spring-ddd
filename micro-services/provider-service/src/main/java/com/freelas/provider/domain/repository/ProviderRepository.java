package com.freelas.provider.domain.repository;

import com.freelas.provider.domain.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
