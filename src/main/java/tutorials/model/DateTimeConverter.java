package tutorials.model;

import org.joda.time.DateTime;
import org.joda.time.Instant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DateTimeConverter implements AttributeConverter<DateTime, Long> {

    @Override
    public Long convertToDatabaseColumn(DateTime dateTime) {
        return dateTime.toInstant().getMillis();
    }

    @Override
    public DateTime convertToEntityAttribute(Long dbData) {
        return new DateTime(new Instant(dbData));
    }
}
