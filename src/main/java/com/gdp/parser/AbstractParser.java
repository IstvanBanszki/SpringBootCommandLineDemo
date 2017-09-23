package com.gdp.parser;

import com.gdp.model.Organization;

public class AbstractParser {
    
    protected String getOrganizationCountries(String content, Organization org){
        int from = content.lastIndexOf(getFrom(org));
        int to = content.lastIndexOf(getTo(org));
        return content.substring(from, to);
    }   
    
    private String getFrom(Organization org) {        
        if (org == Organization.IMF) {
            return Organization.IMF.getValue();
        } else if (org == Organization.WB) {
            return Organization.WB.getValue();
        } else {
            return Organization.UN.getValue();
        }
    }
    
    private String getTo(Organization org) {        
        if (org == Organization.IMF) {
            return Organization.WB.getValue();
        } else if (org == Organization.WB) {
            return Organization.UN.getValue();
        } else {
            return "==See also==";
        }
    }
    
}
