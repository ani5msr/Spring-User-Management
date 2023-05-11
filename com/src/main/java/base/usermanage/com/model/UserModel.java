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
	
}
