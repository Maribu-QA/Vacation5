package ru.netologi.services;

public class VacationService {
    public int calculate(int income, int expenses, int threshold) {
        int money = 0;
        int vacations = 0;
        for (int i = 0; i < 12; i++) {
            if (money >= threshold) {
                money -= expenses;
                money = money / 3;
                vacations++;

            } else {
                money += income;
                money -= expenses;
            }
        }
        return vacations;
    }
}