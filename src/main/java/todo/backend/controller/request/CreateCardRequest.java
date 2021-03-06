package todo.backend.controller.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCardRequest {

	@NotBlank
	@Size(max = 20)
	private String title;

	@Pattern(regexp = "^[가-힣a-zA-Z0-9]{1,15}+$")
	private String assignee;

	@Min(1)
	@Max(3)
	private Integer priority;
}
