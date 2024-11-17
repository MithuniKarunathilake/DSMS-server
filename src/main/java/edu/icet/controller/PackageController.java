package edu.icet.controller;

import edu.icet.dto.Package;
import edu.icet.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
@CrossOrigin
public class PackageController {
    @Autowired
    private final PackageService service;

    @GetMapping("/get-package")
    public List<Package> getPackage(){
        return service.getAll();
    }

    @PostMapping("/add-package")
    //@ResponseStatus(HttpStatus.CREATED)
    public void addPackage(@RequestBody Package packageA){
        service.addPackage(packageA);
    }

    @GetMapping("/search-package/{id}")
    public Package getPackageById(@PathVariable Integer id){
        return service.searchPackageById(id);
    }

    @DeleteMapping("/delete-package/{id}")
    public void deletePackageById(@PathVariable Integer id){
        service.deletePackageById(id);
    }

    @PutMapping("/update-package")
    public void updatePackage(@RequestBody Package packageA){
        service.updatePackageById(packageA);
    }
}
