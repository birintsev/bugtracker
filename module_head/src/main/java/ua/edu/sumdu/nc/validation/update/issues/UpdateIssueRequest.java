package ua.edu.sumdu.nc.validation.update.issues;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.sumdu.nc.validation.BTRequest;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UpdateIssueRequest implements BTRequest {
@Min(value = 0)
    @JsonProperty(required = true)
    private Long issueId;
    @Min(value = 0)
    private Long assigneeId;
    private String body;
    private String title;
    @Min(value = 0)
    private Integer statusId;
    @Min(value = 0)
    private Integer projectId;
}