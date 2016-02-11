package com.example.cice.openweathermapjson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by CICE on 9/2/16.
 */
public class HttpRequestHelper {

    HttpURLConnection connection;

    public HttpRequestHelper() {
    }

    public String getResponseFromUrl(String url) throws HttpException {
        return openConnection(url).getResponse();
    }

    private HttpRequestHelper openConnection(String stringUrl) throws HttpException {


        try {
            URL url = new URL(stringUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
        }catch (IOException e) {
            throw new HttpException("No se pudo conectar con el servidor");
        }
        return this;

    }

    private String getResponse() throws HttpException {
        InputStream inputStream;
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                return IOUtils.toString(inputStream);

                //tarda mas pero es una solucion valida.
            /*
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine())!= null){
                    total.append(line);
            }
            */

            } else {
                throw new HttpException("No se pudo conectar con el servidor");
        }
        }catch(IOException e){
            e.getMessage();
            throw new HttpException("No se pudo conectar con el servidor");
        }
    }

    public static String createQuery(HashMap<String, String> params){

        StringBuilder query = new StringBuilder();
        query.append("?");
        for(HashMap.Entry<String, String> entry : params.entrySet()){
            query.append(entry.getKey() + "=" +entry.getValue());
            query.append("&");
        }
        query.deleteCharAt(query.length()-1);
        return query.toString();
    }

}


