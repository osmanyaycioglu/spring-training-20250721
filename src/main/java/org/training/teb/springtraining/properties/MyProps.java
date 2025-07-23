package org.training.teb.springtraining.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

// Camel --- longDescription
// Snake --- long_description
// kebap --- long-description
// Pascal -- LongDescription

@Component
@ConfigurationProperties(prefix = "my.app")
@Data
public class MyProps {
    private String                language;
    private int                   port;
    private String                longDescription;
    private List<String>          nickNames;
    private SubProps              subProps;
    private List<SubProps>        allSubProps;
    private Map<String, SubProps> subPropsMap;

}
