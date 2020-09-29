
package com.resencia.backoffice.app.Index;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/index")
    public String getIndex(){
        
        return "index";
    }
}
