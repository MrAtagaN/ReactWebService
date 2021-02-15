package com.plekhanov.react_web_service.config.security;

import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Аутентификация по email и паролю.
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailPasswordAuthService {

    UserDao userDao;
    BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * Сверяет введенные пользователем email и пароль с
     * email и паролем {@link User} в базе.
     *
     * Возвращает аутентифицированного {@link User}
     */
    public User authenticate(final String email, final String password) { //TODO @NotBlank
        if (isNotBlank(email) && isNotBlank(password)) {
            final User user = userDao.findByEmail(email);
            if (user != null) {
                if (!user.isEnabled()) {
                    throw new DisabledException(format("Email {0} disabled!", email));
                }
                if (!user.isAccountNonExpired()) {
                    throw new AccountExpiredException(format("Email {0} account expired!", email));
                }
                if (!user.isAccountNonLocked()) {
                    throw new LockedException(format("Email {0} account is locked!", email));
                }
                if (!user.isCredentialsNonExpired()) {
                    throw new CredentialsExpiredException(format("Email {0} credentials is expired!", email));
                }
                final String actualPassword = user.getPassword();
                if (!bCryptPasswordEncoder.matches(password, actualPassword)) {
                    throw new BadCredentialsException(format("Email {0} bad credentials!", email));
                }
                user.setLastEnter(user.getEnter());
                user.setEnter(LocalDateTime.now());
                userDao.save(user);
                return user;
            }
        } else {
            throw new ValidationException("email or password is blank!");
        }
        throw new UsernameNotFoundException(format("Email {0} not found!", email));
    }


}
