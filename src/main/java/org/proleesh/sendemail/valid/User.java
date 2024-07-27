package org.proleesh.sendemail.valid;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class User {
    private Long id;

    @NotNull
    @Size(min = 5, max = 10)
    private String username;

    @NotNull
    private Integer age;

    private String address;

    private String memo;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
