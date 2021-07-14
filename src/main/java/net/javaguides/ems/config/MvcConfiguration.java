/*
 * package net.javaguides.ems.config;
 * 
 * import javax.sql.DataSource;
 * 
 * 
 * import net.javaguides.ems.service.EmployeeDao;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.web.servlet.ViewResolver; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc; import
 * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 * import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 * import org.springframework.web.servlet.view.InternalResourceViewResolver;
 * 
 * @Configuration
 * 
 * @ComponentScan(basePackages="net.javaguides.ems")
 * 
 * @EnableWebMvc public class MvcConfiguration extends WebMvcConfigurerAdapter{
 * 
 * @Bean public ViewResolver getViewResolver(){ InternalResourceViewResolver
 * resolver = new InternalResourceViewResolver();
 * resolver.setPrefix("/WEB-INF/views/"); resolver.setSuffix(".jsp"); return
 * resolver; }
 * 
 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
 * registry.addResourceHandler("/resources/**").addResourceLocations(
 * "/resources/"); }
 * 
 * @Bean public DataSource getDataSource() { DriverManagerDataSource dataSource
 * = new DriverManagerDataSource();
 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
 * dataSource.setUrl("jdbc:mysql://localhost:3306/emsystem");
 * dataSource.setUsername("root"); dataSource.setPassword("1441");
 * 
 * return dataSource; }
 * 
 * @Bean public EmployeeDao getEmployeeDao() { return new
 * EmployeeDao(getDataSource()); } }
 */