package management.gymbuddy.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "executive")
public class Executive {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        @Column(name = "firstname")
        private String firstName;

        @Column(name = "lastname")
        private String lastName;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "executive", cascade = CascadeType.ALL)
        private List<User> user;
//
//        @OneToOne(fetch = FetchType.LAZY,
//                cascade =  CascadeType.ALL,
//                mappedBy = "manager")
//        private User user;


        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public List<User> getUser() {
                return user;
        }

        public void setUser(List<User> user) {
                this.user = user;
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
