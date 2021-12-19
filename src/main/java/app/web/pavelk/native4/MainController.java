package app.web.pavelk.native4;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    @SneakyThrows
    @GetMapping("/")
    public ResponseInfo getInfo() {
        return ResponseInfo.builder().env(System.getenv()).pr(System.getProperties()).build();
    }

}

