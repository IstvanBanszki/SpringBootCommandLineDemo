package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class JsonParser extends AbstractParser implements IParser {
    
    private final String REGEX = "\\\\n\\|-";
    
    public JsonParser() {
        super(Logger.getLogger(JsonParser.class.getName()));
    }
    
    @Override
    public List<Country> parsingCountries(String content, Organization org) {
        List<Country> countryList = new LinkedList<>();
        
        String orgCountries = getOrganizationCountries(content, org);
        String[] countries = orgCountries.split(REGEX);
        
        for (int index = 1; index < countries.length; index ++) {
            if(countries[index].length() > 26) {
                countryList.add(getCountry(countries[index]));
            }
        }
        return countryList;
    }
    
}
