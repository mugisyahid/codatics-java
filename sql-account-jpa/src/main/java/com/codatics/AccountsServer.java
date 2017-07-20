package com.codatics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codatics.common.utitilty.RoleUtil;
import com.codatics.dto.accountservices.User;
import com.codatics.repository.UserRepository;

@Configuration
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EntityScan(basePackages = "com.codatics.entity")
@ComponentScan("com.codatics")
@EnableZuulProxy
public class AccountsServer {

	// @Autowired
	// protected AccountRepository accountRepository;

	@Autowired
	protected UserRepository userRepository;

	protected Logger logger = Logger.getLogger(AccountsServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "accounts-server");

		SpringApplication.run(AccountsServer.class, args);

		System.out.println("lalala");

	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
			// @formatter:off

			auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER").and().withUser("audit").password("audit").roles("USER", "ADMIN", "READER");
			// @formatter:on
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.httpBasic().and().logout().and().authorizeRequests().antMatchers("/index.html", "/login", "/").permitAll().anyRequest().authenticated().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			// @formatter:on
		}
	}

	@RequestMapping("/user")
	@ResponseBody
	public Map<String, Object> user(User user) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("name", user.getFullName());
		map.put("roles", RoleUtil.RoleToSet(user.getRole()));
		return map;
	}

	@RequestMapping("/login")
	public String login() {
		return "forward:/";
	}

}
