package management.gymbuddy.dto;

import management.gymbuddy.entity.User;

public class CreateNewExecutiveDTO {
    private String firstName;

    private String lastName;


private User user;

    public String getFirstName() {
        return firstName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


}
