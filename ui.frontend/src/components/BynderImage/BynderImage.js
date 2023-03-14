import React from 'react';
import {MapTo} from '@adobe/aem-react-editable-components';

// Logic to render placeholder or component
const BynderImageEditConfig = {
    emptyLabel: 'BynderImage',
    isEmpty: function(props) {
        return !props || !props.bynderURL;
    }
};

// Wrapper function that includes react-open-weather component
function BynderImageWrapper(props) {
    let overlays;
    if(props.descr) {
        overlays=<div className="cmp-BynderImage__overlays">
                    <div className="cmp-BynderImage__overlays_descr" dangerouslySetInnerHTML={{__html: props.descr}} />
                </div>
    } else {
        overlays=<div></div>
    }
    
    return (
        <div className="cmp-BynderImage " id={props.id}>
            <img src={props.bynderURL} width="100%" alt={props.label}></img>
            {overlays}
        </div>
    );
}

export default function BynderImage(props) {
        console.log( "################ BynderImage PROPS BEGIN ###############" );
        console.log( props );
        console.log( "################ BynderImage PROPS END ###############" );

        // render nothing if component not configured
        if (BynderImageEditConfig.isEmpty(props)) {
            return null;
        }

        // render ReactWeather component if component configured
        // pass props to BynderImageWrapper. These props include the mapped properties from AEM JSON
        return BynderImageWrapper(props);

}

// Map BynderImage to AEM component    Left(AEM Bynder COMPONENT, Data ) -- RIGHT(RECT COMPONENT, How to display)
MapTo('aem-bynder-components/components/bynderimage')(BynderImage, BynderImageEditConfig);
