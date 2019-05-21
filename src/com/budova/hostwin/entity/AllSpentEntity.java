package com.budova.hostwin.entity;


public class AllSpentEntity {
    public final static double MODULATION_VALUE = 0.01;
    public final static double MODULATION_TIME = 60000;
    private final int gasMeterId;
    private final double allspentValue;
    private final long time;

    public AllSpentEntity (int gasMeterId, double allspentValue, long time) {
        this.gasMeterId = gasMeterId;
        this.allspentValue = allspentValue;
        this.time = time;
    }

    public AllSpentEntity(int gasMeterId, double allspentValue) {
        this(gasMeterId, allspentValue, System.currentTimeMillis());
    }

    public int getGasMeterId() {
        return gasMeterId;
    }

    public double getValue() {
        return allspentValue;
    }

    public long getTime() {
        return time;
    }

    public boolean isModuled( AllSpentEntity entity) {
        if (entity == this) return false;
        else if (entity == null) return true;
        return  ((Math.abs(this.allspentValue - entity.getValue()) > MODULATION_VALUE)|| (Math.abs(this.time - entity.getTime()) > MODULATION_TIME));

    }
}
//    @Override
//    public String toString() {
//        return "AllSpentEntity{" +
//                "gasMeterId=" + gasMeterId +
//                ", value=" + value +
//                ", time=" + time +
//                '}';
//    }
//}
