package com.softwarecafe.jdbcPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.softwarecafe.jdbcPackage")
//@PropertySource({"classpath:persistence-${envTarget:mysql}.properties"})
@PropertySource("classpath:application.properties")
public class JDBCConfig {
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.driver-class.name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    /*@Bean("edao")
    public UserdataDao userdataDao()
    {
//        String driverClassName = environment.getProperty("spring.datasource.driver-class.name");
//       String user =environment.getProperty("spring.datasource.username");
//       String pass = environment.getProperty("spring.datasource.password");
//       String url = environment.getProperty("spring.datasource.url = jdbc:mysql://localhost:3306/database1");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,user,pass);
        dataSource.setDriverClassName(driverClassName);
        JdbcTemplate jdbct = new JdbcTemplate(dataSource);
        UserdataDao d = new UserdataDao();
        d.setJdbcTemplate(jdbct);
        return d;
    }*/

    //DriverManagerDataSource

    @Bean("upntdao")
    public UserdataDao userdataDapParameterJdbcTemplet()
    {

        UserdataDao d = new UserdataDao();
        d.setNamedParameterJdbcTemplate(this.namedParameterJdbcTemplate());
        return d;

    }
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate()
    {
        return new NamedParameterJdbcTemplate(this.dataSource());
    }
    @Bean
    public DriverManagerDataSource dataSource()
    {

        /*DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/database1","root","Alok@1986");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");*/
        DriverManagerDataSource dataSource = new DriverManagerDataSource(jdbcUrl,username,password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public JdbcTemplate template ()
    {
        return new JdbcTemplate(this.dataSource());
    }

}
