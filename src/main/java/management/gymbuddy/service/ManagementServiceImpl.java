package management.gymbuddy.service;

import management.gymbuddy.dto.CreateNewExecutiveDTO;
import management.gymbuddy.dto.CreateNewTrainerDTO;
import management.gymbuddy.entity.*;
import management.gymbuddy.enums.UserType;
import management.gymbuddy.repository.ExecutiveRepository;
import management.gymbuddy.repository.ManagerRepository;
import management.gymbuddy.repository.TrainerRepository;
import management.gymbuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExecutiveRepository executiveRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Executive createManagerAccount(CreateNewExecutiveDTO createNewExecutiveDTO) {
        try {

          Executive newManager = new Executive();
            newManager.setFirstName(createNewExecutiveDTO.getFirstName());
            newManager.setLastName(createNewExecutiveDTO.getLastName());
            User user = createNewExecutiveDTO.getUser();
//            newManager.setUser(null);
            newManager = executiveRepository.save(newManager);
            List<Role> roles = new ArrayList();
            Role r = new Role();
            r.setRoleName("Manager");
            r.setDescription("Manager Details");
            roles.add(r);
            user.setRoles(roles);
          user.setExecutive(newManager);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserType(UserType.MANAGER);
            createNewExecutiveDTO.setUser(user);
            userRepository.save(user);


            return executiveRepository.save(newManager);

        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Manager not created successfully", exc);
        }
    }


    public Trainer createTrainerAccount(CreateNewTrainerDTO createNewTrainerDTO) {
        try {

            Trainer newTrainer = new Trainer();
            newTrainer.setFirstName(createNewTrainerDTO.getFirstName());
            newTrainer.setLastName(createNewTrainerDTO.getLastName());
            newTrainer.setSpecialty(createNewTrainerDTO.getSpecialty());
            User user = createNewTrainerDTO.getUser();
//            newManager.setUser(null);
           // newTrainer = trainerRepository.save(newTrainer);
            List<Role> roles = new ArrayList();
            Role r = new Role();
            r.setRoleName("Trainer");
            r.setDescription("Trainer Details");
            roles.add(r);
            user.setRoles(roles);
            user.setTrainer(newTrainer);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserType(UserType.MANAGER);
            createNewTrainerDTO.setUser(user);
            userRepository.save(user);


            return trainerRepository.save(newTrainer);

        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Trainer not created successfully", exc);
        }
    }
}
