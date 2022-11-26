package co.zero.gateway;

import java.util.Map;
import java.util.Optional;

public interface FormModelGateway {
    Optional<Map<String, Object>> findFormModel(String formModelId);
}
