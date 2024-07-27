package org.proleesh.sendemail.valid;

import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class ResponseBodyController {
    @CrossOrigin
    @GetMapping(value = "/user/json/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getJsonUserInfo(@PathVariable("userId") @Size(min=5, max=8) Long userId) {
        User user = new User("Java Stack", 18);
        user.setId(Long.valueOf(userId));
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping(value = "/user/save")
    public ResponseEntity saveUser(@RequestBody @Validated User user) {
        user.setId(user.getId());
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
