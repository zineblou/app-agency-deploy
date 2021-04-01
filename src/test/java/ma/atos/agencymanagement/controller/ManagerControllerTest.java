package ma.atos.agencymanagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ManagerControllerTest {

    @Autowired
    private ManagerController managerController;
    @Test
    void addManager() {
        managerController.addManager()
    }

    @Test
    void getManagers() {
    }

    @Test
    void getManagerById() {
    }

    @Test
    void deleteManager() {
    }

    @Test
    void updateManager() {
    }
}