package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

public interface ActivityTypeDataJpaRepository extends JpaRepository<ActivityTypeModel, Long> {
}
