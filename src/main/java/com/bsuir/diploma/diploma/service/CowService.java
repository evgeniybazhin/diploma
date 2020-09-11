package com.bsuir.diploma.diploma.service;

import com.bsuir.diploma.diploma.domain.db.cattle.Cow;

public interface CowService {
    void addCow();
    void updateCow(Cow cow);
    void removeCow(Long id);
}
