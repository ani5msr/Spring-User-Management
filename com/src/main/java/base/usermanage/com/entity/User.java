package base.usermanage.com.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import base.usermanage.com.model.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
	  @SequenceGenerator(name = "user_seq_generator", sequenceName = "user_sequence", allocationSize = 1)
	  private Long id;

	  @Column(name = "EMAIL", nullable = false, unique = true)
	  private String email;
	  private String password;
	  
	  @JsonManagedReference //helps avoid circular dependency in bidirectional mapping
	  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinTable(name = "USER_ROLE", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	  private List<Role> roles = new ArrayList<>();


}
