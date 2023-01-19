package com.country.service;

import com.country.entity.CountryCode;
import org.springframework.data.domain.Page;

public interface CountryService {
    Page<CountryCode> getListOfCountry(int page, int size, String q, String sort) throws Exception;

    Page<CountryCode> getListOfCountryBySort(int page, int size, String sort)throws Exception;
}
