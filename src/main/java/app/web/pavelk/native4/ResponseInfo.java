package app.web.pavelk.native4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Properties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ResponseInfo {
    private Map<String, String> env;
    private Properties pr;
}
