package com.adobe.poc.aem_bynder.core.models;

import com.adobe.cq.export.json.ComponentExporter;

// Sling Models intended to be used with SPA Editor must extend ComponentExporter interface
public interface BynderImageModel extends ComponentExporter {
    public String getLabel();
    public String getDescr();
    public String getBynderURL();
}