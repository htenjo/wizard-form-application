package co.zero.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

import co.zero.model.WizardModel;
import co.zero.service.WizardFormService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WizardFormRestController implements WizardFormAPI {
    private WizardFormService service;

    public WizardFormRestController(WizardFormService service) {
        this.service = service;
    }

    @Override
    public WizardModel create(WizardModel wizardModel) {
        return service.save(wizardModel);
    }

    @Override
    public Optional<WizardModel> find(String wizardModelId) {
        return service.find(wizardModelId);
    }

    @Override
    public Optional<Map<String, Object>> findFormModel(String wizardModelId) {
        return service.findFormModel(wizardModelId);
    }

    @Override
    public WizardModel updateValues(String wizardModelId, WizardModel model) {
        validateModelId(wizardModelId, model);
        model.setId(wizardModelId);
        return service.updateValues(model);
    }

    @Override
    public void delete(String wizardModelId) {
        log.info("::: Deleting by wizardModelId = {}", wizardModelId);
        service.delete(wizardModelId);
    }

    /**
     * Validate both ids match when the model provides one.
     */
    private void validateModelId(String wizardModelId, WizardModel model) {
        boolean modelIdExist = model.getId() != null && !model.getId().isEmpty();

        if (modelIdExist && !model.getId().equalsIgnoreCase(wizardModelId)) {
            throw new IllegalArgumentException("ModelID and ID Param don't match");
        }
    }
}
