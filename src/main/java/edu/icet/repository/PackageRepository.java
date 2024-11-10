package edu.icet.repository;

import edu.icet.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageEntity,Integer> {
}
