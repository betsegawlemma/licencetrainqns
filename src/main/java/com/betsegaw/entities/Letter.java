package com.betsegaw.entities;

public enum Letter {
    HE("0x1200"),
    LE("0x1208"),
    HEMERUHA("0x1210"),
    ME("0x1218"),
    SE("0x1220"),
    RE("0x1228");

    private String value;
    private Letter(String value)
    {
        this.value = value;
    }

    public String toString()
    {
        return this.value;
    }


}
