package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class JsonParser extends AbstractParser implements IParser {
    
    private final String REGEX = "\\\\n\\|-";
    
    @Override
    public List<Country> parsingCountries(String content, Organization org) {
        List<Country> countryList = new LinkedList<>();
        
        String orgCountries = getOrganizationCountries(content, org);
        String[] countries = orgCountries.split(REGEX);
        
        for (int index = 1; index < countries.length; index ++) {
            if(countries[index].length() > 16) {
                countryList.add(getCountry(countries[index]));
            }
        }
        return countryList;
    }
    
    private Country getCountry(String line) {
        String country = line.substring(line.lastIndexOf("flag|")+5, line.lastIndexOf("}}"));
        int gdp = Integer.valueOf(line.substring(line.lastIndexOf("||")+2).replaceAll(",", "").replaceAll(" ", ""));
        return new Country(country, gdp);
    }
    
}
