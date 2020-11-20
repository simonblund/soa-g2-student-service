package com.g2.studentservice.api.mock.epok;

import com.g2.studentservice.api.mock.MockUrlPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface EpokModulResource {
    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.EPOKMODUL)
    ResponseEntity<ModulResponse> getModul();
}