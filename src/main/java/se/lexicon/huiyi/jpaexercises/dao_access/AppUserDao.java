package se.lexicon.huiyi.jpaexercises.dao_access;

import se.lexicon.huiyi.jpaexercises.entity.AppUser;
import java.util.Optional;

public interface AppUserDao {
    Optional<AppUser> findById(int id);
    AppUser update(AppUser appUser);
    AppUser save(AppUser appUser);
    boolean delete(AppUser appUser);
}
