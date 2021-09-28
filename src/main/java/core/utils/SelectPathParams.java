package core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPathParams {

    public List<String> getPathParamsInEndPoint(String endPoint) {
        List<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        boolean isOpen = false;
        for (int i = 0; i < endPoint.length(); i++) {
            if (endPoint.charAt(i) == '{') {
                isOpen = true;
            }
            if (endPoint.charAt(i) == '}') {
                isOpen = false;
                list.add(word.toString());
                word = new StringBuilder();
            }
            if (endPoint.charAt(i) != '{' && isOpen) {
                word.append(endPoint.charAt(i));
            }
        }
        return list;
    }

    public Map<String, String> getMapFollowEndpoint(Map<String, String> mapPathParam , String endPoint){
        Map<String, String> mapValues = new HashMap<>();
        List<String> pathParamsInEndPoint = getPathParamsInEndPoint(endPoint);
        pathParamsInEndPoint.forEach(value -> mapValues.put(value,mapPathParam.get(value)));
        return mapValues;
    }
}
