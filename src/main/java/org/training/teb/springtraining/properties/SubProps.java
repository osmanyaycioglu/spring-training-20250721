package org.training.teb.springtraining.properties;

import lombok.Data;

import java.util.List;

@Data
public class SubProps {
    private String       subName;
    private String       address;
    private List<String> departments;

}
