package co.zero.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

import co.zero.model.WizardModel;

public interface WizardFormAPI {
    String BASE_PATH = "/";
    String ID_PATH = BASE_PATH + "{id}";
    String MODEL_PATH = ID_PATH + "/model";

    @PostMapping(BASE_PATH)
    WizardModel create(@RequestBody WizardModel model);

    @GetMapping(ID_PATH)
    Optional<WizardModel> find(@PathVariable String id);

    @GetMapping(MODEL_PATH)
    Optional<Map<String, Object>> findFormModel(@PathVariable String id);

    @DeleteMapping(ID_PATH)
    void delete(@PathVariable String id);
}
