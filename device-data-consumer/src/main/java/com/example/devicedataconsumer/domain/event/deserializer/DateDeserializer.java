package com.example.devicedataconsumer.domain.event.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.SneakyThrows;

public class DateDeserializer extends JsonDeserializer<Date> {

    private static final String value = "date";
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    @SneakyThrows
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {

        ObjectCodec codec = jsonParser.getCodec();
        if (codec != null) {
            JsonNode node = codec.readTree(jsonParser);
            if (node != null) {
                final String date = node.asText(value);
                if (date != null) {

                    SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
                    return formatter.parse(date);
                }
            }
        }
        return null;
    }

}
