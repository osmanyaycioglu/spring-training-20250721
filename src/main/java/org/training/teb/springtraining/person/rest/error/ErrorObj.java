package org.training.teb.springtraining.person.rest.error;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorObj {
    private List<ErrorObj> subErrorObjs;
    private String errorDescription;
    private int errorCode;

    @Builder(setterPrefix = "with")
    public ErrorObj(final List<ErrorObj> subErrorObjsParam,
                    final String errorDescriptionParam,
                    final int errorCodeParam) {
        subErrorObjs     = subErrorObjsParam;
        errorDescription = errorDescriptionParam;
        errorCode        = errorCodeParam;
    }
}
