package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;

public class AbstractParser {
    
    private final Logger logger;
    
    public AbstractParser(Logger logger) {
        this.logger = logger;
    }
    
    private static final String ORG_SUFFIX = "--";
    private static final String ORG_POSTFIX = "--";
    
    protected String getOrganizationCountries(String content, Organization org){
        int from = content.indexOf(getFrom(org));
        int to = content.indexOf(getTo(org));
        String subContent = content.substring(from, to);
        logger.log(INFO, "SubContent length - {0}", subContent.length());
        return subContent;
    }   
    
    protected Country getCountry(String line) {
        String countryName = line.substring(line.lastIndexOf("flag|")+5, line.lastIndexOf("}}"));
        String number = line.substring(line.lastIndexOf("||")+2)
                .replaceAll(",", "")
                .replaceAll("[\\D\\s]", "");
        int gdp = Integer.valueOf(number);
        Country country = new Country(countryName, gdp);
        logger.log(INFO, "Processed - {0}", country);
        return country;
    }
    
    private String getFrom(Organization org) {     
        String from;
        if (org == Organization.IMF) {
            from = Organization.IMF.getValue();
        } else if (org == Organization.WB) {
            from = Organization.WB.getValue();
        } else {
            from = Organization.UN.getValue();
        }
        return ORG_SUFFIX + from + ORG_POSTFIX;
    }
    
    private String getTo(Organization org) {    
        String to;       
        if (org == Organization.IMF) {
            to = ORG_SUFFIX + Organization.WB.getValue() + ORG_POSTFIX;
        } else if (org == Organization.WB) {
            to = ORG_SUFFIX + Organization.UN.getValue() + ORG_POSTFIX;
        } else {
            to = "==See also==";
        }
        return to;
    }
    
}
