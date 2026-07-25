package auca.sunday.service;

import auca.sunday.domain.Teacher;

public class PayrollService {

    public double calculatePay(Teacher teacher) {
        if (teacher.getHoursWorked() < 0 || teacher.getHourlyRate() < 0) {
            throw new IllegalArgumentException("Hours and rate cannot be negative");
        }

        double basePay = 0;
        double overtimePay = 0;

        // Calculate hours up to 160
        if (teacher.getHoursWorked() > 160) {
            basePay = 160 * teacher.getHourlyRate();
            double overtimeHours = teacher.getHoursWorked() - 160;
            overtimePay = overtimeHours * (teacher.getHourlyRate() * 1.5);
        } else {
            basePay = teacher.getHoursWorked() * teacher.getHourlyRate();
        }

        double totalPay = basePay + overtimePay;

        // Apply category bonus
        double bonusMultiplier = 1.0;
        switch (teacher.getCategory()) {
            case ASSISTANT:
                bonusMultiplier = 1.0; // +0%
                break;
            case LECTURER:
                bonusMultiplier = 1.05; // +5%
                break;
            case SENIOR_LECTURER:
                bonusMultiplier = 1.10; // +10%
                break;
            case PROFESSOR:
                bonusMultiplier = 1.15; // +15%
                break;
        }

        return totalPay * bonusMultiplier;
    }
}