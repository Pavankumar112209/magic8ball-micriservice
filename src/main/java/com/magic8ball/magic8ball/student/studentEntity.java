package com.magic8ball.magic8ball.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "StudentDetails")
@Entity
public class studentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StudentId;
    private String StudentFirstName;
    private String StudentLastName;
    private String StudentEmail;
    private String StudentPhoneNumber;


}
