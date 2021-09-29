package core.utils;

import java.util.HashMap;
import java.util.Map;

public class BaseContext {
    private Map<String, String> pathParams;
    private Map<String, String> pathParamsBase;
    private static BaseContext baseContext;

    public BaseContext() {
        initialize();
    }

    public static BaseContext getBaseContext() {
        if (baseContext == null) {
            baseContext = new BaseContext();
            return baseContext;
        }
        return baseContext;
    }

    public void initialize() {
        pathParams = new HashMap<>();
        pathParamsBase = new HashMap<>();
    }

    /**
     * Gets the map with values of path params.
     *
     * @return Map with values of path params
     * @author Gustavo Huanca
     */
    public Map<String, String> getPathParamsBase() {
        return pathParamsBase;
    }

    /**
     * Sets the values for path params.
     *
     * @param param String with the path params name
     * @param value String with the path params value
     * @author Gustavo Huanca
     */
    public void addPathParamsBase(final String param, final String value) {
        pathParamsBase.put(param, value);
    }
}
