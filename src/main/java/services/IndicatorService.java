package services;

import model.Indicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IndicatorRepository;

@Service
public class IndicatorService {

    @Autowired
    IndicatorRepository repository;

    public void save(Indicator indicator){
        repository.saveAndFlush(indicator);
    }
}
