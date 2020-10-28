//package bt.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import bt.config.CustomUserDetailsServices;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	CustomUserDetailsServices userDetailsService;
//	
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").hasAnyRole("USER", "ADMIN")
//				.antMatchers("/admin").hasAnyRole("USER", "ADMIN").antMatchers("/add")
//				.hasAnyRole("ADMIN").anyRequest().authenticated()
//				.and().formLogin().loginPage("/login").permitAll()
//				.and().logout().permitAll();
//
//		http.csrf().disable();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_USER").and()
//				.withUser("javainuse").password("javainuse").authorities("ROLE_USER", "ROLE_ADMIN");
//	}
//
//
//
//
//}
