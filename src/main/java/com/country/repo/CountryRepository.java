package com.country.repo;

import com.country.entity.CountryCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryCode, Integer>{
@Query(value = "SELECT * FROM COUNTRY_CODE  WHERE country_name ILIKE :query%  OR  alpha_three_code ILIKE :query%", nativeQuery = true)
Page<CountryCode> findCountryNameAndAlphaThreeCodeList(String query, Pageable pageable);
    @Query(value = "SELECT * FROM COUNTRY_CODE", nativeQuery = true)
    Page<CountryCode> findAllCountry(Pageable pageable);
}