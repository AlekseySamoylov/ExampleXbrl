package com.apline.alekseysamoylov.example;

import com.sleepycat.dbxml.XmlContainer;
import com.sleepycat.dbxml.XmlException;
import com.sleepycat.dbxml.XmlInputStream;
import com.sleepycat.dbxml.XmlManager;

import java.io.FileNotFoundException;

/**
 * Created by asamoilov on 03.08.2016.
 */
public class StreamXmlSave {
    public static void main(String[] args) {
        XmlManager myManager = null;
        XmlContainer myContainer = null;

        String docString = "NPF-nadzor-statistica.xsd";

        String docName = "doc4";

        try {
            myManager = new XmlManager();
            myContainer = myManager.openContainer("container.bdbxml");
            XmlInputStream theStream = myManager.createLocalFileInputStream(docString);

            myContainer.putDocument(docName, theStream);
        } catch (XmlException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (myContainer != null)
                myContainer.close();
            } catch (XmlException e) {
                e.printStackTrace();
            }
            try {
                if (myManager != null)
                myManager.close();
            } catch (XmlException e) {
                e.printStackTrace();
            }
        }

    }

}
