package base.usermanage.com.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@AllArgsConstructor
@Data
public class AuthModel implements GrantedAuthority{
	  private String authority;
}
