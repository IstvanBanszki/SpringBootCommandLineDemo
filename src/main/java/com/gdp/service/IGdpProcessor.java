package com.gdp.service;

import com.gdp.model.ContentFormat;
import com.gdp.model.Organization;

public interface IGdpProcessor {
    
    void getCountries(Organization org, ContentFormat format);

}
