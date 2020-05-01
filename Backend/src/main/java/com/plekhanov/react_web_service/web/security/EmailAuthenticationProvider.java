package com.plekhanov.react_web_service.web.security;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.text.MessageFormat.format;
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
            if (user != null) {
                if (!user.isEnabled()) {
                    throw new DisabledException(format("User {0} disabled!", username));
                }
                if (!user.isAccountNonExpired()) {
                    throw new AccountExpiredException(format("User {0} account expired!", username));
                }
                if (!user.isAccountNonLocked()) {
                    throw new LockedException(format("User {0} account is locked!", username));
                }
                if (!user.isCredentialsNonExpired()) {
                    throw new CredentialsExpiredException(format("User {0} credentials is expired!", username));
                }
                final String actualPassword = user.getPassword();
                if (!bCryptPasswordEncoder.matches(password, actualPassword)) {
                    throw new BadCredentialsException(format("User {0} bad credentials!", username));
                }
                //после всех проверок, аутентифицируем пользователя
                return new UsernamePasswordAuthenticationToken(user, actualPassword, user.getAuthorities());
            }
        }
        throw new UsernameNotFoundException(format("User {0} not found!", username));
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
