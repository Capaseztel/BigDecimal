package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Ejercicios {
    //Ejercicio 1
    public BigInteger Factorial(int num) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    //Ejercicio 2
    public BigDecimal InteresCompuesto(double monto, double interes, int meses) {
        BigDecimal montoFinal = BigDecimal.valueOf(monto);
        BigDecimal interesBig = BigDecimal.valueOf(interes);
        MathContext precision = new MathContext(10, RoundingMode.HALF_EVEN);
        montoFinal = montoFinal.multiply(interesBig.add(BigDecimal.ONE, precision).pow(meses, precision), precision);
        return montoFinal;
    }

    //Ejercicio 3
    public void PagoMensual(double monto, double interes, int meses) {
        BigDecimal montoInicial = BigDecimal.valueOf(monto);
        MathContext precision = new MathContext(10, RoundingMode.HALF_EVEN);
        BigDecimal interesBig = BigDecimal.valueOf(interes).divide(BigDecimal.valueOf(12), precision);
        BigDecimal fraccion = BigDecimal.ONE.subtract(BigDecimal.ONE.add(interesBig, precision).pow(-meses, precision), precision);
        BigDecimal montoFinal = montoInicial.multiply(interesBig, precision).divide(fraccion, precision).setScale(2, RoundingMode.HALF_EVEN);
        int i = 1;
        System.out.println("Monto: " + monto + "€\nInterés: " + (interes*100) + "%\nPago mensual: " + montoFinal);
        System.out.println("\nAmortización del préstamo\n-------------------------");
        System.out.println("Mes\t\tPago\t\tPrincipal\tIntereses\tBalance");
        while (i <= meses) {
            BigDecimal intereses = montoInicial.multiply(interesBig).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal principal = montoFinal.subtract(intereses).setScale(2, RoundingMode.HALF_EVEN);
            montoInicial = montoInicial.subtract(principal).setScale(2, RoundingMode.HALF_EVEN);
            System.out.println(i + "\t\t" + montoFinal + "\t\t" + principal + "\t\t" + intereses + "\t\t" + montoInicial);
            i++;
        }
    }

    //Ejercicio 4
    public BigDecimal FormulaHaversine(double lat1, double lon1, double lat2, double lon2) {
        BigDecimal radioTierra = BigDecimal.valueOf(6371);
        BigDecimal lat1Rad = BigDecimal.valueOf(Math.toRadians(lat1));
        BigDecimal lon1Rad = BigDecimal.valueOf(Math.toRadians(lon1));
        BigDecimal lat2Rad = BigDecimal.valueOf(Math.toRadians(lat2));
        BigDecimal lon2Rad = BigDecimal.valueOf(Math.toRadians(lon2));
        BigDecimal dLat = lat2Rad.subtract(lat1Rad, MathContext.DECIMAL128);
        BigDecimal dLon = lon2Rad.subtract(lon1Rad, MathContext.DECIMAL128);
        BigDecimal a = BigDecimal.valueOf(Math.pow(Math.sin(dLat.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128).doubleValue()), 2) + Math.cos(lat1Rad.doubleValue()) * Math.cos(lat2Rad.doubleValue()) * Math.pow(Math.sin(dLon.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128).doubleValue()), 2));
        BigDecimal c = BigDecimal.valueOf(2 * Math.atan2(Math.sqrt(a.doubleValue()), Math.sqrt(1 - a.doubleValue())));
        return radioTierra.multiply(c, MathContext.DECIMAL128);
    }
}
