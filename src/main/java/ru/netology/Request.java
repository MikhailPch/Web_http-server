package ru.netology;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URLEncodedUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class Request {
    public static MultiMap getQueryParams(String url) {

        MultiMap parameters = new MultiValueMap();
        List<NameValuePair> params;
        try {
            params = URLEncodedUtils.parse(new URI(url), Charset.defaultCharset());
            for (NameValuePair param : params) {
                if (param.getName() != null && param.getValue() != null)
                    parameters.put(param.getName(), param.getValue());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return parameters;
    }

    public static String getQueryPath(String url) {
        String result;
        int i = url.indexOf("?");
        if (i == -1) {
            return url;
        }
        result = url.substring(0, i);
        return result;
    }
}
