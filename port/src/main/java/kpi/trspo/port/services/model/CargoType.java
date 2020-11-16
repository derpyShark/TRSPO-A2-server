package kpi.trspo.port.services.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "cargo_types")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoType {

    @Id
    @GeneratedValue
    private UUID cargoTypeId;
    @NotNull
    @Column(name = "cargo_type_name")
    private String cargoTypeName;

}
