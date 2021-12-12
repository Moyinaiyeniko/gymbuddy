package management.gymbuddy.service;

import management.gymbuddy.dto.AssignTrainerToCustomerDTO;
import management.gymbuddy.dto.CreateNewCustomerDTO;
import management.gymbuddy.dto.CreateNewExecutiveDTO;
import management.gymbuddy.entity.Customer;
import management.gymbuddy.entity.Executive;
import management.gymbuddy.entity.Role;
import management.gymbuddy.entity.User;
import management.gymbuddy.enums.UserType;
import management.gymbuddy.repository.CustomerRepository;
import management.gymbuddy.repository.ExecutiveRepository;
import management.gymbuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExecutiveRepository executiveRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createNewCustomerAccount(CreateNewCustomerDTO createNewCustomerDTO) {
        try {

          Customer newCustomer = new Customer();
            newCustomer.setFirstName(createNewCustomerDTO.getFirstName());
            newCustomer.setLastName(createNewCustomerDTO.getLastName());
            User user = createNewCustomerDTO.getUser();
            //newManager.setUser(null);
            //newCustomer = customerRepository.save(newCustomer);
            List<Role> roles = new ArrayList();
            Role r = new Role();
            r.setRoleName("Customer");
            r.setDescription("Customer Details");
            roles.add(r);
            user.setRoles(roles);
         // user.setCustomer(newCustomer);
          String customerId = generateCustomerId(createNewCustomerDTO.getFirstName(),createNewCustomerDTO.getLastName());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserId(customerId);
            user.setUserType(UserType.CUSTOMER);
            createNewCustomerDTO.setUser(user);
            newCustomer.setUser(user);
            userRepository.save(user);


            return customerRepository.save(newCustomer);

        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Customer not created successfully", exc);
        }
    }
    public Customer assignTrainer(UUID customerId, AssignTrainerToCustomerDTO assignTrainerToCustomerDTO){
        try {
            Optional<Customer> customer = customerRepository.findById(customerId);
            Customer customer1 = customer.get();
            if(customer1!=null){
                customer1.setTrainer(assignTrainerToCustomerDTO.getTrainer());
            }
            return customerRepository.save(customer1);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Trainer not assigned successfully", exc);
        }
    }



    public String generateCustomerId(String firstName, String lastName){
        String fullName = firstName+lastName;
        char[] charArray = fullName.toCharArray();
        char first = charArray[0];
        char last = charArray[charArray.length - 1];
        String firstString = Character.toString(first);
        String lastString = Character.toString(last);
        int min = 1000;
        int max = 4000;
//Generate random int value from 200 to 400
        System.out.println("Random value of type int between "+min+" to "+max+ ":");
        int b = (int)(Math.random()*(max-min+1)+min);
        String randomCustId = firstString+lastString+b;
        return randomCustId;
    }
}
