package edu.miu.student.domain;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@NotBlank(message = "street  should not be blank ")
    @NotBlank()
    @Size(min = 2,max = 28,message = "city  should not be between  2 and 8")
    private String street;
    //@NotBlank(message="ZipCode   should not be blank ")
    private String zipCode;

    @NotBlank()
    @Size(max = 15, message = " size must be less15 ")
    private String state;
    //@NotBlank(message = "city  should not be blank ")
    private String city;





}
