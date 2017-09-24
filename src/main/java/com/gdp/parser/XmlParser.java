package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class XmlParser extends AbstractParser implements IParser {

    private final String REGEX = "\\|-";

    public XmlParser() {
        super(Logger.getLogger(XmlParser.class.getName()));
    }
    
    @Override
    public List<Country> parsingCountries(String content, Organization org) {
        List<Country> countryList = new LinkedList<>();
        
        String orgCountries = getOrganizationCountries(content, org);
        String[] countries = orgCountries.split(REGEX);
        
        for (int index = 1; index < countries.length; index ++) {
            if(countries[index].length() > 28) {
                countryList.add(getCountry(countries[index]));
            }
        }
        return countryList;
    }

}
