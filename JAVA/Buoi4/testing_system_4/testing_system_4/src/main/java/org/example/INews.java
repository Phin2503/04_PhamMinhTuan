package org.example;

interface INews {
    void display();

    void Display();

    default float Calculate() {
        return 0;
    }
}
