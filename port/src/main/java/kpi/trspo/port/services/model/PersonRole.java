package kpi.trspo.port.services.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "person_roles")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRole {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private UUID roleId;
    @NotNull
    @Column(name = "role_name")
    private String roleName;

}
