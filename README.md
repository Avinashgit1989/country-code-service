# Country Code service

This is country code application
# Following is the Assumption i have made
* Assumed, Test data will be avialable in H2 testdb
* Created database name testdb

# Table name
* country_code

# API Details
* http://localhost:8081/v1/api/countries/0/4/United/name

      This api will Search countries where the name or iso3Code contains “united” in first page with current page size of 5 and sort by the country name in ascending order.
	  
* http://localhost:8081/v1/api/countries/1/10/iso3Code

      This api will Get second page of countries with current page size of 10 and sort by the country iso3Code in ascending order.

