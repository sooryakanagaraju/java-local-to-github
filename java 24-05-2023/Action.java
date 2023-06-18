package com.Java;

interface exercise {
    void startRun();
    void stopRun();
}

// Child interface extending the parent interface
interface Action extends Vehicle {
    void Jogging();
    void Walking();
}

