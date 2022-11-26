package co.zero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Document(value = "wizard")
@Getter
@Setter
public class WizardModel {
    @Id
    private String id;
    private String formModelId;
    private String country;
    private WizardState state;
    private Map<String, Object> values;

    public WizardModel(String formModelId, String country, WizardState state, Map<String, Object> values) {
        this.formModelId = formModelId;
        this.country = country;
        this.state = state;
        this.values = values;
    }
}
