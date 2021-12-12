package management.gymbuddy.service;

import management.gymbuddy.dto.CreateNewExecutiveDTO;
import management.gymbuddy.dto.CreateNewTrainerDTO;
import management.gymbuddy.entity.Executive;
import management.gymbuddy.entity.Manager;
import management.gymbuddy.entity.Trainer;

public interface ManagementService {
    Executive createManagerAccount(CreateNewExecutiveDTO createNewExecutiveDTO);
    Trainer createTrainerAccount(CreateNewTrainerDTO createNewTrainerDTO);
}
