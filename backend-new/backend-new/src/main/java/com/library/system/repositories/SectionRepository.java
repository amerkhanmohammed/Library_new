package com.library.system.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Module, Long> {
    @Override
    public List<Module> findAll();
    public List<Module> findAllBySectionId(long id);
}
