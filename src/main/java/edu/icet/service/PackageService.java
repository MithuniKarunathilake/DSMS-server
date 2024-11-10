package edu.icet.service;

import edu.icet.dto.Package;

import java.util.List;

public interface PackageService {
    List<Package> getAll();
    void addPackage(Package packageA);
    Package searchPackageById(Integer id);
    void deletePackageById(Integer id);
    void updatePackageById(Package packageA);
}
