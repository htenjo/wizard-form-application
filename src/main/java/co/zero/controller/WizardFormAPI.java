package co.zero.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

import co.zero.model.WizardModel;

public interface WizardFormAPI {
    String BASE_PATH = "/api/";
    String ID_PATH = BASE_PATH + "{id}";
    String MODEL_PATH = ID_PATH + "/model";

    @PostMapping(BASE_PATH)
    WizardModel create(@RequestBody WizardModel model);

    @PutMapping(ID_PATH)
    WizardModel updateValues(@PathVariable("id") String wizardModelId, @RequestBody WizardModel model);

    @GetMapping(ID_PATH)
    Optional<WizardModel> find(@PathVariable("id") String wizardModelId);

    @GetMapping(MODEL_PATH)
    Optional<Map<String, Object>> findFormModel(@PathVariable("id") String wizardModelId);

    @DeleteMapping(ID_PATH)
    void delete(@PathVariable("id") String wizardModelId);
}
