package at.ac.fhstp.fhstpgroup3b.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class CalculationUiState(
    val result: Double
)

class MainViewModel : ViewModel() {

    // private MUTABLE state flow
    private val _calculationUiState = MutableStateFlow(CalculationUiState(0.0))
    // public IMMUTABLE state flow
    val calculationUiState: StateFlow<CalculationUiState> = _calculationUiState

    fun calculate(num1Text: String, num2Text: String) {
        val num1 = num1Text.toDoubleOrNull() ?: 0.0
        val num2 = num2Text.toDoubleOrNull() ?: 0.0
        val sum = num1 + num2

        _calculationUiState.update {
            it.copy(result = sum)
        }
    }
}