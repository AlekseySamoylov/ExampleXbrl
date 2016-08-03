package com.apline.alekseysamoylov.example;

import com.sleepycat.dbxml.*;

import java.io.FileNotFoundException;

/**
 * Created by asamoilov on 03.08.2016.
 */
public class XQueryXmlLoad {
    public static void main(String[] args) {
        XmlManager myManager = null;
        XmlContainer myContainer = null;

        try {
            myManager = new XmlManager();
            myContainer = myManager.openContainer("container.bdbxml");
            XmlQueryContext context = myManager.createQueryContext();

//            XmlDocument document = myContainer.getDocument("doc4");
//            System.out.println(document.getContentAsString());

            XmlResults results = myManager.query("collection('container.bdbxml')/bookstore/book/author/string()", context);
            while (results.hasNext()) {
                System.out.println(results.next().asString());
            }


        } catch (XmlException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
