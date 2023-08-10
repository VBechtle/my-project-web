import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class User {
    private String userEmail;
    private String userPassword;
    private String userFullName;
}
