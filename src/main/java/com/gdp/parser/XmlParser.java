package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class XmlParser extends AbstractParser implements IParser {

    @Override
    public List<Country> parsingCountries(String content, Organization org) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
