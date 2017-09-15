package com.yonyou.energy.common.util;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonBinder
{
  private static final Logger logger = LoggerFactory.getLogger(JsonBinder.class);
  private ObjectMapper mapper;

  public JsonBinder(JsonSerialize.Inclusion inclusion)
  {
    this.mapper = new ObjectMapper();

    this.mapper.setSerializationInclusion(inclusion);

    this.mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    setDateFormat("yyyy-MM-dd HH:mm:ss");
  }

  public static JsonBinder buildNormalBinder()
  {
    return new JsonBinder(JsonSerialize.Inclusion.ALWAYS);
  }

  public static JsonBinder buildNonNullBinder()
  {
    return new JsonBinder(JsonSerialize.Inclusion.NON_NULL);
  }

  public static JsonBinder buildNonEmptyBinder()
  {
    return new JsonBinder(JsonSerialize.Inclusion.NON_EMPTY);
  }

  public static JsonBinder buildNonDefaultBinder()
  {
    return new JsonBinder(JsonSerialize.Inclusion.NON_DEFAULT);
  }

  public <T> T fromJson(String jsonString, Class<T> clazz)
  {
    if (StringUtils.isEmpty(jsonString)) {
      return null;
    }
    try
    {
      return this.mapper.readValue(jsonString, clazz);
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonString, e);
      throw new RuntimeException(e);
    }
  }

  public <T> List<T> fromJsonArray(String jsonArray, Class<T> clazz)
  {
    if (StringUtils.isEmpty(jsonArray)) {
      return null;
    }
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    try {
      return (List)this.mapper.readValue(jsonArray, typeFactory.constructCollectionType(ArrayList.class, clazz));
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonArray, e);
      throw new RuntimeException(e);
    }
  }

  public Collection fromJsonArrayBy(String jsonArray, Class recordClazz, Class collectionClazz)
  {
    if (StringUtils.isEmpty(jsonArray)) {
      return null;
    }
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    try {
      return (Collection)this.mapper.readValue(jsonArray, typeFactory.constructCollectionType(collectionClazz, recordClazz));
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonArray, e);
      throw new RuntimeException(e);
    }
  }

  public String toJson(Object object)
  {
    try
    {
      return this.mapper.writeValueAsString(object);
    } catch (IOException e) {
      logger.warn("write to json string error:" + object, e);
      throw new RuntimeException(e);
    }
  }

  public void setDateFormat(String pattern)
  {
    if (StringUtils.isNotBlank(pattern)) {
      DateFormat df = new SimpleDateFormat(pattern);
      this.mapper.setDateFormat(df);
    }
  }

  public ObjectMapper getMapper()
  {
    return this.mapper;
  }

  public void setMapper(ObjectMapper mapper) {
    this.mapper = mapper;
  }
}