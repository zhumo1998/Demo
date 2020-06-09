package com.yj.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
}
