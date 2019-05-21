package com.budova.hostwin;

import net.iryndin.jdbf.core.DbfRecord;
import net.iryndin.jdbf.reader.DbfReader;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class DbfMapReader {
    private static volatile DbfMapReader instance;
    private DbfMapReader(){}

    public static DbfMapReader getInstance() {
        DbfMapReader localInstance = instance;
        if (localInstance == null) {
            synchronized (DbfMapReader.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbfMapReader();
                }
            }
        }
        return localInstance;
    }

    public static HashMap<BigDecimal, Object> dbfReader(File dbfFile) {
        Map<BigDecimal, Object> map = new HashMap<>();
        DbfRecord rec;
        try (DbfReader reader = new DbfReader(dbfFile)){
            while (( rec = reader.read()) != null)
            {
                Object a = rec.toMap().get("N_FLONIT");
                Object b = rec.toMap().get("ALLSPEND");
                BigDecimal c = (BigDecimal) a;
                if(a!=null && b!=null)
                {
                    map.put(c,b);
                }
                else {

                }
            }
            System.out.println(map.entrySet());
            System.out.println(map.toString());
        }
        catch (IOException | ParseException e)
        {
            System.out.println(e);
        }
        return new HashMap<>(map);
    }
}
