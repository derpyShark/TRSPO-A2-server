package kpi.trspo.port.services.impl;


import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.HandlingRequestService;
import kpi.trspo.port.services.model.HandlingRequest;
import kpi.trspo.port.services.model.Machinery;
import kpi.trspo.port.services.repository.HandlingRequestRepository;
import kpi.trspo.port.services.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HandlingRequestServiceImpl implements HandlingRequestService {

    @Autowired
    private HandlingRequestRepository handlingRequestRepository;

    @Override
    public List<HandlingRequest> getAll() {
        return handlingRequestRepository.findAll();
    }

    @Override
    public HandlingRequest getById(UUID handlingRequestId) throws NotFoundException {
        Optional<HandlingRequest> handlingRequestMaybe = handlingRequestRepository.findById(handlingRequestId);
        if(handlingRequestMaybe.isPresent()){
            return handlingRequestMaybe.get();
        }
        else
            throw new NotFoundException("No handlingRequest with such an Id: " + handlingRequestId);
    }

    @Override
    public HandlingRequest update(UUID handlingRequestId, HandlingRequest handlingRequestDetails) throws NotFoundException {
        HandlingRequest oldHandlingRequest = getById(handlingRequestId);
        oldHandlingRequest.setContainerToHandle(handlingRequestDetails.getContainerToHandle());
        oldHandlingRequest.setGiverMachinery(handlingRequestDetails.getGiverMachinery());
        oldHandlingRequest.setReceiverMachinery(handlingRequestDetails.getReceiverMachinery());
        return handlingRequestRepository.save(oldHandlingRequest);
    }

    @Override
    public HandlingRequest create(HandlingRequest handlingRequestObject) {
        return handlingRequestRepository.save(handlingRequestObject);
    }

    @Override
    public void delete(UUID handlingRequestId) throws NotFoundException{
        handlingRequestRepository.delete(getById(handlingRequestId));
    }
}
