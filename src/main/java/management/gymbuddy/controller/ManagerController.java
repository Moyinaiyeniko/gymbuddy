package management.gymbuddy.controller;

import management.gymbuddy.dto.CreateNewExecutiveDTO;
import management.gymbuddy.dto.CreateNewTrainerDTO;
import management.gymbuddy.entity.Executive;
import management.gymbuddy.entity.Manager;
import management.gymbuddy.entity.Trainer;
import management.gymbuddy.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ManagerController {
    @Autowired
    private ManagementService managementService;
    @RequestMapping(value = "/createmanager", method = RequestMethod.POST, produces = {"application/json"})
    @PreAuthorize("hasAuthority('EXECUTIVE')")
    public Executive createNewManager(@RequestBody CreateNewExecutiveDTO managerDTO) {
        Executive createManager = managementService.createManagerAccount(managerDTO);
        return createManager;
    }

    @RequestMapping(value = "/createtrainer", method = RequestMethod.POST, produces = {"application/json"})
    @PreAuthorize("hasAuthority('Manager')")
    public Trainer createNewTrainer(@RequestBody CreateNewTrainerDTO trainerDTO) {
        Trainer createNewTrainer = managementService.createTrainerAccount(trainerDTO);
        return createNewTrainer;
    }
}
