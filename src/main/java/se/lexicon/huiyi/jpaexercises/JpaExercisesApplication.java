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

	}

}
