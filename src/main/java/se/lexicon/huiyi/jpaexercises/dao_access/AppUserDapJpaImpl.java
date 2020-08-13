package se.lexicon.huiyi.jpaexercises.dao_access;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.huiyi.jpaexercises.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Transactional
@Repository
public class AppUserDapJpaImpl implements AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<AppUser> findById(int id) {

        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    public AppUser save(AppUser appUser) {
        //if (appUser != null)
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public boolean delete(AppUser appUser) {
        boolean isRemoved = false;
        if (appUser != null && findById(appUser.getUserId()).isPresent()){
            entityManager.remove(appUser);
            isRemoved = true;
        }
        return isRemoved;
    }
}
