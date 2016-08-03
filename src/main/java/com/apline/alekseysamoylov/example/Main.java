package com.apline.alekseysamoylov.example;

import com.sleepycat.db.DatabaseException;
import com.sleepycat.db.Environment;
import com.sleepycat.db.EnvironmentConfig;
import com.sleepycat.dbxml.XmlException;
import com.sleepycat.dbxml.XmlManager;
import com.sleepycat.dbxml.XmlManagerConfig;

import java.io.File;
import java.io.FileNotFoundException;

import static com.sleepycat.dbxml.XmlManager.CATEGORY_ALL;
import static com.sleepycat.dbxml.XmlManager.LEVEL_ALL;

/**
 * Created by asamoilov on 02.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Environment myEnv = null;
        XmlManager myManager = null;
        File envHome = new File("c:\\database\\files");
        // Open an XmlManager
        try {
            // Set the error handler for this application
            EnvironmentConfig envConf = new EnvironmentConfig();
            MyErrorHandler meh = new MyErrorHandler();
            envConf.setErrorHandler(meh);
            myEnv = new Environment(envHome, envConf);
            myManager = new XmlManager(myEnv, new XmlManagerConfig());
            XmlManager.setLogLevel(LEVEL_ALL, true);
            XmlManager.setLogCategory(CATEGORY_ALL, true);
        } catch (XmlException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}
