package com.country.service.impl;

import com.country.constant.CountryConstants;
import com.country.entity.CountryCode;
import com.country.repo.CountryRepository;
import com.country.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Page<CountryCode> getListOfCountry(int page, int size, String query, String sort) {
        log.info("Enter into getListOfCountry method with [PAGE]: {}, [SIZE] :{} ,[QUERY] :{}, [SORT] :{}", page,size,query,sort);
       String sortBy ="";
       Page<CountryCode> countryResponse= null;
       Pageable pageable = null;
       try {
           if(sort.equalsIgnoreCase(CountryConstants.NAME)){
               pageable = PageRequest.of(page, size, Sort.by(CountryConstants.COUNTRY_NAME).ascending());
           }else{
               throw new RuntimeException("You have not provided expected input");
           }
           countryResponse = countryRepository.findCountryNameAndAlphaThreeCodeList(query,pageable);
       }catch (Exception e){
           log.error("Error while fetching country List with [PAGE]: {}, [SIZE] :{} ,[QUERY] :{}, [SORT] :{}, [EXCEPTION] :{}",page,size,query,sort,e);
       }
        return countryResponse;
    }

    @Override
    public Page<CountryCode> getListOfCountryBySort(int page, int size, String sort) {
        log.info("Enter into getListOfCountryBySort method with [PAGE]: {}, [SIZE] :{} , [SORT] :{}", page, size, sort);

        Page<CountryCode> countryResponse = null;
        Pageable pageable = null;
        try {
            if (sort.equalsIgnoreCase(CountryConstants.ISO3CODE)) {
                 pageable = PageRequest.of(page, size, Sort.by(CountryConstants.ALPHA_THREE_CODE).ascending());
            }else{
                throw new RuntimeException("You have not provided expected input");
            }
            countryResponse = countryRepository.findAllCountry(pageable);
        } catch (Exception e) {
            log.info("Error into getListOfCountryBySort method with [PAGE]: {}, [SIZE] :{} , [SORT] :{}, [EXCEPTION] :{}", page, size, sort, e);
        }
        return countryResponse;
    }
}
