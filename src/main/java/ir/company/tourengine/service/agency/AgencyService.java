package ir.company.tourengine.service.agency;

import ir.company.tourengine.dao.model.Agency;

import java.util.List;

public interface AgencyService {
    List<Agency> fetchAgencies(long mobile) throws Exception;
}
