package app.web.pavelk.native4;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class MainController {

    @Value("${ast.new.one:}")
    private String one;

    @Value("${ast.new.two:}")
    private String two;

    @Value("${ast.new.three:}")
    private String three;

    @SneakyThrows
    @GetMapping("/")
    public ResponseInfo getInfo() {
        ArrayList<String> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        return ResponseInfo.builder().env(System.getenv()).pr(System.getProperties()).custom(list).build();
    }

}

