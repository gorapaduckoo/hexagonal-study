package com.example.hexagonalstudy;

import com.example.hexagonalstudy.archunit.HexagonalArchitecture;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class DependencyRuleTests {

    @Test
    void domainLayerDoesNotDependOnApplicationLayer() {
        noClasses()
                .that()
                .resideInAPackage("com.example.hexagonalstudy.account.domain..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("com.example.hexagonalstudy.account.application..")
                .check(new ClassFileImporter()
                        .importPackages("com.example.hexagonalstudy.account.."));
    }

    @Test
    void validateRegistrationContextArchitecture() {
        HexagonalArchitecture.boundedContext("com.example.hexagonalstudy.account")
                .withDomainLayer("domain")
                .withAdaptersLayer("adapter")
                .incoming("in.web")
                .outgoing("out.persistence")
                .and()

                .withApplicationLayer("application")
                .services("service")
                .incomingPorts("port.in")
                .outgoingPorts("port.out")
                .and()

                .withConfiguration("configuration")
                .check(new ClassFileImporter()
                        .importPackages("com.example.hexagonalstudy.."));
    }
}
