package app.web.pavelk.native4;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MainController {

    @Value("${ast.new.one:}")
    private String one;

    @Value("${ast.new.one2:}")
    private String one2;

    @Value("${ast.new.two:}")
    private String two;

    @Value("${ast.new.three:}")
    private String three;

    @Value("${ast.new.four:}")
    private String four;

    @Value("${param.l1:}")
    private List<String> paramList1;

    @Value("${param.l2:}")
    private List<String> paramList2;

    @Value("${param.l3:}")
    private List<String> paramList3;

    @Value("${param.p1:}")
    private String p1;

    @SneakyThrows
    @GetMapping("/")
    public ResponseInfo getInfo() {
        Field[] fields = this.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for (Field f : fields) {
            f.setAccessible(false);
            map.put(f.getName(), f.get(this));
        }
        return ResponseInfo.builder().env(System.getenv()).pr(System.getProperties()).custom(map.toString()).build();
    }

}

