package edu.icet.service.impl;

import edu.icet.dto.Package;
import edu.icet.entity.PackageEntity;
import edu.icet.repository.PackageRepository;
import edu.icet.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final ModelMapper mapper;
    @Override
    public List<Package> getAll() {
        List<Package> packageArrayList = new ArrayList<>();
        packageRepository.findAll().forEach(entity->{
            packageArrayList.add(mapper.map(entity, Package.class));
        });
        return packageArrayList;
    }

    @Override
    public void addPackage(Package packageA) {
        packageRepository.save(mapper.map(packageA, PackageEntity.class));
    }

    @Override
    public Package searchPackageById(Integer id) {
        return mapper.map(packageRepository.findById(id),Package.class);
    }

    @Override
    public void deletePackageById(Integer id) {
        packageRepository.deleteById(id);
    }

    @Override
    public void updatePackageById(Package packageA) {
        packageRepository.save(mapper.map(packageA, PackageEntity.class));

    }
}
