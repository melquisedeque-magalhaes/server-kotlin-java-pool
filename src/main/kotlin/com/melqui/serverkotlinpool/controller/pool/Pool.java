package com.melqui.serverkotlinpool.controller.pool;

import com.melqui.serverkotlinpool.dto.CreatePoolDTO;
import com.melqui.serverkotlinpool.services.PoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("pools")
class Pool {
    @Autowired
    private PoolServices poolServices;
    @PostMapping
    public void createPool(@RequestBody @Valid CreatePoolDTO createPoolDTO) {

        this.poolServices.create(createPoolDTO);
    }
    @GetMapping
    public Iterable<com.melqui.serverkotlinpool.model.Pool> listPools() {
        return this.poolServices.list();
    }
}