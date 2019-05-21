package com.budova.hostwin.dto;

import com.budova.hostwin.entity.AllSpentEntity;

import java.math.BigDecimal;
import java.util.HashMap;

public class AllSpentDto {
    public static AllSpentEntity getGasMeterIdData(HashMap<BigDecimal, Object> map, BigDecimal gasMeterId) {
        BigDecimal value =(BigDecimal) map.get(gasMeterId);
        double allspentValue = value.doubleValue();
        int GasMeterId = gasMeterId.intValue();
        System.out.println("Газ.счетчик №:" + gasMeterId + "-" + "значение:" + allspentValue + ";");
        return new AllSpentEntity(GasMeterId,allspentValue);
    }
}
