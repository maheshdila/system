package com.devstack.healthcare.system.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    private long id;
    private String roleName;
    private String description;
    @OneToMany(mappedBy = "userRole")
    @Column()
    private Set<UserRoleHasUser> userRoleHasUsers;
}
