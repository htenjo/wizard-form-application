package co.zero.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import co.zero.gateway.FormModelGateway;
import co.zero.model.WizardModel;
import co.zero.repository.WizardFormRepository;

@Service
public class WizardFormService {
    private FormModelGateway gateway;
    private WizardFormRepository repository;

    public WizardFormService(FormModelGateway gateway, WizardFormRepository repository) {
        this.gateway = gateway;
        this.repository = repository;
    }

    public WizardModel save(WizardModel wizardModel) {
        Optional<Map<String, Object>> formModel = gateway.findFormModel(wizardModel.getFormModelId());

        if (!formModel.isPresent()) {
            throw new IllegalArgumentException("::: FormModel doesn't exist " + wizardModel.getFormModelId());
        }

        return repository.save(wizardModel);
    }

    public Optional<WizardModel> find(String wizardId) {
        return repository.findById(wizardId);
    }

    public void delete(String wizardId) {
        repository.deleteById(wizardId);
    }

    public Optional<Map<String, Object>> findFormModel(String wizardModelId) {
        WizardModel wizardModel = repository.findById(wizardModelId)
                .orElseThrow(() -> new IllegalArgumentException("::: WizardModel not found"));
        return gateway.findFormModel(wizardModel.getFormModelId());
    }
}
