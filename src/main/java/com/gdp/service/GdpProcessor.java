package com.gdp.service;

import com.gdp.api.IWikipediaApi;
import com.gdp.model.ContentFormat;
import com.gdp.model.Organization;
import com.gdp.parser.JsonParser;
import com.gdp.parser.XmlParser;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.logging.Level.INFO;

@Service
public class GdpProcessor implements IGdpProcessor {

    private static final Logger LOG = Logger.getLogger(GdpProcessor.class.getName());
    private static final String TITLE = "List_of_countries_by_GDP_(nominal)_per_capita";

    @Autowired
    private IWikipediaApi api;
    @Autowired
    private JsonParser jsonParser;
    @Autowired
    private XmlParser xmlParser;

    @Override
    public void getCountries(Organization org, ContentFormat format) {

        LOG.log(INFO, "Get countries with following params - org:{0}, format{1}", new Object[]{org, format});
        if (org == null || format == null) {
            throw new IllegalArgumentException();
        }

        String content = api.getPageContent(TITLE, format);
        LOG.log(INFO, "Content length - {0} getting from - {1}", new Object[]{content.length(), TITLE});

        switch (format) {
            case JSON:
                this.jsonParser.parsingCountries(content, org);
                break;
            case XML:
                this.xmlParser.parsingCountries(content, org);
                break;
            default:
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        }
    }

}
