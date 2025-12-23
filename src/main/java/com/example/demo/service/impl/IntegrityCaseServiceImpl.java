package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repository;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public IntegrityCase saveCase(IntegrityCase integrityCase) {
        return repository.save(integrityCase);
    }
}
