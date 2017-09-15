package com.yonyou.energy.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by hugw on 2016/12/1.
 */
public class NumberBigDecimalSerializer extends com.fasterxml.jackson.databind.ser.std.NumberSerializer {
    @Override
    public void serialize(Number value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (value instanceof BigDecimal) {
            ((BigDecimal) value).setScale(8);
        }
        super.serialize(value, jgen, provider);
    }
}
