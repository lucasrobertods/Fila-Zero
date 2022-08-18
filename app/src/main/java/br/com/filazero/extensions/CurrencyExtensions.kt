package br.com.filazero.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

/**
 * 22.      * Simbolos especificos do Dolar Americano
 * 23.       */
private val DOLAR = DecimalFormatSymbols(Locale.US)
/**
 * Mascara de dinheiro para Dolar Americano
 */
val FORMAT_DOLAR = DecimalFormat("¤ ###,###,##0.00", DOLAR)
/**
 * Simbolos especificos do Euro
 */
private val EURO = DecimalFormatSymbols(Locale.GERMANY)
/**
 * Mascara de dinheiro para Euro
 */
val FORMAT_EURO = DecimalFormat("¤ ###,###,##0.00", EURO)
/**
 * Locale Brasileiro
 */
private val BRAZIL = Locale("pt", "BR")
/**
 * Sï¿½mbolos especificos do Real Brasileiro
 */
private val REAL = DecimalFormatSymbols(BRAZIL)
/**
 * Mascara de dinheiro para Real Brasileiro
 */
val FORMAT_REAL = DecimalFormat("¤ ###,###,##0.00", REAL)

/**
 * Mascara texto com formatacao monetaria
 * @param value Valor a ser mascarado
 * @param currencyFormat Padrao monetario a ser usado
 * @return Valor mascarado de acordo com o padrao especificado
 */
fun Double.formatCurrency(currencyFormat: DecimalFormat): String {
    return currencyFormat.format(this)
}

fun Double.toCurrency(): String =
    NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this)

fun Int?.toCurrency(): String = if (this != null) {
    NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this / 100.00)
} else {
    NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(0)
}