package com.melqui.serverkotlinpool.controller.pool;

import com.melqui.serverkotlinpool.dto.CreatePoolDTO;
import com.melqui.serverkotlinpool.repository.PoolRepository;
import com.melqui.serverkotlinpool.services.PoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("pools")
class Pool {
    @Autowired
    private PoolServices poolServices;
    @Autowired
    private PoolRepository poolRepository;
    @PostMapping
    public Map<String, String> createPool(@RequestBody @Valid CreatePoolDTO createPoolDTO) {

        var codePool = this.poolServices.create(createPoolDTO);

        return Collections.singletonMap("code", codePool);
    }
    @GetMapping
    public Iterable<com.melqui.serverkotlinpool.model.Pool> listPools() {
        return this.poolServices.list();
    }

    @GetMapping("/count")
    public Map<String, Long> count() {
        var count = this.poolRepository.count();

        return Collections.singletonMap("count",count);
    }
}