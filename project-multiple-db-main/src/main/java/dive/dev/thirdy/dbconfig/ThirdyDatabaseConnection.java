package dive.dev.thirdy.dbconfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "thirdyEntityManagerFactory",
		transactionManagerRef = "thirdyTransactionManager",
		basePackages = {"dive.dev.thirdy.repo"}
		)
public class ThirdyDatabaseConnection {
	
	@Value("${spring.thirdy.datasource.url}")
    private String url;
	
	@Value("${spring.thirdy.datasource.username}")
    private String username;
	
	@Value("${spring.thirdy.datasource.password}")
    private String password;
	
	
	@Bean(name = "thirdyDbDataSource")
    public DataSource thirdyDbDataSource(){
        return DataSourceBuilder.create()
        		.url(url)
        		.username(username)
        		.password(password)
        		.build();
    }
	
	
	@Bean(name = "thirdyEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean thirdyEntityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("thirdyDbDataSource") DataSource thirdyDataSource) {
		Map<String, String> props = new HashMap<>();
		props.put("hibernate.physical_naming_strategy"
				, CamelCaseToUnderscoresNamingStrategy.class.getName());
		return builder
				.dataSource(thirdyDataSource)
				.packages("dive.dev.thirdy.models")
				.properties(props)
				.build();
	}
	
	
	@Bean(name = "thirdyTransactionManager")
	public PlatformTransactionManager thirdyTransactionManager(
			@Qualifier("thirdyEntityManagerFactory") EntityManagerFactory
			thirdyEntityManagerFactory) {
		return new JpaTransactionManager(thirdyEntityManagerFactory);
	}
}
