package com.budova.hostwin.task;

import com.budova.hostwin.DbfMapReader;
import com.budova.hostwin.FtpDbfLoader;
import com.budova.hostwin.dao.AllSpentDao;
import com.budova.hostwin.dto.AllSpentDto;
import com.budova.hostwin.entity.AllSpentEntity;
import com.budova.hostwin.dto.FromDB;
import java.io.BufferedInputStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;

public class SingleGasMeterDbfReaderTask extends Thread{
    private long period;
    private String dbfFilePath;
    private int gasMeterId;

    public SingleGasMeterDbfReaderTask(long period, String dbfFilePath,int GasMeterId) {
        this.period = period;
        this.dbfFilePath = dbfFilePath;
        this.gasMeterId = GasMeterId;
    }

    @Override
    public synchronized void start() {
        try {
//            BufferedInputStream dbf = FtpDbfLoader.method(dbfFilePath);
            File dbf = FtpDbfLoader.getInstance().dbfLoader(dbfFilePath);
            HashMap<BigDecimal, Object> map = DbfMapReader.getInstance().dbfReader(dbf);
//            Поместить в Singleton 26-27 строку
            AllSpentEntity entityFromDto = AllSpentDto.getGasMeterIdData(map, BigDecimal.valueOf(11481));
            AllSpentEntity entityFromDao = FromDB.getLast(11481);
            System.out.println(entityFromDto.isModuled(entityFromDao));
            if (entityFromDto.isModuled(entityFromDao))
            {
                AllSpentDao.put(entityFromDto);
                Thread.sleep(period);
            }
            else Thread.sleep(period/2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
