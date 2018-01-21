package com.springboot.springbootmybatisredis.entity;


import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 134716687127740331L;

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer age;
}