package miu.cs.ads_datapersisitence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String fname;
    private String lname;
    @OneToMany
    @JoinColumn(name = "patient")
    @Column(nullable = true)
    private List<Appointment> appointment = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}