package ru.netology;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URLEncodedUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class Request {
    private String method;
    private String path;
    private String version;
    private List<NameValuePair> queryParams;

    public void setMethod(String method){
        this.method = method;
    }
    public String getMethod(){
        return method;
    }
    public void setPath (String path){
        int indexDelimiter = path.indexOf('?');
        if (indexDelimiter != -1) {
            this.path = path.substring(0, indexDelimiter);
        }
    }
    public String getPath(){
        return path;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return version;
    }
    public void setQueryParams(String path) {
        int indexDelimiter = path.indexOf('?');
        if (indexDelimiter == -1) return;
        queryParams = URLEncodedUtils.parse(path.substring(indexDelimiter + 1), Charset.defaultCharset());
    }
    public List<NameValuePair> getQueryParams(){
        return queryParams;
    }
    public Optional<String> getQueryParam(String nameParam) {
        return queryParams.stream()
                .filter(o -> o.getName().equals(nameParam))
                .map(NameValuePair::getValue)
                .findFirst();
    }

}
