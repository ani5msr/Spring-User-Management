package base.usermanage.com.model;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@Entity(name = "Users")
public class UserModel implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String email;

	private String password;
	@Builder.Default
	private Boolean locked = false;

	@Builder.Default
	private Boolean enabled = false;
	private List<Role> roles = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  Set<AuthModel> authorityModels = new HashSet<>();
	        roles.forEach(
	                role -> {
	                    authorityModels.add(new AuthModel(role.getRoleName()));
	                }
	        );
	        return authorityModels;}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
