package net.javaguides.ems;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfiguration {

	@Autowired 
	private Environment env;
	
    @Bean(name="dataSource")
    public DataSource getDatasource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
    	//DataSource datasource = new DataSource();
        datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));//this.dbDriver
        datasource.setUrl(env.getProperty("spring.datasource.url"));//this.dbURL
        datasource.setUsername(env.getProperty("spring.datasource.username"));//this.dbUserName
        datasource.setPassword(env.getProperty("spring.datasource.password"));//this.dbPassword
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

	/*
	 * @Bean("resourceBundle") public ResourceBundle resourceBundle() {
	 * ResourceBundle rb = ResourceBundle.getBundle("query"); return rb; }
	 */
}