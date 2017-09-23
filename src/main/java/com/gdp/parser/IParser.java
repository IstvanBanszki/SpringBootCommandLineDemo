package com.gdp.parser;

import com.gdp.model.Country;
import com.gdp.model.Organization;
import java.util.List;

public interface IParser {

    List<Country> parsingCountries(String content, Organization org);
}
