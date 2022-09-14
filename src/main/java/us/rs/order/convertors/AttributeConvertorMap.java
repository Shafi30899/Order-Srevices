package us.rs.order.convertors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Converter
public class AttributeConvertorMap implements AttributeConverter<Map<String,String>,String> {


    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {
        String mapAsString = attribute.keySet().stream()
                .map(key -> key + "=" + attribute.get(key))
                .collect(Collectors.joining(", "));
        return mapAsString;
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        Map<String, String> map = Arrays.stream(dbData.split(","))
                .map(entry -> entry.split("="))
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
        return map;
    }
}
//migration flyway