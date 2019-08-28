package br.com.runescape.Controller;

import br.com.runescape.Entity.Overall;
import br.com.runescape.Service.OverallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/overall")
public class OverallController {

    @Autowired
    private OverallService overallService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Overall> readAll(){
        return this.overallService.readAll();
    }

}
