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
@Table(name = "machinery")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machinery {

    @Id
    @GeneratedValue
    private UUID machineryId;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person operator;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private MachineryType machineryType;

}
