package management.gymbuddy.entity;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "manager")
public class Manager {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        private String email;



        private String userName;


        @Column(name = "firstname")
        private String firstName;

        @Column(name = "lastname")
        private String lastName;


//        @OneToOne(fetch = FetchType.LAZY,
//                cascade =  CascadeType.ALL,
//                mappedBy = "manager")
//        private User user;


        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

//        public User getUser() {
//                return user;
//        }
//
//        public void setUser(User user) {
//                this.user = user;
//        }
}
