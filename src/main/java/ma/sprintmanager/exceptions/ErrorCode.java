package ma.sprintmanager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    RESOURCE_NOT_FOUND(100),
    RESOURCE_NOT_VALID(200),
    PROJECT_NOT_FOUND(300),
    PROJECT_NOT_VALID(400),
    SPRINT_NOT_FOUND(500),
    SPRINT_NOT_VALID(600),
    TASK_NOT_FOUND(700),
    TASK_NOT_VALID(800);

    private Integer code;

}
