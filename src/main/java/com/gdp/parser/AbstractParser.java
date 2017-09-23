package com.gdp.parser;

import com.gdp.model.Organization;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;

public class AbstractParser {
    
    protected static final Logger LOG = Logger.getLogger(AbstractParser.class.getName());
    
    private static final String ORG_SUFFIX = "<!--";
    private static final String ORG_POSTFIX = "-->";
    
    protected String getOrganizationCountries(String content, Organization org){
        int from = content.lastIndexOf(ORG_SUFFIX+getFrom(org)+ORG_POSTFIX);
        int to = content.lastIndexOf(ORG_SUFFIX+getTo(org)+ORG_POSTFIX);        
        String subContent =content.substring(from, to);
        LOG.log(INFO, "SubContent length - {0} value - {1}", new Object[] {subContent.length(), subContent});
        return subContent;
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
