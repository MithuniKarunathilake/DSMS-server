package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    private Integer packageId;
    private String description;
    private Double price;
    private String licenceType;
}
