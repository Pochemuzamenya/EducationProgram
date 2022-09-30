package org.isu.rpd.services;

import org.isu.rpd.model.Indicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.isu.rpd.repositories.IndicatorRepository;

@Service
public class IndicatorService {

    @Autowired
    IndicatorRepository repository;

    public void save(Indicator indicator){
        repository.saveAndFlush(indicator);
    }
}
