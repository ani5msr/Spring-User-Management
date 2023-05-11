package base.usermanage.com.model;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;
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
	@Builder.Default
	private Role userRole = Role.USER;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(simpleGrantedAuthority);
	}

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
