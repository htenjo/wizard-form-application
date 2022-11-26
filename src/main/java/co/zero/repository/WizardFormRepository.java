package co.zero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.zero.model.WizardModel;

public interface WizardFormRepository extends MongoRepository<WizardModel, String> {
}
