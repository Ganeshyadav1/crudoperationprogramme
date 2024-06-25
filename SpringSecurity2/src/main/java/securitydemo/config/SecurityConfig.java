package securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	  @Bean
	    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	        UserDetails user = User.withDefaultPasswordEncoder()
	                .username("ganesh")
	                .password("ganesh123")
	                .roles("USER")
	                .build();
	        UserDetails admin = User.withDefaultPasswordEncoder()
	                .username("gani")
	                .password("gani123")
	                .roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((authorize) -> authorize
            		 .antMatchers("/welcome").permitAll() 
                .antMatchers("/fetch-all").hasRole("USER") 
                .antMatchers("/fetch/**").hasRole("ADMIN")
                .anyRequest().authenticated() 
            )
            .httpBasic(); 

        return http.build();
    }
}
