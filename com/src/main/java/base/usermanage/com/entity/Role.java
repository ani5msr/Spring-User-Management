package base.usermanage.com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "ROLE_TABLE")
public class Role {
	   @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_generator")
	   @SequenceGenerator(name="role_seq_generator", sequenceName = "role_sequence", allocationSize=1)
	   private Long roleId;

	    private String roleName;

	    @JsonBackReference
	    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
	    private Set<User> users = new HashSet<>();

}
