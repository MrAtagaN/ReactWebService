package com.plekhanov.react_web_service.web.security;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Аутентифицирует по логину и паролю.
 * В качестве логина выступает поле email
 */
@Service
@RequiredArgsConstructor
public class EmailAuthenticationProvider implements AuthenticationProvider {

    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    /**
     * Сверяет введенные пользователем логин и пароль с
     * логином и паролем {@link User} в базе.
     *
     * В качестве логина выступает поле email
     */
    @Override
    public Authentication authenticate(final Authentication authentication) {
        final String username = (String) authentication.getPrincipal();
        final String password = (String) authentication.getCredentials();

        if (isNotBlank(username) && isNotBlank(password)) {
            final User user = userDao.findByEmail(username);
            if (user != null
                    && user.isEnabled()
                    && user.isAccountNonExpired()
                    && user.isAccountNonLocked()
                    && user.isCredentialsNonExpired()
                    && bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            }
        }
        throw new UsernameNotFoundException("User " + username + " not found!");
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
