package com.bolsadeideas.springboot.web.app.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String name;
    private String lastname;
    private String email;

}
