package co.zero.gateway;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FormModelGatewayDefault implements FormModelGateway {
    @Override
    public Optional<Map<String, Object>> findFormModel(String formModelId) {
        Map<String, Object> fake = new HashMap<>();
        fake.put("fieldA", "1");
        fake.put("fieldB", "2");
        return Optional.of(fake);
    }
}
