package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;

@Repository //nie jest to wymagane
public interface DefaultActivityDataJpaRepository extends JpaRepository<ActivityEntity, Long> {

}
