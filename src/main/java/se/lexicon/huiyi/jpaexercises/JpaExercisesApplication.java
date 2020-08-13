package se.lexicon.huiyi.jpaexercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import se.lexicon.huiyi.jpaexercises.dao_access.AppUserDao;
import se.lexicon.huiyi.jpaexercises.dao_access.AppUserDapJpaImpl;
import se.lexicon.huiyi.jpaexercises.entity.AppUser;

import java.time.LocalDate;


@SpringBootApplication
public class JpaExercisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExercisesApplication.class, args);
//		AppUser user1 = new AppUser("one", "test1", "Tester1", LocalDate.of(2020,1,1), true, "1234");
//		AppUser user2 = new AppUser("two", "test2", "Tester2", LocalDate.of(2020,2,2), true, "4321");
//
//
//		AppUserDao user = new AppUserDapJpaImpl();
//		System.out.println(user1);
//		user.save(user2);
//		user.save(user1);
		//System.out.println(user.findById(1));

	}

}
