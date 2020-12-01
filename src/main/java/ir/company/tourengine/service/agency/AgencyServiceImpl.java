package ir.company.tourengine.service.agency;

import ir.company.tourengine.dao.model.Agency;
import ir.company.tourengine.dao.repository.agency.AgencyDAO;
import ir.company.tourengine.service.agency.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    AgencyDAO agencyDAO;

    @Override
    public List<Agency> fetchAgencies(long mobile) throws Exception {
        if(mobile!=0)
        return agencyDAO.getAllAgencies(String.valueOf(mobile));
        else {
            throw new Exception("شماره همراه نادرست می باشد");
        }
    }
}
