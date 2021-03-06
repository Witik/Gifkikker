package eu.gillissen.topicus.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA configuration.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"eu.gillissen.topicus.model"})
@EnableJpaRepositories(basePackages = {"eu.gillissen.topicus.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
