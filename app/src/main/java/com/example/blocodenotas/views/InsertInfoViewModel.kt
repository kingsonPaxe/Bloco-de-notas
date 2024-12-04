package com.example.blocodenotas.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocodenotas.roomDatabase.Anotacao
import com.example.blocodenotas.roomDatabase.AnotacaoDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertInfoViewModel @Inject constructor(
    private val dao: AnotacaoDao
): ViewModel() {

    fun salvarAnotacao(titulo: String, descricao: String){
        viewModelScope.launch(Dispatchers.IO) {
            val nota = Anotacao(titulo = titulo, descricao = descricao)
            dao.insertAnotacao(nota)
        }
    }

}