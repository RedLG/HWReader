package com.budova.hostwin;

import java.io.*;

public class FtpDbfLoader {
    private static volatile FtpDbfLoader instance;
    private FtpDbfLoader (){}
    public static FtpDbfLoader getInstance() {
        FtpDbfLoader localInstance = instance;
        if (localInstance == null) {
            synchronized (FtpDbfLoader.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FtpDbfLoader();
                }
            }
        }
        return localInstance;
    }
    public static File dbfLoader(String dbfFilePath){
//        String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
//        String server = "192.168.1.110:2121";
//        String user = "Buger";
//        String password = "Buger12345!";
//        ftpUrl = String.format(ftpUrl, user, password, server, dbfFilePath);
//        System.out.println("Upload URL:" + ftpUrl);
//        URL url = new URL(ftpUrl);
//        URLConnection conn = url.openConnection();
//        BufferedInputStream dbf = new BufferedInputStream(conn.getInputStream());
        File dbf = new File(dbfFilePath);
        return dbf;
    }
}
