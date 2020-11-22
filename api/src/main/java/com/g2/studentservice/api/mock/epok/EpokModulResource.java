package com.g2.studentservice.api.mock.epok;

import com.g2.studentservice.api.mock.MockUrlPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface EpokModulResource {
    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.EPOKMODUL)
    ResponseEntity<List<ModulResponse>> getAll();

    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.EPOKMODUL+"?code={module}")
    ResponseEntity<List<ModulResponse>> getOne(@PathVariable String module);
}
