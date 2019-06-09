package com.ycjh.tmp;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tmpRepository extends JpaRepository<tmpDTO, Long> {
}
