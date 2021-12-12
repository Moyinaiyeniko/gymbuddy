package management.gymbuddy.service;

import management.gymbuddy.dto.AssignTrainerToCustomerDTO;
import management.gymbuddy.dto.CreateNewCustomerDTO;
import management.gymbuddy.entity.Customer;

import java.util.UUID;


public interface CustomerService {

    Customer createNewCustomerAccount(CreateNewCustomerDTO createNewCustomerDTO);

    Customer assignTrainer(UUID customerId, AssignTrainerToCustomerDTO assignTrainerToCustomerDTO);
}
