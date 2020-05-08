package com.codeup.adlister.util;

import java.awt.*;
import java.net.URL;

public class Image {
    public static java.awt.Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    public static void main(String[] args) {
        System.out.println(getImage("images/pikachu_icon.png"));
    }
}
