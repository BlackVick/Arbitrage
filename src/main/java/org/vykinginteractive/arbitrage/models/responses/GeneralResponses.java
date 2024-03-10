package org.vykinginteractive.arbitrage.models.responses;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class GeneralResponses {

    public static ResponseEntity<Object> respondLoginSuccess(HttpStatus code, boolean status, String message, String token, Object data) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status);
        if (!StringUtils.isEmpty(message))
            map.put("message", message);
        map.put("token", token);
        map.put("data", data);

        return new ResponseEntity<Object>(map, code);
    }

    public static ResponseEntity<Object> respondSuccessData(HttpStatus code, boolean status, String message, Object data) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status);
        if (!StringUtils.isEmpty(message))
            map.put("message", message);
        map.put("data", data);

        return new ResponseEntity<Object>(map, code);
    }

    public static ResponseEntity<Object> respondSuccess(HttpStatus code, boolean status, String message) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status);
        if (!StringUtils.isEmpty(message))
            map.put("message", message);

        return new ResponseEntity<Object>(map, code);
    }

    public static ResponseEntity<Object> respondPaginatedData(HttpStatus code, boolean status, Object data, PaginationMetaData metadata) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status);
        map.put("data", data);
        if (metadata != null)
            map.put("metadata", metadata);

        return new ResponseEntity<Object>(map, code);
    }

}
