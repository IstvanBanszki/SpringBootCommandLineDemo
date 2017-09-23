package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import static com.gdp.parser.AbstractParser.LOG;
import java.util.LinkedList;
import java.util.List;
import static java.util.logging.Level.INFO;
import org.springframework.stereotype.Component;

@Component
public class JsonParser extends AbstractParser implements IParser {
    
    private final String REGEX = "\\\\n\\|-";
    
    @Override
    public List<Country> parsingCountries(String content, Organization org) {
        List<Country> countryList = new LinkedList<>();
        
        String orgCountries = getOrganizationCountries(content, org);
        String[] countries = orgCountries.split(REGEX);
        
        for (int index = 1; index <= countries.length; index ++) {
            LOG.log(INFO, "Line {0}", countries[index]);
            countryList.add(getCountry(countries[index]));
        }
        return countryList;
    }
    
    private Country getCountry(String line) {
        String country = line.substring(line.lastIndexOf("flag\\|"), line.lastIndexOf("\\|\\|")-2);
        int gdp = Integer.valueOf(line.substring(line.lastIndexOf("\\|\\|")+2).replaceAll(" ", ""));
        System.out.println(country + gdp);
        return new Country(country, gdp);
    }
    
}
