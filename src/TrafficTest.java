import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import httpclient.HttpProtocolHandler;
import httpclient.HttpRequest;
import httpclient.HttpResponse;
import httpclient.HttpResultType;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.httpclient.NameValuePair;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by I330347 on 7/19/2016.
 */
public class TrafficTest {
    private static HashMap<String,String> posMap= new HashMap<>();
    //private static HashMap<String,String> roadMap = new HashMap<>();
    public static void TranslateText(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s=bufferedReader.readLine();
        while ((s=bufferedReader.readLine())!=null){
            String[] eachline = s.split(";");
            posMap.put(eachline[0].trim(),eachline[1]+"_"+eachline[2]);
        }
    }

    public static String BuilderConnection(String LAT,String LNG) {
        /**HttpRequest httpRequest = new HttpRequest(HttpResultType.STRING);
        httpRequest.setUrl("http://api.map.baidu.com/geocoder/v2");
        httpRequest.setCharset("UTF-8");
        //httpRequest.setParameters(nameValuePairs);
        httpRequest.setMethod(HttpRequest.METHOD_GET);
        httpRequest.setQueryString("ak=E4805d16520de693a3fe707cdc962045&callback=renderReverse&location=32.05185,118.77892&output=json&pois=1");
        try {
            HttpResponse httpResponse= HttpProtocolHandler.getInstance().execute(httpRequest,"","");
            String result = httpResponse.getStringResult();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }**/
        HttpURLConnection conn = null;
        String location = LAT+","+LNG;//"32.061146,118.77844";
        String ak = "ak=djnwsINbZGWnhoKi8yo8tZW9z6Lf9KOq";
        int poi =0;
        String url = "http://api.map.baidu.com/geocoder/v2/?"+ak+"&"+"location="+location+"&output=json&pois="+poi;
        URL mURL = null;
        try {
            mURL = new URL(url);
            conn = (HttpURLConnection) mURL.openConnection();
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(10000);
            InputStream inputStream = conn.getInputStream();
            byte[] buff = new byte[1024*5];
            inputStream.read(buff);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(buff);
            String result =byteArrayOutputStream.toString().trim();
            JSONObject jsonObject0 =  JSON.parseObject(result);
            JSONObject jsonObject1 = (JSONObject)jsonObject0.get("result");
            JSONObject jsonObject2 = (JSONObject)jsonObject1.get("addressComponent");
            String road = (String)jsonObject2.get("street");
            System.out.println(road);
            return  road;
            /**HashMap hashMap = new HashMap(jsonObject0.size());
            for (Iterator<Map.Entry<String,Object>> i =jsonObject0.entrySet().iterator();i.hasNext();){
                Map.Entry entry =i.next();

            }
            System.out.println(result);**/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\I330347\\Desktop\\44.txt")));
            TranslateText(new File("C:\\Users\\I330347\\Desktop\\33.txt"));
            for (int i = 1; i <= 30; i++) {
                System.out.println(String.valueOf(i));
                //System.out.println("1".hashCode()==String.valueOf(i).hashCode());
                String value = posMap.get(String.valueOf(i));
                String[] pos = value.split("_");
                System.out.println(pos[0]);
                System.out.println(pos[1]);
                String road = BuilderConnection(pos[0].trim(), pos[1].trim());
                bufferedWriter.write(road + "\r\n");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

