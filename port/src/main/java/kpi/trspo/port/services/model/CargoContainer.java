package kpi.trspo.port.services.model;


import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "cargo_containers")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoContainer {

    @Id
    @GeneratedValue
    private UUID containerId;
    @NotNull
    @Column(name = "cargo_weight")
    private float cargoWeight;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cargo_type_id")
    private CargoType cargoType;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "machinery_id")
    private Machinery machineryWithContainer;

}
