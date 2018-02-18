package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class LocationDTO {

    private String name;
    private double lat;
    private double lng;

    @DateTimeFormat( pattern = "yyyy/MM/dd")
    private Date visitDate;

}
