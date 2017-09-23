package com.gdp.api;

import com.gdp.model.ContentFormat;

public interface IWikipediaApi {
    
    String getPageContent(String title, ContentFormat format);
}
