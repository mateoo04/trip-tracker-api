package com.mateo.trip_tracker_api.service;

import com.mateo.trip_tracker_api.api.model.Employee;
import com.mateo.trip_tracker_api.api.model.TravelLog;
import com.mateo.trip_tracker_api.exception.DatabaseFetchingException;
import com.mateo.trip_tracker_api.repository.EmployeeRepository;
import com.mateo.trip_tracker_api.repository.TravelLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelLogService {
    
    private final TravelLogRepository travelLogRepository;
    private final EmployeeRepository employeeRepository;

    public List<TravelLog> getAllTravelLogs(){
        return travelLogRepository.findAll();
    }

    public TravelLog getTravelLogById(Long id){
        return travelLogRepository.findById(id).orElse(null);
    }

    public TravelLog saveTravelLog(TravelLog travelLog){
        Employee employee = employeeRepository.findById(travelLog.getEmployee().getId())
                .orElseThrow(()-> new DatabaseFetchingException("Employee not found"));
        travelLog.setEmployee(employee);

        return travelLogRepository.save(travelLog);
    }

    public TravelLog updateTravelLog(TravelLog travelLog){
        if(travelLogRepository.existsById(travelLog.getId())){
            return travelLogRepository.save(travelLog);
        }else throw new DatabaseFetchingException("TravelLog not found");
    }

    public void deleteTravelLogById(Long id){
        if(travelLogRepository.existsById(id)){
            travelLogRepository.deleteById(id);
        }else throw new DatabaseFetchingException("Travel log not found");
    }

    public void deleteTravelLogsByEmployeeId(Long employeeId){
        /*travelLogRepository.findAll().stream()
                .filter(travelLog -> travelLog.getEmployee().getId().equals(employeeId))
                .forEach(travelLog -> travelLogRepository.deleteById(travelLog.getId()));*/

        travelLogRepository.deleteAll(travelLogRepository.findTravelLogsByEmployeeId(employeeId));
    }
}
