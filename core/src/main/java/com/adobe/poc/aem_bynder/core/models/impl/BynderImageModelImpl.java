package com.adobe.poc.aem_bynder.core.models.impl;

import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import com.adobe.poc.aem_bynder.core.models.BynderImageModel;

// Sling Model annotation
@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { BynderImageModel.class, ComponentExporter.class },
    resourceType = BynderImageModelImpl.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter( //Exporter annotation that serializes the modoel as JSON
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class BynderImageModelImpl implements BynderImageModel {
    @ValueMapValue
    private String label; //maps variable to jcr property named "label" persisted by Dialog

    @ValueMapValue
    private String descr;
    
    @ValueMapValue
    private String bynderURL;
    // points to AEM component definition in ui.apps
    static final String RESOURCE_TYPE = "aem-bynder-components/components/bynderimage";

    // public getter method to expose value of private variable `label`
    // adds additional logic to default the label to "(Default)" if not set.

    @Override
    public String getLabel() {
        return StringUtils.isNotBlank(label) ? label : "";
    }

    @Override
    public String getDescr() {
        return  StringUtils.isNotBlank(descr) ? descr : "";
    }
    @Override
    public String getBynderURL() {
        return  StringUtils.isNotBlank(bynderURL) ? bynderURL : "";
    }

    // method required by `ComponentExporter` interface
    // exposes a JSON property named `:type` with a value of `wknd-spa-react/components/open-weather`
    // required to map the JSON export to the SPA component props via the `MapTo`
    @Override
    public String getExportedType() {
        return BynderImageModelImpl.RESOURCE_TYPE;
    }
}
