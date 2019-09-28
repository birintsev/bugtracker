package ua.edu.sumdu.nc.validation.create.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import ua.edu.sumdu.nc.validation.BTRequest;

@Data
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CreateUserRequest implements BTRequest {

  @JsonProperty(required = true)
  @NotBlank
  private String firstName;

  @JsonProperty(required = true)
  @NotBlank
  private String lastName;

  @JsonProperty(required = true)
  @NotBlank
  private String login;

  @JsonProperty(required = true)
  @NotBlank
  private String password;
}
