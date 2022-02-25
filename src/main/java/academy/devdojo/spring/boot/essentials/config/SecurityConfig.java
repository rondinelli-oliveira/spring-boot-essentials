package academy.devdojo.spring.boot.essentials.config;

import academy.devdojo.spring.boot.essentials.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    /**
     * BasicAuthenticationFilter
     * UsernamePasswordAuthenticationFilter
     * DefaultLoginPageGeneratingFilter
     * DefaultLogoutPageGeneratingFilter
     * FilterSecurityInterceptor
     * Authentication -> Authorization
     * @param http
     * @throws Exception
     */
    
    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
                .antMatchers("/animes/admin/**").hasRole("ADMIN")
                .antMatchers("/animes/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("test"));
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("rondinelli2")
                .password(passwordEncoder.encode("academy"))
                .roles("USER","ADMIN")
                .and()
                .withUser("devdojo2")
                .password(passwordEncoder.encode("academy"))
                .roles("USER");

        authenticationManagerBuilder.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}
