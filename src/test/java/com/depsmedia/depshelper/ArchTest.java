package com.depsmedia.depshelper;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.depsmedia.depshelper");

        noClasses()
            .that()
                .resideInAnyPackage("com.depsmedia.depshelper.service..")
            .or()
                .resideInAnyPackage("com.depsmedia.depshelper.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.depsmedia.depshelper.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
