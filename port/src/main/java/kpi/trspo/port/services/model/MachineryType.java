package kpi.trspo.port.services.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "machinery_types")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineryType {

    @Id
    @GeneratedValue
    private UUID typeId;
    @NotNull
    @Column(name = "type_name")
    private String machineryTypeName;

}
