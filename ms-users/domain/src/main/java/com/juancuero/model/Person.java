package com.juancuero.model;


import com.juancuero.model.abstracts.BaseModel;
import com.juancuero.model.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Person extends BaseModel {
    private String name;
    private Gender gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
}
