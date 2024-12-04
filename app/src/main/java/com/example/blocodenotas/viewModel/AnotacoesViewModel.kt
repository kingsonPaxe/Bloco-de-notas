package com.example.blocodenotas.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blocodenotas.roomDatabase.Anotacao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val dao: com.example.blocodenotas.roomDatabase.AnotacaoDao
) : ViewModel() {

    val anotacoes = dao.getAllAnotacoes()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            emptyList()
        )

    fun eliminarAnotacao(anotacao: Anotacao){
        viewModelScope.launch {
            dao.deleteAnotacao(anotacao)
        }
    }


}
