package org.proleesh.sendemail.ioctest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private long id;
    private String username;
    private String note;
}
