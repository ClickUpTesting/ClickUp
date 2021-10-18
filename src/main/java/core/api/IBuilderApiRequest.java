/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.api;

import java.io.File;

public interface IBuilderApiRequest {
    ApiRequest build();

    ApiRequestBuilder body(String body);

    ApiRequestBuilder method(Enum<ApiMethod> method);

    ApiRequestBuilder headers(String header, String value);

    ApiRequestBuilder pathParams(String param, String value);

    ApiRequestBuilder endpoint(String endpoint);

    ApiRequestBuilder queryParams(String queryParam, String value);

    ApiRequestBuilder setMultipart(String key, File file);
}
