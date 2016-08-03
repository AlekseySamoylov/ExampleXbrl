package com.apline.alekseysamoylov.example;

import com.sleepycat.dbxml.XmlContainer;
import com.sleepycat.dbxml.XmlException;
import com.sleepycat.dbxml.XmlManager;

import java.io.FileNotFoundException;

/**
 * Created by asamoilov on 03.08.2016.
 */
public class FirstXmlSave {



    public static void main(String[] args) {
        XmlManager myManager = null;
        XmlContainer myContainer = null;

        String docString = "" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "" +
                "<bookstore>" +
                "" +
                "<book category=\"COOKING\">" +
                "  <title lang=\"en\">Everyday Italian</title>" +
                "  <author>Giada De Laurentiis</author>" +
                "  <year>2005</year>" +
                "  <price>30.00</price>" +
                "</book>" +
                "" +
                "<book category=\"CHILDREN\">" +
                "  <title lang=\"en\">Harry Potter</title>" +
                "  <author>J K. Rowling</author>" +
                "  <year>2005</year>" +
                "  <price>29.99</price>" +
                "</book>" +
                "" +
                "<book category=\"WEB\">" +
                "  <title lang=\"en\">XQuery Kick Start</title>" +
                "  <author>James McGovern</author>" +
                "  <author>Per Bothner</author>" +
                "  <author>Kurt Cagle</author>" +
                "  <author>James Linn</author>" +
                "  <author>Vaidyanathan Nagarajan</author>" +
                "  <year>2003</year>" +
                "  <price>49.99</price>" +
                "</book>" +
                "" +
                "<book category=\"WEB\">" +
                "  <title lang=\"en\">Learning XML</title>" +
                "  <author>Erik T. Ray</author>" +
                "  <year>2003</year>" +
                "  <price>39.95</price>" +
                "</book>" +
                "" +
                "</bookstore> ";

        String docName = "testDoc3";

        try {
            myManager = new XmlManager();

            myContainer = myManager.openContainer("container.bdbxml");

            myContainer.putDocument(docName, docString);

        } catch (XmlException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (myContainer != null) {
                try {
                    myContainer.close();
                } catch (XmlException e) {
                    e.printStackTrace();
                }
            }
            if (myManager != null) {
                try {
                    myManager.close();
                } catch (XmlException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
