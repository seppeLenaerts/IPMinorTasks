package be.ucll.ip.tasks.dto;

import be.ucll.ip.tasks.model.UserRole;

public class UserDTO {
    private Long id;
    private String username;
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
