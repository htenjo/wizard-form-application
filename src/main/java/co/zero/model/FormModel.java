package co.zero.model;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormModel {
    private String id;
    private String name;
    private String version;
    private List<String> countries;
    private List<String> tags;
    private Map<String, Object> model;
}
