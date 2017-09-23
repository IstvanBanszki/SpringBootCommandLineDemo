package com.gdp.api;

import com.gdp.model.ContentFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WikipediaApi implements IWikipediaApi {

    private final String BASE_URL = "https://en.wikipedia.org/w/api.php?";
    private final String ACTION_PARAM = "action=query";
    private final String TITLE_PARAM = "&titles=";
    private final String PROP_PARAM = "&prop=revisions";
    private final String RVPROP_PARAM = "&rvprop=content";
    private final String FORMAT_PARAM = "&format=";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public String getPageContent(String title, ContentFormat format) {
       String content = "";
       String uri = new StringBuilder(BASE_URL)
               .append(ACTION_PARAM)
               .append(TITLE_PARAM).append(title)
               .append(PROP_PARAM)
               .append(RVPROP_PARAM)
               .append(FORMAT_PARAM).append(format.getValue())
               .toString();
       try {
           content = this.restTemplate.getForObject(uri, String.class);
       } catch(Exception ex) {
           ex.printStackTrace();
       }
       return content;
    }
    
}
