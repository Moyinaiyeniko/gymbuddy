package management.gymbuddy.controller;

import management.gymbuddy.dto.AssignTrainerToCustomerDTO;
import management.gymbuddy.dto.CreateNewCustomerDTO;
import management.gymbuddy.dto.CreateNewExecutiveDTO;
import management.gymbuddy.entity.Customer;
import management.gymbuddy.entity.Executive;
import management.gymbuddy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/createcustomeraccount", method = RequestMethod.POST, produces = {"application/json"})
    @PreAuthorize("hasAuthority('Manager')")
    public Customer createNewCustomer(@RequestBody CreateNewCustomerDTO newCustomerDTO) {
        Customer createNewCustomer = customerService.createNewCustomerAccount(newCustomerDTO);
        return createNewCustomer;
    }
    @RequestMapping(value = "/assignTrainer/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    @PreAuthorize("hasAuthority('Manager')")
    public Customer assignTrainer(@PathVariable(value = "id") UUID customerId, @RequestBody AssignTrainerToCustomerDTO assignTrainerToCustomerDTO) {
        Customer assignTrainer = customerService.assignTrainer(customerId, assignTrainerToCustomerDTO);
        return assignTrainer;
    }


}
