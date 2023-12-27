package pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.web.services.ActivityService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/activities")
public class ActivityController {

    private static final Logger LOGGER = Logger.getLogger(ActivityController.class.getName());

    private final ActivityService activityService; //zależność

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    private List<ActivityModel> activities = new ArrayList<>();

    @GetMapping
    public String read(ActivityModel activityModel) throws ActivityException {
        LOGGER.info("read(" + activityModel + ")");
        activityService.read(activityModel.getId());
        LOGGER.info("read(...)");
        return null;
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        modelMap.addAttribute("activity", new ActivityModel());

        LOGGER.info("createView(...)");
        return "app/social-activity-tracker/create-activity.html";
    }

    @PostMapping
    public String create(ActivityModel activityModel) {
        LOGGER.info("create(" + activityModel + ")");
        activities.add(activityModel);
        LOGGER.info("create(...)");
        return "redirect:/activities/list";
    }

    @GetMapping(value = "/list")
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        modelMap.addAttribute("activities", activities);
        LOGGER.info("list(...)");
        return "app/social-activity-tracker/activities.html";
    }

//    // C - create
//    public ActivityEntity create(ActivityEntity activityEntity) throws ActivityException {
//        LOGGER.info("create(" + activityEntity + ")");
//        if (activityEntity != null) {
//            if (activityEntity.getLabel() == null) {
//                throw new MissingLabelActivityException("Label is null");
//            }
//        }
//        ActivityEntity createdActivityEntity = activityService.create(activityEntity);
//        LOGGER.info("create(...) = " + createdActivityEntity);
//        return createdActivityEntity;
//    }


}

