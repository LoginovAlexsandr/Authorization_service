package ru.org.Authorization_service.repository;

import org.springframework.stereotype.Repository;
import ru.org.Authorization_service.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, String> userCredentials = Map.of(
            "admin", "password",
            "user", "123"
    );

    private final Map<String, List<Authorities>> userAuthorities = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!userCredentials.containsKey(user) || !userCredentials.get(user).equals(password)) {
            return Collections.emptyList();
        }
        return userAuthorities.getOrDefault(user, Collections.emptyList());
    }
}