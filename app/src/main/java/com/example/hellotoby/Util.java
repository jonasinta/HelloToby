package com.example.hellotoby;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Nirmal Dhara on 12-07-2015.
 * copied from http://javaant.com/how-to-use-properties-file-in-android/#.X2Yuq4ZS_k3
 */
public class Util {
    public static String getProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("config.properties.xml");
        properties.load(inputStream);
        return properties.getProperty(key);
    }
}