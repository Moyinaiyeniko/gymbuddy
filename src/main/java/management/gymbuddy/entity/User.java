package management.gymbuddy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import management.gymbuddy.enums.PostgreSQLEnumType;
import management.gymbuddy.enums.UserType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

   // @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "usertype")
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    private UserType userType;

    @Column(name = "password")
    private String password;

    @Column(name = "userId")
    private String userId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_role", joinColumns
            = @JoinColumn(name = "users_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "manager_id", nullable = false)
//    private Manager manager;


    @ManyToOne
    @JoinColumn(name = "executive_id")
    private Executive executive;



    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Customer customer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Trainer trainer;

    public User(String password, String email, UserType userType, List<Role> roles) {

        this.password = password;
        this.email = email;
        this.userType = userType;
        this.roles = roles;


    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    //    public Manager getManager() {
//        return manager;
//    }
//
//    public void setManager(Manager manager) {
//        this.manager = manager;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Executive getExecutive() {
        return executive;
    }

    public void setExecutive(Executive executive) {
        this.executive = executive;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
