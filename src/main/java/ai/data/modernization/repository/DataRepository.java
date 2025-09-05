package ai.data.modernization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.data.modernization.data.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
