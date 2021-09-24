package com.picpay.aop.demo;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchTest {

    private static final ImportOption ignoreTests = new ImportOption.DoNotIncludeTests();

    @Test
    public void coreDependConstraint() {
        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(ignoreTests)
                .importPackages("com.picpay.aop.demo");

        ArchRule rule = classes()
                .that()
                .resideInAPackage("com.picpay.aop.demo.domain..")
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "com.picpay.aop.demo.domain..",
                        "lombok..", // Ideal nao permitir ele
                        "javax.validation.constraint..", // Ideal nao permitir ele
                        "javax.persistence..", // Ideal nao permitir ele
                        "java..",
                        "org.springframework.stereotype.." // Ideal nao permitir ele
                );

        rule.check(importedClasses);
    }

    @Test
    public void servicesConstraint() {
        JavaClasses serviceClasses = new ClassFileImporter()
                .withImportOption(ignoreTests)
                .importPackages("com.picpay.aop.demo.domain.services");

        ArchRule rule = classes()
                .that()
                .resideInAPackage("com.picpay.aop.demo.domain.services")
                .should()
                .notBePublic()
                .andShould()
                .dependOnClassesThat()
                .resideOutsideOfPackage("com.picpay.aop.demo.domain.services")
                .as("Services shouldn't depend other services and not be public");

        rule.check(serviceClasses);
    }
}
