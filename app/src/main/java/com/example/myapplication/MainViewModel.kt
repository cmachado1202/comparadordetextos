package com.example.myapplication


    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel

    class MainViewModel : ViewModel() {

        // Propiedades para los textos y el resultado
        private val _text1 = MutableLiveData<String>()
        val text1: LiveData<String> = _text1

        private val _text2 = MutableLiveData<String>()
        val text2: LiveData<String> = _text2

        private val _comparisonResult = MutableLiveData<String>()
        val comparisonResult: LiveData<String> = _comparisonResult

        // Método para comparar los textos
        fun compareTexts() {
            val text1Value = _text1.value
            val text2Value = _text2.value

            if (text1Value != null && text2Value != null) {
                if (text1Value == text2Value) {
                    _comparisonResult.value = "Los textos son iguales."
                } else {
                    _comparisonResult.value = "Los textos son diferentes."
                }
            } else {
                _comparisonResult.value = "Ingrese valores en ambos campos."
            }
        }

        // Métodos para establecer los textos
        fun setText1(text: String) {
            _text1.value = text
        }

        fun setText2(text: String) {
            _text2.value = text
        }


}