package com.mnubo.java.sdk.client.mapper;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.MapperFeature.DEFAULT_VIEW_INCLUSION;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import org.joda.time.Interval;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.deser.IntervalDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.IntervalSerializer;
import com.mnubo.java.sdk.client.models.Event;
import com.mnubo.java.sdk.client.models.Owner;
import com.mnubo.java.sdk.client.models.SmartObject;

public abstract class ObjectMapperConfig {
    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper;
        Jackson2ObjectMapperFactoryBean factory = new Jackson2ObjectMapperFactoryBean();
        factory.setFeaturesToDisable(WRITE_DATES_AS_TIMESTAMPS);
        factory.setFeaturesToEnable(DEFAULT_VIEW_INCLUSION);
        factory.setFindModulesViaServiceLoader(false);
        factory.setSerializationInclusion(NON_NULL);
        factory.setIndentOutput(false);
        factory.afterPropertiesSet();
        objectMapper = factory.getObject();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        objectMapper.registerModule(createJodaModule());
        objectMapper.registerModule(createSmartObject());
        objectMapper.registerModule(createOwner());
        objectMapper.registerModule(createEvent());
        return objectMapper;
    }

    private static SimpleModule createJodaModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new IntervalSerializer());
        module.addDeserializer(Interval.class, new IntervalDeserializer());
        return module;

    }

    private static SimpleModule createSmartObject() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new SmartObjectSerializer());
        module.addDeserializer(SmartObject.class, new SmartObjectDeserializer());
        return module;
    }

    private static SimpleModule createOwner() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new OwnerSerializer());
        module.addDeserializer(Owner.class, new OwnerDeserializer());
        return module;
    }

    private static SimpleModule createEvent() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new EventSerializer());
        module.addDeserializer(Event.class, new EventDeserializer());
        return module;
    }

}
