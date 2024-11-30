package com.example.blocodenotas.viewModel

import Anotacao
import AnotacaoDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AnotacoesViewModel(private val dao: AnotacaoDao) : ViewModel() {
    private val _anotacoes = MutableStateFlow<List<Anotacao>>(emptyList())
    val anotacoes: StateFlow<List<Anotacao>> = _anotacoes

    init {
        fetchAnotacoes()
    }

    private fun fetchAnotacoes() {
        viewModelScope.launch(Dispatchers.IO) {
            _anotacoes.value = dao.getAllAnotacoes()
        }
    }

    fun addAnotacao(anotacao: Anotacao) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertAnotacao(anotacao)
            fetchAnotacoes()
        }
    }

    fun deleteAnotacao(anotacao: Anotacao) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteAnotacao(anotacao)
            fetchAnotacoes()
        }
    }
}
