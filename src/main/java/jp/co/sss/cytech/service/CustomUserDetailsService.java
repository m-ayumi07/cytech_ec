package jp.co.sss.cytech.service;
import jp.co.sss.cytech.domain.entity.User;
import jp.co.sss.cytech.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository users;
    public CustomUserDetailsService(UserRepository users){ this.users = users; }
    @Override public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = users.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("not found"));
        return org.springframework.security.core.userdetails.User.withUsername(u.getEmail()).password(u.getPassword()).roles("USER").build();
    }
}
