package kpi.trspo.port.services.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.crypto.Mac;
import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "handling_requests")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandlingRequest {

    @Id
    @GeneratedValue
    private UUID handlingRequestId;
    @ManyToOne
    @JoinColumn(name = "container_id")
    private CargoContainer containerToHandle;
    @ManyToOne
    @JoinColumn(name = "giver_machinery_id")
    private Machinery giverMachinery;
    @ManyToOne
    @JoinColumn(name = "receiver_machinery_id")
    private Machinery receiverMachinery;




}
