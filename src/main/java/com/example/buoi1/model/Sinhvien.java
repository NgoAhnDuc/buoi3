package com.example.buoi1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Sinhvien {

    public Integer id;

    public String name;

    public String address;

    public String gender;

    public String status;
}
