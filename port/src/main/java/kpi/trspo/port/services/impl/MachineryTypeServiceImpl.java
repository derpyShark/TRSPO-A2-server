package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.MachineryTypeService;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.model.PersonRole;
import kpi.trspo.port.services.repository.CargoTypeRepository;
import kpi.trspo.port.services.repository.MachineryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MachineryTypeServiceImpl implements MachineryTypeService {

    @Autowired
    private MachineryTypeRepository machineryTypeRepository;

    @Override
    public List<MachineryType> getAll() {
        return machineryTypeRepository.findAll();
    }

    @Override
    public MachineryType getById(UUID machineryTypeId) throws NotFoundException {
        Optional<MachineryType> machineryTypeMaybe = machineryTypeRepository.findById(machineryTypeId);
        if(machineryTypeMaybe.isPresent()){
            return machineryTypeMaybe.get();
        }
        else
            throw new NotFoundException("No machineryType with such an Id: " + machineryTypeId);
    }

    @Override
    public MachineryType update(UUID machineryTypeId, MachineryType machineryTypeDetails) throws NotFoundException {
        MachineryType oldMachineryType = getById(machineryTypeId);
        oldMachineryType.setMachineryTypeName(machineryTypeDetails.getMachineryTypeName());
        return machineryTypeRepository.save(oldMachineryType);
    }

    @Override
    public MachineryType create(MachineryType machineryTypeObject) {
        return machineryTypeRepository.save(machineryTypeObject);
    }

    @Override
    public void delete(UUID machineryTypeId) throws NotFoundException{
        machineryTypeRepository.delete(getById(machineryTypeId));
    }
}
