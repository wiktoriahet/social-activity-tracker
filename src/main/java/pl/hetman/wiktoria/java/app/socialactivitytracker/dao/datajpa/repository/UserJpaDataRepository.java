package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

@Repository
public interface UserJpaDataRepository extends JpaRepository<UserModel, Long> {
}
