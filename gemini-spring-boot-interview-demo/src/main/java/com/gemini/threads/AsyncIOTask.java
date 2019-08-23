package com.gemini.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author xiaocuzi
 * @package com.gemini.threads
 * @classname: AsyncIOTask
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/23 10:48
 * @since 1.0.0
 */
public class AsyncIOTask implements Runnable {


    @Override
    public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            String getURL = "https://www.baidu.com";
            URL getUrl = new URL(getURL);

            connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // empty loop
            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {

                }
            }
            connection.disconnect();
        }

    }
}
