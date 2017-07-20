package com.codatics;

import com.codatics.common.utitilty.RoleUtil;
import com.codatics.dto.accountservices.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;


@SpringBootApplication
@Controller
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayApplication {

	/**
	 * URL uses the logical name of account-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String ACCOUNTS_SERVICE_URL = "http://NETFREAKS-ACCOUNTS";

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

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
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
			// http.httpBasic().and().logout().and().authorizeRequests().antMatchers("/index.html",
			// "/login",
			// "/").permitAll().anyRequest().authenticated().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			// @formatter:on
		}
	}

}
