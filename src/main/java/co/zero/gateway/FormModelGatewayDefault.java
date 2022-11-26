package co.zero.gateway;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

import co.zero.model.FormModel;

@Service
public class FormModelGatewayDefault implements FormModelGateway {
    @Value("${form.model.url}")
    private String formModelUrl;
    private RestTemplate restTemplate;

    public FormModelGatewayDefault(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Map<String, Object>> findFormModel(String formModelId) {
        String formModelInstanceUrl = formModelUrl + "/" + formModelId;
        FormModel formModel = restTemplate.getForEntity(formModelInstanceUrl, FormModel.class).getBody();
        Map<String, Object> model = formModel.getModel();
        return Optional.of(model);
    }
}
