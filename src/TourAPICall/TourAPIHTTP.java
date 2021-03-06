package TourAPICall;

import Definition.OperationCode;
import Definition.OperationURL;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Jeong Taegyun on 2017-04-10.
 */

public class TourAPIHTTP{
    private final static String SERVICEKEY = "mJOEcE4eFDUTJd8nBIasxDwAws4fIdm64UmPnM6qGSJCmLubYafK9MxfKDmp4P0G71WBf8RQC1a09ebXz%2Ffxig%3D%3D";

    public static String getSERVICEKEY() { return SERVICEKEY; }

    // API 호출, 두 번째 인자로 오퍼레이션 구분
    public Document getNearFestival(HashMap<String, String> paramMap, OperationCode operation){
        if (paramMap == null || paramMap.size() == 0){
            return null;
        }

        String parameters = "?";

        /* URL 파라미터 설정 */
        Set<String> keySet = paramMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        while(iterator.hasNext()){
            String paramKey = iterator.next();
            String paramValue = paramMap.get(paramKey);

            if (parameters.equals("?")){
                parameters += paramKey + "=" + paramValue;
            }
            else{
                parameters += "&" + paramKey + "=" + paramValue;
            }
        }

        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;
        Document document = null;

        /* API 호출 */
        try{
            String url = "";
            switch (operation){
                case LOCATIONBASEDLIST:
                    url = OperationURL.LOCATIONBASEDLISTURL + parameters;
                    break;

                case SEARCHFESTIVAL:
                    url = OperationURL.SEARCHFESTIVAL + parameters;
                    break;

                case DETAILINTRO:
                    url = OperationURL.LOCATIONBASEDLISTURL + parameters;
                    break;

                case AREACODE:
                    url = OperationURL.AREACODE + parameters;
                    break;

                case UNKNOWN:
                    url = "";
                    break;
            }

            URL festivalAPIURL = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) festivalAPIURL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/xml");

            InputStream xml = httpURLConnection.getInputStream();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xml);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return document;
    }
}
