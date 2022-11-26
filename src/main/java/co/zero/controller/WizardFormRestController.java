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
    public void delete(String wizardModelId) {
        log.info("::: Deleting by wizardModelId = {}", wizardModelId);
        service.delete(wizardModelId);
    }
}
